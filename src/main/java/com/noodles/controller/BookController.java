package com.noodles.controller;

import com.noodles.dao.BookDao;
import com.noodles.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by gaoxinwei on 2018/4/18.
 */
@Controller
@RequestMapping("/book") // url:/模块/资源/{id}/细分 /seckill/list
public class BookController {

    @Autowired
    private BookDao bookDao;

//    @RequestMapping(value = "/one", method = RequestMethod.GET, produces = {
//            "application/json; charset=utf-8" })
    @RequestMapping(value = "/one", method = RequestMethod.GET)
    @ResponseBody
    public Book getOne() {
        List<Book> books = bookDao.queryAll(0, 1000);
        return books.get(0);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list", bookDao.queryAll(0, 1000));
        return "list";
    }

}
