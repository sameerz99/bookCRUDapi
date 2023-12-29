package com.system.book.dto.errorDto;

import com.system.book.dto.response.BookResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookErrorDto extends BookResponseDto {
    private String message;
}
