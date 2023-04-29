package hello.upload.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Item {
    private Long id;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;
}
