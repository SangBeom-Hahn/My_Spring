package hello.jdbc.connection;

import hello.jdbc.domain.Car;
import hello.jdbc.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DBConnectionUtilTest {

    @Test
    void getConnection() {
//        Connection connection = DBConnectionUtil.getConnection();
//        assertThat(connection).isNotNull();

//        Member member = new Member("id", 10);
//        Member member2 = new Member("id", 10);
//
//        System.out.println(member.hashCode());
//        System.out.println(member2.hashCode());
//
//        Set<Member> members = new HashSet<>();
//        members.add(member);
//        members.add(member2);
//
//        Assertions.assertThat(members.size()).isEqualTo(1);

        Car car = new Car("id");
        Car car2 = new Car("id");

        Set<Car> cars = new HashSet<>();
        cars.add(car);
        cars.add(car2);

        Assertions.assertThat(cars.size()).isEqualTo(1);


//        Member member = new Member("id", 10);
//        Member member2 = new Member("id");
//        Member member3 = new Member();
//        System.out.println(Objects.hash(member.getMemberId()));
//        System.out.println(Objects.hash(member.getMoney()));

//        System.out.println(member.hashCode());
//        System.out.println(member2.hashCode());
//        System.out.println(member3.hashCode());
//
//        Car car = new Car("id");
//        Car car2 = new Car("id");
//
//        System.out.println(car.hashCode());
//        System.out.println(car2.hashCode());
    }
}