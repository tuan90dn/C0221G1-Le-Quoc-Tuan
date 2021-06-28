package com.model.service.book_service;

import com.model.entity.Book;
import com.model.entity.BorrowBook;
import com.model.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BorrowBook findBorrowBookByCode(String code) {
        return null;
    }

//    @Override
//    public Page<Book> findByName(String name, Pageable pageable) {
//        return bookRepository.findBookByName("%"+name+"%",pageable);
//    }
}
