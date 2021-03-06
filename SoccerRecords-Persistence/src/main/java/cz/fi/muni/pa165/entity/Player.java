package cz.fi.muni.pa165.entity;
import cz.fi.muni.pa165.enums.Position;
import java.util.Set;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@Entity
public class Player
{ 
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column 
    private Long id;

    @Column 
    private String name;

    @Temporal(TemporalType.DATE) 
    @Column 
    private Date dateOfBirth;

    @Column 
    private int dressNumber;

    @Enumerated(EnumType.STRING) 
    @Column 
    private Position position;

    @Column 
    private String country;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="team_id")
    private Team team;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "player")
    private Set<Goal> goals = new HashSet<>();

    public Player(){
            super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getDressNumber() {
        return dressNumber;
    }

    public void setDressNumber(int dressNumber) {
        this.dressNumber = dressNumber;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        if(!team.getPlayers().contains(this)){
            team.getPlayers().add(this);
        }
    }
    public void unsetTeam() {
        if(this.team != null)
            this.team.removePlayer(this);
        this.team = null;
    }

    public Set<Goal> getGoals() {
        return goals;
    }

    public void addGoal(Goal goal) {
        this.goals.add(goal);
        if(goal.getPlayer()== null){
            goal.setPlayer(this);
        }
        if(!goal.getPlayer().equals(this)){
            goal.setPlayer(this);
        }
    }
    
    public void removeGoal(Goal goal) {
        if(goal !=null)
        this.goals.remove(goal);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode()) + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (!(obj instanceof Player))
                    return false;
            Player  other = (Player) obj;
            if (name == null) {
                    if (other.name != null)
                            return false;
            } else if (!name.equals(other.getName()))
                    return false;
            if (dateOfBirth == null) {
                    if (other.dateOfBirth != null)
                            return false;
            } else if (!dateOfBirth.equals(other.getDateOfBirth()))
                    return false;
            
            return true;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", dressNumber=" + dressNumber + ", position=" + position + ", country=" + country + ", team=" + team + ", goal=" + goals + '}';
    }
        
        
}
