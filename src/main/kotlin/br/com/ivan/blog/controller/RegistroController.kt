package br.com.ivan.blog.controller

import br.com.ivan.blog.model.Usuario
import br.com.ivan.blog.repository.UsuarioRepository
import br.com.ivan.blog.util.FileUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

@Controller
class RegistroController {

    @Autowired
    private lateinit var usuariorepo: UsuarioRepository

    @GetMapping("/registro")
    fun abrirTelaCadastro(model: Model): String {

        val usuario = Usuario()
        model.addAttribute("usuario", usuario)

        return "registro"
    }

    @PostMapping("/cadastrar/usuario")
    fun cadastrarUsuario(
            usuario: Usuario,
            @RequestParam("image") file: MultipartFile,
    ): String {

        val imageUrl = FileUtil.create().saveFile(file)

        usuario.imagemPerfil = imageUrl

        usuariorepo.save(usuario)

        println(usuario)

        return "redirect:/login"
    }
}