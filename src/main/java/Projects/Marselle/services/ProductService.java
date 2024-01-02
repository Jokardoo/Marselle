package Projects.Marselle.services;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.AllStandartPositions;
import Projects.Marselle.repositories.ChipboardRepository;
import Projects.Marselle.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ChipboardRepository chipboardRepository;
    private final ProductRepository productRepository;
    private final AllStandartPositions allStandartPositions;

    @Autowired
    public ProductService(ChipboardRepository chipboardRepository, ProductRepository productRepository, AllStandartPositions allStandartPositions) {
        this.chipboardRepository = chipboardRepository;
        this.productRepository = productRepository;
        this.allStandartPositions = allStandartPositions;
    }


    // Если мы добавили новую стандартную позицию в программу, то данный метод позволит
    // обновить их наличие в БД
    //TODO
    public List<Product> getStandartPositions() {
        List<Product> allPositions = new ArrayList<>();

        // кидаем в список все стеллажи
        allPositions.addAll(allStandartPositions.getShelvings().getShelvingList());
        // Тележки
        allPositions.addAll(allStandartPositions.getCarts().getCartList());
        // Маникюрные столы
        allPositions.addAll(allStandartPositions.getManicureTables().getManicureTablesList());
        // Зеркала
        allPositions.addAll(allStandartPositions.getMirrors().getMirrors());
        // Комоды
        allPositions.addAll(allStandartPositions.getCommodes().getCommodes());
        return allPositions;
    }

    // Возвращает тележки
    public List<Product> getStandartCarts() {
        List<Product> carts = new ArrayList<>();

        carts.addAll(allStandartPositions.getCarts().getCartList());
        return carts;
    }

    // возвращает стеллажи
    public List<Product> getStandartShelvings() {
        List<Product> shelving = new ArrayList<>();

        shelving.addAll(allStandartPositions.getShelvings().getShelvingList());
        return shelving;
    }

    // возвращает Маникюрные столы
    public List<Product> getStandartManicureTables() {
        List<Product> manicureTables = new ArrayList<>();

        manicureTables.addAll(allStandartPositions.getManicureTables().getManicureTablesList());
        return manicureTables;
    }

    // возвращает Зеркала
    public List<Product> getStandartMirrors() {
        List<Product> mirrors = new ArrayList<>();

        mirrors.addAll(allStandartPositions.getMirrors().getMirrors());
        return mirrors;
    }

    // возвращает Зеркала
    public List<Product> getStandartCommodes() {
        List<Product> commodes = new ArrayList<>();

        commodes.addAll(allStandartPositions.getCommodes().getCommodes());
        return commodes;
    }

    public void updateStandartPositions() {
        List<Product> allPositions = getStandartPositions();    // позиции в программе
        List<Product> databasePositions = productRepository.findAll();  // Все позиции в БД

        for (Product currentPosition : allPositions) {
            if (!databasePositions.contains(currentPosition)) {
                productRepository.save(currentPosition);
            }
        }

    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

}

