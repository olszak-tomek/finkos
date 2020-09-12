package pl.sda.final_project.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.final_project.dto.ProductDto;
import pl.sda.final_project.model.product.ProductType;
import pl.sda.final_project.service.ProductCategoryService;
import pl.sda.final_project.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductCategoryService productCategoryService;

    public ProductController(ProductService productService, ProductCategoryService productCategoryService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
    }


    @GetMapping("/all")
    public ModelAndView getProducts(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("productList");
        modelAndView.addObject("products", productService.findProducts(pageable));

        return modelAndView;

    }

    @GetMapping("/add")
    public ModelAndView saveProductForm() {
        ModelAndView modelAndView = new ModelAndView("productAdd");
        ProductDto productDto = new ProductDto();
        modelAndView.addObject("productToSave", productDto);
        modelAndView.addObject("productCategories", productCategoryService.findProductCategory());
        modelAndView.addObject("productTypes", ProductType.values());
        return modelAndView;
    }

    @PostMapping("/add")
    public String saveProduct(ProductDto productDto) {
        productService.saveProduct(productDto);

        return "redirect:/product/all";
    }

}
