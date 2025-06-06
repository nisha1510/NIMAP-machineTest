package com.test.SpringBootCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.SpringBootCRUD.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
