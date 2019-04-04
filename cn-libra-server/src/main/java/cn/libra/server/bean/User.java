package cn.libra.server.bean;

public class User {
    private String id;

    private String userType;

    private String acc;

    private String pass;

    private String name;

    private Integer gender;

    private String nation;

    private String dateOfBirth;

    private String idNumber;

    private String department;

    private String email;

    private String qq;

    private String weixin;

    private String mobilePhone;

    private String loginIp;

    private String lastLoginIp;

    private String lgionTime;

    private String lastLoginTime;

    private Integer loginTimes;

    private Integer onlineTime;

    private Integer state;

    public User(String id, String userType, String acc, String pass, String name, Integer gender, String nation, String dateOfBirth, String idNumber, String department, String email, String qq, String weixin, String mobilePhone, String loginIp, String lastLoginIp, String lgionTime, String lastLoginTime, Integer loginTimes, Integer onlineTime, Integer state) {
        this.id = id;
        this.userType = userType;
        this.acc = acc;
        this.pass = pass;
        this.name = name;
        this.gender = gender;
        this.nation = nation;
        this.dateOfBirth = dateOfBirth;
        this.idNumber = idNumber;
        this.department = department;
        this.email = email;
        this.qq = qq;
        this.weixin = weixin;
        this.mobilePhone = mobilePhone;
        this.loginIp = loginIp;
        this.lastLoginIp = lastLoginIp;
        this.lgionTime = lgionTime;
        this.lastLoginTime = lastLoginTime;
        this.loginTimes = loginTimes;
        this.onlineTime = onlineTime;
        this.state = state;
    }

    public User() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc == null ? null : acc.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth == null ? null : dateOfBirth.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public String getLgionTime() {
        return lgionTime;
    }

    public void setLgionTime(String lgionTime) {
        this.lgionTime = lgionTime == null ? null : lgionTime.trim();
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime == null ? null : lastLoginTime.trim();
    }

    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    public Integer getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Integer onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}