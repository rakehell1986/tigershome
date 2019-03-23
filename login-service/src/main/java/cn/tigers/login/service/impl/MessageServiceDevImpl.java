package cn.tigers.login.service.impl;

import cn.tigers.commons.inter.Dev;
import cn.tigers.login.service.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by tigershome on 2018/11/17.
 */
@Component
@Dev
public class MessageServiceDevImpl implements MessageService {

    @Value("${msg-content}")
    private String msgContent;

    @Override
    public String getMessage() {
        return msgContent;
    }
}
