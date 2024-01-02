package Projects.Marselle.models;

import Projects.Marselle.models.furniture.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    @NotNull
    @Size(min = 2, max = 100, message = "Username should be between 2 and 100")
    private String username;

    @Column(name = "role")
    private String role;

    @Column(name = "is_worker")
    private boolean isWorker;

    @ManyToMany(mappedBy = "personList", fetch = FetchType.EAGER)
    private List<Product> productList;

    @OneToMany(mappedBy = "personWork", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkInfo> workInfoList;

    @ManyToMany(mappedBy = "executors", fetch = FetchType.LAZY)
    private List<CompletedOrder> completedOrderList;

    @ManyToMany(mappedBy = "people", fetch = FetchType.LAZY)
    private List<Saw> sawList;

    @ManyToMany(mappedBy = "peopleEdging", fetch = FetchType.LAZY)
    private List<EdgingWork> edgingWorkList;

    @ManyToMany(mappedBy = "peopleList", fetch = FetchType.LAZY)
    private List<Delivery> deliveryWorkList;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "first_name")
    @Size(min = 2, max = 100, message = "First name should be between 2 and 100")
    private String first_name;
    @Column(name = "second_name")
    @Size(min = 2, max = 100, message = "Second name should be between 2 and 100")
    private String second_name;

    @NotNull
    @Column(name = "password")
    @Size(min = 2, max = 100, message = "Password should be between 2 and 100")
    private String password;

    public Person(String username, String first_name, String second_name, String password) {
        this.username = username;
        this.first_name = first_name;
        this.second_name = second_name;
        this.password = password;
    }

    public Person() {

    }

    public List<WorkInfo> getWorkInfoList() {
        return workInfoList;
    }

    public void setWorkInfoList(List<WorkInfo> workInfoList) {
        this.workInfoList = workInfoList;
    }

    public List<EdgingWork> getEdgingWorkList() {
        return edgingWorkList;
    }

    public void setEdgingWorkList(List<EdgingWork> edgingWorkList) {
        this.edgingWorkList = edgingWorkList;
    }

    public List<Delivery> getDeliveryWorkList() {
        return deliveryWorkList;
    }

    public void setDeliveryWorkList(List<Delivery> deliveryWorkList) {
        this.deliveryWorkList = deliveryWorkList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Saw> getSawList() {
        return sawList;
    }

    public void setSawList(List<Saw> sawList) {
        this.sawList = sawList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CompletedOrder> getCompletedOrderList() {
        return completedOrderList;
    }

    public void setCompletedOrderList(List<CompletedOrder> completedOrderList) {
        this.completedOrderList = completedOrderList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
