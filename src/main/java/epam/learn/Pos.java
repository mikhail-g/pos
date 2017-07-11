package epam.learn;


import epam.learn.transaction.Transaction;

import java.math.BigDecimal;

/**
 * Created by Mykhailo on 010 10.07.17.
 */
public interface Pos {

//    void showMenu();
    void selectProduct(String name);
    void putMoney(Currency currency);
    void finishTransaction();
    void cancelTransaction();
    void returnProducts();
    void returnMoney();
    BigDecimal getBalance();
    Transaction getTransaction();
}
