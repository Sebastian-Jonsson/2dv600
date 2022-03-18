package sj223gb_assign1;

/**
* Class Description: This class is about the eight task of assignment 1.
* A class that will be tested by the InvoiceTest class.
* 
* @version 1.0 7 September 2021
* @author Sebastian Jonsson
*/
public class Invoice {
    private String number;
    private String description;
    private int quantity;
    private double price;

    /**
     * The constructor of the invoice class.
     * 
     * @param number - The number of the invoice.
     * @param description - The description of the invoice.
     * @param quantity - The quantity of the invoice.
     * @param price - The price of the invoice.
     */
    public Invoice(String number, String description, int quantity, double price) {
        this.setNumber(number);
        this.setDescription(description);
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    /**
     * Gets the price of the invoice.
     * 
     * @return - The price of the invoice
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the invoice.
     * 
     * @param price - The price of the invoice.
     */
    public void setPrice(double price) {
        this.price = price;
        priceCheck(price);
    }

    /**
     * Gets the quantity of the invoice.
     * 
     * @return - The quantity of the invoice.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the invoice.
     * 
     * @param quantity - The quantity of the invoice.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        quantityCheck(quantity);
    }

    /**
     * Gets the description of the invoice. 
     * 
     * @return - The description of the invoice.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the invoice.
     * 
     * @param description - The description of the invoice.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the number of the invoice.
     * 
     * @return - The number of the invoice.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the number of the invoice.
     * 
     * @param number - The number of the invoice.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Calculates the total invoice amount by multiplying the quantity with the price.
     * 
     * @return - The multiplied value of the quantity and price.
     */
    public double getInvoiceAmount() {
        return this.quantity * this.price;
    }

    /**
     * Checks that the quantity is not a negative number.
     * 
     * @param quantity - The quantity of the invoice.
     */
    private void quantityCheck(int quantity) {

        if (quantity < 0) {
            this.quantity = 0;
        }
    }

    /**
     * Checks that the price is not a negative number.
     * 
     * @param price - The price of the invoice.
     */
    private void priceCheck(double price) {
    
        if (price < 0.0) {
            this.price = 0.0;
        }
    }

}
