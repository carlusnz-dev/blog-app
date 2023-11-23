package br.com.ivan.blog.controller

import br.com.ivan.blog.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @Autowired
    private lateinit var postrepo: PostRepository

    @GetMapping("/home")
    fun abrirTelaHome(model: Model): String {

        val posts = postrepo.findAll()

        model.addAttribute("posts", posts)

        return "home"
    }
}