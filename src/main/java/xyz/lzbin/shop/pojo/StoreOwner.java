package xyz.lzbin.shop.pojo;

import java.util.Date;

public class StoreOwner {
    private Integer id;

    private String nickname;

    private String name;

    private String idCard;

    private String gender;

    private String tel;

    private String headimgUrl;

    private Date createTime;

    private Short status;

    private Short realStatus;

    private String username;

    private String password;
    public  StoreOwner(){ }

    public StoreOwner(StoreOwnerBuilder builder) {
        this.id = builder.id;
        this.nickname = builder.nickname;
        this.name = builder.name;
        this.idCard = builder.idCard;
        this.gender = builder.gender;
        this.tel = builder.tel;
        this.headimgUrl = builder.headimgUrl;
        this.createTime = builder.createTime;
        this.status = builder.status;
        this.realStatus = builder.realStatus;
        this.username = builder.username;
        this.password = builder.password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHeadimgUrl() {
        return headimgUrl;
    }

    public void setHeadimgUrl(String headimgUrl) {
        this.headimgUrl = headimgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getRealStatus() {
        return realStatus;
    }

    public void setRealStatus(Short realStatus) {
        this.realStatus = realStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class StoreOwnerBuilder {
        private Integer id;

        private String nickname;

        private String name;

        private String idCard;

        private String gender;

        private String tel;

        private String headimgUrl;

        private Date createTime;

        private Short status;

        private Short realStatus;

        private String username;

        private String password;

        public static StoreOwnerBuilder newBuilder() {
            return new StoreOwnerBuilder();
        }

        public StoreOwner builder() {
            return new StoreOwner(this);
        }

        public StoreOwnerBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public StoreOwnerBuilder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public StoreOwnerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StoreOwnerBuilder idCard(String idCard) {
            this.idCard = idCard;
            return this;
        }

        public StoreOwnerBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public StoreOwnerBuilder tel(String tel) {
            this.tel = tel;
            return this;
        }

        public StoreOwnerBuilder headimgUrl(String headimgUrl) {
            this.headimgUrl = headimgUrl;
            return this;
        }

        public StoreOwnerBuilder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public StoreOwnerBuilder status(Short status) {
            this.status = status;
            return this;
        }

        public StoreOwnerBuilder realStatus(Short realStatus) {
            this.realStatus = realStatus;
            return this;
        }

        public StoreOwnerBuilder username(String username) {
            this.username = username;
            return this;
        }

        public StoreOwnerBuilder password(String password) {
            this.password = password;
            return this;
        }
    }

}