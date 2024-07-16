package com.gl.app.service.Impl;

import com.gl.app.Dto.BookDTO;
import com.gl.app.entity.Book;
import com.gl.app.exception.ResourceNotFoundException;
import com.gl.app.repository.BookRepository;
import com.gl.app.service.BookService;

import com.gl.app.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.gl.app.utils.Mapper.*;

@Service
public class BookServiceImpl  implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(Mapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDTO> getBookById(Long id) {
        Optional<Book> books = Optional.ofNullable(bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book", "id", id)
        ));
        return books.map(Mapper::mapToBookDTO);
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = mapToBook(bookDTO);
        Book savedBook = bookRepository.save(book);
        return mapToBookDTO(savedBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDetails) {
        Book book1 = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));

        book1.setTitle(bookDetails.getTitle());
        book1.setAuthor(bookDetails.getAuthor());
        book1.setIsbn(bookDetails.getIsbn());
        Book updateBook = bookRepository.save(book1);
        return Mapper.mapToBookDTO(updateBook);
    }
}
