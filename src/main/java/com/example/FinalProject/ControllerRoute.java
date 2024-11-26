package com.example.FinalProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Arrays;
import java.util.List;

@Controller
public class ControllerRoute {
    private final List<Route> routes = Arrays.asList(

            new Route("Шанхай - Санкт-Петербург - Москва", "Модуль"),
            new Route("Шанхай - Владивосток - Москва", "Транзит"),
            new Route("Шанхай - Новороссийск - Москва", "Силмар")

    );
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("routes", routes);
        return "index";
    }
    @GetMapping("/companies")
    public String companies(@RequestParam("route") String routeName, Model model) {

        List<Route> companyRoutes = routes.stream()
                .filter(route -> route.getName().equals(routeName))
                .toList();

        model.addAttribute("route", routeName);
        model.addAttribute("companies", companyRoutes);
        return "companies";
    }
}

