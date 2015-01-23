/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import controller.ApplicantHandler;

/**
 *
 * @author syst3m
 */

@ManagedBean(name="applicationManager")
@ViewScoped

public class ApplicationManager implements Serializable {
      
    private static final long serialVersionUID = 1L;
   
    private ApplicantHandler applicantHandler = new ApplicantHandler();
    private String name;
    private String lastname;
    private String ssn;
    private String email;
    private String username;
    private String password;
    private String message;

    public ApplicationManager(){
        
    }
     
    
    /**
     * Registers a filled application once it has been validated
     * 
     * @return returns an empty string to force a refresh of the browser.
     */
    public String send(){
        if(!validate()){
            return"";
        }
        
        applicantHandler.addApplicant(name, lastname, ssn, email, username, password);
        message = "Application sent!";
        return "";
    }
    
   /**
    * NOT COMPLETE
    * Need a functioning controller for further development
    * 
    * Validates entered values.
    * Takes no parameters but instead accesses the private variables of the class
    * Returns a boolean with a value reflecting the result of the verification process.
    * Changes the "message" variable to specify what went wrong on failure
    * 
    * @return returns true on successful validation, otherwise false
    */
    public boolean validate(){
        if(!name.matches( "[a-zA-Z]*" ) || name.equals("")){
            message = "Name may only contain letters.";
            return false;
        }
        if(!lastname.matches( "[a-zA-Z]*" ) || lastname.equals("")){
            message = "Lastname may only contain letters.";
            return false;
        }
        if(!ssn.matches("([0-9]{6,6})[-]([0-9]{4,4})")){
            message = "SSN is to be entered in the following format XXXXXXX-XXXX";
            return false;
        }
        if(!email.matches("([a-zA-Z1-9.-_]*)[@]([a-zA-Z1-9.]*)")){
            message = "A real Email Adress required.";
            return false;
        }
        
        
        return true;
    }
    
    
    /******************************************************
     * The following methods consist of Getters and setters
     *****************************************************/
    
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
