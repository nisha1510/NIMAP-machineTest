package com.test.SpringBootCRUD.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.test.SpringBootCRUD.entity.Product;
import com.test.SpringBootCRUD.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
		@Autowired
		private ProductService productService;

		public ProductController(){
			System.out.println("ProductController is created");
		}

	    @GetMapping("/products")
	    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0")int page,
	                                        @RequestParam(defaultValue = "10")int size
	    ){
	        return productService.getAllProducts(page, size);

	    }
	    @PostMapping
	    public ResponseEntity<Product> createProduct(@RequestBody Product product){
	        return ResponseEntity.ok(productService.createProduct(product));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long id){
	        Optional<Product> product = productService.getProductById(id);
	        return product.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
	        Product updatedProduct = productService.updateProduct(id, product);
	        return updatedProduct != null ? ResponseEntity.ok(updatedProduct):ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
	        return productService.deleteProduct(id)
	                ? ResponseEntity.noContent().build()
	                : ResponseEntity.notFound().build();

	    }
}
