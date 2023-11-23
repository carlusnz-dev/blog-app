package br.com.ivan.blog.controller

import br.com.ivan.blog.model.Usuario
import br.com.ivan.blog.repository.PostRepository
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MeusPostsController {
    @Autowired
    private lateinit var postrepo: PostRepository

    @GetMapping("/meus/posts")
    fun abrirTelaMeusPosts(
            model: Model,
            request: HttpServletRequest,
            usuario: Usuario
    ): String {

        // pegar o usuário logado
        val usuarioLogado = request.session.getAttribute("usuarioLogado")

        val posts = postrepo.findPostByUsuario(usuarioLogado as Usuario)

        model.addAttribute("posts", posts)

        return "meus-posts"
    }
}