package furama_resorts.exception;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCustomer {
    static String regex = "";
    private static final String EMAIL_PATTERN =
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean emailException(final String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean nameExveption(String name) {
        regex = "^[A-Z][a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$";
        return name.matches(regex);
    }

    public static boolean genderExeption(String gender) {
        regex = "^male$|^female$|^unknow$";
        return gender.toLowerCase().matches(regex);
    }

    public static boolean idCardException(int idCard) {
        int lengh = String.valueOf(idCard).length();
        if (lengh != 9)
            return false;
        else
            return true;
    }

    public static boolean numberTelException(int sdt) {
        int lengh = String.valueOf(sdt).length();
        if (lengh == 10 || lengh==11)
            return true;
        else
            return false;
    }

    public static boolean birthdayException(String dof) {
        boolean check;
        LocalDate birthday;
        regex = "\\b(0?[1-9]|[12]\\d|3[01])[\\/\\-.](0?[1-9]|[12]\\d|3[01])[\\/\\-.](\\d{2}|\\d{4})\\b";
        check = dof.matches(regex);
        if (check) {
            String[] dateString = dof.split("/");
            int date = Integer.parseInt(dateString[0]);
            int month = Integer.parseInt(dateString[1]);
            int year = Integer.parseInt(dateString[2]);
            try {
                birthday = LocalDate.of(year, month, date);
            } catch (Exception e) {
                return false;
            }
            LocalDate today = LocalDate.now();
            if (Period.between(birthday, today).getYears() < 18) {
                return false;
            }
            if (year < 1900) {
                return false;
            }
        }
        return check;
    }
}
