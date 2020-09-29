package com.kuang.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//实体类  orm  类表关系映射
@Data
@NoArgsConstructor
@Accessors(chain = true)  //链式写法: new Dept().setDeptnum().setDname().setDb_source();
public class Dept implements Serializable {
    private Long deptnum;  //主键
    private String dname;  //部门名称
    private String db_source; //来自哪个数据库，一个服务对应一个数据库，同一个信息可能存在不同的数据库

    public Dept(String dname){
        this.dname = dname;
    }
}
