package com.hillel.crm.config.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "client")
public class Client extends BaseEntity{

    @Id
    @Column(name = "client_id")
    private Long ClientID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "sex")
    private String sex;

    @Column(name = "diagnoses")
    private String diagnose;



    public java.lang.String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(java.lang.String diagnose) {
        this.diagnose = diagnose;
    }

    public Client() {

    }

    public Client(java.lang.String firstName, java.lang.String lastName, Date dateOfBirth, java.lang.String sex, java.lang.String diagnoses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.diagnose = diagnoses;
    }

    public java.lang.String getDiagnoses() {
        return diagnose;
    }

    public void setDiagnoses(java.lang.String diagnoses) {
        this.diagnose = diagnoses;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public java.lang.String getSex() {
        return sex;
    }

    public void setSex(java.lang.String sex) {
        this.sex = sex;
    }

    @Override
    public java.lang.String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex='" + sex + '\'' +
                ", diagnoses='" + diagnose + '\'' +
                '}';
    }

    public Long getClientID() {
        return ClientID;
    }

    public void setClientID(Long clientID) {
        ClientID = clientID;
    }
}
