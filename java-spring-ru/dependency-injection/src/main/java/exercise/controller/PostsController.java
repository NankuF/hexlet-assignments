package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import java.util.List;
import exercise.model.Comment;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("")
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post with id " + id + " not found."));
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable long id) {
        commentRepository.deleteByPostId(id);
        postRepository.deleteById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post entity) {
        return postRepository.save(entity);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable long id, @RequestBody Post entity) {
        var post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post with id " + id + " not found."));

        post.setBody(entity.getBody());
        post.setTitle(entity.getTitle());
        postRepository.save(post);
        return post;
    }
}
// END
