package com.example.candidacyform;

public class Member {

    private String Name;
    private String Gender;
    private String Address;
    private String Emailaddress;

    private String Membership;
    private String Age;
    private String Dateofbirth;

    private String Vision;

    private String CivilStatus;

    private String ElectivePosition;




    public Member(){



    }

    public void setElectivePosition(String electivePosition) {
        ElectivePosition = electivePosition;
    }
    public String getElectivePosition() {
        return ElectivePosition;
    }







    public String getCivilStatus() {
        return CivilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        CivilStatus = civilStatus;
    }























    public String getName(){
        return Name;
    }
    public String getAddress(){
        return Address;
    }
    public String getEmailaddress(){
        return Emailaddress;
    }
    public String getMembership(){
        return Membership;
    }
    public String getAge(){
        return Age;
    }
    public String getDateofbirth(){
        return Dateofbirth;
    }
    public String getVision(){
        return Vision;
    }





    public void setName(String name) {Name = name;}

    public String getGender() {return Gender;}
    public void setGender(String gender){ Gender = gender;}

    public void  setAddress(String address) {Address = address;}

    public void setEmailaddress(String emailaddress) {Emailaddress = emailaddress;}



    public void  setMembership(String membership) {Membership = membership;}

    public  void setAge(String age) { Age = age;}

    public  void setDateofbirth( String dateofbirth) {Dateofbirth = dateofbirth;}



    public void setVision (String vision) {Vision = vision;}











}
