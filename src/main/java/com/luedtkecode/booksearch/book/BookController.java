package com.luedtkecode.booksearch.book;

import com.google.api.services.books.model.Volume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/books/{name}")
    public List<Volume> getBooksByName(@PathVariable String name) {
        return bookService.getBooksByName(name);
    }
}
