package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.model.Comment;
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.model.UserVideoPost;
import by.tms.instaclonec26onl.storage.InMemoryCommentStorage;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {

    InMemoryCommentStorage storage=new InMemoryCommentStorage();

    public void addComment(String textComment, Long postId, User user) {
        //String commentText = req.getParameter("comment");
        Comment comment = new Comment(new UserPost(postId), textComment, user);
        storage.save_comment(comment);
    }

    public List<Comment> findAllComment(UserPost userPost) {
        return storage.findAllByPostId(userPost.getIdPost());
    }


    public void deleteComment(Long commentId){
        storage.deleteComment(commentId);
    }

    public void deleteCommentsByPostId(Long postId) {
        storage.deleteCommentByPostId(postId);
    }

}
