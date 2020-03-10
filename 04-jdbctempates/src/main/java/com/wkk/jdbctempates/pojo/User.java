package com.wkk.jdbctempates.pojo;

/**
 * @Time: 20-3-10下午2:20
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class User {
    private String sno;
    private String name;
    private String sex;

    public User(String sno, String name, String sex) {
        this.sno = sno;
        this.name = name;
        this.sex = sex;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
