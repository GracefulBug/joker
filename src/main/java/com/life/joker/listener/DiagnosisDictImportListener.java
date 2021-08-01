package com.life.joker.listener;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.life.joker.entity.DiagnosisDict;
import com.life.joker.entity.excel.DiagnosisDictExcelModel;
import com.life.joker.service.IDiagnosisDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhengdeqi
 * @description 诊断字典listener
 * @date 2021/7/27
 */
@Component
public class DiagnosisDictImportListener extends AnalysisEventListener<DiagnosisDictExcelModel> {

    @Autowired
    IDiagnosisDictService diagnosisDictService;

    private List<DiagnosisDictExcelModel> excelData = new ArrayList<>();

    @Override
    public void invoke(DiagnosisDictExcelModel data, AnalysisContext context) {
        excelData.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        List<DiagnosisDict> dictList = excelData.stream().map(data -> {
            DiagnosisDict dict = BeanUtil.toBean(data, DiagnosisDict.class);
            dict.setDeleted(false);
            dict.setValid("是");
            return dict;
        }).collect(Collectors.toList());
        diagnosisDictService.saveBatch(dictList);
    }
}
