package com.lys.xuexi.service;

import com.lys.xuexi.domain.Girl;
import org.springframework.data.domain.Page;

public interface GirlService {
    /*普通分页*/
    Page<Girl> getPage(Integer pageNum,Integer pageLimit);
    /*排序分页*/
    Page<Girl> getPageSort(Integer pageNum,Integer pageLimit);

    public  void  insertTwo();

    public void getAge(Integer id) throws Exception;
}
