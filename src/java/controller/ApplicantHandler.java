package controller;

import model.Person;
import model.Competence;
import model.CompetenceProfile;
import model.Role;
import model.Availability;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * A controller. All calls to the model related to user accounts that are executed because of an action taken by
 * the user pass through here.
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class ApplicantHandler {
    @PersistenceContext(unitName = "ProjectIv1201PU")
    private EntityManager em;
    private Person person;

    public void addApplicant(
            String name,
            String lastname,
            String ssn, 
            String email, 
            String username,
            String password){
            Role role = getRole("applicant");
            person = new Person(name,lastname,ssn,email,username,password,role);
            em.persist(person);
    }
    
    public Role getRole(String role){
        TypedQuery<Role> query= em.createNamedQuery("Role.findByName", Role.class);
        query.setParameter("r", role);
        Role result = query.getSingleResult();
        return result;
    }

}
