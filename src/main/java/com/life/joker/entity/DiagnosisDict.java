package com.life.joker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

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
public class DiagnosisDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 疾病诊断编码
     */
    private String diagnosisCode;

    /**
     * 疾病诊断名称
     */
    private String diagnosisName;

    /**
     * 是否为有效码(注意：标示为“否”者是章、节代码，或具有细分亚目的类目编码；在编码时应当采用有效码）
     */
    private String valid;

    /**
     * 输入码
     */
    private String inputCode;

    /**
     * 删除标识（0，未删除；1，已删除）
     */
    private Boolean deleted;


}
