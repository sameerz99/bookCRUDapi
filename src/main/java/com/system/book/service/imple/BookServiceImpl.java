package com.system.book.service.imple;

import com.system.book.dto.errorDto.BookErrorDto;
import com.system.book.dto.request.BookRequestDto;
import com.system.book.dto.response.BookResponseDto;
import com.system.book.exception.BookNotFoundException;
import com.system.book.model.Book;
import com.system.book.repo.BookRepo;
import com.system.book.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookResponseDto saveBookInfo(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setName(bookRequestDto.getName());
        book.setAuthor(bookRequestDto.getAuthor());
        book.setPrice(bookRequestDto.getPrice());
        Book savedBook = bookRepo.save(book);
        BookResponseDto bookResponseDto = new BookResponseDto(savedBook);
        return bookResponseDto;
    }

    @Override
    public BookResponseDto getBookInfoById(Integer id) {
        try{
            Optional<Book> optionalBook = bookRepo.findById(id);
            if(optionalBook.isPresent()){
                Book book = optionalBook.get();
                return new BookResponseDto(book);
            }else{
                throw new BookNotFoundException("Book with ID " + id + " not found");
            }
        }
        catch(BookNotFoundException e) {
            System.out.println(e);
            return new BookErrorDto(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteBookInfoById(Integer id) {
        bookRepo.deleteById(id);
    }

    @Override
    public BookResponseDto updateBookInfo(Integer id, BookRequestDto bookRequestDto) {
        try{
            Optional<Book> optionalBook = bookRepo.findById(id);
            if(optionalBook.isPresent()){
                Book book = optionalBook.get();
                book.setName(bookRequestDto.getName());
                book.setAuthor(bookRequestDto.getAuthor());
                book.setPrice(bookRequestDto.getPrice());
                Book savedBook = bookRepo.save(book);
                return new BookResponseDto(savedBook);
            }else{
                throw new BookNotFoundException("Book with ID " + id + " not found");
            }
        }
        catch(BookNotFoundException e) {
            System.out.println(e);
            return new BookErrorDto(e.getMessage());
        }
    }

    @Override
    public List<BookResponseDto> getAllBook() {
        List<BookResponseDto> returnList = new ArrayList<>();
        List<Book> bookList = bookRepo.findAll();
        for(Book book: bookList){
            BookResponseDto bookResponseDto = new BookResponseDto(book);
            returnList.add(bookResponseDto);
        }
        return returnList;
    }
}
