package com.hillel.controller;

import com.hillel.dao.UserDao;
import com.hillel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllUser(Model model) {
        List<User> user = userDao.findAll();
        model.addAttribute("users", userDao.findAll());
        return "view/listUsers";
    }

    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable("user_id") Integer id) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("view/user");
        maw.addObject("user", userDao.findById(id));
        return maw;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddUserPage(Model model) {
        model.addAttribute("user", new User());
        return "view/addUser";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        userDao.save(user);
        return "redirect:/user/";
    }
}
