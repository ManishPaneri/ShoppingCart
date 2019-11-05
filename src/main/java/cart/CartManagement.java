package cart;

import catelog.Products;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartManagement {

    @Autowired
    Products products = Products.getInstance();

    @Autowired
    Cart cart = new Cart();
    private int ch = 0;

    public CartManagement () {
        menu();
    }

    public void startScreen () {
        System.out.println("1. Display Store Products");
        System.out.println("2. Display Cart");
        System.out.println("0. Exit");
        System.out.println("\n");
    }

    public void storeProductsMenu() {
        System.out.println("1. Add to Cart");
        System.out.println("2. Remove From Cart");
        System.out.println("0. Exit");
    }

    public void menu () {
        do {
            startScreen();
            getUserInput();

            switch (ch) {
                case 1:
                    storeProductsMenu();
                    displayStoreProducts();
                    getUserInput();
                    innerChoice1();
                    break;
                case 2:
                    showCart();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:

                    break;
            }
        } while (ch != 0);
    }

    public void innerChoice1() {
        switch (ch) {
            case 1:
                addProductToCart();
                showCart();
                break;
            case 2:
                removeProductFromCart();
                break;
            default:

                break;
        }
    }

    public int getUserInput() throws NumberFormatException {
        Scanner in = new Scanner (System.in);
        ch = Integer.parseInt(in.nextLine());
        return ch;
    }

    public void displayStoreProducts() {
        products.printItems();
    }

    private void addProductToCart() {
        int pid = getUserInput();
        cart.addProductToCartByPID(pid,1);
    }

    private void showCart() {
        cart.printCartItems();
    }

    private void removeProductFromCart() {
        int pid = getUserInput();
        cart.removeProductByPID(pid);
    }
}
