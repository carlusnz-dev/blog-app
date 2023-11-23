package br.com.ivan.blog.model

import jakarta.persistence.*

@Entity
class Comentario (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val texto: String = "",

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "usuario_id")
        val usuario: Usuario? = null,
)