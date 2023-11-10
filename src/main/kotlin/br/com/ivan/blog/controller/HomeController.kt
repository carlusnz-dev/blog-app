package br.com.ivan.blog.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    @GetMapping("/home")
    fun abrirTelaHome(): String {
        return "home"
    }
}