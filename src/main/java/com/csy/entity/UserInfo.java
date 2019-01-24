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
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String uName;

    private Integer uSex;

    private String uPhone;

    private String uImgurl;

    private Integer iId;

    private Integer uid;

    private Integer uTime;

    private String uIntro;


}
