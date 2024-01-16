package giovannilongo.U5S2L2160124.controllers;

import giovannilongo.U5S2L2160124.entities.Blogger;
import giovannilongo.U5S2L2160124.services.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloggers")
public class BloggerController {
    @Autowired
    private BloggerService bloggerService;

    // 1. GET http://localhost:3001/bloggers
    @GetMapping
    public List<Blogger> getBloggers() {
        return bloggerService.getBlogger();
    }

    // 	2. POST http://localhost:3001/bloggers (+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public Blogger saveBlogger(@RequestBody Blogger body) {
        return bloggerService.save(body);
    }

    // 	3. GET http://localhost:3001/bloggers/:id
    @GetMapping("/{id}")
    public Blogger findById(@PathVariable int id) {
        return bloggerService.findById(id);
    }


    // 	4. PUT http://localhost:3001/bloggers/:id (+body)
    @PutMapping("/{id}")
    public Blogger findByAndUpdate(@PathVariable int id, @RequestBody Blogger body) {
        return this.bloggerService.findByIdAndUpdate(id, body);
    }

    // 	5. DELETE http://localhost:3001/bloggers/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204 (No content)
    public void findByIdAndDelete(@PathVariable int id) {
        this.bloggerService.findByIdAndDelete(id);
    }
}
