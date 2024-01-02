package Projects.Marselle.models.furniture.standartPositions.manicureTables;

import Projects.Marselle.models.furniture.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class ManicureTables {
    private final List<Product> manicureTablesList;

    @Autowired
    public ManicureTables() {
        this.manicureTablesList = new ArrayList<>();

        this.manicureTablesList.add(MC05.getMC05());
        this.manicureTablesList.add(MC06.getMC06());
        this.manicureTablesList.add(MC09.getMC09());
        this.manicureTablesList.add(MC18.getMC18());
        this.manicureTablesList.add(MC22.getMC22());
        this.manicureTablesList.add(MC26.getMC26());

    }

    public List<Product> getManicureTablesList() {
        return manicureTablesList;
    }
}
