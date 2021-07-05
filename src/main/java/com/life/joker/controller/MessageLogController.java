package com.life.joker.controller;


import cn.hutool.core.bean.BeanUtil;
import com.life.joker.entity.vo.MessageLogVO;
import com.life.joker.service.IMessageLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhengdeqi
 * @since 2021-07-05
 */
@Api(tags = "消息日志")
@RestController
@RequestMapping("/message-log")
public class MessageLogController {

    @Autowired
    private IMessageLogService messageLogService;

    @ApiOperation("添加消息日志")
    @PostMapping()
    public void addMessageLog() {

    }

    @ApiOperation("消息日志列表")
    @GetMapping("/list")
    public List<MessageLogVO> list() {
        return messageLogService.list()
                .stream()
                .map(messageLog ->  BeanUtil.toBean(messageLog, MessageLogVO.class))
                .collect(Collectors.toList());
    }
}
