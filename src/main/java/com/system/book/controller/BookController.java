package com.system.book.controller;

import com.system.book.dto.request.BookRequestDto;
import com.system.book.dto.response.BookResponseDto;
import com.system.book.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/save")
    public ResponseEntity<BookResponseDto> saveBookInfo(@RequestBody BookRequestDto bookRequestDto){
        return new ResponseEntity<>(bookService.saveBookInfo(bookRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookResponseDto>> getAllBook(){
        return new ResponseEntity<>(bookService.getAllBook(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookInfoById(@PathVariable Integer id){
        return new ResponseEntity<>(bookService.getBookInfoById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookInfo(@PathVariable Integer id,@RequestBody BookRequestDto bookRequestDto){
        return new ResponseEntity<>(bookService.updateBookInfo(id, bookRequestDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookInfoById(@PathVariable Integer id){
        bookService.deleteBookInfoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
