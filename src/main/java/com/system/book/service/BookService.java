package com.system.book.service;

import com.system.book.dto.request.BookRequestDto;
import com.system.book.dto.response.BookResponseDto;
import com.system.book.model.Book;

import java.util.List;

public interface BookService {
    BookResponseDto saveBookInfo(BookRequestDto bookRequestDto);
    BookResponseDto getBookInfoById(Integer id);
    void deleteBookInfoById(Integer id);
    BookResponseDto updateBookInfo(Integer id, BookRequestDto bookRequestDto);
    List<BookResponseDto>getAllBook();
}
