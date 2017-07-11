package epam.learn.pos;

import java.math.BigDecimal;

import epam.learn.currency.Coin;
import epam.learn.product.ProductDefinition;
import epam.learn.transaction.Transaction;

public interface Pos {

    void selectProduct(String name, int quantity);

    void selectProduct(String name);

    ProductDefinition getMenuItem(String name);

    void putCoin(Coin coin);

    void finishTransaction();

    void cancelTransaction();

    BigDecimal getBalance();

    Transaction getTransaction();

    CoinTray getCoinTray();

    ProductTray getProductTray();
}
