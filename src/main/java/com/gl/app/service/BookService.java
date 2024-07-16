package com.gl.app.service;

import com.gl.app.Dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDTO> getAllBooks();
    Optional<BookDTO> getBookById(Long id);
    BookDTO saveBook(BookDTO bookDTO);
    void deleteBook(Long id);
    BookDTO updateBook(Long id, BookDTO bookDetails);
}
