package Projects.Marselle.models.furniture.standartPositions.materials;

public class Material {
    private String name;
    private Integer length; // длина
    private Integer width;  // ширина

    public Material(String name, Integer length, Integer width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public Material() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
