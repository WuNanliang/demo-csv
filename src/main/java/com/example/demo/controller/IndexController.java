package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wunanliang
 * @date 2017/12/24
 * @since 1.0.0
 */
@RestController
@RequestMapping("/demo/csv")
public class IndexController {


    @GetMapping("index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}
