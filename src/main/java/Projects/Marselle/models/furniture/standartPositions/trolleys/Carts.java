package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Carts {
    private final List<Product> carts;

    @Autowired
    public Carts() {
        this.carts = new ArrayList<>();

        this.carts.add(T01.getT01());
        this.carts.add(T02.getT02());
        this.carts.add(T03.getT03());

        this.carts.add(T04.getT04());
        this.carts.add(T05.getT05());
        this.carts.add(T06.getT06());

        this.carts.add(T07.getT07());
        this.carts.add(T08.getT08());
        this.carts.add(T09.getT09());

        this.carts.add(T11.getT11());
        this.carts.add(T12.getT12());

        this.carts.add(T13.getT13());
        this.carts.add(T15.getT15());
        this.carts.add(T16.getT16());

        this.carts.add(T17.getT17());
    }

    public List<Product> getCartList() {
        return carts;
    }
}
