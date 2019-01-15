package com.lys.xuexi.service;

import com.lys.xuexi.domain.Girl;
import com.lys.xuexi.enums.ResultEnum;
import com.lys.xuexi.exception.GirlException;
import com.lys.xuexi.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public  void  insertTwo(){
        Girl girlA = new Girl();

        girlA.setAge(19);
        girlA.setCupSize("B");
        girlRepository.save(girlA);
        Girl girlB = new Girl();
        girlB.setAge(20);
        girlB.setCupSize("d");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl=girlRepository.findById(id).get();
        Integer age=girl.getAge();
        if(age<10){
            // xiaoxue
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>=10 && age<16){
            // 中学
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

    }

    public Girl findone(Integer id){
        return girlRepository.findById(id).get();
    }
}
