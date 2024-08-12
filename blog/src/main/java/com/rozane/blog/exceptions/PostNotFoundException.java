package com.rozane.blog.exceptions;

import java.util.UUID;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(UUID id) {
        super("Post not found with ID: " + id);
    }
}
