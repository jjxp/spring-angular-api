package org.sprouts.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
@Table
public class User extends DomainEntity {

    // Attributes -------------------------------------------------------------

    private String firstName;
    private String lastName;
    private String age;
    private String gender;

    // Constructors -----------------------------------------------------------

    public User() {

    }

    // Getters/Setters --------------------------------------------------------

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    // Relationships ----------------------------------------------------------

    private UserAccount userAccount;

    @NotNull
    @Valid
    @OneToOne(optional = false)
    @JoinColumn(name = "userAccountId")
    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}