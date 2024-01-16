package Projects.Marselle.controllers;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;
import Projects.Marselle.models.furnitureGenerator.ShelfGenerator;
import Projects.Marselle.models.furnitureGenerator.ShelfTechnicalConditions;
import Projects.Marselle.services.ProductService;
import org.dom4j.rule.Mode;
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

    @GetMapping("/shelf-generator-page-stage-1")
    public ModelAndView shelfGeneratorPage() {
        ModelAndView modelAndView = new ModelAndView("furniture/shelf-generator-page");
        return modelAndView;
    }

    @GetMapping("/shelf-generator-page-stage-2")
    public ModelAndView shelfGeneratorPage2(@RequestParam("height") String height,
                                            @RequestParam("width") String width,
                                            @RequestParam("depth") String depth,
                                            @RequestParam("top_type") String top_type,
                                            @RequestParam("bottom_type") String bottom_type,
                                            @RequestParam("back_type") String back_type,
                                            @RequestParam("legs") String legs,
                                            @RequestParam("shelf_count") String shelf_count,
                                            @RequestParam("facade") String facade) {

        ModelAndView modelAndView = new ModelAndView("furniture/shelf-generator-page-stage-2");

        modelAndView.addObject("height", height);
        modelAndView.addObject("width", width);
        modelAndView.addObject("depth", depth);
        modelAndView.addObject("top_type", top_type);
        modelAndView.addObject("bottom_type", bottom_type);
        modelAndView.addObject("back_type", back_type);
        modelAndView.addObject("legs", legs);
        modelAndView.addObject("shelf_count", shelf_count);
        modelAndView.addObject("facade", facade);



        if (facade.equalsIgnoreCase("none")) {
            // ВОЗВРАЩАЕМ ГОТОВЫЙ СТЕЛЛАЖ
        }

        return modelAndView;
    }

    @PostMapping("furniture/shelf-generator-page/calculate")
    public ModelAndView calculateShelf(@RequestParam("height") String height,
                                       @RequestParam("width") String width,
                                       @RequestParam("depth") String depth,
                                       @RequestParam("top_type") String top_type,
                                       @RequestParam("bottom_type") String bottom_type,
                                       @RequestParam("back_type") String back_type,
                                       @RequestParam("legs") String legs,
                                       @RequestParam("shelf_count") String shelf_count,
                                       @RequestParam("facade") String facade,
                                       @RequestParam("facade_type") String facade_type,
                                       @RequestParam("facade_section_overlap") String facade_section_overlap) {

        ModelAndView modelAndView = new ModelAndView("furniture/furniture-generate-result");

        ShelfTechnicalConditions conditions = new ShelfTechnicalConditions();
        conditions.setHeight(height);
        conditions.setWidth(width);
        conditions.setDepth(depth);
        conditions.setTop_type(top_type);
        conditions.setBottom_type(bottom_type);
        conditions.setBack_type(back_type);
        conditions.setLegs(legs);
        conditions.setShelf_count(shelf_count);
        conditions.setFacade(facade);
        conditions.setFacade_type(facade_type);
        conditions.setFacade_section_overlap(facade_section_overlap);

        ShelfGenerator shelfGenerator = new ShelfGenerator(conditions);

        for (Chipboard chipboard : shelfGenerator.getShelf()) {
            System.out.println(chipboard);
        }
        modelAndView.addObject("shelfChipboardList", shelfGenerator.getShelf());
        modelAndView.addObject("stringListOfDetails", shelfGenerator.getStringResultOfShelfDetails());

        return modelAndView;
    }
}
