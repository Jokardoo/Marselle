package Projects.Marselle.controllers;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FurnitureController {
    private final ProductService productService;

    @Autowired
    public FurnitureController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/furniture")
    public ModelAndView furniture() {
        ModelAndView modelAndView = new ModelAndView("furniture/furniture");
        List<Product> furniture = productService.findAll();

        List<Product> carts = productService.getStandartCarts();
        List<Product> shelvings = productService.getStandartShelvings();
        List<Product> manicureTables = productService.getStandartManicureTables();
        List<Product> mirrors = productService.getStandartMirrors();
        List<Product> commodes = productService.getStandartCommodes();

        modelAndView.addObject("product", new Product());

        modelAndView.addObject("carts", carts);
        modelAndView.addObject("shelvings", shelvings);
        modelAndView.addObject("manicureTables", manicureTables);
        modelAndView.addObject("mirrors", mirrors);
        modelAndView.addObject("commodes", commodes);

        modelAndView.addObject("standartPositions", furniture);
        return  modelAndView;
    }

    @PostMapping("/update_furniture")
    public ModelAndView updateFurniture() {
        ModelAndView modelAndView = new ModelAndView("furniture/furniture");
        System.out.println("well done");
        productService.updateStandartPositions();

        List<Product> furniture = productService.findAll();

        modelAndView.addObject("standartPositions", furniture);

        return modelAndView;
    }

    @GetMapping("/standart-position")
    public ModelAndView standartPosition(@RequestParam("name") String name) {
        Optional<Product> optionalProduct = productService.findByName(name);

        if (optionalProduct.isEmpty()) {
            //TODO
        }

        Product product = optionalProduct.get();
        List<Accessory> accessoryList = new ArrayList<>();

        for (Accessory accessory : product.getAccessoryList()) {
            accessoryList.add(accessory);
        }

        ModelAndView modelAndView = new ModelAndView("furniture/position");
        modelAndView.addObject("accessory", accessoryList);
        modelAndView.addObject("position", product);

        return modelAndView;
    }

    @GetMapping("/furniture-generator-page")
    public ModelAndView furnitureGeneratorPage() {
        ModelAndView modelAndView = new ModelAndView("furniture/furniture-generator-page");
        return modelAndView;
    }

    @GetMapping("/furniture-generator-page/shelf")
    public ModelAndView shelfGeneratorPage() {
        ModelAndView modelAndView = new ModelAndView("furniture/shelf-generator-page");
        return modelAndView;
    }
}
