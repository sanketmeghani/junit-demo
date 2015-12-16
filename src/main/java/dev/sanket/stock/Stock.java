package dev.sanket.stock;

public class Stock
{
    private String name;
    private int quantity;

    public Stock(String name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }
}
