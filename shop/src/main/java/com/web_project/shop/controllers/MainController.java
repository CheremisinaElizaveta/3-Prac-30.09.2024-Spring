package com.web_project.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String home (Model model){

        model.addAttribute("name", "Ксения");
        return "home";
    }

    @PostMapping("calculate")
    public String calculate (@RequestParam("operand1") double operand1,
                             @RequestParam("operand2") double operand2,
                             @RequestParam ("operator") String operator,
                             Model model){
        double result = switch (operator){
            case "+" -> operand1 +operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1/operand2;
            default -> 0.0;
        };
        model.addAttribute("result", result);
        return "result";
    }
    @GetMapping("/calculator")
    public String calculator(Model model){
        return "calculator";
    }


    @GetMapping("/convert")
    public String convert(@RequestParam("amount") double amount,
                          @RequestParam("fromCurrency") String fromCurrency,
                          @RequestParam("toCurrency") String toCurrency,
                          Model model) {
        double result = convertCurrency(amount, fromCurrency, toCurrency);
        model.addAttribute("result", result);
        model.addAttribute("amount", amount);
        model.addAttribute("fromCurrency", fromCurrency);
        model.addAttribute("toCurrency", toCurrency);
        return "result";
    }

    private double convertCurrency(double amount, String fromCurrency, String toCurrency) {

        double usdToEur = 0.85;
        double usdToRub = 74.0;
        double eurToUsd = 1 / usdToEur;
        double eurToRub = 88.0;
        double rubToUsd = 0.013;
        double rubToEur = 0.011;

        double result = amount;


        if (fromCurrency.equals("USD")) {
            if (toCurrency.equals("EUR")) {
                result = amount * usdToEur;
            } else if (toCurrency.equals("RUB")) {
                result = amount * usdToRub;
            }
        } else if (fromCurrency.equals("EUR")) {
            if (toCurrency.equals("USD")) {
                result = amount * eurToUsd;
            } else if (toCurrency.equals("RUB")) {
                result = amount * eurToRub;
            }
        } else if (fromCurrency.equals("RUB")) {
            if (toCurrency.equals("USD")) {
                result = amount * rubToUsd;
            } else if (toCurrency.equals("EUR")) {
                result = amount * rubToEur;
            }
        }

        return result;
    }

    @GetMapping("/converter")
    public String converter(Model model) {
        return "moneyconverter";
    }
}
