package com.cmd.service;

import com.cmd.entity.Post;
import com.cmd.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPosts(Post post) {
        postRepository.save(post);
    }

    public void deleteById(long id) {
        postRepository.deleteById(id);
    }
}
