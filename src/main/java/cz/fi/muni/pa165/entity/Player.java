package cz.fi.muni.pa165.entity;
import cz.fi.muni.pa165.enums.Position;
import java.util.Set;
import java.util.Date;
import javax.persistence.GenerationType;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Player
{ 
	@javax.persistence.Id 
        @javax.persistence.GeneratedValue(strategy = GenerationType.AUTO)
	@javax.persistence.Column(nullable = false) 
	private Long id;
	 
	@javax.persistence.Column(nullable = false) 
	private String name;
	 
	@javax.persistence.Temporal(javax.persistence.TemporalType.DATE) 
	@javax.persistence.Column(nullable = false) 
	private Date dateOfBirth;
	 
	@javax.persistence.Column(nullable = false) 
	private int dressNumber;
	 
	@javax.persistence.Enumerated(javax.persistence.EnumType.STRING) 
	@javax.persistence.Column(nullable = false) 
	private Position position;
	 
	@javax.persistence.Column(nullable = false) 
	private String country;
 
	@javax.persistence.ManyToOne 
	private Team team;
	 
	@javax.persistence.OneToMany(mappedBy = "player") 
	private Set<Goal> goal;

	public Player(){
		super();
	}
}

