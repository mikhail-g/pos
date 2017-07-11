package epam.learn.product;

import java.math.BigDecimal;

/**
 * Created by Mykhailo on 010 10.07.17.
 */
public class Product implements ProductDefinition {

    private String name;
    private String description;
    private BigDecimal price;

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
