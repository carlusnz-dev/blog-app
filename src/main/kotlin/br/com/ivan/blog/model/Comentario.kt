package br.com.ivan.blog.model

import jakarta.persistence.*

@Entity
data class Comentario (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        var texto: String = "",

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "usuario_id")
        var usuario: Usuario? = null
)