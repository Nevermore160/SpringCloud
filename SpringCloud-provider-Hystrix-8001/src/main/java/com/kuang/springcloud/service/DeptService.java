package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    //增加一个部门
    public boolean addDept(Dept dept);

    //根据id查询出一个部门
    public Dept queryById(Long id);

    //查询所有部门
    public List<Dept> queryAll();
}
