package br.com.ivan.blog.model

import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class Post (
        val id: Long? = null,
        val titulo: String = "",
        val conteudo: String = "",
        val imageUrl: String = "",
        val datatime: LocalDateTime? = null,
        val usuario: Usuario? = null,
) {
}