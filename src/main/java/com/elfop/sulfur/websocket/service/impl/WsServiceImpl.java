package com.elfop.sulfur.websocket.service.impl;

import com.elfop.sulfur.websocket.service.WsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.websocket.Session;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/15  14:05
 */
@Slf4j
@Service
public class WsServiceImpl implements WsService {

    @Override
    public Session getSession(String uid) {
        return SESSION_MAP.get(uid);
    }

    @Override
    public boolean removeSession(String uid) {
        try {
            Session s = SESSION_MAP.remove(uid);
            s = null;
        } catch (Exception e) {
            log.error(">>>移除用户session时失败，待移除的用户id: {}", uid);
            return false;
        }
        return true;
    }

    @Override
    public boolean registerSession(String uid, Session session) {
        try {
            SESSION_MAP.put(uid, session);
        } catch (Exception e) {
            log.error(">>> 注册用户session 时失败，注册用户:{}, session:{}", uid, session);
            return false;
        }
        return true;
    }

    @Override
    public void process() {

    }

}
