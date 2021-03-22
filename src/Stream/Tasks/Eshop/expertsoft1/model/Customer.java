package Stream.Tasks.Eshop.expertsoft1.model;

import java.util.List;
import java.util.Objects;

public class Customer {

    public Customer() {}

    private String name;
    private String email;
    private AddressInfo addressInfo;
    private List<Order> orders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressInfo getAddress() {
        return addressInfo;
    }

    public void setAddress(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
