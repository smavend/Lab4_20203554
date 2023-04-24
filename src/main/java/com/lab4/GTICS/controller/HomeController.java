package com.lab4.GTICS.controller;

import com.lab4.GTICS.entity.User;
import com.lab4.GTICS.entity.Vuelo;
import com.lab4.GTICS.repository.ReservaRepository;
import com.lab4.GTICS.repository.UserRepository;
import com.lab4.GTICS.repository.VueloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    final UserRepository userRepository;
    final VueloRepository vueloRepository;
    final ReservaRepository reservaRepository;

    public HomeController(UserRepository userRepository, VueloRepository vueloRepository, ReservaRepository reservaRepository) {
        this.userRepository = userRepository;
        this.vueloRepository = vueloRepository;
        this.reservaRepository = reservaRepository;
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
                                  @RequestParam(name = "password") String password,
                                  RedirectAttributes attr){
        Optional<User> optUser = userRepository.validarInicioSesion(email,password);
        if(optUser.isPresent()){
            attr.addFlashAttribute("user", optUser.get());
            return "redirect:/home";
        }else {
            return "redirect:/";
        }
    }

    @GetMapping("/reservar/{vueloId}/{idUser}")
    public String reservar(@PathVariable int vueloId,
                          @PathVariable int idUser,
                          RedirectAttributes attr){
        Optional<Vuelo> optVuelo = vueloRepository.findById(vueloId);
        Optional<User> optUser = userRepository.findById(idUser);
        if(optVuelo.isPresent()) {
            Vuelo vuelo = optVuelo.get();
            reservaRepository.guardarReserva(vuelo.getPrecio(), idUser, vueloId);
            attr.addFlashAttribute("msg", "Se realizó con éxito su reserva");
        }
        attr.addFlashAttribute("user", optUser.get());
        return "redirect:/home";
    }
}
