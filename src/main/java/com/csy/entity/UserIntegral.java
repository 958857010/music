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
public class UserIntegral extends BaseEntity {

    private int id;

    private Integer integral;

    private Integer uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
