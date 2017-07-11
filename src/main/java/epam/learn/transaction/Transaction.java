package epam.learn.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import epam.learn.product.ProductDefinition;

public interface Transaction {

    LocalDate getDate();

    LocalTime getTime();

    BigDecimal getTotal();

    void addTransactionItem(ProductDefinition product, Integer quantity);

    List<TransactionItem> getTransactionItems();

}
