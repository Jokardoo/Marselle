package Projects.Marselle.models.furniture.standartPositions.mirrors;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.shelvings.C01;
import Projects.Marselle.models.furniture.standartPositions.shelvings.C02;
import Projects.Marselle.models.furniture.standartPositions.shelvings.C03;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Mirrors {
    private final List<Product> mirrors;

    @Autowired
    public Mirrors() {
        this.mirrors = new ArrayList<>();

        // добавляем стандартные позиции
        mirrors.add(A10.getA10());
    }

    public List<Product> getMirrors() {
        return mirrors;
    }
}
