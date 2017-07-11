package epam.learn.product;

import java.math.BigDecimal;

/**
 * Created by Mykhailo on 010 10.07.17.
 */
public interface ProductDefinition {

    BigDecimal getPrice();
    String getName();
    String getDescription();

}
