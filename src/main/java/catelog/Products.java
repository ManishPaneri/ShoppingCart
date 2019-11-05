package catelog;

import org.springframework.stereotype.Service;
import utils.HalfRoundOFF;
import java.util.HashMap;
import java.util.Set;

/**
 * Products Catalog Management
 * Products Singleton Class
 * @author Manish Paneri
 */
@Service
public class Products {

    private  static Products products = null;

    private final HashMap<Product,Integer> prod = new HashMap<>();

    /**
     * Private constructors for single products object
     * */
    private Products () {
        this.initStoreItems();
    }

    /**
     * Instance create products
     * @return the Products
     * */
    public static Products getInstance() {
        if (products == null) {
            products = new Products();
        }
        return products;
    }

    public Set<Product> getProducts() {
        return prod.keySet();
    }

    /**
     * Initialed products in store Product catalogs
     * */
    private void initStoreItems() {
        String [] productNames = {"Dove Soaps", "Axe Deo", "MTR"};
        Double [] productPrice = {39.99d, 99.99d, 30.00d};
        Integer [] stock = {8, 3, 1};
        double taxrate = 12.5/100;

        for (int i=0; i < productNames.length; i++) {
            Product product = new Product(i+1, productNames[i], productPrice[i],(productPrice[i]*taxrate));
            this.prod.put(product,stock[i]);
        }
    }

    /**
     * @return the stock
     */
    public Integer getStock(Product product) {
        if(prod.containsKey(product)){
            return prod.get(product);
        }
        return 0;

    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Product product, Integer stock) {
        if(prod.containsKey(product)){
            prod.put(product, prod.get(product)+stock);
        }else{
            prod.put(product,stock);
        }
    }



    /**
     * Print available product details in catalog
     * */
    public void printItems(){
        System.out.println("===============================");
        System.out.println("    DISPLAY PRODUCT STORE   ");
        System.out.println("-------------------------------");
        System.out.println(
                "ID ||" + " NAME ||" + " PRICE ||"+ " MRP ||"+" STOCK"
        );
        System.out.println("-------------------------------");
        for (Product prod: products.getProducts()) {
            System.out.println(
                    prod.getPid() +
                            " || "  + prod.getName() +
                            " || "  + prod.getPrice()+
                            " || "  + HalfRoundOFF.round(prod.getPrice()+prod.getApplyTax(),2)+
                            " || "  + Products.getInstance().getStock(prod)
            );
        }
        System.out.println("===============================");
        System.out.println("\n");
    }
}
