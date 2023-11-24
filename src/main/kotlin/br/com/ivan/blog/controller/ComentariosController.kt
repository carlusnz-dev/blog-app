package br.com.ivan.blog.controller

import br.com.ivan.blog.model.Comentario
import br.com.ivan.blog.model.Usuario
import br.com.ivan.blog.repository.ComentarioRepository
import br.com.ivan.blog.repository.PostRepository
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class ComentariosController {

    @Autowired
    private lateinit var postRepository: PostRepository

    @Autowired
    private lateinit var comentarioRepository: ComentarioRepository

    @GetMapping("/post/comentarios/{idPost}")
    fun abrirComentarios(
            @PathVariable("idPost") idPost: Long,
            model: Model
    ): String {

        val post = postRepository.findById(idPost).orElse(null)

        val comentario = Comentario()

        model.addAttribute("post", post)
        model.addAttribute("comentario", comentario)

        return "comentarios-post"
    }

    @PostMapping("/postar/comentario/{idPost}")
    fun postarComentario(
            @PathVariable("idPost") idPost: Long,
            @ModelAttribute comentario: Comentario,
            session: HttpServletRequest
    ): String {

        val post = postRepository.findById(idPost).orElse(null)
        val usuario = session.session.getAttribute("usuarioLogado") as Usuario

        comentario.usuario = usuario
        post.comentarios.add(comentario)

        postRepository.save(post)

        return "redirect:/post/comentarios/$idPost"
    }
}