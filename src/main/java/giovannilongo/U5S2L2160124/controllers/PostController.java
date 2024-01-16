package giovannilongo.U5S2L2160124.controllers;

import giovannilongo.U5S2L2160124.entities.Post;
import giovannilongo.U5S2L2160124.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    // 1. GET http://localhost:3001/posts
    @GetMapping
    public List<Post> getUsers() {
        return postService.getPost();
    }

    // 	2. POST http://localhost:3001/posts (+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public Post savePost(@RequestBody Post body) {
        return postService.save(body);
    }

    // 	3. GET http://localhost:3001/posts/:id
    @GetMapping("/{id}")
    public Post findById(@PathVariable int id) {
        return postService.findById(id);
    }


    // 	4. PUT http://localhost:3001/posts/:id (+body)
    @PutMapping("/{id}")
    public Post findByAndUpdate(@PathVariable int id, @RequestBody Post body) {
        return this.postService.findByIdAndUpdate(id, body);
    }

    // 	5. DELETE http://localhost:3001/posts/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204 (No content)
    public void findByIdAndDelete(@PathVariable int id) {
        this.postService.findByIdAndDelete(id);
    }
}
