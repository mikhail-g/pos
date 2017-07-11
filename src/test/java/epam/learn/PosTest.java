package epam.learn;

import java.math.BigDecimal;

import epam.learn.product.ProductBase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mykhailo on 010 10.07.17.
 */
public class PosTest {

    @Test
    public void posAcceptCoins() throws Exception {
        Pos pos = new PosDrink();
        pos.putMoney(Coin.ONE);
        pos.putMoney(Coin.FIVE);
        pos.putMoney(Coin.TEN);
        pos.putMoney(Coin.QUARTER);
        pos.putMoney(Coin.FIFTY);
        Assert.assertEquals("Coins are not accepted", new BigDecimal("0.91"), pos.getBalance());
    }

    @Test
    public void posAllowsToSelectProduct() throws Exception {
        Pos pos = new PosDrink();
        pos.selectProduct("tea");
        Assert.assertEquals("Product is not added", "tea",
                pos.getTransaction().getTransactionItems().get(0).getProduct().getName());
        pos.selectProduct("coffee");
        Assert.assertEquals("Product is not added", "coffee",
                pos.getTransaction().getTransactionItems().get(0).getProduct().getName());
        pos.selectProduct("juice");
        Assert.assertEquals("Product is not added", "juice",
                pos.getTransaction().getTransactionItems().get(0).getProduct().getName());
    }

    @Test
    public void posAllowsToCancelTransactionAndReturnMoney() throws Exception {
        Pos pos = new PosDrink();
        ProductBase.initProducts();
        pos.selectProduct("tea");
        pos.putMoney(Coin.QUARTER);
        pos.cancelTransaction();
        Assert.fail("not implemented method");
    }

    @Test
    public void posProvidesChangeAndProduct() throws Exception {
        Pos pos = new PosDrink();
        ProductBase.initProducts();
        pos.selectProduct("tea");
        pos.putMoney(Coin.QUARTER);
        pos.finishTransaction();
        Assert.fail("not implemented method");
    }
}
