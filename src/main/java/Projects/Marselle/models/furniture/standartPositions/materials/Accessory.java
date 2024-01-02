package Projects.Marselle.models.furniture.standartPositions.materials;

import Projects.Marselle.models.furniture.Product;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

// Класс для фурнитуры
@Entity
@Table(name = "accessory")
public class Accessory {
    @Id
    @Column(name = "accessory_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accessory_id;

    @Column(name = "article_number")
    private String articleNumber;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "provider")
    private String provider;

    @Column(name = "count")
    private Integer count;
    @Column(name = "price")
    private Double price;

    @ManyToMany(mappedBy = "accessoryList", fetch = FetchType.EAGER)
    private List<Product> productList;

    public Accessory() {
        this.name = "Unknown";
        this.price = 0.0;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setAccessory_id(Integer accessory_id) {
        this.accessory_id = accessory_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAccessory_id() {
        return accessory_id;
    }

    public String getName() {
        return name;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Double getPrice() {
        return price;
    }

    public String getArticleNumber() {
        return articleNumber;
    }



    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    @Override
    public String toString() {
        String name = "Наименование: " + getName() + ", количество: " + getCount() + ", цена за единицу: " + getPrice();
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accessory accessory = (Accessory) o;
        return Objects.equals(name, accessory.name) && Objects.equals(count, accessory.count) && Objects.equals(price, accessory.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count, price);
    }
}
