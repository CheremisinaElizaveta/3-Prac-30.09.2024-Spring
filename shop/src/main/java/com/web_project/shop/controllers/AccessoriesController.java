
package com.web_project.shop.controllers;

import com.web_project.shop.model.AccessoriesModel;
import com.web_project.shop.model.NewModel;
import com.web_project.shop.service.AccessoriesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/accessories")
public class AccessoriesController {
    @Autowired
    public AccessoriesService accessoriesService;

    @GetMapping("/all")
    public String getAllAccessories(Model model) {
        model.addAttribute("accessories", accessoriesService.findAllAccessories());
        model.addAttribute("accessory", new AccessoriesModel());
        return "accessoriesList";
    }

    @PostMapping("/add")
    public String addAccessories(@Valid @ModelAttribute("accessories") AccessoriesModel product, BindingResult result, Model model) {
        /*AccessoriesModel newAccessory = new AccessoriesModel(0, name, brand, category, material, color, price);*/
        if (result.hasErrors()) {
            model.addAttribute("accessories", accessoriesService.findAllAccessories());
            return "accessoriesList";
        }
        accessoriesService.addAccessories(product);
        return "redirect:/accessories/all";
    }

    @PostMapping("/update")
    public String updateAccessories( @Valid @ModelAttribute("accessories") AccessoriesModel product, BindingResult result) {
        /*AccessoriesModel newAccessory = new AccessoriesModel(id, name, brand, category, material, color, price);*/
        accessoriesService.updateAccessories(product);
        return "redirect:/accessories/all";
    }

    @PostMapping("/delete")
    public String deleteAccessories(@RequestParam Long id) {
        accessoriesService.deleteAccessories(id);
        return "redirect:/accessories/all";
    }

    @GetMapping("/all/{id}")
    public String getAccessoriesById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("accessories", accessoriesService.findAccessoriesById(id));
        model.addAttribute("accessory", new AccessoriesModel());
        return "accessoriesList";
    }
    @GetMapping("/all/{name}")
    public String getAccessoriesByName(@PathVariable("name") String name, Model model) {
        model.addAttribute("accessories", accessoriesService.findAccessoriesByName(name));
        model.addAttribute("accessory", new AccessoriesModel());
        return "accessoriesList";
    }


}

