package mer.mano.Dao;

import java.util.List;

import mer.mano.model.BlogComment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDaoImpl implements BlogCommentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean editBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().update(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<BlogComment> getBlogCommentList(int blogId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BlogComment WHERE blogId = '" + blogId + "'");
		List<BlogComment> blogCommentList = query.list();
		session.close();
		return blogCommentList;
	}

	@Override
	public BlogComment getBlogComment(int commentId) {
		Session session = sessionFactory.openSession();
		BlogComment blogComment = session.get(BlogComment.class, commentId);
		session.close();
		return blogComment;
	}

}
