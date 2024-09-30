package com.web_project.shop.service;

import com.web_project.shop.model.NewModel;
import com.web_project.shop.model.StudentModel;

import java.util.List;

public interface NewService {
    public List<NewModel> findAllClothingProducts();
    public NewModel findClothingProductById(Long id);
    public NewModel addClothingProduct(NewModel product);
    public NewModel updateClothingProduct(NewModel product);
    public void deleteClothingProduct(Long id);
}
