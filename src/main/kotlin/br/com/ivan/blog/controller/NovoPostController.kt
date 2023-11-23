package br.com.ivan.blog.controller

import br.com.ivan.blog.model.Post
import br.com.ivan.blog.model.Usuario
import br.com.ivan.blog.repository.PostRepository
import br.com.ivan.blog.util.FileUtil
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

@Controller
class NovoPostController {

    @Autowired
    private lateinit var postrepo: PostRepository

    @GetMapping("/novo/post")
    fun abrirTelaNovoPost(model: Model): String {

        val post = Post()

        model.addAttribute("post", post)

        return "novo-post"
    }

    @PostMapping("/postar")
    fun criarPost(
            post: Post,
            @RequestParam("image") imagem: MultipartFile,
            request: HttpServletRequest
    ): String {

        val imagemUrl = FileUtil.create().saveFile(imagem)

        post.imagemUrl = imagemUrl
        post.data = java.time.LocalDateTime.now()

        post.usuario = request.session.getAttribute("usuarioLogado") as Usuario

        postrepo.save(post)

        return "redirect:/home"
    }

}