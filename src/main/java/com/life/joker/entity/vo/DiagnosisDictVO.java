package com.life.joker.entity.vo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
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
* @since 2021-07-27
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(value="DiagnosisDictVO对象", description="")
    public class DiagnosisDictVO implements Serializable {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "ID")
            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty(value = "疾病诊断编码")
    private String diagnosisCode;

            @ApiModelProperty(value = "疾病诊断名称")
    private String diagnosisName;

            @ApiModelProperty(value = "是否为有效码(注意：标示为“否”者是章、节代码，或具有细分亚目的类目编码；在编码时应当采用有效码）")
    private String valid;

            @ApiModelProperty(value = "输入码")
    private String inputCode;

            @ApiModelProperty(value = "删除标识（0，未删除；1，已删除）")
    private Boolean deleted;


}
