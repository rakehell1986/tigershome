package cn.tigers.login.service.impl;

import cn.tigers.commons.exception.SysException;
import cn.tigers.entity.pojo.User;
import cn.tigers.login.service.SecurityLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by tigershome on 2018/11/18.
 */
@Component
public class SecurityLoginServiceImpl implements SecurityLoginService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public User getUserByUsername(String username) throws SysException {
        User user = new User();
        return null;
    }
}
