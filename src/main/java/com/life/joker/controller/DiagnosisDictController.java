package com.life.joker.controller;


import com.life.joker.service.IDiagnosisDictService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhengdeqi
 * @since 2021-07-27
 */
@RestController
@RequestMapping("/joker/diagnosis-dict")
public class DiagnosisDictController {

    @Autowired
    IDiagnosisDictService diagnosisDictService;

    @ApiOperation(value = "批量导入诊断数据")
    @PostMapping(value = "/batchImport")
    public void batchImport(@RequestParam("file") MultipartFile file) {
        diagnosisDictService.batchImport(file);
    }

}
