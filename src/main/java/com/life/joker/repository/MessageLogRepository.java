package com.life.joker.repository;

import com.life.joker.entity.MessageLog;
import com.life.joker.mapper.MessageLogMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zhengdeqi
 * @description 消息记录仓储层
 * @date 2021/7/5
 */
@Repository
public class MessageLogRepository {

    @Resource
    private MessageLogMapper messageLogMapper;

    /**
     * 添加消息日志
     *
     * @param messageLog
     */
    public void saveMessageLog(MessageLog messageLog) {
        messageLogMapper.insert(messageLog);
    }

}
