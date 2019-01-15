package com.lys.xuexi.service;

import com.lys.xuexi.domain.Girl;
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
}
