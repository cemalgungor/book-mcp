package com.example.mcp.model;
import lombok.Data;

import java.util.List;
@Data
public class Book {
    private String isbn;
    private String title;
    private List<String> authors;
    private String genre;
    private int year;
    private double rating;
    private String summary;
}
