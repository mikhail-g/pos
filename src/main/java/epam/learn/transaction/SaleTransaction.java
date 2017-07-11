package epam.learn.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import epam.learn.product.ProductDefinition;

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
    public void addTransactionItem(ProductDefinition product, Integer quantity) {
        items.add(new SaleTransactionItem(product, quantity));
    }

    @Override
    public List<TransactionItem> getTransactionItems() {
        return items;
    }
}
