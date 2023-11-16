package br.com.ivan.blog.controll

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import br.com.ivan.blog.model.Usuario
import br.com.ivan.blog.repository.UsuarioRepository
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping

@Controller
class LoginController {

    @Autowired
    private lateinit var usuariorepo: UsuarioRepository

    @GetMapping("/login")
    fun abrirTelaLogin(model: Model, request: HttpServletRequest): String {

        val sessao = request.session

        if (sessao.getAttribute("usuarioLogado") != null) {
            return "redirect:/home"
        }

        val usuario = Usuario()

        model.addAttribute("usuario", usuario)

        return "login"
    }

    // logar usuario
    @PostMapping("/login/usuario")
    fun logarUsuario(usuario: Usuario, request: HttpServletRequest): String {

        val sessao = request.session

        val usuarioBD = usuariorepo.findUsuarioByEmail(usuario.email).orElse(null)

        if (usuarioBD == null) {
            return "redirect:/login?error"
        }

        if (usuarioBD.senha == usuario.senha) {
            sessao.setAttribute("usuarioLogado", usuarioBD)
            return "redirect:/home"
        } else {
            return "redirect:/login?error"
        }

        println(usuario)

        return "redirect:/home"
    }

    // deslogar usuario
    @GetMapping("/logout")
    fun deslogarUsuario(request: HttpServletRequest): String {

        val sessao = request.session

        sessao.invalidate()

        return "redirect:/login"
    }
}