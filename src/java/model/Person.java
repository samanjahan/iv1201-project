/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import java.util.LinkedList;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author syst3m
 */
@Entity(name = "person")


public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Size(max = 255)
    @Column(name = "name")
    private String name;
    
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    
   
    
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    
    @Size(max = 255)
    @Column(name = "ssn")
    private String ssn;
    
    @Size(max = 255)
    @Column(name = "surname")
    private String surname;
    
    
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = { @JoinColumn(name = "username") })
    @Column(name = "role")
    @CascadeOnDelete
    private List<Role> roles;


    public Person() {
        super();
        roles = new LinkedList<Role>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public List<Role> getRoles(){
        return roles;
    }
    
    public  void setRoles(List<Role> roles){
        this.roles = roles;
    }
}
