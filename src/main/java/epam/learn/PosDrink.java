package epam.learn;

import epam.learn.product.ProductBase;
import epam.learn.transaction.SaleTransaction;
import epam.learn.transaction.Transaction;

import java.math.BigDecimal;

/**
 * Created by Mykhailo on 010 10.07.17.
 */
public class PosDrink implements Pos {

    private BigDecimal balance = BigDecimal.ZERO;
    private Transaction transaction;

    public PosDrink() {
        this.transaction = new SaleTransaction();
    }

    @Override
    public void selectProduct(String name) {
        ProductBase.getProduct(name);
    }

    @Override
    public void putMoney(Currency currency) {
        balance = balance.add(currency.getValue());
        System.out.println("Currency added = $" + currency.getValue());
    }

    @Override
    public void finishTransaction() {
        System.out.println("Transaction is finished");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Transaction is canceled");
        transaction = null;
    }

    @Override
    public void returnProducts() {

    }

    @Override
    public void returnMoney() {

    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public Transaction getTransaction() {
        return transaction;
    }
}
