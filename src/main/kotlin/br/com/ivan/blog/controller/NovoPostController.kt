package br.com.ivan.blog.controller

import br.com.ivan.blog.model.Post
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class NovoPostController {

    @GetMapping("/novo/post")
    fun abrirTelaNovoPost(model: Model): String {

        val post = Post()

        model.addAttribute("post", post)

        return "meus-posts"
    }

}