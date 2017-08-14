package api.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangtc on 2017/6/27.
 */
public class CardDTO implements Serializable {
    private static final long serialVersionUID = -8532405747544689353L;
    private int id;
    private String title;
    private String subtitle;
    private String description;
    private String picture;
    private String cardtype;
    private String person;
    private String ext;
    private String status;
    private Date gmtcreate;
    private Date gmtupdate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSubtitle() {
        return subtitle;
    }
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getCardtype() {
        return cardtype;
    }
    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }
    public String getPerson() {
        return person;
    }
    public void setPerson(String person) {
        this.person = person;
    }
    public String getExt() {
        return ext;
    }
    public void setExt(String ext) {
        this.ext = ext;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getGmtcreate() {
        return gmtcreate;
    }
    public void setGmtcreate(Date gmtcreate) {
        this.gmtcreate = gmtcreate;
    }
    public Date getGmtupdate() {
        return gmtupdate;
    }
    public void setGmtupdate(Date gmtupdate) {
        this.gmtupdate = gmtupdate;
    }
    public String toString(){
        return"Card:["+id+","+title+","+subtitle+","+description+","
                +picture+","+cardtype+","+person+","+ext+","+status+","
                +gmtcreate+","+gmtupdate;
    }
}
