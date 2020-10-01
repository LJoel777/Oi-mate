package hu.joel.laczkovszki.qa.service;

import hu.joel.laczkovszki.qa.infoView.PostInfoView;
import hu.joel.laczkovszki.qa.infoView.UserInfoView;
import hu.joel.laczkovszki.qa.model.Post;
import hu.joel.laczkovszki.qa.model.User;
import hu.joel.laczkovszki.qa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    UserService userService;

    @Autowired
    NotificationService notificationService ;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void addPost(Post post) {
        User user = userService.getUserById(post.getUserId());
        if (user != null) {
            post.setUser(user);
            user.addPost(post);
            postRepository.save(post);
        }
    }

    public PostInfoView getPostInfoViewById(Long postId, Long userId) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post != null) {
            UserInfoView userInfoView = userService.getUserInfoView(post.getUser().getId());
            return PostInfoView.builder()
                    .postId(post.getId())
                    .userId(post.getUser().getId())
                    .description(post.getDescription())
                    .imagePath(post.getImagePath())
                    .categories(post.getCategories())
                    .userInfoView(userInfoView)
                    .voteNumber(post.getVotes().size())
                    .isUserVoted(post.didUserVoted(userService.getUserById(userId)))
                    .build();
        }
        return null;
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

    public Set<PostInfoView> getAllPostInfoViewsByUserId(Long userId) {
        Set<Post> posts = postRepository.findAllByUserId(userId);
        return convertPosts(posts, userId);
    }

    public Set<PostInfoView> getPostInfoViewssByUserHobby(Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            List<String> hobbies = user.getFieldsOfInterests();
            Set<Post> posts = postRepository.findAllByCategoriesIn(hobbies);
            return convertPosts(posts, userId);
        }
        return new HashSet<>();
    }

    public Set<PostInfoView> getPostInfoViewsByFriends(Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            Set<User> friends = user.getFriends();
            Set<Post> posts = postRepository.findAllByUserIsIn(friends);
            return convertPosts(posts, userId);
        }
        return new HashSet<>();
    }

    public void addVote(Long postId, Long userId) {
        Post post = postRepository.findById(postId).orElse(null);
        User user = userService.getUserById(userId);
        if (post != null && user != null) {
            notificationService.addPostVoteNotification(user,post);
            post.addVote(user);
            postRepository.save(post);
        }
    }

    public Set<PostInfoView> convertPosts(Set<Post> posts, Long session) {
        Set<PostInfoView> postInfoViews = new HashSet<>();
        posts.forEach(post -> {
            UserInfoView userInfoView = userService.getUserInfoView(post.getUser().getId());
            postInfoViews.add(PostInfoView.builder()
                    .userInfoView(userInfoView)
                    .voteNumber(post.getVotes().size())
                    .categories(post.getCategories())
                    .imagePath(post.getImagePath())
                    .description(post.getDescription())
                    .userId(post.getUser().getId())
                    .postId(post.getId())
                    .isUserVoted(post.didUserVoted(userService.getUserById(session)))
                    .build());
        });
        return postInfoViews;
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Set<PostInfoView> getPostInfoViewsByTopic(String topic, Long session) {
        Set<Post> posts = new HashSet<>(postRepository.findPostsByCategoriesIsContaining(topic));
        return convertPosts(posts, session);
    }
}
