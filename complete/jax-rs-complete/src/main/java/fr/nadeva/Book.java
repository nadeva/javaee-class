package fr.nadeva;


public class Book {

    private String title;
    private double price;
    private String description;


    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }


    public Book(String title, double price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        boolean isEqual=Double.compare(book.price, price) == 0;

        isEqual = isEqual &&  title != null ? title.equals(book.title) : book.title == null;
        isEqual = isEqual &&  description != null ? description.equals(book.description) : book.description == null;
        return isEqual;
    }


    @Override
    public int hashCode() {
        int result;
        result = title != null ? title.hashCode() : 0;
        result += 7 * Double.valueOf(price).hashCode();
        result += description != null ? 11 * description.hashCode() : 0;
        return result;
    }


}
