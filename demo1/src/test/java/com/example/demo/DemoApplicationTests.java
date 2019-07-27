package com.example.demo;

import com.example.demo.service.AyUserService;
import com.example.demo.service.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private AyUserService ayUserService;
    @Test
    void contextLoads() {
        String sql="select  *from  ay_user";
        List<AyUser> userList=(List<AyUser>)jdbcTemplate.query(sql, new RowMapper<AyUser>() {
            @Override
            public AyUser mapRow(ResultSet rs, int i) throws SQLException {
                AyUser user=new AyUser();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        System.out.println("查询成功:");
        for(AyUser user: userList){
            System.out.println("id:"+user.getId()+";name:"+user.getName());
        }



        /*************************/
        //List<AyUser> userList1=ayUserService.findAll();
        //System.out.println("findAll():"+userList1.size());
        //t通过name查询数据
        List<AyUser> userList2 =ayUserService.findByName("阿毅");
        System.out.println("findByName()："+userList2.size());
        Assert.isTrue(userList2.get(0).getName().equals("阿毅"),"data error");
        //通过name模糊查询
        List<AyUser> userList3 =ayUserService.findByNameLike("%阿%");
        System.out.println("findByNameLike()："+userList3.size());
        Assert.isTrue(userList3.get(0).getName().equals("阿毅"),"data error");
        //通过id列表查询数据
        List<String> ids=new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");
        List<AyUser> userList4 =ayUserService.findByIdIn(ids);
        System.out.println("findByIdIn()："+userList4.size());
        //分页查询数据
  /*      PageRequest pageRequest =new PageRequest(0,10);
        Page<AyUser> userList5 =ayUserService.findAll(pageRequest);
        System.out.println("page findAll()："+userList5.size());*/
        //新增数据
        AyUser ayUser =new AyUser();
        ayUser.setPassword("6666");
        ayUser.setName("王二麻");
        ayUser.setId("10");
        ayUserService.save(ayUser);
        //删除数据
        ayUserService.delete("3");
    }
}
