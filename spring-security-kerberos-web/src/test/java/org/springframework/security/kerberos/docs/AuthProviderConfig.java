/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.security.kerberos.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.kerberos.authentication.KerberosAuthenticationProvider;
import org.springframework.security.kerberos.authentication.sun.SunJaasKerberosClient;

//tag::snippetA[]
@Configuration
// @EnableWebMvcSecurity
public class AuthProviderConfig /*extends WebSecurityConfigurerAdapter*/ {

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeRequests()
    //             .antMatchers("/", "/home").permitAll()
    //             .anyRequest().authenticated()
    //             .and()
    //         .formLogin()
    //             .loginPage("/login").permitAll()
    //             .and()
    //         .logout()
    //             .permitAll();
    // }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth
    //         .authenticationProvider(kerberosAuthenticationProvider());
    // }

    @Bean
    public KerberosAuthenticationProvider kerberosAuthenticationProvider() {
        KerberosAuthenticationProvider provider =
        		new KerberosAuthenticationProvider();
        SunJaasKerberosClient client = new SunJaasKerberosClient();
        client.setDebug(true);
        provider.setKerberosClient(client);
        provider.setUserDetailsService(dummyUserDetailsService());
        return provider;
    }

    @Bean
    public DummyUserDetailsService dummyUserDetailsService() {
        return new DummyUserDetailsService();
    }

}
//end::snippetA[]
