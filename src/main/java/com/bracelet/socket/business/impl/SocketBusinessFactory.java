package com.bracelet.socket.business.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bracelet.exception.BizException;
import com.bracelet.util.RespCode;
import com.bracelet.socket.business.IService;

/**
 * 业务类型工厂类,根据type返回对应的业务处理对象
 * 
 */
@Component
public class SocketBusinessFactory {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 根据名称注入对应的业务
     */
    @Resource
    private IService loginService;
   
    @Resource
    private IService heartCheck;
    @Resource
    private IService minerStatusService;
    
    public IService getService(int type) throws BizException {
        logger.info("*****type:" + type);
        switch (type) {
        case 1:
            // 登录
            return loginService;
        case 9:
            // 心跳
            return heartCheck;
        case 12:
            // Minter status
            return minerStatusService;
            
        default:
            logger.info("找不到对应的类型:" + type);
            throw new BizException(RespCode.DEV_REQ_TYPE_ERR);
        }
    }
}
