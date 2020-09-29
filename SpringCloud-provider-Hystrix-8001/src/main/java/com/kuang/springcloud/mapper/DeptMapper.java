package com.kuang.springcloud.mapper;

import com.kuang.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    //增加一个部门
    public boolean addDept(Dept dept);

    //根据id查询出一个部门
    public Dept queryById(Long id);

    //查询所有部门
    public List<Dept> queryAll();
}
