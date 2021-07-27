package com.life.joker.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.life.joker.entity.excel.BaseExcelModel;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhengdeqi
 * @description Excel解析基类
 * @date 2021/7/27
 */
public class AbstractAnalysisEventListener extends AnalysisEventListener<BaseExcelModel> {

    private Collection<BaseExcelModel> excelModels;

    @PostConstruct
    public void init() {
        this.excelModels = new ArrayList<>();
    }


    @Override
    public void invoke(BaseExcelModel data, AnalysisContext context) {
        excelModels.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

}
