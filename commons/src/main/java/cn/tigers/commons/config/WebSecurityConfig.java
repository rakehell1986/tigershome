package cn.tigers.commons.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by tigershome on 2018/11/18.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin()
                    .loginPage("/login").permitAll().and()  // 定义当需要用户登陆时候，转到的登陆页面
                .authorizeRequests()
                    .antMatchers("/", "/home").permitAll()  // 定义哪些URL需要被被保护、哪些不需要被保护
                    .anyRequest().authenticated().and()         // 任何请求，登陆后可以访问
                .logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("USER");
    }
}
