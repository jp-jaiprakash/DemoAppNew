package com.example.demowithh2.controller;

import com.example.demowithh2.model.ProductsModel;
import com.example.demowithh2.configuration.Converter;
import com.example.demowithh2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
public class ProductsController {

   @Autowired
   private ProductService productService;

   @Autowired
   private Converter converter;

   @GetMapping("/all")
   public ResponseEntity<List<ProductsModel>> getAllProducts(){
      List<ProductsModel> lst = new LinkedList<>();
      productService.getAllProducts().forEach(
              entity -> lst.add(converter.convertToModel(entity)));
      return new ResponseEntity<>(lst, HttpStatus.OK);
   }

   @PostMapping(value = "/saveProduct", produces = { "application/json" }, consumes = {
           "application/json" })
   ResponseEntity<ProductsModel> login(@Valid @RequestBody ProductsModel request){
      ProductsModel response = converter.convertToModel(productService.saveAProduct(converter.convertToEntity(request)));
      return new ResponseEntity<>(response, HttpStatus.OK);


   }

}
