package com.bamboo.system.websocket;

import com.bamboo.system.util.ThreadVariable;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * 从ThreadVariable中获取httpSession
 * Created by yklin on 2018/6/26.
 */
public class ThreadVariableConfig extends ServerEndpointConfig.Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        sec.getUserProperties().put("ThreadVariable", ThreadVariable.getSession());
    }
}
