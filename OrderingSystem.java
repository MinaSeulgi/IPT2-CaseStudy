import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class OrderingSystem {
    
    static Map<Object,String> toppings = new HashMap<>();
    static Map<Object, String> sizes = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        greet();

        populateSizes();
        String userSize = askForSize();

        String userToppingQuantity = askForToppingQuantity();
    }
        
    private static String askForToppingQuantity() {
        String quantity = "";
        boolean isValidQuantity = false;
        while (!isValidQuantity) {
            System.out.print("\nHow many toppings do you want?\nThere are only " + toppings.size() + " number toppings to choose from => ");
            quantity = sc.nextLine();
            isValidQuantity = validate(quantity, "quantity");
            System.out.println((!isValidQuantity ? "INVALID INPUT" : getResponse()));
        }
        return quantity;
    }

    private static void greet() {
        System.out.println("""
                           WELCOME TO LA LUNA PIZZA STORE!
                           You can buy assured that we provide quality pizzas!""");
    }

    private static void populateSizes() {
        sizes.put(1, "Small");
        sizes.put(2, "Regular");
        sizes.put(3, "Medium");
        sizes.put(4, "Large");
        sizes.put(5, "Jumbo");
    }

	 private static String askForSize() {
        String selectedSize = "";
        boolean isValidSize = false;
        while (!isValidSize) {
            System.out.println("\nTo start, choose your desired size:");
            for(Map.Entry<Object, String> entry : sizes.entrySet()) {
                System.out.printf("\t%s. %s\n", entry.getKey(), entry.getValue());
            }
            System.out.print("Enter number => ");
            selectedSize = sc.nextLine();
            isValidSize = validate(selectedSize, "size");
            System.out.println((!isValidSize ? "INVALID INPUT" : getResponse()));
        }
        return sizes.get(Integer.parseInt(selectedSize));
    }
    
    private static boolean isSizePresent(int key) {
        return sizes.containsKey(key);
    }

    private static boolean validate(String num, String type) {
        try {
            boolean isPresent;
            switch(type) {
                case "size":
                    isPresent = isSizePresent(Integer.parseInt(num));
                    if (!isPresent) { return false; }
                case "topping":
                    isPresent = isToppingPresent(Integer.parseInt(num));
                    if (!isPresent) { return false; }
                case "quantity":
                    if (Integer.parseInt(num) > toppings.size()) { return false; }
            }
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    private static String[] askForToppings(int quantity) {
        List<String> selectedToppings = new ArrayList<>();
        String topping;
        boolean isDoneSelecting = false;
        while (!isDoneSelecting) {
            System.out.println("\nNow, choose your desired toppings one at a time:");
            for(Map.Entry<Object, String> entry : toppings.entrySet()) {
                System.out.printf("\t%s. %s\n", entry.getKey(), entry.getValue());
            }
            
            boolean isDone = false;
            boolean isValid;
            while (!isDone) {
                System.out.print("Enter number => ");
                topping = sc.nextLine();
                isValid = validate(topping, "topping");
                if(isValid) {
                    if(selectedToppings.contains(toppings.get(Integer.parseInt(topping)))) {
                        System.out.println("THAT TOPPING IS ALREADY SELECTED!");
                        continue;
                    } else {
                        selectedToppings.add(toppings.get(Integer.parseInt(topping)));
                    }
                }
                System.out.println((!isValid ? "INVALID INPUT" : getResponse()));
                if (selectedToppings.size() < quantity) { System.out.println("YOUR SELECTION SO FAR: " + selectedToppings); }
                isDone = selectedToppings.size() == quantity;
            }
            break;
        }
        return selectedToppings.toArray(new String[quantity]);
    }
    
    private static boolean isToppingPresent(int key) {
        return toppings.containsKey(key);
    }
    

}
