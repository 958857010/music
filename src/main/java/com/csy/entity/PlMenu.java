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
public class PlMenu extends BaseEntity {

    private int id;

    private Integer mid;

    private Integer pid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
