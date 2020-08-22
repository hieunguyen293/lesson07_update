package Test;

public class Book {

    String name, origin, type;
    float price, numberOfPage;

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setNumberOfPage(float numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public float getNumberOfPage() {
        return numberOfPage;
    }

    public Book() {

    }

    public Book(String name, String origin, String type, float price, float numberOfPage) {
        this.name = name;
        this.origin = origin;
        this.type = type;
        this.price = price;
        this.numberOfPage = numberOfPage;
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + name + ", origin=" + origin + ", type=" + type + ", price=" + price + ", numberOfPage=" + numberOfPage + '}';
    }

}
