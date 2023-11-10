package br.com.ivan.blog.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Usuario (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val nome: String = "",
        val nickname: String = "",
        val email: String = "",
        val senha: String = "",
        var imagemPerfil: String = ""
) {

}