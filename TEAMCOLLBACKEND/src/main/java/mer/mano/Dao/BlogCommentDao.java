package mer.mano.Dao;

import java.util.List;

import mer.mano.model.BlogComment;

public interface BlogCommentDao {
	public BlogComment getBlogComment(int commentId);

	public boolean addBlogComment(BlogComment blogComment);

	public boolean editBlogComment(BlogComment blogComment);

	public boolean deleteBlogComment(BlogComment blogComment);

	public List<BlogComment> getBlogCommentList(int blogId);
}



