package com.bamboo.system.aop;

import com.bamboo.core.base.BaseEntity;
import com.bamboo.core.base.GlobalConstants;
import com.bamboo.entity.system.Session;
import com.bamboo.entity.system.User;
import com.bamboo.simulate.UserAdmin;
import com.bamboo.system.exception.ServiceException;
import com.bamboo.system.util.ThreadVariable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 痕迹填充
 * Created by yklin on 2018/5/15.
 */
@Aspect
@Repository
public class TraceAspect {
    private final static Logger logger = LoggerFactory.getLogger(TraceAspect.class);

    /**
     * 新增操作切入
     *
     * @param baseEntity
     * @throws Exception
     */
    @Before("execution(public * com.bamboo.*.mapper.*Mapper.save*(..)) &&  args(baseEntity,..)")
    public void appendCreateInfo(BaseEntity baseEntity) throws Exception {
        System.out.println("append create info...");
        if (baseEntity instanceof User) {
            UserAdmin userAdmin = new UserAdmin();
            baseEntity.setCreateUser(userAdmin.getUserName());
            baseEntity.setCreateDate(new Date());
            baseEntity.setCreateIp(userAdmin.getSimulateIp());
            baseEntity.setUpdateUser(userAdmin.getUserName());
            baseEntity.setUpdateDate(new Date());
            baseEntity.setUpdateIp(userAdmin.getSimulateIp());
            baseEntity.setIzDelete(GlobalConstants.INTEGER_YES);
            baseEntity.setVersion(GlobalConstants.VERSION_START);
            return;
        }
        Session session = ThreadVariable.getSession();
        if (null == session || null == session.getUser() || null == session.getUser().getUserName()) {
            throw new ServiceException("Session不存在，系统不能正常工作!", this.getClass().getName());
        }
        baseEntity.setCreateUser(session.getUser().getUserName());
        baseEntity.setCreateDate(new Date());
        baseEntity.setCreateIp(session.getAccessIp());
        baseEntity.setUpdateUser(session.getUser().getUserName());
        baseEntity.setUpdateDate(new Date());
        baseEntity.setUpdateIp(session.getAccessIp());
        baseEntity.setIzDelete(GlobalConstants.INTEGER_YES);
        baseEntity.setVersion(GlobalConstants.VERSION_START);
    }

    /**
     * 修改操作切入
     *
     * @param baseEntity
     * @throws Exception
     */
    @Before("execution(public * com.bamboo.*.mapper.*Mapper.update*(..)) &&  args(baseEntity,..)")
    public void appendUpdateInfo(BaseEntity baseEntity) throws Exception {
        System.out.println("append update info...");
        Session session = ThreadVariable.getSession();
        if (null == session || null == session.getUser() || null == session.getUser().getUserName()) {
            throw new ServiceException("Session不存在，系统不能正常工作!", this.getClass().getName());
        }
        baseEntity.setUpdateUser(session.getUser().getUserName());
        baseEntity.setUpdateDate(new Date());
        baseEntity.setUpdateIp(session.getAccessIp());
//        baseEntity.setIzDelete(GlobalConstants.INTEGER_YES);
    }
}
