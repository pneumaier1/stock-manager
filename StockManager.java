import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
        Boolean itemFound = false;
        for(Product pro: stock)
        {
            if(pro.getID() == item.getID())
            {
                itemFound = true;
                break;
            }
        }
        if(itemFound == false)
            stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        for(Product pro : stock)
        {
            if(pro.getID() == id)
            {
                pro.increaseQuantity(amount);
            }        
        }
    }    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for(Product pro: stock)
        {
            if(pro.getID() == id)
            {
                return pro;
            }
        }
        return null;
    }
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        for(Product pro : stock)
        if(pro != null)
            return pro.getQuantity();
        else
        return 0;
        
        return 0;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        if(stock.size() == 0)
        {
            System.out.println("No product in stock to print details");
        }
        else
        {
            System.out.println("Details of product:");
            
            for(Product pro : stock)
            {
                    System.out.println(pro.toString());
            }
        }
    }
}    