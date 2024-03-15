package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;
import exercise.model.Comment;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;
import org.springframework.web.bind.annotation.RequestParam;


// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("")
    public List<PostDTO> getPosts() {
        var posts = postRepository.findAll();
        var comments = commentRepository.findAll();

        List<PostDTO> postDTO = new ArrayList<>();
        for (Post post : posts) {
            var postComments =
                    comments.stream().filter(c -> c.getPostId() == post.getId()).toList();
            List<CommentDTO> commentsDTO = new ArrayList<>();
            for (Comment comment : postComments) {
                CommentDTO newCommentDTO = new CommentDTO();
                newCommentDTO.setId(comment.getId());
                newCommentDTO.setBody(comment.getBody());
                commentsDTO.add(newCommentDTO);
            }

            PostDTO newPostDTO = new PostDTO();
            newPostDTO.setId(post.getId());
            newPostDTO.setTitle(post.getTitle());
            newPostDTO.setBody(post.getBody());
            newPostDTO.setComments(commentsDTO);

            postDTO.add(newPostDTO);
        }
        return postDTO;
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable long id) {
        var post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                String.format("Post with id %s not found", id)));

        var comments = commentRepository.findAllByPostId(id);
        List<CommentDTO> commentDTOs = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDTO newCommentDTO = new CommentDTO();
            newCommentDTO.setId(comment.getId());
            newCommentDTO.setBody(comment.getBody());
            commentDTOs.add(newCommentDTO);
        }

        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setBody(post.getBody());
        postDTO.setComments(commentDTOs);

        return postDTO;
    }

}


// END
