package com.nyu.leetcode;

import java.util.*;

public class StockPriceFluctuation {

    int maxTimestamp;
    HashMap<Integer, Integer> timePriceMap;
    TreeMap<Integer, Integer> prices;

    public StockPriceFluctuation() {
        maxTimestamp = 0;
        timePriceMap = new HashMap<Integer, Integer>();
        prices = new TreeMap<Integer, Integer>();
    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        int prevPrice = timePriceMap.getOrDefault(timestamp, 0);
        timePriceMap.put(timestamp, price);
        if (prevPrice > 0) {
            prices.put(prevPrice, prices.get(prevPrice) - 1);
            if (prices.get(prevPrice) == 0) {
                prices.remove(prevPrice);
            }
        }
        prices.put(price, prices.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timePriceMap.get(maxTimestamp);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }

    public static void main(String[] args) {
        StockPriceFluctuation stockPriceFluctuation = new StockPriceFluctuation();
        stockPriceFluctuation.update(1, 10);
        stockPriceFluctuation.update(2, 5);
        System.out.println(stockPriceFluctuation.current());
        System.out.println(stockPriceFluctuation.maximum());
        stockPriceFluctuation.update(1, 3);
        System.out.println(stockPriceFluctuation.maximum());
        stockPriceFluctuation.update(4, 2);
        System.out.println(stockPriceFluctuation.minimum());
    }
}
