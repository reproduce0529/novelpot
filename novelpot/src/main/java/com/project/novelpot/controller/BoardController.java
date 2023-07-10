package com.project.novelpot.controller;

import com.project.novelpot.dto.BoardWriteDto;
import com.project.novelpot.repository.BoardRepository;
import com.project.novelpot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public String goToDetail(@RequestParam Long id, Model model) {
        model.addAttribute("board", boardService.getBoardDetail(id));
        return "detail";
    }

    @GetMapping("/name")
    public String goToNameDetail(@RequestParam Long id, Model model) {
        model.addAttribute("board", boardService.getBoardDetail(id));
        return "name";
    }

    @PostMapping("/board/write")
    public String write(BoardWriteDto dto, Principal principal) {
        boardService.write(dto, principal);
        return "redirect:/view/index";
    }

}
