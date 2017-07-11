package epam.learn.pos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import epam.learn.currency.Coin;
import epam.learn.product.Product;
import epam.learn.product.ProductDefinition;
import epam.learn.transaction.SaleTransaction;
import epam.learn.transaction.Transaction;
import epam.learn.transaction.TransactionItem;

public class PosDrink implements Pos {

    private CoinTray coinTray;
    private BigDecimal balance = BigDecimal.ZERO;
    private Transaction transaction;
    private List<Coin> balanceCoins;
    private List<Product> products;
    private ProductTray productTray;

    {
        products = Arrays.asList(new Product("tea", "Green tea with jasmin", new BigDecimal("0.25")),
                new Product("coffee", "Kopi Luwak", new BigDecimal("0.35")),
                new Product("juice", "Fresh seabuckthorn juice", new BigDecimal("0.45")));
    }

    public PosDrink() {
        this.coinTray = new CoinTray();
        this.productTray = new ProductTray();
        this.transaction = new SaleTransaction();
        this.balanceCoins = new ArrayList<>();
    }

    @Override
    public ProductDefinition getMenuItem(String name) {
        return products.stream().filter(item -> name.equalsIgnoreCase(item.getName())).findFirst()
                .orElseThrow(() -> new NoSuchElementException("There is no such product in the system: " + name));
    }

    @Override
    public void selectProduct(String name) {
        selectProduct(name, 1);
    }

    @Override
    public void selectProduct(String name, int quantity) {
        ProductDefinition product = getMenuItem(name);
        transaction.addTransactionItem(product, quantity);
    }

    @Override
    public void putCoin(Coin coin) {
        balance = balance.add(coin.getValue());
        balanceCoins.add(coin);
        System.out.println("Currency added = $" + coin.getValue());
    }

    @Override
    public void finishTransaction() {
        List<ProductDefinition> transactionProducts = new ArrayList<>();
        for (TransactionItem item : transaction.getTransactionItems()) {
            ProductDefinition product = item.getProduct();
            for (int i = 0; i < item.getQuantity(); i++) {
                transactionProducts.add(product);
            }
        }
        productTray.setSoldProduct(transactionProducts);
        coinTray.setReturnedCoins(calculateChange());
        transaction = new SaleTransaction();
        System.out.println("Transaction is finished");
    }

    private List<Coin> calculateChange() {
        List<Coin> changeCoins = new ArrayList<>();
        BigDecimal changeAmount = transaction.getTotal().subtract(balance).abs();
        System.out.println("[DEBUG]changeAmount = " + changeAmount);

        List<Coin> coins = Arrays.asList(Coin.values());
        coins.sort(Comparator.comparing(Coin::getValue).reversed());
        for (Coin coin : coins) {
            System.out.println("[DEBUG]coin = " + coin);
            while (changeAmount.compareTo(coin.getValue()) > -1) {
                changeCoins.add(coin);
                changeAmount = changeAmount.subtract(coin.getValue());
                System.out.println("[DEBUG]dueAmount = " + changeAmount);
            }
        }
        System.out.println("[DEBUG]changeCoins = " + changeCoins);
        return changeCoins;
    }

    @Override
    public void cancelTransaction() {
        coinTray.setReturnedCoins(balanceCoins);
        transaction = new SaleTransaction();
        System.out.println("Transaction is canceled. Please take your coins. See you later!");
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public CoinTray getCoinTray() {
        return coinTray;
    }

    @Override
    public ProductTray getProductTray() {
        return productTray;
    }
}
