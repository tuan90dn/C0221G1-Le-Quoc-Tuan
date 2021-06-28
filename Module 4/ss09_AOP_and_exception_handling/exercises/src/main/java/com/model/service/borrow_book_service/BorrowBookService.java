package com.model.service.borrow_book_service;

import com.model.entity.BorrowBook;
import com.model.repository.IBookRepository;
import com.model.repository.IBorrowBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BorrowBookService implements IBorrowBookService{
    @Autowired
    private IBorrowBookRepository borrowBookRepository;
    @Override
    public List<BorrowBook> findAll() {
        return borrowBookRepository.findAll();
    }

    @Override
    public BorrowBook findById(Integer id) {
        return borrowBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BorrowBook borrowBook) {
        borrowBookRepository.save(borrowBook);
    }

    @Override
    public void remove(Integer id) {
        borrowBookRepository.deleteById(id);
    }

    @Override
    public BorrowBook findBorrowBookByCode(String code) {
        return borrowBookRepository.findBorrowBookByCode(code);
    }
}
