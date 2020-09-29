package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
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

    //获取一些配置信息，得到具体的微服务
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDeptById(@PathVariable("id")Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> getDept(){
        return deptService.queryAll();
    }

    @GetMapping("/dept/discovery")
    //注册进来的微服务，获取一些消息,就是写在配置文件里的那个东西，当然也有可能是其他东西
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery ===> services:" + services);

        //得到一个具体的微服务信息,通过具体的微服务id，applicationName
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getInstanceId() + "\t" +
                    instance.getScheme() + "\t" +
                    instance.getServiceId() + "\t" +
                    instance.getMetadata()
            );
        }
        return this.discoveryClient;
    }


}
