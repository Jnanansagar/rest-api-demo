package com.learning.restapidimo.controller

import com.learning.restapidimo.service.AuthorService
import com.learning.restapidimo.entity.Author
import com.learning.restapidimo.entity.Blog
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorController(val authorService: AuthorService) {

    @PutMapping("/author")
    fun author(@RequestBody author: Author): ResponseEntity<Author> {
        return ResponseEntity.ok(authorService.save(author))
    }

    @GetMapping("/author/{id}/blogs")
    fun findAllBlogsByAuthorId(@PathVariable id: Long): ResponseEntity<Set<Blog>> {
        return ResponseEntity.ok(authorService.findAll(id))
    }
}