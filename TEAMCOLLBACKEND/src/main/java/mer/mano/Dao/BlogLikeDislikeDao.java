package mer.mano.Dao;
import java.util.List;

import mer.mano.model.BlogDislike;
import mer.mano.model.BlogLike;


public interface BlogLikeDislikeDao {

	public boolean addBlogLike(BlogLike like);

	public boolean removeBlogLike(BlogLike like);

	public boolean addBlogDislike(BlogDislike dislike);

	public boolean removeBlogDislike(BlogDislike dislike);

	public BlogLike getBlogLikeById(int likeId);

	public BlogDislike getBlogDislikeById(int dislikeId);

	public BlogLike getBlogLikeByUser(String username, int blogId);

	public BlogDislike getBlogDislikeByUser(String username, int blogId);

	public List<BlogLike> getBlogLikesList(String username);

	public List<BlogDislike> getBlogDislikesList(String username);


}