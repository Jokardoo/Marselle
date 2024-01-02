package Projects.Marselle.models;

import Projects.Marselle.models.furniture.CompletedWork;
import Projects.Marselle.models.furniture.Product;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "completed_order")
public class CompletedOrder extends CompletedWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "completedOrder_person",
            joinColumns = @JoinColumn(name = "completedOrder_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> executors;

    @ManyToMany(fetch = FetchType.EAGER,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "completedOrder_product",
            joinColumns = @JoinColumn(name = "completedOrder_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Column(name = "ordernumber")
    private String orderNumber;

    @Column(name = "costofwork")
    private Integer costOfWork;     // сумма к оплате сборщику

    @Column(name = "thecostoftheproduct")
    private Integer theCostOfTheProduct;    // стоимость заказа

    @Column(name = "dateofexecution")
    private Date dateOfExecution;   // Дата окончания изготовления

    @Column(name = "preparationtime")
    private Integer preparationTime;

    public CompletedOrder() {

    }



    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public List<Person> getExecutors() {
        return executors;
    }

    public void setExecutors(List<Person> executors) {
        this.executors = executors;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getCostOfWork() {
        return costOfWork;
    }

    public void setCostOfWork(Integer costOfWork) {
        this.costOfWork = costOfWork;
    }

    public Integer getTheCostOfTheProduct() {
        return theCostOfTheProduct;
    }

    public void setTheCostOfTheProduct(Integer theCostOfTheProduct) {
        this.theCostOfTheProduct = theCostOfTheProduct;
    }

    public Date getDateOfExecution() {
        return dateOfExecution;
    }

    public void setDateOfExecution(Date dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }
}
