package com.crud.test.board;

import com.crud.test.user.User;
import com.crud.test.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public Board register(BoardDTO boardDTO) {

       User user = userRepository.findById(boardDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않음."));


        Board board = modelMapper.map(boardDTO, Board.class);


        //이걸 강제로 안넣어주면 user의 id값이 계속 null값을 반환함.
        //board 의 manyToOne으로 불러온 User값에 UserRepository 값 넣어주기.
        board.setUser(user);
        boardRepository.save(board);

        return board;
    }
}
