package com.test.SpringBootCRUD.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.test.SpringBootCRUD.entity.Category;
import com.test.SpringBootCRUD.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepo;
	
	public Category createCategory(Category category){
        return categoryRepo.save(category);
    }

    public Page<Category> getAllCategory(int page, int size){
        return categoryRepo.findAll(PageRequest.of(page, size));
    }

    public Optional<Category> getCategoryById(Long id){
        return categoryRepo.findById(id);
    }

    public Category updateCategory(Long id, Category category){
        if(categoryRepo.existsById(id)){
            category.setCategory_id(id);
            return categoryRepo.save(category);
        }else {
            return null;
        }
    }
    public boolean deleteCategory(Long id){
        if(categoryRepo.existsById(id)){
            categoryRepo.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
