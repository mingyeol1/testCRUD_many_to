package com.crud.test.user;

import com.crud.test.mail.EmailService;
import com.crud.test.mail.EmailVerificationStore;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;
    private final EmailService emailService;
    private final Map<String, String> verificationCodes = new HashMap<>(); // 이메일-인증코드 저장

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserDTO userDTO){


        try {
            User user = userService.signUp(userDTO);

            return ResponseEntity.ok(user);
        } catch (UserService.UserIdExistException e) {
            throw new RuntimeException(e);
        }



    }

    // 이메일 인증 코드 요청
    @PostMapping("/send-code")
    public String sendVerificationCode(@RequestParam String email) {
        String code = emailService.generateVerificationCode();
        emailService.sendVerificationEmail(email, code);
        verificationCodes.put(email, code); // 이메일과 인증 코드 저장
        return "인증 코드가 이메일로 전송되었습니다.";
    }

    // 인증 코드 확인
    @PostMapping("/verify-code")
    public String verifyCode(@RequestParam String email, @RequestParam String code) {
        if (verificationCodes.containsKey(email) && verificationCodes.get(email).equals(code)) {
            verificationCodes.remove(email);
            EmailVerificationStore.verifyEmail(email); // 인증 성공 시 이메일 저장
            return "이메일 인증 성공!";
        }
        return "인증 코드가 올바르지 않습니다.";
    }


}
