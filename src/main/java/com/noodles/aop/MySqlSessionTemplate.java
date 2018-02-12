package com.noodles.aop;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * Created by gaoxinwei on 2018/2/12.
 */
public class MySqlSessionTemplate extends SqlSessionTemplate {

    public MySqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }
}
