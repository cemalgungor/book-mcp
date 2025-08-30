# book-mcp

A minimal **Spring MCP server** for a Book Search & Recommendation use-case.

## Tools
- `search_books(query)` → title/author/genre içinde arar.
- `get_book_details(isbn)` → tek kitabın detaylarını döndürür.
- `recommend_books(genre)` → türe göre önerir.
- `list_best_sellers(year)` → örnek çok satanlar.
- `find_by_author(authorName)` → yazara göre arama.

All data served from a mock in-memory dataset in `books.json`.

## Build & Run
```bash
./mvnw clean package
java -jar target/book-mcp-0.0.1-SNAPSHOT.jar
```

## Use with Claude (STDIO)
```bash
claude mcp add book-mcp --   java -jar /abs/path/target/book-mcp-0.0.1-SNAPSHOT.jar
```
Then call tools from the chat:
- `search_books` with: `"deep learning"`
- `get_book_details` with: `"9780262035613"`
- `recommend_books` with: `"fantasy"`
- `list_best_sellers` with: `"2024"`
- `find_by_author` with: `"Brandon Sanderson"`
