package br.com.ivan.blog.repository

import br.com.ivan.blog.model.Comentario
import br.com.ivan.blog.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComentarioRepository : JpaRepository<Comentario, Long> {
}