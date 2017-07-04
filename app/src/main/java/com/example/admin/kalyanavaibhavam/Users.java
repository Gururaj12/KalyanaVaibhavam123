package com.example.admin.kalyanavaibhavam;


import static android.R.attr.name;
import static android.R.attr.thickness;

public class Users {

    private String email;
    private String password;
    private String profile_for;  //spinner//
    private String first_name;
    private String last_name;
    private String sisters;      //spinner//
    private String brothers;    //spinner//
    private String gender;      //spinner//
    private String date;        //spinner//
    private String month;       //spinner//
    private String year;        //spinner//
    private String religion;    //spinner//
    private String mother_tongue; //spinner//
    private String country;        //spinner//
    private String state;         //spinner//
    private String not_in_list;



    private String marital;
    private String community;
    private String sub_community;

    private String education_level;
    private String works_as;
    private String education_field;
    private String works;

    private String food_type;
    private String smoke;
    private String drink;
    private String height;
    private String body_type;
    private String skin_tone;
    private String mobile;
    private String disability;
    private String number;
    private String about_him;
    private String user_name;



    public Users(String community, String sub_community, String marital) {
        this.community = community;
        this.sub_community = sub_community;
        this.marital = marital;

    }

    public Users(String education_level, String works_as, String education_field, String works) {
        this.education_level = education_level;
        this.works_as = works_as;
        this.education_field = education_field;
        this.works = works;
    }

    public Users(String email, String password, String profile_for, String first_name, String last_name,
                 String sister, String brother, String gender, String date, String month, String year, String religion,
                 String mother_tongue, String country, String state, String not_in_list) {
        this.email = email;
        this.password = password;
        this.profile_for = profile_for;
        this.first_name = first_name;
        this.last_name = last_name;
        this.sisters = sister;
        this.brothers = brother;
        this.gender = gender;
        this.date = date;
        this.month = month;
        this.year = year;
        this.religion = religion;
        this.mother_tongue = mother_tongue;
        this.country = country;
        this.state = state;
        this.not_in_list = not_in_list;
    }


    public Users(String food_type, String smoke, String drink, String height, String body_type, String skin_tone, String mobile, String disability, String number, String about_him, String user_name) {
        this.food_type = food_type;
        this.smoke = smoke;
        this.drink = drink;
        this.height = height;
        this.body_type = body_type;
        this.skin_tone = skin_tone;
        this.disability = disability;
        this.number = number;
        this.about_him = about_him;
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_for() {
        return profile_for;
    }

    public void setProfile_for(String profile_for) {
        this.profile_for = profile_for;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSisters() {
        return sisters;
    }

    public void setSisters(String sisters) {
        this.sisters = sisters;
    }

    public String getBrothers() {
        return brothers;
    }

    public void setBrothers(String brothers) {
        this.brothers = brothers;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getMother_tongue() {
        return mother_tongue;
    }

    public void setMother_tongue(String mother_tongue) {
        this.mother_tongue = mother_tongue;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNot_in_list() {
        return not_in_list;
    }

    public void setNot_in_list(String not_in_list) {
        this.not_in_list = not_in_list;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getSub_community() {
        return sub_community;
    }

    public void setSub_community(String sub_community) {
        this.sub_community = sub_community;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    public String getWorks_as() {
        return works_as;
    }

    public void setWorks_as(String works_as) {
        this.works_as = works_as;
    }

    public String getEducation_field() {
        return education_field;
    }

    public void setEducation_field(String education_field) {
        this.education_field = education_field;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBody_type() {
        return body_type;
    }

    public void setBody_type(String body_type) {
        this.body_type = body_type;
    }

    public String getSkin_tone() {
        return skin_tone;
    }

    public void setSkin_tone(String skin_tone) {
        this.skin_tone = skin_tone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAbout_him() {
        return about_him;
    }

    public void setAbout_him(String about_him) {
        this.about_him = about_him;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}