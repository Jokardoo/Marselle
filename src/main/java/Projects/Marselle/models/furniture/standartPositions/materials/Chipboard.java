package Projects.Marselle.models.furniture.standartPositions.materials;

import Projects.Marselle.models.furniture.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

// ЛДСП
//@Component
@Entity
@Table(name ="chipboard")
public class Chipboard extends Material{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @Size(min = 2, max = 100, message = "name size should be between 2 and 100")
    private String name;

    @Column(name = "length")
    @Min(value = 10, message = "Length size should be bigger than 10")
    @Max(value = 4000, message = "Length size should be smaller than 4000")
    private Integer length; // длина

    @Column(name = "width")
    @Min(value = 10, message = "Width size should be bigger than 10")
    @Max(value = 4000, message = "Width size should be smaller than 4000")
    private Integer width;  // ширина

    // кромка
    @Column(name = "edging_top")
    private String edging_top;
    @Column(name = "edging_bottom")
    private String edging_bottom;
    @Column(name = "edging_left")
    private String edging_left;
    @Column(name = "edging_right")
    private String edging_right;

    @Column(name = "thick")
    private Integer thick;     // Толщина ДСП

    @ManyToMany(mappedBy = "chipboardList", fetch = FetchType.EAGER)
    private List<Product> productList;

    public Chipboard() {
        super();
        this.name = "unknown";
        this.thick = 16;
    }

    // Возвращает длину толстой кромки
    public Integer getLengthOfFatEdge() {
        int edgeLength = 0;
        if (this.edging_bottom != null && this.edging_bottom.equalsIgnoreCase("red")) {
            edgeLength = edgeLength + this.length;
        }
        if (this.edging_top != null && this.edging_top.equalsIgnoreCase("red")) {
            edgeLength = edgeLength + this.length;
        }
        if (this.edging_left != null && this.edging_left.equalsIgnoreCase("red")) {
            edgeLength = edgeLength + this.width;
        }
        if (this.edging_right != null && this.edging_right.equalsIgnoreCase("red")) {
            edgeLength = edgeLength + this.width;
        }

        return edgeLength;
    }

    // Возвращает длину тонкой кромки
    public Integer getLengthOfThinEdge() {
        int edgeLength = 0;
        if (this.edging_bottom != null && this.edging_bottom.equalsIgnoreCase("blue")) {
            edgeLength = edgeLength + this.length;
        }
        if (this.edging_top != null && this.edging_top.equalsIgnoreCase("blue")) {
            edgeLength = edgeLength + this.length;
        }
        if (this.edging_left != null && this.edging_left.equalsIgnoreCase("blue")) {
            edgeLength = edgeLength + this.width;
        }
        if (this.edging_right != null && this.edging_right.equalsIgnoreCase("blue")) {
            edgeLength = edgeLength + this.width;
        }

        return edgeLength;
    }

    public Integer getThick() {
        return thick;
    }

    public void setThick(Integer thick) {
        this.thick = thick;
    }

    public void setEdgingRed() {
        this.setEdging_bottom("red");
        this.setEdging_left("red");
        this.setEdging_right("red");
        this.setEdging_top("red");
    }

    public void setEdgingBlue() {
        this.setEdging_bottom("blue");
        this.setEdging_left("blue");
        this.setEdging_right("blue");
        this.setEdging_top("blue");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getEdging_top() {
        return edging_top;
    }

    public void setEdging_top(String edging_top) {
        if (edging_top.equalsIgnoreCase("red") || edging_top.equalsIgnoreCase("blue")) {
            this.edging_top = edging_top;
        }
    }

    public String getEdging_bottom() {
        return edging_bottom;
    }

    public void setEdging_bottom(String edging_bottom) {
        if (edging_bottom.equalsIgnoreCase("red") || edging_bottom.equalsIgnoreCase("blue")) {
            this.edging_bottom = edging_bottom;
        }
    }

    public String getEdging_left() {
        return edging_left;
    }

    public void setEdging_left(String edging_left) {
        if (edging_left.equalsIgnoreCase("red") || edging_left.equalsIgnoreCase("blue")) {
            this.edging_left = edging_left;
        }

    }

    public String getEdging_right() {
        return edging_right;
    }

    public void setEdging_right(String edging_right) {
        if (edging_right.equalsIgnoreCase("red") || edging_right.equalsIgnoreCase("blue")) {
            this.edging_right = edging_right;
        }
    }


    @Override
    public String toString() {
        return "Chipboard{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", edging_top='" + edging_top + '\'' +
                ", edging_bottom='" + edging_bottom + '\'' +
                ", edging_left='" + edging_left + '\'' +
                ", edging_right='" + edging_right + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chipboard chipboard = (Chipboard) o;
        return Objects.equals(name, chipboard.name) && Objects.equals(length, chipboard.length) && Objects.equals(width, chipboard.width) && Objects.equals(edging_top, chipboard.edging_top) && Objects.equals(edging_bottom, chipboard.edging_bottom) && Objects.equals(edging_left, chipboard.edging_left) && Objects.equals(edging_right, chipboard.edging_right) && Objects.equals(thick, chipboard.thick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length, width, edging_top, edging_bottom, edging_left, edging_right, thick);
    }
}
