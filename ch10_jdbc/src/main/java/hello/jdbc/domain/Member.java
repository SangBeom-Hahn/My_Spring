package hello.jdbc.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

//@Data
@Getter
@Setter
public class Member {
    private String memberId;
    private int money;

    public Member(String memberId, int money) {
        this.memberId = memberId;
        this.money = money;
    }

    public Member(String memberId) {
        this.memberId = memberId;
    }

    public Member() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(money) + Objects.hash(memberId)  ;
    }
}
