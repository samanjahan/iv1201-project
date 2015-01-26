package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Role;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-26T13:07:57")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> username;
    public static volatile SingularAttribute<Person, String> email;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile ListAttribute<Person, Role> roles;
    public static volatile SingularAttribute<Person, String> ssn;
    public static volatile SingularAttribute<Person, String> surname;
    public static volatile SingularAttribute<Person, String> password;

}