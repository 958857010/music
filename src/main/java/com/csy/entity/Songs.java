package com.csy.entity;

import com.csy.utils.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author shawn
 * @since 2019-01-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Songs extends BaseEntity {

    private int id;

    private String songName;

    private Integer sid;

    private Integer alid;

    private LocalDate songCreattime;

    private String songImg;

    private Integer type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getAlid() {
        return alid;
    }

    public void setAlid(Integer alid) {
        this.alid = alid;
    }

    public LocalDate getSongCreattime() {
        return songCreattime;
    }

    public void setSongCreattime(LocalDate songCreattime) {
        this.songCreattime = songCreattime;
    }

    public String getSongImg() {
        return songImg;
    }

    public void setSongImg(String songImg) {
        this.songImg = songImg;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
