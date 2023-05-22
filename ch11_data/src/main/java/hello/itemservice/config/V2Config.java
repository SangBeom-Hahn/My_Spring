package hello.itemservice.config;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.jpa.JpaRepositoryV3;
import hello.itemservice.repository.v2.ItemQueryRepositoryV2;
import hello.itemservice.repository.v2.ItemRepositoryV2;
import hello.itemservice.service.ItemService;
import hello.itemservice.service.ItemServiceV1;
import hello.itemservice.service.ItemServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class V2Config {
    private final EntityManager entityManager;
    private final ItemRepositoryV2 itemRepositoryV2; // springData JPA

    @Bean
    public ItemService itemService() {
        return new ItemServiceV2(itemQueryRepositoryV2(), itemRepositoryV2);
    }

    @Bean
    public ItemQueryRepositoryV2 itemQueryRepositoryV2() { // 쿼리 dsl
        return new ItemQueryRepositoryV2(entityManager);
    }

//    @Bean
//    public ItemRepository itemRepository() {
//        return new JpaRepositoryV3(entityManager);
//    }
}
