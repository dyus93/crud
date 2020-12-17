package com.example.product.controller;

import com.example.product.dto.ProductDto;
import com.example.product.persistence.entity.Product;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("products", productService.getAll());
        return "index";
    }

    @GetMapping("/create")
    public String createForm(){
        return "create";
    }


    @PostMapping("/create")
    public String createProduct(ProductDto productDto){
        productService.save(productDto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateProductForm(@PathVariable("id") Long id, Model model ){
        Optional<Product> product = productService.getOneById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update")
    public String updateProduct(ProductDto productDto){
        productService.save(productDto);
        return "redirect:/";
    }
}
