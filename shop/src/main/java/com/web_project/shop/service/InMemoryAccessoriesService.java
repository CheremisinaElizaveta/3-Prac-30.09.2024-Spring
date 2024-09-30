
package com.web_project.shop.service;

import com.web_project.shop.model.AccessoriesModel;
import com.web_project.shop.model.NewModel;
import com.web_project.shop.repository.AccessoriesRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InMemoryAccessoriesService implements AccessoriesService{

    private final AccessoriesRepository accessoriesRepository;

    public InMemoryAccessoriesService(AccessoriesRepository accessoriesRepository) {
        this.accessoriesRepository = accessoriesRepository;
    }

    @Override
    public List<AccessoriesModel> findAllAccessories() {
        return accessoriesRepository.findAll(Sort.by("id"));
    }

    @Override
    public AccessoriesModel findAccessoriesById(Long id) {
        return accessoriesRepository.findById(id).orElse(null);
    }

    @Override
    public AccessoriesModel addAccessories(AccessoriesModel product) {
        return accessoriesRepository.save(product);
    }

    @Override
    public AccessoriesModel updateAccessories(AccessoriesModel product) {
        if (accessoriesRepository.existsById(product.getId())){
            return accessoriesRepository.save(product);
        }else{
            return null;
        }
    }

    @Override
    public void deleteAccessories(Long id) {
        if (accessoriesRepository.existsById(id)){
            accessoriesRepository.deleteById(id);
        }
    }
    @Override
    public AccessoriesModel findAccessoriesByName(String name) {
        return accessoriesRepository.findByName(name).orElse(null);
    }
}
