package Domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="ROLE_NORMAL")
public class Volunteer extends User {
	
}
