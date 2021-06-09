package thi_module_2.common.validate;

import furama_resorts.common.exception.user_exception.*;

import java.time.LocalDate;
import java.time.Period;

public class ValidateCustomer {
    static String regex = "";
    public static boolean emailException( String email) throws EmailException {
       regex="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
               + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
       if(!email.matches(regex))
           throw new EmailException();
       else
            return email.matches(regex);
    }
    public static boolean nameException(String name) throws NameException {
        regex = "^[A-Z][a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$";
        if(!name.matches(regex))
            throw new NameException();
         else
             return name.matches(regex);
    }
    public static boolean genderExeption(String gender) throws GenderException {
        regex = "^male$|^female$|^unknow$";
        if(!gender.matches(regex))
            throw new GenderException();
        else
            return gender.toLowerCase().matches(regex);

    }
    public static boolean idCardException(String idCard) throws IdCardException {
        regex = "^(\\d{9}$)";
        if(!idCard.matches(regex))
            throw new IdCardException();
        else
            return idCard.matches(regex);
    }

    public static boolean numberTelException(String sdt) {
        regex="^0?(\\d{10}$)";
       return sdt.matches(regex);
    }

    public static boolean birthdayException(String dof) throws BirthdayException  {
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
                throw new BirthdayException();
            }
            LocalDate today = LocalDate.now();
            if (Period.between(birthday, today).getYears() < 18) {
                throw new BirthdayException();
            }
            if (year < 1900) {
                throw new BirthdayException();
            }
        }else{
            throw new BirthdayException();
        }
        return check;
    }
}
