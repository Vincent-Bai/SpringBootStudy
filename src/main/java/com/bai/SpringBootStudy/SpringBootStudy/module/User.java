package com.bai.SpringBootStudy.SpringBootStudy.module;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_user")
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private Date bir;

}
