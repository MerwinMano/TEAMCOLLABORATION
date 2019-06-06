package mer.mano.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import mer.mano.Dao.BlogDao;
import mer.mano.Dao.BlogLikeDislikeDao;
import mer.mano.model.Blog;



@RestController
public class BlogController {
	@Autowired
	BlogDao blogDAO;
	@Autowired
	BlogLikeDislikeDao blogLikeDislikeDAO;
	@Autowired
	//FriendDAO friendDAO;

	@RequestMapping(value = "/addBlog",method=RequestMethod.GET)
	public String addBlog(@Valid @RequestBody Blog blog) {
		blog.setCreatedDate(new java.util.Date());

		if (blogDAO.addBlog(blog)) {
			Gson gson = new Gson();
			return gson.toJson(blog);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/deleteBlog/{blogId}",method=RequestMethod.GET)
	public String deleteBlog(@PathVariable("blogId") int blogId) {
		Blog blog = blogDAO.getBlog(blogId);
		if (blogDAO.deleteBlog(blog)) {
			{
				Gson gson = new Gson();
				return gson.toJson(blog);
			}
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/updateBlog",method=RequestMethod.POST)
	public String updateBlog(@Valid @RequestBody Blog blog) {
		blog.setCreatedDate(blogDAO.getBlog(blog.getBlogId()).getCreatedDate());
		if (blogDAO.updateBlog(blog)) {
			Gson gson = new Gson();
			return gson.toJson(blog);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/approveBlog/{blogId}",method=RequestMethod.GET)
	public String approveBlog(@PathVariable("blogId") int blogId) {
		Blog blog = blogDAO.getBlog(blogId);
		if (blogDAO.approveBlog(blog)) {
			{
				Gson gson = new Gson();
				return gson.toJson(blog);
			}
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/rejectBlog/{blogId}",method=RequestMethod.GET)
	public String rejectBlog(@PathVariable("blogId") int blogId) {
		Blog blog = blogDAO.getBlog(blogId);
		if (blogDAO.rejectBlog(blog)) {
			{
				Gson gson = new Gson();
				return gson.toJson(blog);
			}
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/getBlogList",method=RequestMethod.GET)
	public String getBlogList() {
		List<Blog> blogList = blogDAO.getBlogList();
		if (blogList != null) {
			Gson gson = new Gson();
			return gson.toJson(blogList);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/blogSearch/{queryText}",method=RequestMethod.GET)
	public String blogSearch(@PathVariable("queryText") String queryText) {
		List<Blog> blogList = blogDAO.blogSearch(queryText);
		if (blogList != null) {
			Gson gson = new Gson();
			return gson.toJson(blogList);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/getUserBlogList/{username}",method=RequestMethod.GET)
	public String getUserBlogList(@PathVariable("username") String username) {
		List<Blog> blogList = blogDAO.getUserBlogList(username);
		if (blogList != null) {
			Gson gson = new Gson();
			return gson.toJson(blogList);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/getLimitedBlogList/{username}/{startRowNum}/{endRowNum}",method=RequestMethod.GET)
	public String getLimitedBlogList(@PathVariable("username") String username,
			@PathVariable("startRowNum") int startRowNum, @PathVariable("endRowNum") int endRowNum) {
		List<Blog> blogList = blogDAO.getLimitedBlogList(username, startRowNum, endRowNum);
		if (blogList != null) {
			Gson gson = new Gson();
			return gson.toJson(blogList);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/getBlog/{blogId}",method=RequestMethod.GET)
	public String getBlog(@PathVariable("blogId") int blogId) {
		Blog blog = blogDAO.getBlog(blogId);
		if (blog != null) {
			Gson gson = new Gson();
			return gson.toJson(blog);
		} else
			return null;
	}

	@RequestMapping(value = "/incrementLike/{blogId}",method=RequestMethod.GET)
	public String incrementLike(@PathVariable("blogId") int blogId) {
		Blog blog = blogDAO.getBlog(blogId);
		if (blogDAO.incrementLike(blog)) {
			Gson gson = new Gson();
			return gson.toJson(blog);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/incrementDislike/{blogId}",method=RequestMethod.GET)
	public String incrementDislike(@PathVariable("blogId") int blogId) {
		Blog blog = blogDAO.getBlog(blogId);
		if (blogDAO.incrementDislike(blog)) {
			Gson gson = new Gson();
			return gson.toJson(blog);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/decrementLike/{blogId}",method=RequestMethod.GET)
	public String decrementLike(@PathVariable("blogId") int blogId) {
		Blog blog = blogDAO.getBlog(blogId);
		if (blogDAO.decrementLike(blog)) {
			Gson gson = new Gson();
			return gson.toJson(blog);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/decrementDislike/{blogId}",method=RequestMethod.GET)
	public String decrementDislike(@PathVariable("blogId") int blogId) {
		Blog blog = blogDAO.getBlog(blogId);
		if (blogDAO.decrementDislike(blog)) {
			Gson gson = new Gson();
			return gson.toJson(blog);
		} else {
			return null;
		}
	}

}


