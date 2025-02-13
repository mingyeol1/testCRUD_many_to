package com.crud.test.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {

    private Long id;
    private String title;
    private String content;
    private Long userId;
}
