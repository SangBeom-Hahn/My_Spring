package hello.itemservice.domain.item;

import lombok.Getter;

@Getter
public enum Regions {
    SEOUL("서울"), PUSAN("부산"), JEJU("제주"), GANGJU("광주");
    private final String description;

    Regions(String description) {
        this.description = description;
    }
}
