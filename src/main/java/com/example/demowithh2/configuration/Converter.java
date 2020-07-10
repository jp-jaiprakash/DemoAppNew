package com.example.demowithh2.configuration;

import com.example.demowithh2.domain.ProductsEntity;
import com.example.demowithh2.model.ProductsModel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Converter {

   DozerBeanMapper dozerMapper;

   @Autowired
   public Converter(DozerBeanMapper dozerMapper){
      this.dozerMapper = dozerMapper;
   }

   public ProductsModel convertToModel(ProductsEntity entity){
      return dozerMapper.map(entity, ProductsModel.class);
   }

   public ProductsEntity convertToEntity(ProductsModel model){
      return dozerMapper.map(model, ProductsEntity.class);
   }
}
