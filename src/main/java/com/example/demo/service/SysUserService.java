package com.example.demo.service;

import com.example.demo.entity.SysUser;
import com.example.demo.mapper.SysUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    public void insert(SysUser record){
        sysUserMapper.insert(record);
    }

    public PageInfo<SysUser> findAllUser(int pageNum, SysUser user){
        int pageSize = 10;
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> list = sysUserMapper.selectAll();
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
        return pageInfo;
    }
}
