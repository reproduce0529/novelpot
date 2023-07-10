package com.project.novelpot.controller;

import com.project.novelpot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view")
public class ViewController {

    private final BoardService boardService;

    @GetMapping("/login")
    public String goToLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String goToRegister() {
        return "register";
    }

    @GetMapping("/index")
    public String goToIndex(Model model) {
        model.addAttribute("recentBoard", boardService.getRecentBoard());
        model.addAttribute("hotBoard", boardService.getHotBoard());
        return "index";
    }

    @GetMapping("/list")
    public String goToList(Model model) {
        model.addAttribute("boards", boardService.getBoards());
        return "list";
    }

    @GetMapping("/form")
    public String goToForm() {
        return "form";
    }

    @GetMapping("/rank")
    public String goToRank(Model model) {
        model.addAttribute("boards", boardService.getBoardsHot());
        return "rank";
    }

}
