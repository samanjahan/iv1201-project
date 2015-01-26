/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Person;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import model.Role;

/**
 *
 * @author syst3m
 */

@Stateless
public class PersonController {
    @PersistenceContext(unitName = "ProjectIv1201PU")
    private EntityManager em;
    
    /**
     *Method register the user to the database
     */
    
    public void register(String name, String surname, String ssn, String email, String password, String username) throws RejectException{
        Person person = em.find(Person.class,username);
        if(person != null){
            throw  new RejectException("Username is already taken.");
        }
        
        person = populatePersonObject(name, surname, ssn, email, password, username);
        List<Role> roles = new ArrayList<Role>();
        roles.add(Role.USER);
        
        person.setRoles(roles);
        System.out.println("hahahahahahahahahahahahahahahahah " + person.getName());
        em.persist(person);
    } 
    
    private String getEncryptedPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest digDigest = MessageDigest.getInstance("MD5");
        digDigest.update(password.getBytes(),0,password.length());
        String md5 = new BigInteger(1,digDigest.digest()).toString(16);
        return md5;
    }
    
    private Person populatePersonObject(String name, String surname, String ss, String email, String password, String username) throws RejectException{
        
        Person person;
        person = new Person();
        person.setName(name);
        person.setSsn(ss);
        person.setSurname(surname);
        person.setUsername(username);
        person.setEmail(email);
        
        
        try {
            person.setPassword(getEncryptedPassword(password));
        } catch (NoSuchAlgorithmException e) { 
            throw new RejectException("Server fatal error:MD5 algorithm not found");
        }catch (UnsupportedOperationException e){
            throw new RejectException("Server fatal error:UTF-8 encoding is not supported on server");
        } 
     //  Role role = em.find(Role.class, "admin");
     //   long roleId =  role.getRoleId();
      //  person.setRoleId(roleId);
        return person;
    }
    
        /**
     * Not yet implemented
     * 
     * Checks if a username already exists 
     * @param username
     * @return returns true if input is not yet taken
     */
    public boolean usernameAvailable(String username) {
    
        return true;
    }
    
    
    
}
