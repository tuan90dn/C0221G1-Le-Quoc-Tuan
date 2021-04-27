package bai19_regular_expression.bai_tap.validate_sdt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_REGEX =   "^\\([0-9]{2}\\)\\-\\([0]+[0-9]{9}\\)";

    public PhoneNumber() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
