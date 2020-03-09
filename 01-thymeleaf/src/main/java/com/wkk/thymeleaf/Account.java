package com.wkk.thymeleaf;

/**
 * @Time: 20-3-9上午9:26
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Account {
    private String name;
    private String zhName;
    private String password;
    private String level;
    private String levelPassword;

    public Account(String name, String zhName, String password, String level, String levelPassword) {
        this.name = name;
        this.zhName = zhName;
        this.password = password;
        this.level = level;
        this.levelPassword = levelPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelPassword() {
        return levelPassword;
    }

    public void setLevelPassword(String levelPassword) {
        this.levelPassword = levelPassword;
    }
}
