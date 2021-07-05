package com.life.joker.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhengdeqi
 * @since 2021-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="MessageLog对象", description="")
public class MessageLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String messageId;

    private String message;

    private Integer tryCount;

    private String status;

    private LocalDateTime nextRetry;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
