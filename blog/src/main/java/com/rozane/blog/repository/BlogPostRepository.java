package com.rozane.blog.repository;

import com.rozane.blog.model.BlogPostModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogPostRepository extends JpaRepository<BlogPostModel, UUID> {
}
