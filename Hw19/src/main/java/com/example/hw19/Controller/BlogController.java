package com.example.hw19.Controller;

import com.example.hw19.Model.Blog;
import com.example.hw19.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/blog")
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getAllBlogs(){
        List<Blog> blogs=blogService.getAllBlogs();
        return ResponseEntity.status(200).body(blogs);
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog){
        blogService.addBlog(blog);
        return ResponseEntity.status(200).body("Blog added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@PathVariable Integer id,@Valid @RequestBody Blog blog){
        blogService.updateBlog(id, blog);
        return ResponseEntity.status(200).body("blog updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id ){
        blogService.deleteBlog(id);
        return ResponseEntity.status(200).body("blog deleted");
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity findBlogById(@PathVariable Integer id){
        Blog blog=blogService.findBlogById(id);
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/getbytitle/{title}")
    public ResponseEntity findBlogByTitle(@PathVariable String title){
        List<Blog>blogs=blogService.findBlogByTitle(title);
        return ResponseEntity.status(200).body(blogs);
    }

    @GetMapping("/getbycategory/{category}")
    public ResponseEntity findBlogByCategory(@PathVariable String category){
        List<Blog>blogs=blogService.findBlogByCategory(category);
        return ResponseEntity.status(200).body(blogs);
    }

    @GetMapping("/publish/{id}")
    public ResponseEntity Publish(@PathVariable Integer id){
        blogService.ChangePublishedStatesToTrue(id);
        return  ResponseEntity.status(200).body("Blog published");
    }


}