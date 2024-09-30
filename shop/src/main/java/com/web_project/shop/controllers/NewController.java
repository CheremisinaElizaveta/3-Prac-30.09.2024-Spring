package com.web_project.shop.controllers;

import com.web_project.shop.model.NewModel;
import com.web_project.shop.model.StudentModel;
import com.web_project.shop.service.NewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clothingproducts")
public class NewController {
    @Autowired
    public NewService newService;

    @GetMapping("/all")
    public String getAllClothingProducts(Model model) {
        model.addAttribute("clothingproducts", newService.findAllClothingProducts());
        model.addAttribute("product", new NewModel());
        return "clothingList";
    }

    @PostMapping("/add")
    public String addClothingProduct(@Valid @ModelAttribute("clothingproducts") NewModel product, BindingResult result, Model model) {
       /* NewModel newProduct = new NewModel(0, name, brand, category, size, price);*/
        if (result.hasErrors()) {
            model.addAttribute("clothingproducts", newService.findAllClothingProducts());
            return "clothingList";
        }
        newService.addClothingProduct(product);
        return "redirect:/clothingproducts/all";
    }

    @PostMapping("/update")
    public String updateClothingProduct(
            @Valid @ModelAttribute("clothingproducts") NewModel product, BindingResult result) {
       /* NewModel newProduct = new NewModel(id, name, brand, category, size, price);*/
        newService.updateClothingProduct(product);
        return "redirect:/clothingproducts/all";
    }

    @PostMapping("/delete")
    public String deleteClothingProduct(@RequestParam Long id) {
        newService.deleteClothingProduct(id);
        return "redirect:/clothingproducts/all";
    }

    @GetMapping("/all/{id}")
    public String getClothingProductById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("clothingproducts", newService.findClothingProductById(id));
        model.addAttribute("product", new NewModel());
        return "clothingList";
    }
}
