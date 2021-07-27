package com.life.joker.service.impl;

import com.alibaba.excel.EasyExcel;
import com.life.joker.entity.DiagnosisDict;
import com.life.joker.entity.excel.DiagnosisDictExcelModel;
import com.life.joker.listener.DiagnosisDictImportListener;
import com.life.joker.mapper.DiagnosisDictMapper;
import com.life.joker.service.IDiagnosisDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhengdeqi
 * @since 2021-07-27
 */
@Slf4j
@Service
public class DiagnosisDictServiceImpl extends ServiceImpl<DiagnosisDictMapper, DiagnosisDict> implements IDiagnosisDictService {

    @Autowired
    DiagnosisDictImportListener diagnosisDictImportListener;

    @Override
    public void batchImport(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            EasyExcel.read(inputStream, DiagnosisDictExcelModel.class, diagnosisDictImportListener).sheet().doRead();
        } catch (IOException e) {
            log.error("excel文件读取失败, 失败原因：{}", e);
        }
    }
}
