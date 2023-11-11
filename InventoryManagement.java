import java.util.ArrayList;
import java.util.Scanner;


class InventoryItems {
    String name;
    int quantity;
    double price;

    InventoryItems(String n, int q, double p) {
        name = n;
        quantity = q;
        price = p;
    }

    void showItem(){
        System.out.println("Name: " + name + ", Quantity: " + quantity + ", Price: $" + price);
    }
}


public class InventoryManagement {
    public static void main(String[] args) {
        ArrayList<InventoryItems> inventory = new ArrayList<>();

        Scanner keyboard = new Scanner(System.in);
        while(true) {
            System.out.println("\nInventory Management");
            System.out.println("1. Add Item");
            System.out.println("2. Display Inventory");
            System.out.println("3. Edit Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = keyboard.nextInt();
            keyboard.nextLine();

            switch (choice) {
                case 1:
                    addItem(inventory, keyboard);
                    break;

                case 2:
                    showInventory(inventory);
                    break;

                case 3:
                    editItem(inventory, keyboard);
                    break;

                case 4:
                    deleteItem(inventory, keyboard);
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    keyboard.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }

    private static void addItem(ArrayList<InventoryItems> inventory, Scanner keyboard) {

        System.out.print("Enter items name: ");
        String name = keyboard.nextLine();

        System.out.print("Enter the quantity: ");
        int quantity = keyboard.nextInt();

        System.out.print("Enter the price: $");
        double price = keyboard.nextDouble();

        InventoryItems newItems = new InventoryItems(name, quantity, price);

        inventory.add(newItems);

        System.out.println("Item has been added!");

    }

    private static void showInventory(ArrayList<InventoryItems> inventory){
        System.out.println("Inventory Items: ");

        for(InventoryItems items : inventory){
            items.showItem();
        }
    }

    private static void editItem(ArrayList<InventoryItems> inventory, Scanner keyboard){
        System.out.print("Enter Item you want to edit: ");
        String name = keyboard.nextLine();

        for (InventoryItems items : inventory) {
            if (items.name.equals(name)) {
                System.out.println("What do you want to edit?");
                System.out.println("1. Name");
                System.out.println("2. Quantity");
                System.out.println("3. Price");
                System.out.println("Enter your choice: ");

                int choice = keyboard.nextInt();

                keyboard.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter the new name for item: ");
                        items.name = keyboard.nextLine();
                        System.out.println("Item has been updated!");
                        break;

                    case 2:
                        System.out.print("Enter the new quantity: ");
                        items.quantity = keyboard.nextInt();
                        System.out.println("Item quantity has been updated!");
                        break;

                    case 3:
                        System.out.print("Enter the new price : $");
                        items.price = keyboard.nextDouble();
                        System.out.println("Ite price has been updated!");
                        break;

                    default:
                        System.out.println("Invalid choice. No changes were made.");
                }
                return;
            }
        }

        System.out.println("Item not found in inventory.");
    }

    private static  void deleteItem(ArrayList<InventoryItems> inventory, Scanner keyboard){

        System.out.print("Enter the name of the item you want to delete: ");

        String name = keyboard.nextLine();

        for (int i = 0; i < inventory.size(); i++) {

            if (inventory.get(i).name.equals(name)){
                inventory.remove(i);
                System.out.println("Item has been deleted!");
                return;
            }
        }
    }
}
