package com.system.book.dto.response;

import com.system.book.dto.request.BookRequestDto;
import com.system.book.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private Integer id;
    private String name;
    private String author;
    private double price;

    public BookResponseDto(Book add){
        this.id=add.getId();
        this.author=add.getAuthor();
        this.name=add.getName();
        this.price=add.getPrice();
    }
    public BookResponseDto(BookRequestDto add){
        this.author=add.getAuthor();
        this.name=add.getName();
        this.price=add.getPrice();
    }



}
