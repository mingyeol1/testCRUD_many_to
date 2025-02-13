package com.crud.test.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public User signUp(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);

        userRepository.save(user);


        return user;
    }
}
