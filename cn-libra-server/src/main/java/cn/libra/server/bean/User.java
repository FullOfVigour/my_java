package cn.libra.server.bean;

public class User {
    private String id;

    private String acc;

    private String pass;

    public User(String id, String acc, String pass) {
        this.id = id;
        this.acc = acc;
        this.pass = pass;
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
}