package br.com.ivan.blog.controller

import br.com.ivan.blog.model.Comentario
import br.com.ivan.blog.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class ComentarioController {

    @Autowired
    private lateinit var postRepository: PostRepository

    @GetMapping("/post/comentario/{idPost}")
    fun abrirComentarios(
            @PathVariable("idPost") idPost: Long,
            model: Model
    ): String {

        val postrepo = postRepository.findById(idPost).orElse(null)

        val comentario = Comentario()

        model.addAttribute("post", postrepo)
        model.addAttribute("comentario", comentario)

        return "comentarios-post"
    }

}