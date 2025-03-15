package com.edms.lite.config;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/admin/**").hasRole("ADMIN")
            .antMatchers("/api/bugs/**").hasAnyRole("ADMIN", "EDITOR")
            .antMatchers("/api/documents/**").authenticated()
            .anyRequest().permitAll()
            .and()
            .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin").password("{noop}admin123").roles("ADMIN")
            .and()
            .withUser("editor").password("{noop}editor123").roles("EDITOR")
            .and()
            .withUser("viewer").password("{noop}viewer123").roles("VIEWER");
    }
}

