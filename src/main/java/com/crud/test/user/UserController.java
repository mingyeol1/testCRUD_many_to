package com.crud.test.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("signin")
    public ResponseEntity<?> signIn(@RequestBody UserDTO userDTO){

        User user = userService.signUp(userDTO);

        return ResponseEntity.ok(user);
    }
}
