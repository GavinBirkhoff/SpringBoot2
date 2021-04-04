package com.gavin.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 */
//@Component
@NoArgsConstructor  // 无参构造器
@AllArgsConstructor // 有参构造器
@ToString  // 编译的是偶自动生成 toString
@Data // 生成get set 方法
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;
}
