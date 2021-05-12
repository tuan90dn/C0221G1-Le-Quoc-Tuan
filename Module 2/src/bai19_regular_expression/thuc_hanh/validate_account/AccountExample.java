package bai19_regular_expression.thuc_hanh.validate_account;

import java.util.regex.*;

public class AccountExample {
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";

    public AccountExample() {
    }


    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher  matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
