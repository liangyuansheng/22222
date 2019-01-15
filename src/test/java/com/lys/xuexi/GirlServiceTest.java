package com.lys.xuexi;

import com.lys.xuexi.domain.Girl;
import com.lys.xuexi.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;
    @Test
    public void findoneTest(){
       Girl girl= girlService.findone(1);
        Assert.assertEquals(new Integer(9),girl.getAge());
    }
}
