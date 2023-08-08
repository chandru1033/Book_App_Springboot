package com.csk.spring_bbot_1.spring_boot_1.controller;

import com.csk.spring_bbot_1.spring_boot_1.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookController {

    @Autowired
    MyBookService mbs;
    @RequestMapping("/deleteMyBook/{id}")
    public String deleteById(@PathVariable("id") int id)
    {
        mbs.deleteById(id);
        return "redirect:/my_books";
    }
}
