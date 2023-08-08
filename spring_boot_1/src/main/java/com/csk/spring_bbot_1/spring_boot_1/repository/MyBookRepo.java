package com.csk.spring_bbot_1.spring_boot_1.repository;

import com.csk.spring_bbot_1.spring_boot_1.entity.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepo extends JpaRepository<MyBook,Integer> {
}
