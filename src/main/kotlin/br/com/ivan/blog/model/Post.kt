package br.com.ivan.blog.model

import jakarta.persistence.Entity
import java.time.LocalDateTime

@Entity
class Post (
        val id: Long? = null,
        val titulo: String = "",
        val conteudo: String = "",
        val imageUrl: String = "",
        val datatime: LocalDateTime? = null,
        val usuario: Usuario? = null,
) {
}