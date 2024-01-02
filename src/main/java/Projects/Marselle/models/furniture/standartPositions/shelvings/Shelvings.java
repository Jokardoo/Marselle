package Projects.Marselle.models.furniture.standartPositions.shelvings;

import Projects.Marselle.models.furniture.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
    В этом классе собираются все стандартные позиции в разделе стеллажей.

 */
public class Shelvings {
    private final List<Product> shelvingList;

    @Autowired
    public Shelvings() {
        this.shelvingList = new ArrayList<>();

        // добавляем стандартные позиции
        shelvingList.add(C01.getC01());
        shelvingList.add(C02.getC02());
        shelvingList.add(C03.getC03());
    }

    public List<Product> getShelvingList() {
        return shelvingList;
    }
}
