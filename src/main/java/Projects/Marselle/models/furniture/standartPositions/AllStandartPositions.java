package Projects.Marselle.models.furniture.standartPositions;

import Projects.Marselle.models.furniture.standartPositions.commodes.Commodes;
import Projects.Marselle.models.furniture.standartPositions.manicureTables.ManicureTables;
import Projects.Marselle.models.furniture.standartPositions.mirrors.Mirrors;
import Projects.Marselle.models.furniture.standartPositions.shelvings.Shelvings;
import Projects.Marselle.models.furniture.standartPositions.trolleys.Carts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AllStandartPositions {
    private final Shelvings shelvings;
    private final Carts carts;
    private final ManicureTables manicureTables;
    private final Mirrors mirrors;

    private final Commodes commodes;

    @Autowired
    public AllStandartPositions(Commodes commodes) {
        this.commodes = commodes;
        this.shelvings = new Shelvings();
        this.carts = new Carts();
        this.manicureTables = new ManicureTables();
        this.mirrors = new Mirrors();
    }

    public Shelvings getShelvings() {
        return shelvings;
    }

    public Commodes getCommodes() {
        return commodes;
    }

    public Carts getCarts() {
        return carts;
    }

    public ManicureTables getManicureTables() {
        return manicureTables;
    }

    public Mirrors getMirrors() {
        return mirrors;
    }
}
