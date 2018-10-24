package com.hospital.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "blood_donor")
public class BloodDonor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blood_donor_id")
    private Integer bloodDonorId;

    @Column(name = "name")
    private String name;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "last_donation_timestamp")
    private String lastDonationTimestamp;

    public Integer getBloodDonorId() {
        return bloodDonorId;
    }

    public void setBloodDonorId(Integer bloodDonorId) {
        this.bloodDonorId = bloodDonorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastDonationTimestamp() {
        return lastDonationTimestamp;
    }

    public void setLastDonationTimestamp(String lastDonationTimestamp) {
        this.lastDonationTimestamp = lastDonationTimestamp;
    }
}
