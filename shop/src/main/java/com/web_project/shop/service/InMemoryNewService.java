package com.web_project.shop.service;
import com.web_project.shop.model.NewModel;
import com.web_project.shop.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryNewService implements NewService{

    private final NewRepository newRepository;

    public InMemoryNewService(NewRepository clothingProductRepository) {
        this.newRepository = clothingProductRepository;
    }

    @Override
    public List<NewModel> findAllClothingProducts() {
        return newRepository.findAll(Sort.by("id"));
    }

    @Override
    public NewModel findClothingProductById(Long id) {
        return newRepository.findById(id).orElse(null);
    }

    @Override
    public NewModel addClothingProduct(NewModel product) {
        return newRepository.save(product);
    }

    @Override
    public NewModel updateClothingProduct(NewModel product) {
        if (newRepository.existsById(product.getId())){
            return newRepository.save(product);
        }else{
            return null;
        }
    }

    @Override
    public void deleteClothingProduct(Long id) {
        if (newRepository.existsById(id)){
            newRepository.deleteById(id);
        }
    }
}
