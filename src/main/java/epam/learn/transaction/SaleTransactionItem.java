package epam.learn.transaction;

import java.math.BigDecimal;

import epam.learn.product.ProductDefinition;

public class SaleTransactionItem implements TransactionItem {

    private Integer quantity;
    private ProductDefinition product;

    SaleTransactionItem(ProductDefinition product, Integer quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public BigDecimal getSubtotal() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public ProductDefinition getProduct() {
        return product;
    }
}
