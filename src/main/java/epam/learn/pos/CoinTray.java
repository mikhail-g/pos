package epam.learn.pos;

import epam.learn.currency.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoinTray {

    private List<Coin> returnedCoins;

    {
        returnedCoins = new ArrayList<>();
    }

    public List<Coin> getReturnedCoins() {
        return returnedCoins;
    }

    void setReturnedCoins(List<Coin> returnedCoins) {
        this.returnedCoins = returnedCoins;
    }
}
