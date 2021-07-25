package com.example.demo.User;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users/{id}")
    User one(@PathVariable int id) {

        return userService.getById(id);
    }

    @GetMapping("/companies/{companyId}/users")
    List<User> getCompanyUsers(@PathVariable int companyId,
                               @RequestParam(name="id", required = false , defaultValue = "") String id,
                               @RequestParam(name="lastName", required = false , defaultValue = "") String lastName,
                               @RequestParam(name="firstName", required = false , defaultValue = "") String firstName,
                               @RequestParam(name="age", required = false , defaultValue = "") String age )                                {
        return userService.getCompanyUsers(companyId);
    }

    // search

    @GetMapping("/users")
    List<User> searchUsers(@RequestParam(name="id", required = false , defaultValue = "") String id,
                           @RequestParam(name="lastName", required = false , defaultValue = "") String lastName,
                           @RequestParam(name="firstName", required = false , defaultValue = "") String firstName,
                           @RequestParam(name="age", required = false , defaultValue = "") String age ){
        return userService.searchUsers(id,firstName,lastName,age);

    }






    @GetMapping("/search")
    List<User> generalSearch(@RequestParam(name="id", required = false , defaultValue = "") String id,
                             @RequestParam(name="lastName", required = false , defaultValue = "") String lastName,
                             @RequestParam(name="firstName", required = false , defaultValue = "") String firstName,
                             @RequestParam(name="age", required = false , defaultValue = "") String age,
                             @RequestParam(name="companyId", required = false , defaultValue = "") String companyId,
                             @RequestParam(name="companyName", required = false , defaultValue = "") String companyName,
                             @RequestParam(name="companyLocation", required = false , defaultValue = "") String companyLocation) {
        return userService.generalSearch(id,firstName,lastName,age,companyId,companyName,companyLocation);
    }
}
