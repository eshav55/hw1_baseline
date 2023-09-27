import javax.swing.JOptionPane;
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
    // Create an instance of InputValidation
    InputValidation inputValidation = new InputValidation(); 

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
      double amount = view.getAmountField();
      String category = view.getCategoryField();
      // Use InputValidation to validate the inputs
        if (inputValidation.validateAmount(amount) && inputValidation.isValidCategory(category)) {
            // Create a transaction object
            Transaction t = new Transaction(amount, category);

            // Call the controller to add transaction
            view.addTransaction(t);
        } else {
          // Display error message to user in case of invalid input
          JOptionPane.showMessageDialog(view, "Invalid input. Please check your amount and category.");
        }
    });
}
}