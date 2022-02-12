package com.hnie.blogbackstage.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author :CXQ
 * @description :
 * @create :2022-02-12 15:25:00
 */
@Controller
public class FragmentsController {
    @Value("${myblog.footer.qRcodePath}")
    private String qRcodePath;

    @Value("${myblog.footer.conEmail}")
    private String conEmail;

    @Value("${myblog.footer.conQQ}")
    private String conQQ;

    @Value("${myblog.footer.motto}")
    private String motto;

    @GetMapping("/fragments/footer")
    public String footer(Model model) {
        model.addAttribute("qRcodePath", qRcodePath);
        model.addAttribute("conEmail", conEmail);
        model.addAttribute("conQQ", conQQ);
        model.addAttribute("motto", motto);

        return "_fragments::footer";
    }
}
