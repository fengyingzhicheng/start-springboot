package com.flyin.example;

import com.flyin.example.mapper.TkUserMapper;
import com.flyin.example.pojo.TkUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王军
 * @description TkMapperTest
 * @date 2021/12/9 9:34
 */
@SpringBootTest
public class TkMapperTest {

    @Autowired
    private TkUserMapper userMapper;

    /**
     * INSERT INTO tk_user ( id,name,age,create_time,update_time,deleted )
     * VALUES( null,'bravo',16,null,null,null );
     *
     * 注意，如果不带xxxSelective，默认会插入null，null也算一种赋值，所以数据库设置的默认值不会生效
     */
    @Test
    public void testInsert() {
        TkUser TkUser = new TkUser();
        // 虽然我只设置了两个值，但实际执行会插入全量字段，默认null
        TkUser.setName("bravo");
        TkUser.setAge(16);
        userMapper.insert(TkUser);
    }

    /**
     * INSERT INTO tk_user ( id,name,age ) VALUES( null,'bravoSelective',16 );
     *
     * 只会插入id,name,age三个字段，此时数据库默认值会生效
     */
    @Test
    public void testInsertSelective() {
        TkUser TkUser = new TkUser();
        TkUser.setName("bravoSelective");
        TkUser.setAge(16);
        userMapper.insertSelective(TkUser);
    }

    /**
     * INSERT INTO tk_user ( id,name,age,create_time,update_time,deleted )
     * VALUES
     * ( null,'bravo1',18,null,null,null ) ,
     * ( null,'bravo2',19,null,null,null ) ,
     * ( null,'bravo3',20,null,null,null ) ,
     * ( null,'bravo4',21,null,null,null )
     * ...
     *
     * insertList(list)方法底层是insert()而不是insertSelective()，数据库默认值不会生效
     */
    @Test
    public void testInsertBatch() {
        // 准备10个数据
        List<TkUser> list = new ArrayList<>();
        TkUser TkUser = null;
        for (int i = 1; i <= 10; i++) {
            TkUser = new TkUser();
            TkUser.setName("bravo" + i);
            TkUser.setAge(17 + i);
            list.add(TkUser);
        }
        // 批量插入
        userMapper.insertList(list);
    }

    /**
     * UPDATE tk_user SET name = 'bravoSelective',age = 100,create_time = null,update_time = null,deleted = null
     * WHERE id = 6;
     *
     * 没设置的值会被更新为null，可能产生两个问题：
     * 1.数据库默认值不会生效
     * 2.不想更新的字段被更新为null（严重错误）
     */
    @Test
    public void testUpdate() {
        TkUser TkUser = new TkUser();
        TkUser.setId(6L);
        TkUser.setName("bravoSelective");
        TkUser.setAge(100);
        userMapper.updateByPrimaryKey(TkUser);
    }

    /**
     * UPDATE tk_user SET name = 'bravoSelective',age = 100
     * WHERE id = 6;
     *
     * 只更新设置的字段
     */
    @Test
    public void testUpdateSelective() {
        TkUser TkUser = new TkUser();
        TkUser.setId(6L);
        TkUser.setName("bravoSelective");
        TkUser.setAge(100);
        userMapper.updateByPrimaryKeySelective(TkUser);
    }

    /**
     * DELETE
     * FROM tk_user
     * WHERE id in (1,2,3,4,5);
     *
     * deleteByIdList底层用的是IN，是物理删除DELETE，不是逻辑删除UPDATE
     */
    @Test
    public void testDeleteBatch() {
        List<Long> ids = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        userMapper.deleteByIdList(ids);
    }

    /**
     * SELECT COUNT(*)
     * FROM tk_user
     * WHERE ( ( name like 'bravo' ) );
     *
     * 有两点注意：
     * 1.这里的'name'只是是POJO的属性，而不是数据库字段
     * 2.模糊匹配要自己写%
     */
    @Test
    public void testCount() {
        Example example = new Example(TkUser.class);
        example.createCriteria().andLike("name", "bravo");
        int i = userMapper.selectCountByExample(example);
        System.out.println("count记录数为：" + i);
    }

    /**
     * SELECT id , name FROM tk_user WHERE ( ( age = ? ) )
     *
     * 虽然通用Mapper也能只查询指定列，但是复用性不好，每次都要在service层重新写一遍
     */
    @Test
    public void testSelectByExample() {
        Example example = new Example(TkUser.class);
        // 指定查询列只查询id和name，指定条件列为age
        example.selectProperties("id", "name").createCriteria().andEqualTo("age", 16);
        userMapper.selectByExample(example);
    }

    /**
     * SELECT id,name,age,create_time,update_time,deleted
     * FROM tk_user
     * WHERE id in (1,2,3,4,5);
     *
     * selectByIdList底层也是用IN
     */
    @Test
    public void testSelectBatch() {
        List<Long> ids = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        userMapper.selectByIdList(ids);
    }
}