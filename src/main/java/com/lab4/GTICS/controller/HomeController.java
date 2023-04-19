package com.lab4.GTICS.controller;

import com.lab4.GTICS.entity.User;
import com.lab4.GTICS.entity.Vuelo;
import com.lab4.GTICS.repository.UserRepository;
import com.lab4.GTICS.repository.VueloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    final UserRepository userRepository;
    final VueloRepository vueloRepository;

    public HomeController(UserRepository userRepository, VueloRepository vueloRepository) {
        this.userRepository = userRepository;
        this.vueloRepository = vueloRepository;
    }

    @GetMapping("/home")
    public String inicio(Model model){
        List<Vuelo> lista = vueloRepository.findAll();
        model.addAttribute("listaVuelos", lista);
        return "homePage";
    }
    @GetMapping("/")
    public String login(){
        return "inicio";
    }

    @PostMapping("/login")
    public String validacionLogin(@RequestParam(name = "email") String email,
                                  @RequestParam(name = "password") String password){
        Optional<User> optUser = userRepository.validarInicioSesion(email,password);
        if(optUser.isPresent()){
            return "redirect:/home";
        }else {
            return "redirect:/";
        }
    }
}
