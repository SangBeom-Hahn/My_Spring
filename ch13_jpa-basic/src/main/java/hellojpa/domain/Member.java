package hellojpa.domain;

import javax.persistence.*;
import java.util.concurrent.locks.Lock;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
    
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;
    
    public Team getTeam() {
        return team;
    }
    
    public void setTeam(Team team) {
        this.team = team;
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
    
    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team=" + team +
                '}';
    }
}
