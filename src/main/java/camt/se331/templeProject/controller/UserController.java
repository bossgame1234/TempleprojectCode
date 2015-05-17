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

    @RequestMapping(value = "user/verifyusername",method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "username")String user){
        return userService.findByUserName(user);
    }

    @RequestMapping(value = "user",method = RequestMethod.POST)
    public @ResponseBody
    User addUser(@RequestBody User user, BindingResult bindingResult){
        return userService.addUser(user);
    }
}
