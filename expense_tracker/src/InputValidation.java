import java.util.Arrays;
import java.util.List;

public class InputValidation{
    //Define the maximum and minimum transaction amount 
    private static double minAmount = 0;
    private static double maxAmount = 1000;

    public boolean validateAmount(double amount) {
        return (amount >= minAmount) && (amount <= maxAmount);
    }
    public boolean isValidCategory(String category){
        //Define list of valid categories 
        List<String> listOfValidCategories = Arrays.asList("food", "travel", "bills", "entertainment", "other");
        return listOfValidCategories.contains(category);
    }

}