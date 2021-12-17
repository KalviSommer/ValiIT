package ee.bcs.valiit.controller;


import ee.bcs.valiit.BankAccount;
import ee.bcs.valiit.Book;
import ee.bcs.valiit.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NewController {

    // http://localhost:8080/dtoTest
    @GetMapping("dtoTest")
    public Book dtoTest(){
        Book book = new Book();
        book.setName("title");
        book.setAuthor("Juku");
        book.setYear(1988);
        return book;
    }

    // http://localhost:8080/dtoTest
    @PostMapping("dtoTest")
    public Book saveBook(@RequestBody Book book){
        return book;
    }


}
