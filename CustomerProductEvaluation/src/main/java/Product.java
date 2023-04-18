import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String price;
    private String qty;

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

   @ManyToOne
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product(String name, String price, String qty, Customer customer) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.customer = customer;
    }

    public Product(String name, String price, String qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public Product(){

    }
}
