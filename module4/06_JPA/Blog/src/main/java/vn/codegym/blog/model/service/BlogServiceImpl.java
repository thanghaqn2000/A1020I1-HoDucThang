package vn.codegym.blog.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.blog.model.bean.Blog;
import vn.codegym.blog.model.repository.BlogRepo;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogRepo blogRepo;
    @Override
    public List<Blog> showAll() {
        return blogRepo.showAll();
    }

    @Override
    public List<Blog> findBlog(String title) {
        return blogRepo.findBlog(title);
    }

    @Override
    public Blog showDetail(int id) {
        return blogRepo.showDetail(id);
    }

    @Override
    public void addBlog(Blog blog) {
        blogRepo.addBlog(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepo.updateBlog(blog);
    }

    @Override
    public void deleteBlog(Blog blog) {
        blogRepo.deleteBlog(blog);
    }
}
