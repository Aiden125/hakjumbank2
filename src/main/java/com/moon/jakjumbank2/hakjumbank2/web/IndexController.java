package com.moon.jakjumbank2.hakjumbank2.web;

import com.moon.jakjumbank2.hakjumbank2.config.auth.LoginUser;
import com.moon.jakjumbank2.hakjumbank2.config.auth.dto.SessionUser;
import com.moon.jakjumbank2.hakjumbank2.service.posts.PostsService;
import com.moon.jakjumbank2.hakjumbank2.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

// 화면 안내용 컨트롤러
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("uName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
