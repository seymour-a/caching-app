package com.seymurahmadzada.cachingapp.repository;

import com.seymurahmadzada.cachingapp.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

