package hello.upload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

@Controller
@Slf4j
@RequestMapping("/spring")
public class SpringUploadController {
    @Value("${file.dir}")
    private String fileDir;


    @GetMapping("/upload")
    public String newFile() {
        return "upload-form";
    }

    @PostMapping("upload")
    public String upload(@RequestParam String itemName,
                         @RequestParam MultipartFile file) throws ServletException, IOException {

        log.info("itemName = {}", itemName);
        log.info("file = {}", file);

        if(!file.isEmpty()) {
            String fullPath = fileDir + file.getOriginalFilename();
            file.transferTo(new File(fullPath));
        }

        return "upload-form";
    }
}
