package cn.tigers.login.service;

import cn.tigers.commons.exception.SysException;
import cn.tigers.entity.pojo.User;

/**
 * Created by tigershome on 2018/11/18.
 */
public interface SecurityLoginService {

    public User getUserByUsername(String username) throws SysException;
}
