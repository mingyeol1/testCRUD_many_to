package com.crud.test.user;

import com.crud.test.mail.EmailVerificationStore;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public User signUp(UserDTO userDTO) throws UserIdExistException {

        // 이메일 인증 여부 확인 (여기서는 간단한 예제로 가정)
        if (!EmailVerificationStore.isVerified(userDTO.getEmail())) {
            throw new IllegalStateException("이메일 인증이 필요합니다.");
        }

        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new UserIdExistException("이메일이 이미 존재합니다.");
        }


        User user = modelMapper.map(userDTO, User.class);

        userRepository.save(user);


        return user;
    }
}
