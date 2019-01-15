package com.lys.xuexi.controller;


import com.lys.xuexi.Utils.ResultUtil;
import com.lys.xuexi.domain.Girl;
import com.lys.xuexi.domain.Result;
import com.lys.xuexi.repository.GirlRepository;
import com.lys.xuexi.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
    private final static Logger logger= LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * all
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        logger.info("girlList");
        return girlRepository.findAll();
    }

    /**
     * 添加一个
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girladd(@Valid Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());

        return ResultUtil.success(girlRepository.save(girl));
    }
    /*
     * search_one
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){

        return girlRepository.findById(id).get();
    }
    /*
     * update_one
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);

    }
    /*
     * del_one
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }
    /*
     * girlFindByAge
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age){

        return girlRepository.findByAge(age);
    }
    /*
     * girlFindByAge
     */
    @GetMapping(value = "/girls/two/")
    public void insertTwo(){

         girlService.insertTwo();
    }

}
