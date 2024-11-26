package com.example.FinalProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ControllerRoute {
    private final List<Route> routes = Arrays.asList(

            new Route("Шанхай - Санкт-Петербург - Москва", "Модуль", "Санкт-Петербург"),
            new Route("Шанхай - Владивосток - Москва", "Транзит", "Владивосток"),
            new Route("Шанхай - Новороссийск - Москва", "Силмар", "Новороссийск")

    );
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("routes", routes);
        return "index";
    }
    @GetMapping("/companies")
    public String companies(@RequestParam(value = "city", required = false) String city, Model model) {
        // Фильтрация по городу, если параметр city указан
        List<Route> filteredRoutes = routes.stream()
                .filter(route -> city == null || city.isEmpty() || city.equals(route.getCity()))
                .collect(Collectors.toList());

        model.addAttribute("city", city);
        model.addAttribute("companies", filteredRoutes);
        model.addAttribute("cities", Arrays.asList("Санкт-Петербург", "Владивосток", "Новороссийск")); // Список городов
        return "companies";
    }
}

