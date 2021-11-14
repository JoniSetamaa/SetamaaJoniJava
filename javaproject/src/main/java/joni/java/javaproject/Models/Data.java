package joni.java.javaproject.Models;

public class Data {
    private long sid;
    private long cid;   

    public Data(long sid, long cid) {
        this.sid = sid;
        this.cid = cid;
    }

    public long getSid() {
        return this.sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public long getCid() {
        return this.cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

     
}