package epam.learn.transaction;

import epam.learn.product.ProductDefinition;

import java.math.BigDecimal;

/**
 * Created by Mykhailo on 010 10.07.17.
 */
public interface TransactionItem {

    Integer getQuantity();
    BigDecimal getSubtotal();
    ProductDefinition getProduct();

}
