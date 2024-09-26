package com.learning.restapidimo

import com.learning.restapidimo.entity.Author
import com.learning.restapidimo.entity.Blog
import com.learning.restapidimo.repository.AuthorRepository
import com.learning.restapidimo.repository.BlogRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import kotlin.jvm.optionals.getOrNull

@SpringBootApplication
class RestApiDemoApplication {

    @Bean
    fun runner(authorRepository: AuthorRepository, blogRepository: BlogRepository): CommandLineRunner {
        return CommandLineRunner {

            // add some dummy data to database on application start
            val author = Author(
                null, "Sagar", "dummy@xml.com",
            )
            val author1 = Author(
                null, "Sudeep", "dummy@gml.com",
            )

            val authorSaved = authorRepository.save(author)
            val author1Saved = authorRepository.save(author1)

            val authorBlogs = listOf(
                Blog(
                    title = "The truth will set you free",
                    category = "spiritual",
                    content = "You will know the truth and truth will set you free.",
                    authorId = authorSaved.id!!
                ),
                Blog(
                    authorId = authorSaved.id,
                    title = "No Fear",
                    category = "spiritual",
                    content = "God says fear not for I am with you."
                )
            )

            val author1Blogs = listOf(
                Blog(
                    title = "Persevere",
                    category = "spiritual",
                    content = "Whover endure in love till the end will be saved.",
                    authorId = author1Saved.id!!
                ),
                Blog(
                    authorId = author1Saved.id,
                    title = "He break you and multiply you",
                    category = "spiritual",
                    content = "Jesus broke the bread and fed multitude of people"
                )
            )

            blogRepository.saveAll(authorBlogs)
            blogRepository.saveAll(author1Blogs)

            println(
                "All blogs for author are ${authorSaved.name} --> ${
                    authorRepository.findById(authorSaved.id).getOrNull()
                }"
            )

            println(
                "All blogs for author are ${author1Saved.name} --> ${
                    authorRepository.findById(author1Saved.id).getOrNull()
                }"
            )

        }
    }
}

fun main(args: Array<String>) {
    runApplication<RestApiDemoApplication>(*args)
}
