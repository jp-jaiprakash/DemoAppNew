package com.example.demowithh2.repo;

import com.example.demowithh2.domain.ProductsEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<ProductsEntity, Integer> {
}
