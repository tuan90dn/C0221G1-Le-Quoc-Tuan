package com.controller;

import com.exception.NotFoundException;
import com.exception.QuantityException;
import com.model.entity.Book;
import com.model.entity.BorrowBook;
import com.model.repository.IBookRepository;
import com.model.service.book_service.IBookService;
import com.model.service.borrow_book_service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowBookService borrowBookService;
    @GetMapping(value = "/borrow")
    public String showListBook(Model model){
        List<Book> bookList=bookService.findAll();
        model.addAttribute("bookList",bookList);
        return "borrow";
    }
    @GetMapping(value = "/borrow/{idBook}")
    public String borrowBook(@PathVariable int idBook,Model model) throws QuantityException {
        Book book = bookService.findById(idBook);
        Integer numberOfBook=book.getNumber();
        if (numberOfBook==0){
            throw new QuantityException();
        }
        book.setNumber(numberOfBook-1);
        bookService.save(book);
        int code= (int) (Math.random()*100000);
        String codeBorrowBook=String.valueOf(code);
        model.addAttribute("codeBook","Mã mượn sách của bạn là: "+codeBorrowBook);
        BorrowBook borrowBook=new BorrowBook();
        borrowBook.setCodeBorrow(String.valueOf(code));
        borrowBook.setBook(book);
        borrowBookService.save(borrowBook);
        return "home";
    }
    @GetMapping(value = "/return")
    public String showReturn(){
        return "return";
    }
    @PostMapping(value = "/return")
    public String returnBook(@RequestParam String code,Model model) throws NotFoundException {
        BorrowBook borrowBook=borrowBookService.findBorrowBookByCode(code);
        if (borrowBook==null){
            throw new NotFoundException();
        }
        Book book=borrowBook.getBook();
        book.setNumber(book.getNumber()+1);
        bookService.save(book);
        borrowBookService.remove(borrowBook.getId());
        model.addAttribute("codeBook","Return successful!");
        return "home";
    }
    @ExceptionHandler(QuantityException.class)
    public String showQuantityErrorPage(){
        return "quantity_error";
    }
    @ExceptionHandler(NotFoundException.class)
    public String showNotFoundErrorPage(){
        return "not_found_error";
    }



}
