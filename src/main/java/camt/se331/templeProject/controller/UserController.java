package camt.se331.templeProject.controller;

import camt.se331.templeProject.entity.User;
import camt.se331.templeProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dell on 14/4/2558.
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "user",method = RequestMethod.GET)
    public List<User> getUser(){
        return userService.getUser();
    }

    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "user",method = RequestMethod.POST)
    public @ResponseBody
    User addUser(@RequestBody User User, BindingResult bindingResult){
        return userService.addUser(User);
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Boolean verifyUsernamePassword(@PathVariable("username") String username,@PathVariable("password") String password){
        return userService.verifyUsernamePassword(username,password);
    }
    @RequestMapping(value = "user/{id}",method = RequestMethod.PUT)
    public  User editNews(@RequestBody User user, BindingResult bindingResult){
        return   userService.editUser(user);
    }
}
