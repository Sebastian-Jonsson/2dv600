package sj223gb_assign1;

/**
* Class Description: This class is about the eight task of assignment 1.
* A class intended to demonstrate the capabilities of the Invoice class.
* 
* @version 1.0 7 September 2021
* @author Sebastian Jonsson
*/
public class InvoiceTest {
    String articleNumber = "35E8679C12";
    String description = "A green pet dragon of about 45 cubic centimeters.";
    int quantity = 10;
    double price = 59.90;

    String newArticleNumber = "12C9768E53";
    String newDescription = "A red pet dragon of about 25 cubic centimeters.";
    int newQuantity = 5;
    double newPrice = 29.10;

    int negativeQuantityTest = -5;
    double negativePriceTest = -100.0;
    
    Invoice invoice = new Invoice(articleNumber, description, quantity, price);

    /**
     * Initiates the demonstration of the Invoice class and prints the result of it.
     */
    public void runDemonstration() {
        System.out.println("༼ʘ̚ل͜ʘ̚༽- Hi!\nDemonstration starting...\n\nOriginal Invoice: \n");
        getInvoice();
        setInvoice();

        System.out.println("\n\nAfter setting the invoice to new values: \n");
        getInvoice();

        invoiceNegativeTest(negativeQuantityTest, negativePriceTest);
    }

    /**
     * Calls all getters in the Invoice class and shows the current values on each of them.
     */
    private void getInvoice() {
        System.out.println("Number: " + invoice.getNumber() +
         "\nDescription: " + invoice.getDescription() + 
         "\nQuantity: " + invoice.getQuantity() + 
         "\nPrice: " + invoice.getPrice() + 
         "$" + "\nInvoice Amount: " + invoice.getInvoiceAmount() + "$");
    }

    /**
     * Call all setters in the Invoice class and sets new values on each of them.
     */
    private void setInvoice() {
        invoice.setNumber(newArticleNumber);
        invoice.setDescription(newDescription);
        invoice.setQuantity(newQuantity);
        invoice.setPrice(newPrice);
    }

    /**
     * Demonstrates the Invoice.quantityCheck which makes certain no values beneath 0 are allowed and set to 0 if a negative value is input.
     * 
     * @param testQuantity - A negative test value.
     */
    private void invoiceNegativeTest(int testQuantity, double testPrice) {
        invoice.setQuantity(testQuantity);
        invoice.setPrice(testPrice);
        
        System.out.println("\n\nInvoice negative test: \nQuantity input value: " 
        + testQuantity + "\nQuantity output value: " + invoice.getQuantity() + 
        "\n\nPrice input value: " + testPrice + "\nPrice output value: " + invoice.getPrice());
    }

}
