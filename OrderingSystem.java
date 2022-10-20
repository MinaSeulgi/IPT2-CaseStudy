public class OrderingSystem {

    static Map<Object, String> sizes = new HashMap<>();

    public static void main(String[] args) {
	greet();

    populateSizes();
    String userSize = askForSize();
    }

    private static void greet() {
        System.out.println("""
                           WELCOME TO LA LUNA PIZZA STORE!
                           You can buy assured that we provide quality pizzas!"");
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
        return sizes.containsKey();
    }

}
