package pl.sda.final_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.final_project.service.ProductService;

@Controller
public class ProductDetailController {

    private final ProductService productService;

    public ProductDetailController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/product/{id}")
    public ModelAndView showProductDetails(@PathVariable Long id) {
        return new ModelAndView("productDetails", "product", productService.findProductById(id));
    }

}
