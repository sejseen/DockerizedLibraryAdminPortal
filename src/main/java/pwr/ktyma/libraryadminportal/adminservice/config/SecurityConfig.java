package pwr.ktyma.libraryadminportal.adminservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pwr.ktyma.libraryadminportal.adminservice.service.impl.UserSecurityService;
import pwr.ktyma.libraryadminportal.adminservice.utility.SecurityUtility;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public Environment environment;

    @Autowired
    UserSecurityService userSecurityService;

    private static final String[] PUBLIC_MATCHERS = {
            "/css/**",
            "/js/**",
            "/forgetPassword",
            "/image/**",
            "/createAccount",
            "/",
            "/login",
            "/fonts/**"
    };

    private BCryptPasswordEncoder passwordEncoder() {
        return SecurityUtility.passwordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpReq) throws Exception {
        httpReq.
                authorizeRequests().
                antMatchers(PUBLIC_MATCHERS).
                permitAll().
                anyRequest().
                authenticated();
        httpReq.
                csrf().disable().
                cors().disable().
                formLogin().failureUrl("/login?error").defaultSuccessUrl("/").
                loginPage("/login").permitAll().
                and().
                logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).
                logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll().
                and().
                rememberMe();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
    }

}