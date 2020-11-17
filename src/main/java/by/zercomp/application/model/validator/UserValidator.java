package by.zercomp.application.model.validator;

import by.zercomp.application.model.service.DTMapKey;
import by.zercomp.application.model.service.ErrorMsg;

import java.util.Map;
import java.util.regex.Pattern;

public class UserValidator {
    private static final UserValidator instance = new UserValidator();
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 20;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern LOGIN_PATTERN = Pattern.compile("\\w{3,20}");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-zА-Яа-яёЁ]{3,20}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])" +
            "(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$");

    private UserValidator() {}

    public static UserValidator getInstance() {
        return instance;
    }

    public boolean checkName(String potential, Map<String, String> signupData, String error) {
        if (potential == null || !NAME_PATTERN.matcher(potential).matches()) {
            signupData.put(error, ErrorMsg.NAME.toString());
            return false;
        }
        return true;
    }

    private boolean checkEmail(Map<String, String> signUpData) {
        String email = signUpData.get(DTMapKey.EMAIL);
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            signUpData.put(DTMapKey.EMAIL, ErrorMsg.EMAIL.toString());
            return false;
        }
        return true;
    }

    private boolean checkLogin(Map<String, String> signUpData) {
        String login = signUpData.get(DTMapKey.LOGIN);
        if (login == null || !LOGIN_PATTERN.matcher(login).matches()) {
            signUpData.put(DTMapKey.LOGIN, ErrorMsg.LOGIN.toString());
            return false;
        }
        return true;
    }
}
