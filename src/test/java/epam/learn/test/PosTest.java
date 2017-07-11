package epam.learn.test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import epam.learn.currency.Coin;
import epam.learn.pos.Pos;
import epam.learn.pos.PosDrink;
import epam.learn.product.ProductDefinition;

public class PosTest {

    private static final String PRODUCT_IS_NOT_ADDED = "The product is not added!";

    @Test
    public void posAcceptCoins() throws Exception {
        Pos pos = new PosDrink();
        pos.putCoin(Coin.ONE);
        pos.putCoin(Coin.FIVE);
        pos.putCoin(Coin.TEN);
        pos.putCoin(Coin.QUARTER);
        pos.putCoin(Coin.FIFTY);
        Assert.assertEquals("Coins are not accepted!", new BigDecimal("0.91"), pos.getBalance());
    }

    @Test
    public void posAllowsToSelectProduct() throws Exception {
        Pos pos = new PosDrink();
        pos.selectProduct("tea", 1);
        Assert.assertEquals(PRODUCT_IS_NOT_ADDED, "tea",
                pos.getTransaction().getTransactionItems().get(0).getProduct().getName());
        pos.selectProduct("coffee", 2);
        Assert.assertEquals(PRODUCT_IS_NOT_ADDED, "coffee",
                pos.getTransaction().getTransactionItems().get(1).getProduct().getName());
        pos.selectProduct("juice", 1);
        Assert.assertEquals(PRODUCT_IS_NOT_ADDED, "juice",
                pos.getTransaction().getTransactionItems().get(2).getProduct().getName());
    }

    @Test
    public void posAllowsToCancelTransactionAndReturnMoney() throws Exception {
        Pos pos = new PosDrink();
        pos.selectProduct("juice");
        pos.putCoin(Coin.FIFTY);
        pos.cancelTransaction();
        Assert.assertTrue("Wrong returned coins!", pos.getCoinTray().getReturnedCoins().contains(Coin.FIFTY));
        Assert.assertTrue("Products are returned to customer on transaction cancellation!",
                pos.getProductTray().getSoldProducts().isEmpty());
        Assert.assertTrue("Transaction is not empty after cancellation!",
                pos.getTransaction().getTransactionItems().isEmpty());
    }

    @Test
    public void posProvidesChangeAndProduct() throws Exception {
        Pos pos = new PosDrink();
        pos.selectProduct("juice", 3);
        pos.selectProduct("coffee");
        pos.putCoin(Coin.FIFTY);
        pos.putCoin(Coin.FIFTY);
        pos.putCoin(Coin.FIFTY);
        pos.putCoin(Coin.FIFTY);
        pos.finishTransaction();
        Assert.assertTrue("Wrong products are returned to customer!",
                pos.getProductTray().getSoldProducts().stream().map(ProductDefinition::getName)
                        .collect(Collectors.toList()).containsAll(Arrays.asList("juice", "juice", "juice", "coffee")));
        Assert.assertTrue("Wrong change calculation!",
                pos.getCoinTray().getReturnedCoins().containsAll(Arrays.asList(Coin.FIVE, Coin.QUARTER)));
        Assert.assertTrue("Transaction is not empty after finalization!",
                pos.getTransaction().getTransactionItems().isEmpty());
    }
}
