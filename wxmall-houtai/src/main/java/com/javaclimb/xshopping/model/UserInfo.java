package com.javaclimb.xshopping.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user_info")
public class UserInfo implements Serializable {
    /**
     * ID,主键
     *
     * @mbg.generated
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 姓名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String password;

    /**
     * 昵称
     *
     * @mbg.generated
     */
    private String nickname;

    /**
     * 性别
     *
     * @mbg.generated
     */
    private String sex;

    /**
     * 年龄
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     * 生日
     *
     * @mbg.generated
     */
    private String birthday;

    /**
     * 手机号
     *
     * @mbg.generated
     */
    private String phone;

    /**
     * 地址
     *
     * @mbg.generated
     */
    private String address;

    /**
     * 编号
     *
     * @mbg.generated
     */
    private String code;

    /**
     * 邮箱
     *
     * @mbg.generated
     */
    private String email;

    /**
     * 身份证
     *
     * @mbg.generated
     */
    private String cardid;

    /**
     * 权限等级
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     * 余额
     *
     * @mbg.generated
     */
    private Double account;

    @Transient
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", code=").append(code);
        sb.append(", email=").append(email);
        sb.append(", cardid=").append(cardid);
        sb.append(", level=").append(level);
        sb.append(", account=").append(account);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}