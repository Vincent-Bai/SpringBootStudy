package com.bai.SpringBootStudy.SpringBootStudy.module;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.*;

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
@TableName("t_user")
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @Null(message="id必须为空")
    private Integer id;

    @NotBlank(message = "name不可以为空")
    @Size(min = 2,max = 4,message = "name的长度范围为2-4")
    private String name;

    @NotNull(message = "age 不能为null")
    @NotEmpty(message = "年龄不能为空")
    @Min(1)
    @Max(150)
    private Integer age;

    @Future
    private Date bir;


}
