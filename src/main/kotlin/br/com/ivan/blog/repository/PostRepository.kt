package br.com.ivan.blog.repository

import br.com.ivan.blog.model.Post
import br.com.ivan.blog.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: JpaRepository<Post, Long> {
    // procure por todos os posts do usuário logado
    fun findPostByUsuario (usuario: Usuario): List<Post>
}