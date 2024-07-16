package com.gl.app.utils;

import com.gl.app.BookMangementSystemApplication;
import com.gl.app.Dto.BookDTO;
import com.gl.app.entity.Book;
import org.modelmapper.ModelMapper;
import org.w3c.dom.events.Event;

public class Mapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public static ModelMapper modelMapper() {
        return modelMapper;
    }

    public static BookDTO mapToBookDTO(Book book)
    {
        return BookMangementSystemApplication.modelMapper().map(book, BookDTO.class);

    }

    public static Book mapToBook(BookDTO bookDTO){
        return BookMangementSystemApplication.modelMapper().map(bookDTO, Book.class);
    }
}
