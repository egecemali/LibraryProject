public class Books {
    private int book_id;
    private String book_name;
    private String author;

    public Books(int book_id, String book_name, String author) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author = author;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book Id=" + book_id +
                ", Book Name='" + book_name + '\'' +
                ", Book Author='" + author + '\'' ;
    }

}
