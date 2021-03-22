package Stream.Tasks.Eshop.expertsoft1.model;

import java.math.BigDecimal;

public class Product {

    public enum Color {
        WHITE,
        BLACK,
        RED,
        BLUE,
        YELLOW
    }

    private long id;
    private String name;
    private Color color;
    private BigDecimal price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal setPrice(BigDecimal price) {
        return this.price = price;
    }

    @Override
    public String toString() {
        return "Product #" + id + " (" + name + ")";
    }
}
