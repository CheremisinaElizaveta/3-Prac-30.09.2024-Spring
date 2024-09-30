package com.web_project.shop.service;

import com.web_project.shop.model.AccessoriesModel;


import java.util.List;

public interface AccessoriesService {
    public List<AccessoriesModel> findAllAccessories();
    public AccessoriesModel findAccessoriesById(Long id);
    public AccessoriesModel addAccessories(AccessoriesModel product);
    public AccessoriesModel updateAccessories(AccessoriesModel product);
    public void deleteAccessories(Long id);
    public AccessoriesModel findAccessoriesByName(String name);
}
