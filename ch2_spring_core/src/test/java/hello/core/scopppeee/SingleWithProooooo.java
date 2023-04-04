package hello.core.scopppeee;

import hello.core.scope.SingleWithPro;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleWithProooooo {
    @Test
    void protoWithSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoBean.class);
        ProtoBean bean1 = ac.getBean(ProtoBean.class);
        ProtoBean bean2 = ac.getBean(ProtoBean.class);

        bean1.addCount();
        bean2.addCount();

        assertThat(bean1.getCount()).isEqualTo(1);
        assertThat(bean2.getCount()).isEqualTo(1);
    }

    @Test
    void protoUse() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Single.class, ProtoBean.class);
        Single bean1 = ac.getBean(Single.class);
        Single bean2 = ac.getBean(Single.class);

        assertThat(bean1.logic()).isEqualTo(1);
        assertThat( bean2.logic()).isEqualTo(1);
    }

    @RequiredArgsConstructor
    static class Single {
        private final ObjectProvider<ProtoBean> protoBeanObjectProvider;

        public int logic() {
            ProtoBean protoBean = protoBeanObjectProvider.getObject();
            protoBean.addCount();
            return protoBean.getCount();
        }
    }

    @Scope("prototype")
    static class ProtoBean {
        private int count = 0;
        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("init: " + this);
        }

        @PreDestroy
        public void close() {
            System.out.println("close: " + this);
        }
    }
}
