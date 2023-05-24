package com.example.hw19.Service;

import com.example.hw19.ApiExcepton.ApiException;
import com.example.hw19.Model.Blog;
import com.example.hw19.Repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogService {


    private final BlogRepository blogRepository;

    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }


    public void addBlog(Blog blog){
        blogRepository.save(blog);
    }


    public void updateBlog(Integer id,Blog blog){
        Blog oldBlog =blogRepository.findBlogById(id);
        if(oldBlog==null){
            throw new ApiException("Blog not existed");
        }
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setCategory(blog.getCategory());
        oldBlog.setBody(blog.getBody());
        blogRepository.save(oldBlog);
    }


    public void deleteBlog(Integer id){
        Blog oldBlog=blogRepository.findBlogById(id);
        if(oldBlog==null){
            throw new ApiException("Blog not existed");
        }
        blogRepository.deleteById(id);
    }


    public Blog findBlogById( Integer id){
        Blog blog=blogRepository.findBlogById(id);
        if (blog == null) {
            throw new ApiException("blog not existed");
        }
        return blog;
    }


    public List<Blog> findBlogByTitle(String title){
        List<Blog> blogs=  blogRepository.findBlogByTitle(title);
        if (blogs==null){
            throw new ApiException("Blog by this title not existed");
        }
        return blogs;
    }


    public List<Blog> findBlogByCategory(String category){
        List<Blog> blogs=  blogRepository.findBlogByCategory(category);
        if (blogs==null){
            throw new ApiException("Blog by this category not existed");
        }
        return blogs;
    }


    public void ChangePublishedStatesToTrue(Integer id){
        Blog blog =blogRepository.findBlogById(id);
        if (blog==null){
            throw new ApiException("Blog by this id not existed");
        }
        blogRepository.publish(id);
    }


}