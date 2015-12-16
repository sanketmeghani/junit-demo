package dev.sanket.stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Portfolio
{
    private StockMarket stockMarket;

    private List<Stock> stocks = new ArrayList<Stock>();

    public void addStock(Stock stock)
    {
        this.stocks.add(stock);
    }

    public List<Stock> getStocks()
    {
        return Collections.unmodifiableList(stocks);
    }

    public int getTotalValue()
    {
        int totalValue = 0;

        for (Stock stock : stocks)
        {
            totalValue = totalValue + (stock.getQuantity() * stockMarket.getPrice(stock.getName()));
        }
     
        return totalValue;
    }

    public void setStockMarket(StockMarket stockMarket)
    {
        this.stockMarket = stockMarket;
    }
}
