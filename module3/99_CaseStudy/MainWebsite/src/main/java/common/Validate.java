package common;

public class Validate {
    private String regex;
    private String regexEmail="^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
    private String regexIdCard="^(\\d{9}|\\d{12}$)";
    private String regexPhone="^09[0-1]\\d{7}$|^\\(84\\)\\+9[0-1]\\d{7}$";
    public Validate() {
    }

    public Validate(String regex) {
        this.regex = regex;
    }
    public boolean checkRegex(String temp){
        return temp.matches(regex);
    }

    public boolean checkEmail(String email){
        return email.matches(regexEmail);
    }
    public boolean checkPhone(String phone){
        return phone.matches(regexPhone);
    }
    public boolean checkIdCard(String idCard){
        return idCard.matches(regexIdCard);
    }
}
