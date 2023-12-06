package jp.ac.morijyobi.book_management2.service;

import jp.ac.morijyobi.book_management2.bean.entity.Book;
import jp.ac.morijyobi.book_management2.bean.form.BookForm;

import java.util.List;

public interface BookService {

    void registerBook(BookForm bookForm);

    List<Book> getBooksByKeyword(String keyword);

    Book getBookById(int bookId);

    boolean registerBookLoan(int bookId, String username);
}
