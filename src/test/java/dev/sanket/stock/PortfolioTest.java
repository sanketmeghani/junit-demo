package dev.sanket.stock;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PortfolioTest
{
    @BeforeClass
    public static void beforeClass()
    {
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("After class");
    }

    @Before
    public void before()
    {
        System.out.println("Before");
    }

    @After
    public void after()
    {
        System.out.println("After");
    }

    @Test
    public void shouldAddStockToPortfolio()
    {
        Portfolio portfolio = new Portfolio();

        Stock stock = new Stock("Infi", 5);

        portfolio.addStock(stock);

        Assert.assertNotNull(portfolio.getStocks());
        Assert.assertEquals("Unexpected stock list size", 1, portfolio.getStocks().size());
    }

    @Test
    public void shouldReturnTotalValue()
    {
        Portfolio portfolio = new Portfolio();

        Stock stock = new Stock("Infi", 5);

        portfolio.addStock(stock);

        // Create
        StockMarket stockMarket = EasyMock.createMock(StockMarket.class);

        // Add Expectation
        EasyMock.expect(stockMarket.getPrice("Infi")).andReturn(10);

        EasyMock.replay(stockMarket);

        portfolio.setStockMarket(stockMarket);

        int totalValue = portfolio.getTotalValue();

        Assert.assertEquals("Unexpected portfolio total value", 50, totalValue);

        // Verify
        EasyMock.verify(stockMarket);
    }
}
