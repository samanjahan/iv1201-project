/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PersonController;
import controller.RejectException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author syst3m
 */
@RequestScoped

@ManagedBean(name = "registration")
public class RegistrationManager {
    private Exception exception;
    private String name;
    private String surname;
    private String ssn;
    private String email;
    private String username;
    private String password;

    
    public  Exception getException(){
        return exception;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
    @EJB PersonController personController;
    
    public String register() throws RejectException{
      String  message = "Registraion was successfull!";
      
        if(!validate()){
            return "";
        }
        
       try{
        personController.register(name, surname, ssn, email, password, username);
        MessageFactory.getInstance().addInfoMessage(message);
       }catch(Exception e){
           MessageFactory.getInstance().addErrorMessage(e.getMessage());
       }
        return "";
    }
    public boolean validate(){
        if(!name.matches( "[a-zA-Z]*" ) || name.equals("")){
            String message = "Name may only contain letters.";
            MessageFactory.getInstance().addInfoMessage(message);
            return false;
        }
        if(!surname.matches( "[a-zA-Z]*" ) || surname.equals("")){
            String message = "Lastname may only contain letters.";
            MessageFactory.getInstance().addInfoMessage(message);
            return false;
        }
        if(!ssn.matches("([0-9]{6,6})[-]([0-9]{4,4})")){
           String message = "SSN is to be entered in the following format XXXXXXX-XXXX";
           MessageFactory.getInstance().addInfoMessage(message);
           return false;
        }
        if(!email.matches("([a-zA-Z1-9.-_]*)[@]([a-zA-Z1-9.]*)")){
          String  message = "A real Email Adress required.";
          MessageFactory.getInstance().addInfoMessage(message);
          return false;
        }
        if(!personController.usernameAvailable(username)){
          String  message = "Username already taken";
          MessageFactory.getInstance().addInfoMessage(message);
            return false;            
        }
        if(username.equals("")){
          String  message = "Username required";
          MessageFactory.getInstance().addInfoMessage(message);
          return false;            
        }
        return true;
    }
}
