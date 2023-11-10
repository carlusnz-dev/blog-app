package br.com.ivan.blog.controll

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import br.com.ivan.blog.model.Usuario
import br.com.ivan.blog.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping

@Controller
class LoginController {

    @Autowired
    private lateinit var usuariorepo: UsuarioRepository

    @GetMapping("/login")
    fun abrirTelaLogin(model: Model): String {

        val usuario = Usuario()

        model.addAttribute("usuario", usuario)

        return "login"
    }

    // logar usuario
    @PostMapping("/login/usuario")
    fun logarUsuario(usuario: Usuario): String {

        val usuarioBD = usuariorepo.findUsuarioByEmail(usuario.email).orElse(null)

        if (usuarioBD == null) {
            return "redirect:/login?error"
        }

        if (usuarioBD.senha == usuario.senha) {
            return "redirect:/home"
        } else {
            return "redirect:/login?error"
        }

        println(usuario)

        return "redirect:/home"
    }
}