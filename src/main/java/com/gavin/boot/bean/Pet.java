package com.gavin.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor  // 无参构造器
@AllArgsConstructor // 有参构造器
@ToString  // 编译的是偶自动生成 toString
@Data // 生成get set 方法
public class Pet {
    private String name;
}
