package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<User> index() {
        // Change from UserRepository to UserService
        return userService.findAll();
    }
    @GetMapping(value = "/{id}")
    public Optional<User> index(@PathVariable String id) {
        // Change from UserRepository to UserService
        return userService.findById(Integer.parseInt(id));
    }
    @GetMapping(value = "/test")
    public List<User> findByAgeIn(@RequestBody Map<String,Object> inputs)
    {
        System.out.println(inputs.get("ages"));
        List<Integer> ages = new ArrayList();
        String[] dummy =  ((String)inputs.get("ages")).split(",");
        for(String S :dummy)
            ages.add(Integer.parseInt(S));
        return userService.findByAgeIn(ages);
    }
    @GetMapping(value = "/test2")
    public List<User> findByCityAndActiveAndAge(@RequestParam String city,@RequestParam Integer active,@RequestParam Integer age) {
        return userService.findByCityAndActiveAndAge(city, active, age);
    }
    @GetMapping(value = "/test3")
    public List<User> findAllByQuery() {
        return userService.findAllByQuery();
    }
    @GetMapping(value = "/test4")
    public List<User> findAllByParamsQuery(@RequestParam Integer active,@RequestParam String city) {
        return userService.findAllByParamsQuery(active, city);
    }
    @GetMapping(value = "/test5")
    public List<User> findAllByJpqlQuery() {
        return userService.findAllByJpqlQuery();
    }
    @GetMapping(value = "/test6")
    public List<User> findAllByJpqlParamsQuery(@RequestParam Integer active,@RequestParam String city) {
        return userService.findAllByJpqlParamsQuery(active, city);
    }
    @GetMapping(value = "/test7")
    public Page<User> findAllByLimit(@RequestParam  Integer start,@RequestParam Integer limit,@RequestParam String field) {
        return userService.findAllByLimit(start,limit,field);
    }
    @GetMapping(value = "/test8")
    public List<User> findByCityIn(@RequestParam List<String> city){
        return userService.findByCityIn(city);
    }
    @GetMapping(value = "/test9")
    public List<User> findByEmailIn(@RequestParam List<String> email){
        return userService.findByEmailIn(email);
    }
}
