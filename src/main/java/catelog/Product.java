package catelog;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 *
 * @author Manish Paneri
 */
@Component
public class Product {
    private Integer pid;
    private String name;
    private Double price;
    private Double applyTax;


    public Product (Integer pid, String name, Double price, Double applyTax) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.applyTax = applyTax;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the pid
     */
    public Integer getPid() {
        return pid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.pid);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.pid, other.pid)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Double getApplyTax() {
        return applyTax;
    }

    public void setApplyTax(Double applyTax) {
        this.applyTax = applyTax;
    }
}
