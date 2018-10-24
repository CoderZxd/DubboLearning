package com.zxd.dubbo.learning.api;

import java.io.Serializable;

/**
 * @Project DubboLearning
 * @Package com.zxd.dubbo.learning.api
 * @Author：zouxiaodong
 * @Description:
 * @Date:Created in 18:04 2018/10/24.
 */
public class Person implements Serializable{
    private String name;
    private Integer age;
    private Long heigh;
    private Boolean isMale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getHeigh() {
        return heigh;
    }

    public void setHeigh(Long heigh) {
        this.heigh = heigh;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }

    public Person(String name) {
        this.name = name;
        this.age = 30;
        this.heigh = 180L;
        this.isMale = true;
    }
}
