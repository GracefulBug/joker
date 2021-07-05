package com.life.joker.entity.vo;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author zhengdeqi
* @since 2021-07-05
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(value="MessageLogVO对象", description="")
    public class MessageLogVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String messageId;

    private String message;

    private Integer tryCount;

    private String status;

    private LocalDateTime nextRetry;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
