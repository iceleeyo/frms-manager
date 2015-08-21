package cn.com.bsfit.frms.manager.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

import cn.com.bsfit.frms.manager.auth.AjaxPostFailureHandler;
import cn.com.bsfit.frms.manager.auth.AjaxPostSuccHandler;
import cn.com.bsfit.frms.manager.utils.Constants;

/**
 * Spring Security配置
 * 
 * @author hjp
 * 
 * @since 1.0.0
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

		@Autowired
		@Qualifier("managerDataSource")
		private DataSource managerDataSource;

		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable().headers().disable().authorizeRequests().antMatchers(HttpMethod.HEAD, "/rs/**")
					.permitAll().antMatchers("/rs/**", "/", "/index.html").authenticated().and()
					.requestMatcher(new RequestHeaderRequestMatcher("User-Agent", "java")).httpBasic()
					.realmName("frms-manager").and().logout().logoutUrl("/j_spring_security_logout")
					.logoutSuccessUrl("/login.html");
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication().dataSource(managerDataSource).passwordEncoder(new ShaPasswordEncoder(256))
					.authoritiesByUsernameQuery(Constants.USER_BY_NAME_QUERY)
					.usersByUsernameQuery(Constants.AUTHORITIES_BY_NAME_QUERY);
		}
	}

	@Configuration
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Autowired
		@Qualifier("managerDataSource")
		private DataSource managerDataSource;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			AjaxPostSuccHandler succHandler = new AjaxPostSuccHandler();
			succHandler.setDefaultTargetUrl("/index.html");
			http.csrf().disable().headers().disable().authorizeRequests().antMatchers(HttpMethod.HEAD, "/rs/**")
					.permitAll().antMatchers("/rs/**", "/", "/index.html").authenticated().and().formLogin()
					.loginPage("/login.html").usernameParameter("j_username").passwordParameter("j_password")
					.loginProcessingUrl("/j_spring_security_check").defaultSuccessUrl("/index.html")
					.failureHandler(new AjaxPostFailureHandler()).successHandler(succHandler).permitAll().and().logout()
					.logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login.html").permitAll();
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication().dataSource(managerDataSource).passwordEncoder(new ShaPasswordEncoder(256))
					.authoritiesByUsernameQuery(Constants.USER_BY_NAME_QUERY)
					.usersByUsernameQuery(Constants.AUTHORITIES_BY_NAME_QUERY);
		}
	}
}
