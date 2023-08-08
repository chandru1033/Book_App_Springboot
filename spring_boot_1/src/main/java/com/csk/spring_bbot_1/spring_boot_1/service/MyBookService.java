package com.csk.spring_bbot_1.spring_boot_1.service;

import com.csk.spring_bbot_1.spring_boot_1.entity.Book;
import com.csk.spring_bbot_1.spring_boot_1.entity.MyBook;
import com.csk.spring_bbot_1.spring_boot_1.repository.MyBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    private MyBookRepo mbr;
    public void saveMyBook(MyBook mb)
    {
       mbr.save(mb);
    }

    public List<MyBook> getAll() {
        return mbr.findAll();
    }
    public void deleteById(int id)
    {
        mbr.deleteById(id);
    }
}
