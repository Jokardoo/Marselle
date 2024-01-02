package Projects.Marselle.models.furniture;

import Projects.Marselle.models.CompletedOrder;
import Projects.Marselle.models.Person;
import Projects.Marselle.models.furniture.standartPositions.manicureTables.MC22;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product extends CompletedWork{
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "product_accessory" ,
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "accessory_id"))
    private List<Accessory> accessoryList;  // все флянцы/петли/саморезы и т.д.

    @ManyToMany(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "product_chipboard",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "chipboard_id"))
    private List<Chipboard> chipboardList;  // заготовки по отдельности

    @ManyToMany(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "person_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> personList;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<CompletedOrder> completedOrderList;


    @Column(name = "areaofmaterial")
    private Integer areaOfMaterial;

    @Column(name = "costofwork")
    private Integer costOfWork;

    public Product() {
        this.name = "unknown";
        this.chipboardList = new ArrayList<>();
        this.accessoryList = new ArrayList<>();
        this.completedOrderList = new ArrayList<>();
    }

    // Возвращает общую длину толстой кромки
    public Integer getLengthOfFatEdge() {
        int fatEdgeLength = 0;

        for (Chipboard chipboard : getChipboardList()) {
            fatEdgeLength += chipboard.getLengthOfFatEdge();
        }

        return fatEdgeLength;
    }

    public List<CompletedOrder> getCompletedOrderList() {
        return completedOrderList;
    }

    public void setCompletedOrderList(List<CompletedOrder> completedOrderList) {
        this.completedOrderList = completedOrderList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public Integer getCostOfWork() {
        return costOfWork;
    }

    @Override
    public void setCostOfWork(Integer costOfWork) {
        this.costOfWork = costOfWork;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Возвращает общую длину тонкой кромки
    public Integer getLengthOfThinEdge() {
        int thinEdgeLength = 0;

        for (Chipboard chipboard : getChipboardList()) {
            thinEdgeLength += chipboard.getLengthOfThinEdge();
        }

        return thinEdgeLength;
    }

    public List<Accessory> getAccessoryList() {
        return accessoryList;
    }

    public void setAccessoryList(List<Accessory> accessoryList) {
        this.accessoryList = accessoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Chipboard> getChipboardList() {
        return chipboardList;
    }

    public void setChipboardList(List<Chipboard> chipboardList) {
        this.chipboardList = chipboardList;
    }

    public Integer getAreaOfMaterial() {
        return areaOfMaterial;
    }

    public void setAreaOfMaterial(Integer areaOfMaterial) {
        this.areaOfMaterial = areaOfMaterial;
    }

    // считает суммарную площадь всех заготовок
    public int calculateAreaOfMaterial() {
        int area = 0;

        for (Chipboard chipboard : chipboardList) { // для каждого куска лдсп

            if (chipboard.getLength() > 0 && chipboard.getWidth() > 0) {    // проверка на размеры
                int areaOfChipboard = chipboard.getLength() * chipboard.getWidth(); // площадь заготовки
                area = area + areaOfChipboard; // к площадям предыдущих заготовок плюсуем настоящую
            }

        }
        return area;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", chipboardList=" + chipboardList +
                ", areaOfMaterial=" + areaOfMaterial +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(chipboardList, product.chipboardList) && Objects.equals(areaOfMaterial, product.areaOfMaterial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, chipboardList, areaOfMaterial);
    }


    public static void main(String[] args) {
        Product product = MC22.getMC22();

        System.out.println("Fat edge: " + product.getLengthOfFatEdge());
        System.out.println("Thin edge: " + product.getLengthOfThinEdge());
    }
}