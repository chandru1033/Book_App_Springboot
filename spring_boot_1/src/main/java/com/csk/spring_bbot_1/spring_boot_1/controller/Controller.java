package com.csk.spring_bbot_1.spring_boot_1.controller;

import com.csk.spring_bbot_1.spring_boot_1.entity.Book;
import com.csk.spring_bbot_1.spring_boot_1.entity.MyBook;
import com.csk.spring_bbot_1.spring_boot_1.service.BookService;
import com.csk.spring_bbot_1.spring_boot_1.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller
{
    @Autowired
    private BookService bs;
    @Autowired
    private MyBookService mbs;
    @GetMapping("/")
    public String disp()
    {
        return "index.html";
    }

    @GetMapping("/book_register")
    public String bookRegister()
    {
        return "book_register.html";
    }
    @GetMapping("/available_books")
    public ModelAndView getAll()
    {
        List <Book> list=bs.getAllBooks();
//        ModelAndView m =new ModelAndView();
//        m.setViewName("available_books");
//        m.addObject("book",list);
     return new ModelAndView("available_books","book",list);
    }
    @GetMapping("/my_books")
    public String myBooks(Model model)
    {
        List<MyBook>list=mbs.getAll();
        model.addAttribute("book",list);
        return "my_books";
//        List<MyBook> list=mbs.getAll();
//        return new ModelAndView("my_book","mybook",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b)
    {
        bs.save(b);
        return "redirect:/available_books";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyBook(@PathVariable("id") int id)
    {
        Book b=bs.getBookById(id);
        MyBook mb=new MyBook(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        mbs.saveMyBook(mb);
        return "redirect:/my_books";
    }
    @RequestMapping("/delete_book/{id}")
    public String deleteById(@PathVariable("id") int id)
    {
        bs.deleteBook(id);
        return "redirect:/available_books";
    }
    @RequestMapping("edit_book/{id}")
    public String editBook(@PathVariable("id") int id, Model model)
    {
        Book b=bs.getBookById(id);
        model.addAttribute("book",b);
        return "book_edit";
    }
}
