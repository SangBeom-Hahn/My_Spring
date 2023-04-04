package hello.hellospring.domain;


import jdk.jfr.Name;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
public class Member {

    @javax.persistence.Id
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
