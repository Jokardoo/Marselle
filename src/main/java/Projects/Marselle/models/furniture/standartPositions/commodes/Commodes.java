package Projects.Marselle.models.furniture.standartPositions.commodes;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.mirrors.A10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Commodes {
    private final List<Product> commodes;

    @Autowired
    public Commodes() {
        this.commodes = new ArrayList<>();

        // добавляем стандартные позиции
        commodes.add(K03.getK03());
    }

    public List<Product> getCommodes() {
        return commodes;
    }
}
