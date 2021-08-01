package com.life.joker.controller;

import com.life.joker.enums.QueueEnum;
import com.life.joker.mq.producer.MQProducer;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengdeqi
 * @description 测试接口
 * @date 2021/7/19
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    MQProducer mqProducer;

    @ApiOperation("发送消息")
    @PostMapping()
    public void sendMessage(@RequestBody String message) {
        mqProducer.sendMessage(QueueEnum.QUEUE_TEST_1, message);
    }
}
