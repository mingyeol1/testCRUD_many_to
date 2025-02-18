package com.crud.test.mail;

import java.util.HashSet;
import java.util.Set;

public class EmailVerificationStore {
    private static final Set<String> verifiedEmails = new HashSet<>();

    public static void verifyEmail(String email) {
        verifiedEmails.add(email);
    }

    public static boolean isVerified(String email) {
        return verifiedEmails.contains(email);
    }
}
