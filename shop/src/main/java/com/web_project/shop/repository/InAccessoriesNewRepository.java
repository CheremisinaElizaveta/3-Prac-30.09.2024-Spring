/*
package com.web_project.shop.repository;

import com.web_project.shop.model.AccessoriesModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InAccessoriesNewRepository {

    */
/*private List<AccessoriesModel> accessories = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public List<AccessoriesModel> findAllAccessories() {
        return new ArrayList<>(accessories);
    }

    public AccessoriesModel findAccessoriesById(int id) {
        return accessories.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public AccessoriesModel addAccessories(AccessoriesModel product) {
        product.setId(idCounter.getAndIncrement());
        accessories.add(product);
        return product;
    }

    public AccessoriesModel updateAccessories(AccessoriesModel product) {
        for (int i = 0; i < accessories.size(); i++) {
            if (accessories.get(i).getId() == product.getId()) {
                accessories.set(i, product);
                return product;
            }
        }
        return null;
    }

    public void deleteAccessories(int id) {
        accessories.removeIf(product -> product.getId() == id);
    }*//*

}
*/
