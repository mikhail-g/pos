package epam.learn.transaction;

import java.math.BigDecimal;

import epam.learn.product.ProductDefinition;

public interface TransactionItem {

    Integer getQuantity();

    BigDecimal getSubtotal();

    ProductDefinition getProduct();

}
