package com.sprinboot.starter.project.springbootdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerAPI {

    @GetMapping("/books")
    public List<String> getAllBooks() {
        List<String> newList = new ArrayList<>();
        newList.add("ABCD");
        newList.add("BCDE");
        newList.add("CDEF");
        newList.add("DEFG");
        return newList;
    }

}
