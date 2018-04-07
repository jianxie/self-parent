package net.xiejian.base;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CommonDao extends SqlSessionDaoSupport{

	@Resource(name="sqlSessionFactory")  
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){  
        super.setSqlSessionFactory(sqlSessionFactory);  
    }
	
}
