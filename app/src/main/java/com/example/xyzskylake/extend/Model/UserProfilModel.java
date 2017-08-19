package com.example.xyzskylake.extend.Model;

/**
 * Created by harzen on 19/08/17.
 */

public class UserProfilModel {

    protected String uuid;
    protected String name;
    protected String email;
    protected long date_birth;
    protected String password;
    protected String address;
    protected String phone_number;
    protected String verification;
    protected String photo;
    protected String company_name;
    protected String company_address;

    public UserProfilModel(){

    }

    public UserProfilModel (String uuid, String name, String email, long date_birth,
                            String password, String address, String phone_number,
                            String verification, String photo, String company_name, String company_address){
        setUuid(uuid);
        setName(name);
        setEmail(email);
        setDate_birth(date_birth);
        setPassword(password);
        setAddress(address);
        setPhone_number(phone_number);
        setVerification(verification);
        setPhoto(photo);
        setCompany_name(company_name);
        setCompany_address(address);

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(long date_birth) {
        this.date_birth = date_birth;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

}
