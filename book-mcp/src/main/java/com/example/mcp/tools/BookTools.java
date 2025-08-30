package com.example.mcp.tools;
import com.example.mcp.model.Book;
import com.example.mcp.service.BookService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import java.util.List;
@Component
@RequiredArgsConstructor
public class BookTools {
    private final BookService books;
    @Tool(name = "search_books", description = "Returns books based on search phrase (title, author, genre)")
    public List<Book> searchBooks(String query) {
        return books.search(query);
    }
    @Tool(name = "get_book_details", description = "Returns book details with ISBN")
    public Book getBookDetails(String isbn) {
        return books.getByIsbn(isbn).orElse(null);
    }
    @Tool(name = "recommend_books", description = "Book recommendations based on genre (top 10 with high scores)")
    public List<Book> recommendBooks(String genre) {
        return books.recommendByGenre(genre);
    }
    @Tool(name = "list_best_sellers", description = "Bestsellers by year (mock)")
    public List<Book> listBestSellers(String year) {
        try {
            int y = Integer.parseInt(year);
            return books.bestSellersByYear(y);
        } catch (Exception e) {
            return new java.util.ArrayList<>();
        }
    }
    @Tool(name = "find_by_author", description = "Returns books by author name")
    public List<Book> findByAuthor(String authorName) {
        return books.byAuthor(authorName);
    }
    @Tool(name = "ping", description = "Returns pong for testing")
    public String ping() {
        return "pong";
    }
}
