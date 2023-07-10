package com.project.novelpot.repository;

import com.project.novelpot.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findTop5ByOrderByCreateAtDesc();

    List<Board> findTop5ByOrderByViewDesc();

}
