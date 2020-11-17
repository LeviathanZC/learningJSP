package by.zercomp.application.model.validator;

import by.zercomp.application.model.service.DTMapKey;
import by.zercomp.application.model.service.ErrorMsg;

import java.util.Map;
import java.util.regex.Pattern;

public class UserValidator {
    private static final UserValidator instance = new UserValidator();
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern LOGIN_PATTERN = Pattern.compile("\\w{3,20}");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-zА-Яа-яёЁ]{3,20}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])" +
            "(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$");

    private UserValidator() {}

    public static UserValidator getInstance() {
        return instance;
    }



    public boolean checkPassword(Map<String, String> signUpData) {
        String password = signUpData.get(DTMapKey.PASSWORD);
        String repeatPw = signUpData.get(DTMapKey.REPEAT_PW);
        if (password == null || !PASSWORD_PATTERN.matcher(password).matches()) {
            signUpData.put(DTMapKey.PASSWORD, ErrorMsg.HARD_PASSWORD.toString());
            return false;
        } else if (!password.equals(repeatPw)) {
            signUpData.put(DTMapKey.REPEAT_PW, ErrorMsg.DIFFERENT_PASSWORDS.toString());
            return false;
        }
        return true;
    }

    private boolean checkName(String potential, Map<String, String> signUpData, String error) {
        if (potential == null || !NAME_PATTERN.matcher(potential).matches()) {
            signUpData.put(error, ErrorMsg.NAME.toString());
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
