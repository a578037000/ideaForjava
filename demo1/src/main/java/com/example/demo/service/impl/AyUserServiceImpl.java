package com.example.demo.service.impl;

import com.example.demo.AyUser;
import com.example.demo.repository.AyUserRepository;
import com.example.demo.service.AyUserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class AyUserServiceImpl  implements AyUserService {
    @Resource
    private AyUserRepository ayUserRepoitory;
   /* @Override
    public AyUser findById(String id) {
        return ayUserRepoitory.getOne(id);
    }

    @Override
    public List<AyUser> findAll() {
        return ayUserRepoitory.findAll();
    }*/

    @Override
    public AyUser save(AyUser ayUser) {
       // return ayUserRepoitory.saveAndFlush(ayUser);
        return null;
    }

    @Override
    public void delete(String id) {
         List<AyUser>list =new ArrayList<>();
        AyUser ayUser= new AyUser();
        list.add(ayUser);
        ayUserRepoitory.deleteInBatch(list);
    }

  /*  @Override
    public Page<AyUser> findAll(Pageable pageable) {
        //ayUserRepoitory.findAll(pageable);
        return null;
    }*/

    @Override
    public List<AyUser> findByName(String name) {
        return ayUserRepoitory.findByName(name);
    }

    @Override
    public List<AyUser> findByNameLike(String name) {
        return ayUserRepoitory.findByNameLike(name);
    }

    @Override
    public List<AyUser> findByIdIn(Collection<String> ids) {
        return ayUserRepoitory.findByIdIn(ids);
    }
}
