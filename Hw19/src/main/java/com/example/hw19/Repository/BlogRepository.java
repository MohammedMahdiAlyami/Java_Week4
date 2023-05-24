package com.example.hw19.Repository;

import com.example.hw19.Model.Blog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Blog findBlogById(Integer id);

    List<Blog> findBlogByTitle(String title);

    List<Blog> findBlogByCategory(String category);

    @Query("update Blog i set i.isPublished = true where i.id=?1")
    void publish(Integer id);

}
