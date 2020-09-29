package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

  @Autowired
  private DeptService deptService;

  @HystrixCommand(fallbackMethod = "hystrixGet")
  @GetMapping("/dept/get/{id}")
  public Dept get(@PathVariable("id") Long id){

      if (deptService.queryById(id) == null) throw new RuntimeException("id ==>" + id + "，不存在该用户，或者信息无法找到");

      return deptService.queryById(id);
  }

    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept().setDeptnum(id)
                .setDname("id ==>" + id + "，不存在该用户，或者信息无法找到 -- @Hystrix")
                .setDb_source("no this database in MYSQL");
    }

}
