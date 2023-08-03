package hello.thymeleaf.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TemplateController {
    @GetMapping("/fragment")
    public String template() {
        return "template/fragment/main";
    }

    @GetMapping("/layout")
    public String layout() {
        return "template/layout/layoutMain";
    }
    @GetMapping("/layoutExtend")
    public String layoutExtends() {
        return "template/layoutExtend/layoutExtendMain";
    }
    
    @GetMapping("/api/hello")
    @ResponseBody
    public Dto test(@RequestBody Dto dto, Model model) {
//        model.addAttribute("data1", dto.getLoginId());
//        model.addAttribute("data2", dto.getPassword());
//        return data;
//        return "basic/text-basic";
        
        return dto;
    }
}
