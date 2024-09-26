package com.learning.restapidimo.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "blog")
data class Blog(
    @Id
    val id: Long? = null,
    val authorId: Long, // foreign key
    val title: String,
    val category: String,
    val content: String,
)