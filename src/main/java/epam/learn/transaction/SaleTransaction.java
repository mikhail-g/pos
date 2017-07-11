package epam.learn.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mykhailo on 010 10.07.17.
 */
public class SaleTransaction implements Transaction {

    private LocalDate date;
    private LocalTime time;
    private List<TransactionItem> items;

    public SaleTransaction() {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.items = new ArrayList<>();
    }

    @Override
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public LocalTime getTime() {
        return this.time;
    }

    @Override
    public BigDecimal getTotal() {
        return items.stream().map(TransactionItem::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void addTransactionItem(TransactionItem transactionItem) {
        items.add(transactionItem);
    }

    @Override
    public List<TransactionItem> getTransactionItems() {
        return items;
    }
}
