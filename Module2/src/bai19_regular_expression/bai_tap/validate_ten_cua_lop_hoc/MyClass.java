package bai19_regular_expression.bai_tap.validate_ten_cua_lop_hoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyClass {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_REGEX =   "^[CAP]+[0-9]{4}[GHIKLM]$";

    public MyClass() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
