package com.crud.test.user;

public interface UserService {

    class UserIdExistException extends Exception {
        public UserIdExistException(String s) {}
    }


    User signUp(UserDTO userDTO) throws UserIdExistException;
}
