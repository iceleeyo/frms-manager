package cn.com.bsfit.frms.manager.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 数据库和HttpMessageConverters配置
 * 
 * @author hjp
 * 
 * @since 1.0.0
 *
 */
@Configuration
@MapperScan(basePackages = { "cn.com.bsfit.frms.manager.mapper" }, sqlSessionFactoryRef = "managerSqlSessionFactory")
public class ManagerConfig {
	
	@Value("${manager.jdbc.type:oracle}")
	private String managerJdbcType;
	
	private DataSource managerDataSource;
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "manager.jdbc")
	public DataSource managerDataSource() {
		return managerDataSource = DataSourceBuilder.create().build();
	}

	@Bean
    public SqlSessionFactory managerSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(managerDataSource);
        bean.setConfigLocation(new ClassPathResource("ManagerMybatisConfig_" + managerJdbcType + ".xml"));
        return bean.getObject();
    }
	
	@Bean
	public JdbcTemplate managerJdbcTemplate() {
		return new JdbcTemplate(managerDataSource);
	}

	@Bean
	public PlatformTransactionManager managerTransactionManager() {
		return new DataSourceTransactionManager(managerDataSource);
	}
	
	@Bean
	public HttpMessageConverters customConverters() {
		FastJsonHttpMessageConverter fastjson = new FastJsonHttpMessageConverter();
		return new HttpMessageConverters(fastjson);
	}
}
