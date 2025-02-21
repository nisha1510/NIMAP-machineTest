package com.demo.SpringBootJPA.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootJPA.DTO.PageResponse;
import com.demo.SpringBootJPA.Entity.Category;
import com.demo.SpringBootJPA.Entity.Product;
import com.demo.SpringBootJPA.repository.CategoryRepository;
import com.demo.SpringBootJPA.repository.ProductRepository;
import com.demo.SpringBootJPA.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
    private ProductService productService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

//    @GetMapping
//    public Page<Product> getAllProducts(Pageable pageable) {
//        return productService.getAllProducts(pageable);
//    }
	
	
	@GetMapping
	public ResponseEntity<Page<Product>> getAllProducts(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size){

	        Pageable pageable = PageRequest.of(page, size);
	    Page<Product> productPage = productRepository.findAll(pageable);
	    return ResponseEntity.ok(productPage);
	}


    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
    	productService.deleteProduct(id);
    }
}
