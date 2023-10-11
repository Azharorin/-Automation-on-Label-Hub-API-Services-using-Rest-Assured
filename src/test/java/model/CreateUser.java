package model;

public class CreateUser {





    // Constructors with required fields
   public  String full_name;
    public String email;
    public int role;
    public String phone_number;
    public String dob;
    public String gender;
    public String institution_name;
    public String qualification;
    public int status;
    public String password;

    public CreateUser(String full_name, String email, int role, String phone_number, String dob, String gender, String institution_name, String qualification, int status, String password) {
        this.full_name = full_name;
        this.email = email;
        this.role = role;
        this.phone_number = phone_number;
        this.dob = dob;
        this.gender = gender;
        this.institution_name = institution_name;
        this.qualification = qualification;
        this.status = status;
        this.password = password;
    }







}
