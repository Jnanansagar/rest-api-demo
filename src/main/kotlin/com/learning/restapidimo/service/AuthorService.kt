package com.learning.restapidimo.service

import com.learning.restapidimo.entity.Author
import com.learning.restapidimo.entity.Blog
import com.learning.restapidimo.repository.AuthorRepository
import com.learning.restapidimo.repository.BlogRepository
import org.springframework.stereotype.Service

@Service
class AuthorService(
    val authorRepository: AuthorRepository,
    val blogRepository: BlogRepository
) {

    fun save(author: Author): Author {
        return authorRepository.save(author)
    }

    fun findAll(id: Long): Set<Blog>? {
        return authorRepository.findById(id).orElse(null)?.blogs
    }
}