package com.wkk.security.controller;

import com.wkk.security.service.HealthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO 类描述
 *
 * @author weikunkun
 * @since 2022/5/22
 */
public class HealthRecordController {

    @Autowired
    private HealthRecordService healthRecordService;

    @GetMapping("/healthrecord")
    public String main(Authentication a, Model model) {

        String userName = a.getName();

        model.addAttribute("username", userName);

        model.addAttribute("healthRecords", healthRecordService.getHealthRecordsByUsername(userName));

        return "health_record.html";

    }
}
