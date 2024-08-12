package com.rozane.blog.service;

import com.rozane.blog.exceptions.PostNotFoundException;
import com.rozane.blog.exceptions.InvalidPostDataException;
import com.rozane.blog.model.BlogPostModel;
import com.rozane.blog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public List<BlogPostModel> findAll() {
        return blogPostRepository.findAll();
    }

    public Optional<BlogPostModel> findById(UUID id) {
        return blogPostRepository.findById(id);
    }

    public BlogPostModel save(BlogPostModel blogPost) {
        // Validação simples
        if (blogPost.getTitle() == null || blogPost.getTitle().trim().isEmpty()) {
            throw new InvalidPostDataException("Post title cannot be empty");
        }
        return blogPostRepository.save(blogPost);
    }

    public BlogPostModel update(UUID id, BlogPostModel updatedPost) {
        if (!blogPostRepository.existsById(id)) {
            throw new PostNotFoundException(id);
        }
        updatedPost.setId(id);
        return blogPostRepository.save(updatedPost);
    }

    public void deleteById(UUID id) {
        if (!blogPostRepository.existsById(id)) {
            throw new PostNotFoundException(id);
        }
        blogPostRepository.deleteById(id);
    }
}
