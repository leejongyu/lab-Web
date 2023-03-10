package edu.web.jsp01.domain;

public class Contact {

    private String name;
    private String number;
    private String mail;

    public Contact() {}
    
    public Contact(String name, String number, String mail) {

        this.name = name;
        this.number = number;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return String.format("연락처 [ 이름 : %s , 전화번호 : %s , 메일주소 : %s ]", name, number, mail);
    }

}
