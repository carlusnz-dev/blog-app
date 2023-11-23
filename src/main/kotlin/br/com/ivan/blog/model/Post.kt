package br.com.ivan.blog.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Post (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val titulo: String = "",
        val conteudo: String = "",
        var imagemUrl: String = "",
        var data: LocalDateTime = LocalDateTime.now(),

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "usuario_id")
        var usuario: Usuario = Usuario(),

        @OneToMany(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
        @JoinColumn(name = "comentario_id")
        var comentarios: MutableList<Comentario> = mutableListOf()
)