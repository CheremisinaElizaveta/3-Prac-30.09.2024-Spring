/*
package com.web_project.shop.repository;

import com.web_project.shop.model.NewModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryNewRepository {
    */
/*private List<NewModel> clothingProducts = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public List<NewModel> findAllClothingProducts() {
        return new ArrayList<>(clothingProducts);
    }

    public NewModel findClothingProductById(int id) {
        return clothingProducts.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public NewModel addClothingProduct(NewModel product) {
        product.setId(idCounter.getAndIncrement());
        clothingProducts.add(product);
        return product;
    }

    public NewModel updateClothingProduct(NewModel product) {
        for (int i = 0; i < clothingProducts.size(); i++) {
            if (clothingProducts.get(i).getId() == product.getId()) {
                clothingProducts.set(i, product);
                return product;
            }
        }
        return null;
    }

    public void deleteClothingProduct(int id) {
        clothingProducts.removeIf(product -> product.getId() == id);
    }*//*

}
*/
