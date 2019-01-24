package com.csy.entity;

import com.csy.utils.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class Singer extends BaseEntity {

    private int id;

    private String singerName;

    private String sImgurl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getsImgurl() {
        return sImgurl;
    }

    public void setsImgurl(String sImgurl) {
        this.sImgurl = sImgurl;
    }
}
