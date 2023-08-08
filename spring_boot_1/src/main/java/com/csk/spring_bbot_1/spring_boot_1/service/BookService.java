package com.csk.spring_bbot_1.spring_boot_1.service;

import com.csk.spring_bbot_1.spring_boot_1.entity.Book;
import com.csk.spring_bbot_1.spring_boot_1.repository.Book_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private Book_Repo br;

    public void save(Book b)
    {
        br.save(b);
    }
    public List<Book> getAllBooks() {
        return br.findAll();
    }

    public Book getBookById(int id) {
        return br.findById(id).get();
    }

    public void deleteBook(int id)
    {
        br.deleteById(id);

    }

}
