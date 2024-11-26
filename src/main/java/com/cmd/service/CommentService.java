package com.cmd.service;

import com.cmd.entity.Comment;
import com.cmd.entity.Post;
import com.cmd.repository.CommentRepository;
import com.cmd.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }
    public void createComments(long postId, Comment comment) {
        Post post= postRepository.findById(postId).get();
        comment.setPost(post);
        commentRepository.save(comment);
    }
}
