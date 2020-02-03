package com.opticus.opticusapp.entity.user;


import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


    @Column(name = "signUpConfirmed")
    private boolean signUpConfirmed;

    public User() {
    }

    public User(String firstName, String lastName, LocalDateTime birthdate, String email, boolean signUpConfirmed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.signUpConfirmed = signUpConfirmed;
    }

    /**
     * Returns value of id
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new value of id
     *
     * @param
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns value of firstName
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets new value of firstName
     *
     * @param
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns value of lastName
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets new value of lastName
     *
     * @param
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns value of email
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets new value of email
     *
     * @param
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSignUpConfirmed() {
        return signUpConfirmed;
    }

    public void setSignUpConfirmed(boolean signUpConfirmed) {
        this.signUpConfirmed = signUpConfirmed;
    }
}
