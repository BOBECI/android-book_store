package com.zurefaseverler.kithub;
public class Book {
    private int book_id, stockQuantity, price, sales, ratedCount;
    private float rating;
    private String ISBN, title, summary, image ,author, category, bookType;

    public Book(int book_id, String author, int stockQuantity, String category, String bookType,
                int price, int sales, int ratedCount, int rating, String ISBN, String title,
                String summary, String image) {
        this.book_id = book_id;
        this.author = author;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.bookType = bookType;
        this.price = price;
        this.sales = sales;
        this.ratedCount = ratedCount;
        this.rating = rating;
        this.ISBN = ISBN;
        this.title = title;
        this.summary = summary;
        this.image = image;
    }

    public int getBook_id() {
        return book_id;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public int getPrice() {
        return price;
    }

    public int getSales() {
        return sales;
    }

    public int getRatedCount() {
        return ratedCount;
    }

    public float getRating() {
        return rating;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getBookType() {
        return bookType;
    }
}
