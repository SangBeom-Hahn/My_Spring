package hello.itemservice.config;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.jpa.JpaRepositoryV3;
import hello.itemservice.repository.vvv222.ItemSearchQueryRepository;
import hello.itemservice.service.ItemService;
import hello.itemservice.service.ItemServiceV1;
import hello.itemservice.service.ItemServiceV3;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class VV222Config {
    private final EntityManager entityManager;
    private final hello.itemservice.repository.vvv222.ItemRepository itemRepository;
    private final ItemSearchQueryRepository itemSearchQueryRepository;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV3(itemRepository, itemSearchQueryRepository());
    }

    @Bean
    public ItemSearchQueryRepository itemSearchQueryRepository() {
        return new ItemSearchQueryRepository(entityManager);
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaRepositoryV3(entityManager);
    }
}
