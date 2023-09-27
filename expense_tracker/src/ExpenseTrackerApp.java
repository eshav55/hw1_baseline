import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
      double amount = view.getAmountField(); 
      String category = view.getCategoryField();
      
      // Validate the amount input
      if (!InputValidation.isDouble(amountStr)) {
        view.showErrorMessage("Invalid amount. Please enter a valid number.");
        return; // Exit the action if the amount is not a valid number
    }
    double amount = Double.parseDouble(amountStr);

    // Validate the category input
    if (!InputValidation.isValidCategory(category)) {
        view.showErrorMessage("Invalid category. Please enter a valid category (food, travel, bills, entertainment, other).");
        return; // Exit the action if the category is not valid
    }
      // Create transaction object
      Transaction t = new Transaction(amount, category);

      // Call controller to add transaction
      view.addTransaction(t);
    });

  }

}