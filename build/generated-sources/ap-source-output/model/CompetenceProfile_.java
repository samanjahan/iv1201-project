package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Competence;
import model.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-25T20:39:48")
@StaticMetamodel(CompetenceProfile.class)
public class CompetenceProfile_ { 

    public static volatile SingularAttribute<CompetenceProfile, Long> competenceProfileId;
    public static volatile SingularAttribute<CompetenceProfile, Competence> competenceId;
    public static volatile SingularAttribute<CompetenceProfile, Person> personId;
    public static volatile SingularAttribute<CompetenceProfile, Double> yearsOfExperience;

}