package com.example.demo.Company;

import com.example.demo.User.User;
import com.example.demo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private final CompanyRepository repository;

    @Autowired
    private UserService userService;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }


    public  List<Company> getAll() {
        return repository.findAll();
    }

    public Company createCompany(Company company) {
        return repository.save(company);
    }

    public Company updateCompany(Company updatedCompany) {
        repository.findById(updatedCompany.getId())
                .orElseThrow (() -> new CompanyNotFoundException(updatedCompany.getId()) );

        return repository.save(updatedCompany);
    }

    public void deleteCompany(int id) {
        repository.findById(id)
                .orElseThrow (() -> new CompanyNotFoundException(id ));
        repository.deleteById(id);
    }

    public Company getById(int id) {
        return repository.findById(id)
                .orElseThrow (() -> new CompanyNotFoundException(id) );
    }

    public Company getByUserId(String userId) {
        User user = userService.getById(Integer.parseInt(userId));
        if(user.getCompany() == null ) throw new UserDoesNotWorkInAnyCompanyException(user);
        int companyId = user.getCompany().getId();
        return repository.findById(companyId)
                .orElseThrow (() -> new CompanyNotFoundException(companyId) );
    }

    public List<Company> get(String userId) {
        if (userId.isBlank())
            return getAll();
        else {
            List<Company> list = new ArrayList<>();
            list.add(getByUserId(userId));
            return list;
        }
    }


}