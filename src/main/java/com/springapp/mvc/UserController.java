package com.springapp.mvc;

import com.springapp.domain.CardUserStoreMock;
import com.springapp.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 1109294 on 14. 2. 11.
 */
@Controller
public class UserController {
    @RequestMapping(value="/user", method= RequestMethod.POST)
    public void insertUser(@RequestBody User user, ModelMap model){
        CardUserStoreMock.add(user);
        model.addAttribute("userId",user.getId());
    }

    @RequestMapping(value="/user/{userId}", method = RequestMethod.GET)
    public void getUser(@PathVariable String userId, ModelMap model){
        User user = CardUserStoreMock.getUser(userId);
        user.setPassword("****");
        model.addAttribute("user",user);
    }

    @RequestMapping(value="/user/{userId}", method = RequestMethod.PUT)
    public void putUser(@PathVariable String userId, @RequestBody User user, ModelMap model){
        User originalUser = CardUserStoreMock.getUser(userId);
        user.setPassword(originalUser.getPassword());
        BeanUtils.copyProperties(user,originalUser);
        CardUserStoreMock.setUser(user);
    }

}
