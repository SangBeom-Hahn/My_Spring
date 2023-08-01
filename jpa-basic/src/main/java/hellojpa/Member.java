package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    public Member() {
    }
    
    @Id
    private Long id;
    @Column(name = "name", insertable = false, updatable = false)
    private String username;
    
    @Column(nullable = false, unique = true)
    private Integer age2;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;
    
    @Transient
    private int temp;
    //Getter, Setter…
}
