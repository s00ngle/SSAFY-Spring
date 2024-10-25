package com.ssafy.configuration;

import java.util.Properties;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.JdbcType;

import com.ssafy.board.model.mapper.BoardMapper;

public class SqlMapConfig {

	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			// 데이터베이스 연결 정보 설정
            Properties properties = new Properties();
            properties.setProperty("driver", "com.mysql.cj.jdbc.Driver");
            properties.setProperty("url", "jdbc:mysql://localhost:3306/ssafyweb?serverTimezone=UTC");
            properties.setProperty("username", "ssafy");
            properties.setProperty("password", "ssafy");
            
            // DataSource 설정
            PooledDataSource dataSource = new PooledDataSource();
            dataSource.setDriver(properties.getProperty("driver"));
            dataSource.setUrl(properties.getProperty("url"));
            dataSource.setUsername(properties.getProperty("username"));
            dataSource.setPassword(properties.getProperty("password"));
            
            // TransactionFactory 설정
            TransactionFactory transactionFactory = new JdbcTransactionFactory();
            
            // Environment 설정
            Environment environment = new Environment("development", 
                                                    transactionFactory, 
                                                    dataSource);
            
            // MyBatis Configuration 객체 생성
            Configuration configuration = new Configuration(environment);
            
            // 기본 설정
            configuration.setMapUnderscoreToCamelCase(true);
            configuration.setJdbcTypeForNull(JdbcType.NULL);
            
            // 매퍼 클래스 등록
            configuration.addMapper(BoardMapper.class);
            // 필요한 매퍼들 추가
            // configuration.addMapper(OtherMapper.class);
            
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
