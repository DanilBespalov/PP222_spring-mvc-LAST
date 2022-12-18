package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.Optional;

@Controller
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

//    @GetMapping("/{count}")
//    public String showCarByID(@PathVariable("count") int count, Model model) {
//        model.addAttribute("cars", carService.getCars(count));
//        return "cars";
//    }
    @GetMapping("/cars")
    public String showCars(@RequestParam(value = "count", required = false) Optional<Integer> count, Model model) {
        model.addAttribute("title", "Cars Table");
        model.addAttribute("cars", carService.getCars(count.orElse(0)));
        return "cars";
    }
}