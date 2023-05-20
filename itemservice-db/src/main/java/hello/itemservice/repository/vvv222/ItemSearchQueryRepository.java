package hello.itemservice.repository.vvv222;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.itemservice.domain.Item;
import hello.itemservice.domain.QItem;
import hello.itemservice.repository.ItemSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ItemSearchQueryRepository {
    private final EntityManager em;
    private final JPAQueryFactory query;

    public ItemSearchQueryRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public List<Item> findAll(ItemSearchCond cond) {
        Integer maxPrice = cond.getMaxPrice();
        String itemName = cond.getItemName();

        List<Item> result = query
                .select(QItem.item)
                .from(QItem.item)
                .where(likeItemName(itemName), maxPrice(maxPrice))
                .fetch();
        return result;
    }

    private BooleanExpression likeItemName(String itemName) {
        if (StringUtils.hasText(itemName)) {
            return QItem.item.itemName.like("%" + itemName + "%");
        }
        return null;
    }

    private BooleanExpression maxPrice(Integer maxPrice) {
        if (maxPrice != null) {
            return QItem.item.price.loe(maxPrice);
        }
        return null;
    }
}
