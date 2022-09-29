public class OrderingSystem {

    static Map<Object, String> sizes = new HashMap<>();

    public static void main(String[] args) {
	greet();

    populateSizes();
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
    
}
