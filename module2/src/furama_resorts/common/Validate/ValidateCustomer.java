package furama_resorts.common.Validate;

import furama_resorts.common.exception.user_exception.EmailException;
import furama_resorts.common.exception.user_exception.NameException;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCustomer {
    static String regex = "";

    public static boolean emailException( String email) {
       regex="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
               + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
       return email.matches(regex);
    }

    public static boolean nameExveption(String name) throws NameException {
        regex = "^[A-Z][a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$";
        if(!name.matches(regex))
            throw new NameException();
         else
             return true;
    }

    public static boolean genderExeption(String gender) {
        regex = "^male$|^female$|^unknow$";
        return gender.toLowerCase().matches(regex);
    }

    public static boolean idCardException(String idCard) {
        regex = "^(\\d{9}$)";
        return idCard.matches(regex);
    }

    public static boolean numberTelException(String sdt) {
        regex="^0?(\\d{10}$)";
       return sdt.matches(regex);
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
