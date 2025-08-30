package com.example.mcp.service;
import com.example.mcp.model.Book;
import com.example.mcp.model.BestSeller;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
@Service
public class BookService {
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Book> books;
    private List<BestSeller> bestSellers;
    @PostConstruct
    void load() {
        try (InputStream bi = getClass().getResourceAsStream("/books.json");
             InputStream bs = getClass().getResourceAsStream("/best_sellers.json")) {
            Map<String, Object> root = mapper.readValue(bi, new TypeReference<Map<String,Object>>(){});
            this.books = mapper.convertValue(root.get("books"), new TypeReference<List<Book>>(){});
            this.bestSellers = mapper.readValue(bs, new TypeReference<List<BestSeller>>(){});
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load mock data", e);
        }
    }
    public List<Book> search(String query) {
        String q = query.toLowerCase(Locale.ROOT);
        return books.stream().filter(b ->
                (b.getTitle()!=null && b.getTitle().toLowerCase(Locale.ROOT).contains(q)) ||
                (b.getAuthors()!=null && b.getAuthors().stream().anyMatch(a->a.toLowerCase(Locale.ROOT).contains(q))) ||
                (b.getGenre()!=null && b.getGenre().toLowerCase(Locale.ROOT).contains(q))
        ).collect(Collectors.toList());
    }
    public Optional<Book> getByIsbn(String isbn) {
        return books.stream().filter(b -> Objects.equals(b.getIsbn(), isbn)).findFirst();
    }
    public List<Book> recommendByGenre(String genre) {
        String g = genre==null ? "" : genre.toLowerCase(Locale.ROOT);
        return books.stream()
                .filter(b -> b.getGenre()!=null && b.getGenre().toLowerCase(Locale.ROOT).contains(g))
                .sorted(Comparator.comparingDouble(Book::getRating).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
    public List<Book> byAuthor(String author) {
        String a = author==null ? "" : author.toLowerCase(Locale.ROOT);
        return books.stream()
                .filter(b -> b.getAuthors()!=null && b.getAuthors().stream().anyMatch(x->x.toLowerCase(Locale.ROOT).contains(a)))
                .collect(Collectors.toList());
    }
    public List<Book> bestSellersByYear(int year) {
        Set<String> isbnsForYear = bestSellers.stream()
                .filter(b -> b.getYear()==year)
                .sorted(Comparator.comparingInt(BestSeller::getRank))
                .map(BestSeller::getIsbn)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Map<String, Book> byIsbn = new HashMap<>();
        for (Book b : books) byIsbn.putIfAbsent(b.getIsbn(), b);
        List<Book> result = new ArrayList<>();
        for (String isbn : isbnsForYear) {
            if (byIsbn.containsKey(isbn)) result.add(byIsbn.get(isbn));
        }
        return result;
    }
}
