package epam.learn.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Mykhailo on 010 10.07.17.
 */
public interface Transaction {

    LocalDate getDate();
    LocalTime getTime();
    BigDecimal getTotal();
    void addTransactionItem(TransactionItem transactionItem);
    List<TransactionItem> getTransactionItems();

}
