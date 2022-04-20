package com.bai.SpringBootStudy.SpringBootStudy.module;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author BaiYe
 * @since 2022-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_emp")
@ApiModel(value="Emp对象", description="")
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private Date bir;

    private Integer deptid;


}
