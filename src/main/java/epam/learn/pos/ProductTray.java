package epam.learn.pos;

import java.util.ArrayList;
import java.util.List;

import epam.learn.product.ProductDefinition;

public class ProductTray {

    private List<ProductDefinition> soldProduct;

    {
        soldProduct = new ArrayList<>();
    }

    public List<ProductDefinition> getSoldProducts() {
        return soldProduct;
    }

    void setSoldProduct(List<ProductDefinition> soldProduct) {
        this.soldProduct = soldProduct;
    }
}
