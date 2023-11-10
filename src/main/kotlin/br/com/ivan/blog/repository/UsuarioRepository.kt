package br.com.ivan.blog.repository

import br.com.ivan.blog.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long>{

    fun findUsuarioByEmail(email: String): Optional<Usuario>

}