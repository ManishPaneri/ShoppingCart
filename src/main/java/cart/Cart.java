package cart;


import catelog.Product;
import catelog.Products;
import java.util.HashMap;
import java.util.Map;
import static utils.HalfRoundOFF.round;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manish Paneri
 */
@Service
public  class Cart {

    HashMap<Product,Integer> cartItems = new HashMap<>();

    @Autowired
    private Products products;

    /**
     * Add Product To cartItems by Product Id
     * @param  pid,
     * @param quantity
     */
    public void addProductToCartByPID(int pid, int quantity ) {
        int i=0;
        do {
            Product product = getProductByProductID(pid);
            if(products.getInstance().getStock(product)!=0){
                addToCart(product);
                products.getInstance().setStock(product,-1);
            }else{
                System.out.println("--> PRODUCT_ID OUT OF STOCK : "+ pid+"\n");
                return;
            }
            i++;
        }while (i<quantity);
        System.out.println("--> Add Product in Cart PID: "+pid+", quantity: "+quantity+"\n");

    }

    /**
    * Get Product By Product Id
    * @param pid
    * @return Product.class
    * */
    private Product getProductByProductID(int pid) {
        Product product = null;
        for (Product prod: products.getInstance().getProducts()) {
            if (prod.getPid() == pid) {
                product = prod;
                break;
            }
        }
        return product;
    }

    /**
     * Add product from CartItems by Product
     * @param product
     * */
    private void addToCart(Product product) {
        if(cartItems.containsKey(product)){
            cartItems.put(product,(cartItems.get(product)+1));
        }else{
            cartItems.put(product,1);
        }
    }

    /**
     * Remove product from CartItems by product id
     * @param pid
     * */
    public void removeProductByPID(int pid) {
        Product prod = getProductByProductID(pid);
        if(cartItems.containsKey(prod)){
            products.getInstance().setStock(prod,+1);
            if(cartItems.get(prod)==1){
                cartItems.remove(prod);
            }else{
                cartItems.put(prod, cartItems.get(prod)-1);
            }
            System.out.println("--> Remove product in cart : "+prod.getName()+"\n");
        }else{
            System.out.println("--> Product_ID is not present in cart : "+pid+"\n");
        }
    }

    /**
     * Print available product details in Cart
     * */
    public void printCartItems() {
        double total = 0;
        System.out.println("==============================");
        System.out.println("    DISPLAY CART ITEMS  ");
        System.out.println("------------------------------");
        System.out.println("S.NO. || NAME || PRICES || QUANTITY");
        System.out.println("------------------------------");
        int i=1;
        double applyTaxAmt =0;
        for (Map.Entry prod : cartItems.entrySet()) {
            Product product = (Product) prod.getKey();
            int count = (Integer) prod.getValue();
            System.out.println(i+"  || "+product.getName()+" || "+ product.getPrice()+" || "+ count);
            applyTaxAmt +=product.getApplyTax()*count;
            total +=  product.getPrice()*count;
            i++;
        }
        System.out.println("---------------------------");
        System.out.println("CART TOTAL AMOUNT : "+round((total+applyTaxAmt),2));
        System.out.println("=========================="+"\n");
    }




}
