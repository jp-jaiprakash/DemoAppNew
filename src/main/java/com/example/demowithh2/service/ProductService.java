package com.example.demowithh2.service;

import com.example.demowithh2.repo.ProductRepo;
import com.example.demowithh2.domain.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {

   @Autowired
   private ProductRepo productRepo;

   public List<ProductsEntity> getAllProducts(){
      List<ProductsEntity> entityList = new LinkedList<>();
       productRepo.findAll().forEach(productsEntity -> entityList.add(productsEntity));
       return entityList;
   }

   public ProductsEntity saveAProduct(ProductsEntity request){
      return productRepo.save(request);
   }
}
