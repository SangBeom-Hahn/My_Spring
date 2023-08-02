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
    private Integer age;
    
    public Member(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
    
    public Member(String username) {
        this.username = username;
    }
    
    //    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//    @Lob
//    private String description;
//
//    @Transient
//    private int temp;
    //Getter, Setter…
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
}
