package com.cmd.controller;

import com.cmd.entity.Comment;
import com.cmd.repository.CommentRepository;
import com.cmd.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private CommentRepository commentRepository;
    private CommentService commentService;

    public CommentController(CommentRepository commentRepository, CommentService commentService) {
        this.commentRepository = commentRepository;
        this.commentService = commentService;
    }
    @PostMapping("/add")
    public String createComments(
            @RequestBody Comment comment,
      @RequestParam long postId){
        commentService.createComments(postId , comment);
        return "Commented successfully on PostId : "+postId;

    }

}
