package com.lys.xuexi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class XuexiController {
    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return "nihao"+id;
    }
}
