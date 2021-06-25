package vn.codegym.blog.model.repository;

import vn.codegym.blog.model.bean.Blog;

import java.util.List;

public interface BlogRepo {
    List<Blog> showAll();
    List<Blog> findBlog(String title);
    Blog showDetail(int id);
    void addBlog(Blog blog);
    void updateBlog(Blog blog);
    void deleteBlog(Blog blog);
}
