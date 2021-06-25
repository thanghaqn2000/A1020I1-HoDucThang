package vn.codegym.blog.model.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.blog.model.bean.Blog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class BlogRepoImpl implements BlogRepo{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Blog> showAll() {
        TypedQuery<Blog>query=entityManager.createQuery("SELECT B FROM Blog as B ",Blog.class);
        return query.getResultList();
    }

    @Override
    public List<Blog> findBlog(String title) {
        TypedQuery<Blog> query =entityManager.createQuery("select b from Blog as b where " +
                "b.title like :title or b.author like :title",Blog.class);
        query.setParameter("title","%"+title+"%");
        return query.getResultList();
    }

    @Override
    public Blog showDetail(int id) {
        return entityManager.find(Blog.class,id);
    }

    @Override
    public void addBlog(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public void deleteBlog(Blog blog) {
        entityManager.remove(entityManager.merge(blog));
    }
}
