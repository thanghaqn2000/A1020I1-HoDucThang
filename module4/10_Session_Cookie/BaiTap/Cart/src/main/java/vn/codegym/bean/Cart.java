package vn.codegym.bean;

public class Cart {
    private String idCart;
    private Product product;
    private int quantity;

    public Cart() {
    }

    public Cart(String idCart, Product product, int quantity) {
        this.idCart = idCart;
        this.product = product;
        this.quantity = quantity;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
