package com.Nav.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nav.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
