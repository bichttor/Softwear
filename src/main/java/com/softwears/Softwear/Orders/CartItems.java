package com.softwears.Softwear.Orders;

<<<<<<< HEAD
import com.softwears.Softwear.Products.Product;

=======
>>>>>>> 56e449c78d139340868d6a3c79fcca1aceb9987c
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
=======
>>>>>>> 56e449c78d139340868d6a3c79fcca1aceb9987c
import jakarta.persistence.Table;

/*Using the Entity tag creates a table with the values given so no schema will have to be written 
 * You can essentially copy and paste this file for other data and just change the respective values
*/

@Entity
@Table(name = "cart_items") /* set for data integrity */
<<<<<<< HEAD
public class CartItems{
    /*@Columns are set for data integrity */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "cart_item_count") 
    private int itemCount;

    @Column(name = "cart_item_price") 
    private double itemPrice;

    public CartItems(Cart cart, Product product){
        this.cart = cart;
        this.product = product;
        this.itemCount = 1;
        this.itemPrice = product.getProductPrice();
    }

    public CartItems(Cart cart, Product product, int itemCount){
        this.cart = cart;
        this.product = product;
        this.itemCount = itemCount;
        this.itemPrice = product.getProductPrice();
    }

    public CartItems(Cart cart, Product product, int itemCount, int itemPrice){
        this.cart = cart;
        this.product = product;
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
    }
=======
public class CartItems {
    /*@Columns are set for data integrity */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cartItemsId;

    @Column(name = "cart_item_price") 
    private double cartPrice;

    @Column(name = "cart_item_count") 
    private int cartCount;

    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "product_id")
    private int productId;

    public CartItems() {}

    public CartItems(int cartPrice, int cartCount, int cartId, int productId){
        this.cartPrice = cartPrice;
        this.cartCount = cartCount;
        this.cartId = cartId;
        this.productId = productId;
    } 

    /* Getters & Setters */

    public int getCartItemsId() {
        return cartItemsId;
    }

    public void setCartItemsId(int cartItemsId) {
        this.cartItemsId = cartItemsId;
    }

    public double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(double cartPrice) {
        this.cartPrice = cartPrice;
    }

    public int getCartCount() {
        return cartCount;
    }

    public void setCartCount(int cartCount) {
        this.cartCount = cartCount;
    }

    public int getCartID() {
        return cartId;
    }

    public void setCartID(int cartId) {
        this.cartId = cartId;
    }

    public int getProductID() {
        return productId;
    }

    public void setProductID(int productId) {
        this.productId = productId;
    }

>>>>>>> 56e449c78d139340868d6a3c79fcca1aceb9987c
}
