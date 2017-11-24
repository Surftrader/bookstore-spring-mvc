package com.hillel.controller;

import com.hillel.dao.BookDao;
import com.hillel.model.Book;
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
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllBook(Model model) {

        List<Book> books = bookDao.findAll();
        model.addAttribute("books", bookDao.findAll());
        return "view/listBook";
    }

    @RequestMapping(value = "/{book_id}", method = RequestMethod.GET)
    public ModelAndView getBook(@PathVariable("book_id") Integer id) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("view/book");
        maw.addObject("book", bookDao.findById(id));
        return maw;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddBookPage(Model model) {
        model.addAttribute("book", new Book());
        return "view/addBook";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addBook(@ModelAttribute Book book) {
        bookDao.save(book);
        return "redirect:/book/";
    }
}
