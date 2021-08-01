package com.life.joker.service;

import com.life.joker.entity.DiagnosisDict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhengdeqi
 * @since 2021-07-27
 */
public interface IDiagnosisDictService extends IService<DiagnosisDict> {

    /**
     * 批量导入
     *
     * @param file
     */
    void batchImport(MultipartFile file);
}
