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
        var postsDTO = posts.stream().map(this::toPostDTO).toList();

        return postsDTO;
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable long id) {
        var post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                String.format("Post with id %s not found", id)));

        return toPostDTO(post);
    }

    private PostDTO toPostDTO(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        
        List<CommentDTO> commentDTOs = new ArrayList<>();
        var comments = commentRepository.findByPostId(post.getId());
        for (Comment comment : comments) {
            CommentDTO newCommentDTO = new CommentDTO();
            newCommentDTO.setId(comment.getId());
            newCommentDTO.setBody(comment.getBody());
            commentDTOs.add(newCommentDTO);
        }
        dto.setComments(commentDTOs);
        return dto;
    }
}


// END
