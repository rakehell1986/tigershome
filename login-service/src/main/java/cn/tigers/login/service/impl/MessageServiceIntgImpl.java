package cn.tigers.login.service.impl;

import cn.tigers.login.service.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by tigershome on 2018/11/17.
 */
@Component
@Profile({"intg"})
public class MessageServiceIntgImpl implements MessageService {

    @Value("${msg-content}")
    private String msgContent;
    @Override
    public String getMessage() {
        return null;
    }
}
