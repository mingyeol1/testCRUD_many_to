package com.crud.test.board;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody BoardDTO boardDTO){

        try {
            Board board = boardService.register(boardDTO);

            return ResponseEntity.ok(board);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
