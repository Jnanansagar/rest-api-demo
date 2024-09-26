package com.learning.restapidimo.repository

import com.learning.restapidimo.entity.Author
import org.springframework.data.repository.ListCrudRepository

interface AuthorRepository : ListCrudRepository<Author, Long>