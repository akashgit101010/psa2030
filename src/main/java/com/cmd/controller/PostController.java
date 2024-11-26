package com.cmd.controller;

import com.cmd.entity.Post;
import com.cmd.repository.PostRepository;
import com.cmd.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostRepository postRepository;
    private PostService postService;

    public PostController(PostRepository postRepository , PostService postService) {
        this.postRepository = postRepository;
        this.postService = postService;

    }

    @PostMapping("/add")
    public String createPost(@RequestBody Post post) {
        postService.createPosts(post);
        return "Posted successfully";
    }
    @DeleteMapping("/delete")
    public String deletePost(@RequestParam long id) {
      postService.deleteById(id);
        return "Deleted Post successfully Of Id : "+id;
    }


}
