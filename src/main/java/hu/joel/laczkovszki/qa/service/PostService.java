package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.model.Hobby;
import hu.joel.laczkovszki.qa.model.Post;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.repository.PostRepository;
import hu.joel.laczkovszki.qa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {
    private PostRepository postRepository;
    private UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public void addPost(Post post) {
        User user = userRepository.findById(post.getUserId()).orElse(null);
        if (user != null) {
            post.setUser(user);
            postRepository.save(post);
        }
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public void removePostById(Long id) {
        postRepository.deleteById(id);
    }

    public void updatePostById(Long id, Post post) {
        Post updatedPost = postRepository.getOne(id);
        updatedPost.setDescription(post.getDescription());
        updatedPost.setImagePath(post.getImagePath());
        postRepository.save(updatedPost);
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public List<Post> getAllPost_byUserId(Long userId) {
        return postRepository.findAllByUserId(userId);
    }

    public List<Post> getPostsByUserHobby(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            List<String> hobbies = user.getFieldsOfInterests();
            return postRepository.findAllByCategoriesIn(hobbies);
        }
        return new ArrayList<>();
    }

    public List<Post> getPostsByFriends(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            List<User> friends = user.getFriends();
            return postRepository.findAllByUserIsIn(friends);
        }
        return new ArrayList<>();
    }

}
