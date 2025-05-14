package com.test.SpringBootCRUD.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.test.SpringBootCRUD.entity.Product;
import com.test.SpringBootCRUD.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepository productRepo;

    public Product createProduct(Product product){
        return productRepo.save(product);
    }

    public Page<Product> getAllProducts(int page, int size){
        return productRepo.findAll(PageRequest.of(page, size));
    }

    public Optional<Product> getProductById(Long id){
        return productRepo.findById(id);
    }

    public Product updateProduct(Long id, Product product){
        if(productRepo.existsById(id)){
            product.setProd_id(id);
            return productRepo.save(product);
        }else {
            return null;
        }
    }
    public boolean deleteProduct(Long id){
        if(productRepo.existsById(id)){
            productRepo.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
