package com.project.novelpot.service;

import com.project.novelpot.dto.BoardWriteDto;
import com.project.novelpot.entity.board.Board;
import com.project.novelpot.repository.BoardRepository;
import com.project.novelpot.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final MemberRepository memberRepository;

    private final BoardRepository boardRepository;

    public Board getBoardDetail(Long id) {
        Board board = boardRepository.findById(id).get();
        board.setView(board.getView() + 1);
        boardRepository.save(board);

        return board;
    }

    public List<Board> getRecentBoard() {
        return boardRepository.findTop5ByOrderByCreateAtDesc();
    }

    public List<Board> getHotBoard() {
        return boardRepository.findTop5ByOrderByViewDesc();
    }

    public void write(BoardWriteDto dto, Principal principal) {
        boardRepository.save(
                Board.builder()
                        .title(dto.getTitle())
                        .content(dto.getContent())
                        .view(0)
                        .member(memberRepository.findByUsername(principal.getName()).get())
                        .createAt(LocalDateTime.now())
                        .build()
        );
    }

    public List<Board> getBoards() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createAt"));
    }

    public List<Board> getBoardsHot() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "view"));
    }

}
