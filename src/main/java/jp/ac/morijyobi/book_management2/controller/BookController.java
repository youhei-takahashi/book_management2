package jp.ac.morijyobi.book_management2.controller;

import jp.ac.morijyobi.book_management2.bean.dto.LoanedBookDTO;
import jp.ac.morijyobi.book_management2.bean.entity.Book;
import jp.ac.morijyobi.book_management2.bean.entity.Tag;
import jp.ac.morijyobi.book_management2.bean.form.BookForm;
import jp.ac.morijyobi.book_management2.service.BookService;
import jp.ac.morijyobi.book_management2.service.TagService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String bookList(@RequestParam(defaultValue = "") String keyword,
                           Model model) {
        List<Book> bookList = bookService.getBooksByKeyword(keyword);
        model.addAttribute("bookList", bookList);

        return "book/book-list";
    }

    @GetMapping("/loan")
    public String bookLoan(@RequestParam int bookId,
                           Model model) {
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book);

        return "book/book-loan";
    }

    @PostMapping("/loan")
    public String bookLoanExe(@RequestParam int id,
                              @AuthenticationPrincipal UserDetails userDetails,
                              RedirectAttributes redirectAttributes,
                              Model model) {

        if (bookService.registerBookLoan(id, userDetails.getUsername())) {
            redirectAttributes.addFlashAttribute("message", "貸出が完了しました。");
        } else {
            redirectAttributes.addFlashAttribute("warning", "貸出に失敗しました。");
        }
        return "redirect:/book/list";
    }

    @GetMapping("/loans")
    public String loanedBooks(@AuthenticationPrincipal UserDetails userDetails,
                              Model model) {
        List<LoanedBookDTO> loanedBookList = bookService.getLoanedBooksByUser(userDetails);
        model.addAttribute("loanedBookList", loanedBookList);

        return "book/loaned-books";
    }

    @GetMapping("return")
    public String returnBook(@RequestParam int bookId,
                             @AuthenticationPrincipal UserDetails userDetails,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        if (bookService.returnBookLoans(bookId, userDetails)) {
            redirectAttributes.addFlashAttribute("message", "返却が完了しました。");
        } else {
            redirectAttributes.addFlashAttribute("warning", "返却に失敗しました。");
        }
        return "redirect:/book/loans";
    }

}
