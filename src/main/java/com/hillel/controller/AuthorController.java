package com.hillel.controller;

import com.hillel.dao.AuthorDao;
import com.hillel.model.Author;
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
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorDao authorDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllAuthors(Model model) {

        List<Author> authors = authorDao.findAll();
        model.addAttribute("authors", authors); //
        return "view/listAuthors";
    }

    @RequestMapping(value = "/{author_id}", method = RequestMethod.GET)
    public ModelAndView getAuthor(@PathVariable("author_id") Integer id) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("view/author");
        maw.addObject("author", authorDao.findById(id));
        return maw;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddAuthorPage(Model model) {
        model.addAttribute("author", new Author());
        return "view/addAuthor";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute Author author) {
        authorDao.save(author);
        return "redirect:/author/";
    }
}
