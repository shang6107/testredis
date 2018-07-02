package com.test.redis.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 上官炳强
 * @description
 * @since 2018-06-30 / 03:00:35
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors(chain = true)
public class User implements Serializable{
    private static final long serialVersionUID = -2967710007706812401L;
    private Integer id;
    private String name;
    private Boolean gender;//1:male 2:female
    private String address;
}
