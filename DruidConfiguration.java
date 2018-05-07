package tz.lion.config.mysql;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
  
/**
 * druid 配置
 */
@Configuration
public class DruidConfiguration {
	
//	@Bean 
//    @ConfigurationProperties(prefix="spring.datasource")
//	public DataSource druidDataSource() {
//        return new DruidDataSource();
//    }
    
    /**
     * 注册一个StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean DruidStatViewServle2(){
       ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");       
       //白名单：
       servletRegistrationBean.addInitParameter("allow","127.0.0.1");
       //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
       //servletRegistrationBean.addInitParameter("deny","192.168.1.73");
       //登录查看信息的账号密码.
       servletRegistrationBean.addInitParameter("loginUsername","admin");
       servletRegistrationBean.addInitParameter("loginPassword","admin");
       //是否能够重置数据.
       servletRegistrationBean.addInitParameter("resetEnable","true");
       return servletRegistrationBean;
    }
    
    /**
     * 注册一个：filterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter2(){
       FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
       filterRegistrationBean.addUrlPatterns("/*");
       filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
       return filterRegistrationBean;
    }
	/**
	*spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
    *
	*spring.datasource.primary.initialSize=5
	*spring.datasource.primary.minIdle=5
	*spring.datasource.primary.maxActive=20
	*spring.datasource.primary.maxWait=60000
	*spring.datasource.primary.timeBetweenEvictionRunsMillis=60000
	*spring.datasource.primary.minEvictableIdleTimeMillis=300000
	*spring.datasource.primary.validationQuery=SELECT 1 FROM DUAL
	*spring.datasource.primary.testWhileIdle=true
	*spring.datasource.primary.testOnBorrow=false
	*spring.datasource.primary.testOnReturn=false
	*spring.datasource.primary.poolPreparedStatements=true
	*spring.datasource.primary.maxPoolPreparedStatementPerConnectionSize=20
	*spring.datasource.primary.filters=stat,wall,log4j
	*spring.datasource.primary.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
	*/
    
}