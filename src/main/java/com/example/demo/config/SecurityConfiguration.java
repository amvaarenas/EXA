package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration("securityCpnfiguration")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	System.out.println("222222222222222222222222222");
        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers( "/swagger-ui.html").permitAll()           
                .antMatchers(HttpMethod.POST, "/registro").permitAll()
                .antMatchers(HttpMethod.GET, "/platillo").authenticated()
                .antMatchers(HttpMethod.POST, "/platillo").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/ingredientes").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/ingredientes").authenticated()
                .antMatchers(HttpMethod.DELETE, "/platillo/{id}").hasAuthority("ADMIN")
                
                .antMatchers(HttpMethod.GET, "/usuarios").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/cambioRoleUsuario/{id}").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/cambioRoleAdm/{id}").hasAuthority("MASTER")
                .and()
                .csrf().disable()
                .formLogin().disable();
        System.out.println("222222222222222222222222222");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}