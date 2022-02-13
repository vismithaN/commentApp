package com.zoho.comment;

import com.zoho.comment.Database.Comments;
import com.zoho.comment.Database.User;
import com.zoho.comment.Database.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@Controller
public class ApplicationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("")
    public String viewHomePage() {
        return "Index";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("user", new User());
        return "SignUp";
    }

    @PostMapping("/register_user")
    public String registerUser(User user) {
        String encodedPassword = new String(Base64.getEncoder().encode(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return "SignUpSuccess";//comment
    }

    @GetMapping("/signin")
    public String signIn(Model model){
        model.addAttribute("user", new User());
        return "SignIn";
    }

    @PostMapping("/signin_user")
    public String signInUser(User user) {
        Optional<User> fetchUser = userRepo.findByEmailID(user.getEmailID());
        if(fetchUser.isPresent()){
            if(fetchUser.get().getPassword().equals(new String(Base64.getEncoder().encode(user.getPassword().getBytes(StandardCharsets.UTF_8)))))
                return "SignUpSuccess";
        }
        return "SignIn";//comment
    }

//    @PostMapping("/user/comment-page")
//    public void createComment(@RequestBody Comments comment,){
//       // Optional<User> optionalUser = userRepository.findById(id)
//
//        User user = optionalUser.get();
//        post.setUser(user);
//        postRepository.save(post);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
//        //return status and the user added
//        return ResponseEntity.created(location).build();
//    }


}
