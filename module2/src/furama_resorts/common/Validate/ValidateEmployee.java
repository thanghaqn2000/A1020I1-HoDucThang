package furama_resorts.common.Validate;

import java.time.LocalDate;
import java.time.Period;

public class ValidateEmployee {
    static String regexEmp = "";
    public static boolean emailExceptionEmp(String email) {
        regexEmp= "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
       return email.matches(regexEmp);
    }
    public static boolean nameExveptionEmp(String name) {
        regexEmp = "^[A-Z][a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$";
        return name.matches(regexEmp);
    }
    public static boolean idCardExceptionEmp(String idCard) {
        regexEmp = "(\\d{9})";
        return idCard.matches(regexEmp);
    }
    public static boolean numberTelExceptionEmp(String sdt) {
        regexEmp="0?(\\d{10})";
        return sdt.matches(regexEmp);
    }
    public static boolean birthdayExceptionEmp(String dof) {
        boolean check;
        LocalDate birthday;
        regexEmp = "\\b(0?[1-9]|[12]\\d|3[01])[\\/\\-.](0?[1-9]|[12]\\d|3[01])[\\/\\-.](\\d{2}|\\d{4})\\b";
        check = dof.matches(regexEmp);
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
    public static boolean checkLevelEmp(String levelEmp) {
        regexEmp = "trung cấp|cao đẳng|đại học|sau đại học|";
        return levelEmp.matches(regexEmp);
    }
    public static boolean checkPositionEmp(String position) {
        regexEmp = "lễ tân|phục vụ|chuyên viên|giám sát|quản lí|giám đốc|";
        return position.matches(regexEmp);
    }
}
