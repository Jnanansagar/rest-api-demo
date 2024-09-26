package com.learning.restapidimo.repository

import com.learning.restapidimo.entity.Blog
import org.springframework.data.repository.ListCrudRepository

interface BlogRepository : ListCrudRepository<Blog, Long> {}