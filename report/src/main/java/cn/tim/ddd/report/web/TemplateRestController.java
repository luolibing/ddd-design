package cn.tim.ddd.report.web;

import cn.tim.ddd.report.application.TemplateApplicationService;
import cn.tim.ddd.report.web.form.TemplateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: luolibing
 * Date: 2017/10/10 18:24
 */
@RestController
@RequestMapping("/template")
public class TemplateRestController {

    @Autowired
    private TemplateApplicationService templateApplicationService;

    @PostMapping("/add")
    public void addTemplate(@RequestBody TemplateForm templateForm) {

    }

}
