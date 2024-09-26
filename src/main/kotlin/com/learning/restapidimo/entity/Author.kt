package com.learning.restapidimo.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table

@Table("author")
data class Author(
    @Id val id: Long? = null,
    val name: String,
    val email: String,
    @MappedCollection(idColumn = "author_id")
    val blogs: Set<Blog> = emptySet()
)
