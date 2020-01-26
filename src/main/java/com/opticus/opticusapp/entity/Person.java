package com.opticus.opticusapp.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "pesel")
    private String PESEL;

    @Column(name = "birthdate")
    private LocalDateTime birthdate;

    @Column(name = "sex")
    private String sex;

    @Column(name = "email")
    private String email;


    public Person() {
    }

    public Person(String firstName, String lastName, String PESEL, LocalDateTime birthdate, String sex, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PESEL = PESEL;
        this.birthdate = birthdate;
        this.sex = sex;
        this.email = email;
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
     * Returns value of PESEL
     *
     * @return
     */
    public String getPESEL() {
        return PESEL;
    }

    /**
     * Sets new value of PESEL
     *
     * @param
     */
    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    /**
     * Returns value of birthdate
     *
     * @return
     */
    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    /**
     * Sets new value of birthdate
     *
     * @param
     */
    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Returns value of sex
     *
     * @return
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets new value of sex
     *
     * @param
     */
    public void setSex(String sex) {
        this.sex = sex;
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
}


//package com.opticus.opticusapp.entity;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "person")
//@Inheritance(strategy = InheritanceType.JOINED)
//public class Person {
//
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name="first_name")
//    private String firstName;
//
//    @Column(name="last_name")
//    private String lastName;
//
//    @Column(name="pesel")
//    private String PESEL;
//
//    @Column(name="birthdate")
//    private LocalDateTime birthdate;
//
//    @Column(name="sex")
//    private String sex;
//
//    @Column(name="email")
//    private String email;
//
//
//    public Person() {
//    }
//
//	public Person(String firstName, String lastName, String PESEL, LocalDateTime birthdate, String sex, String email) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.PESEL = PESEL;
//		this.birthdate = birthdate;
//		this.sex = sex;
//		this.email = email;
//	}
//
//
//
//	/**
//	* Returns value of id
//	* @return
//	*/
//	public int getId() {
//		return id;
//	}
//
//	/**
//	* Sets new value of id
//	* @param
//	*/
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	/**
//	* Returns value of firstName
//	* @return
//	*/
//	public String getFirstName() {
//		return firstName;
//	}
//
//	/**
//	* Sets new value of firstName
//	* @param
//	*/
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	/**
//	* Returns value of lastName
//	* @return
//	*/
//	public String getLastName() {
//		return lastName;
//	}
//
//	/**
//	* Sets new value of lastName
//	* @param
//	*/
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	/**
//	* Returns value of PESEL
//	* @return
//	*/
//	public String getPESEL() {
//		return PESEL;
//	}
//
//	/**
//	* Sets new value of PESEL
//	* @param
//	*/
//	public void setPESEL(String PESEL) {
//		this.PESEL = PESEL;
//	}
//
//	/**
//	* Returns value of birthdate
//	* @return
//	*/
//	public LocalDateTime getBirthdate() {
//		return birthdate;
//	}
//
//	/**
//	* Sets new value of birthdate
//	* @param
//	*/
//	public void setBirthdate(LocalDateTime birthdate) {
//		this.birthdate = birthdate;
//	}
//
//	/**
//	* Returns value of sex
//	* @return
//	*/
//	public String getSex() {
//		return sex;
//	}
//
//	/**
//	* Sets new value of sex
//	* @param
//	*/
//	public void setSex(String sex) {
//		this.sex = sex;
//	}
//
//	/**
//	* Returns value of email
//	* @return
//	*/
//	public String getEmail() {
//		return email;
//	}
//
//	/**
//	* Sets new value of email
//	* @param
//	*/
//	public void setEmail(String email) {
//		this.email = email;
//	}
//}
