package epam.learn.transaction;

import epam.learn.product.ProductDefinition;

import java.math.BigDecimal;

/**
 * Created by Mykhailo on 010 10.07.17.
 */
public class SaleTransactionItem implements TransactionItem{

    private Integer quantity;
    private ProductDefinition product;

    public SaleTransactionItem(ProductDefinition product, Integer quantity) {
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
