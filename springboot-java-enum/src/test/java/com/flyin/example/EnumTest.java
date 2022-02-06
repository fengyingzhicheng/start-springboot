package com.flyin.example;

import com.flyin.example.pojo.TkUserPojo;
import com.flyin.example.mapper.MpUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author 王军
 * @description
 * @date 2022/1/9 20:03
 */
@SpringBootTest
public class EnumTest {
    @Autowired
    MpUserMapper mpUserMapper;

    @Test
    public void test() {
        TkUserPojo tkUserPojo = new TkUserPojo();
        tkUserPojo.setName("");
        tkUserPojo.setAge(0);
        tkUserPojo.setUserType(0);
        tkUserPojo.setCreateTime(new Date());
        tkUserPojo.setUpdateTime(new Date());
        tkUserPojo.setDeleted(false);
        mpUserMapper.insert(tkUserPojo);

    }

}