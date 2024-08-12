package com.rozane.blog.controller;

import com.rozane.blog.model.BlogPostModel;
import com.rozane.blog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/posts")
public class BlogPostController {

    private final BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping
    public String getAllPosts(Model model) {
        List<BlogPostModel> posts = blogPostService.findAll();
        model.addAttribute("posts", posts);
        return "index"; // Nome do template HTML para a página inicial
    }

    @GetMapping("/{id}")
    public String getPostById(@PathVariable UUID id, Model model) {
        Optional<BlogPostModel> post = blogPostService.findById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            return "post";
        } else {
            // Redireciona para uma página de erro ou página de lista se o post não for encontrado
            return "redirect:/posts";
        }
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("blogPost", new BlogPostModel());
        return "form"; // Nome do template HTML para o formulário de criação
    }

    @PostMapping
    public String createPost(@ModelAttribute BlogPostModel blogPost) {
        blogPostService.save(blogPost);
        return "redirect:/posts";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable UUID id, Model model) {
        Optional<BlogPostModel> post = blogPostService.findById(id);
        if (post.isPresent()) {
            model.addAttribute("blogPost", post.get());
            return "form"; // Nome do template HTML para o formulário de edição
        } else {
            // Redireciona para uma página de erro ou página de lista se o post não for encontrado
            return "redirect:/posts";
        }
    }

    @PostMapping("/{id}")
    public String updatePost(@PathVariable UUID id, @ModelAttribute BlogPostModel blogPost) {
        blogPost.setId(id);
        blogPostService.update(id, blogPost);
        return "redirect:/posts";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable UUID id) {
        blogPostService.deleteById(id);
        return "redirect:/posts";
    }
}
