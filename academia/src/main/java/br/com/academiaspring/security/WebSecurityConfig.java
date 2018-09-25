package br.com.academiaspring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/").permitAll()
				 .antMatchers("/cliente.jsf","/cliente.xhtml").hasAnyRole("ADMIN")
				 .antMatchers("/medidas.jsf","/medidas.xhtml").hasAnyRole("ADMIN")
				 .antMatchers("/dobracutanea.jsf","/dobracutanea.xhtml").hasAnyRole("ADMIN")
				 .antMatchers("/administracao.jsf","/administracao.xhtml").hasAnyRole("ALUNO")
				 .antMatchers("/avaliacaodobrascutaneas.jsf","/avaliacaodobrascutaneas.xhtml").hasAnyRole("ALUNO")
				 .antMatchers("/avaliacaofisica.jsf","/avaliacaofisica.xhtml").hasAnyRole("ALUNO")
				 .antMatchers("/mensalidade.jsf","/mensalidade.xhtml").hasAnyRole("ALUNO")

				.anyRequest()
				.authenticated()
				.and()
				.csrf()
				.disable()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/home")
				.permitAll()
				.and().logout().permitAll();
	}

	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
		.inMemoryAuthentication()
		.withUser("administrador")
			.password("123")
			.roles("ADMIN", "ALUNO")
				.and()
		.withUser("aluno")
			.password("321")
			.roles("ALUNO");
	}


	
	// protected UserDetailsService userDetailsService() {
	// UserDetails user1= new User("jao","123",
	// AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
	// UserDetails user2= new User("maria","abc",
	// AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USUARIO"));
	// return new InMemoryUserDetailsManager(Arrays.asList(user1,user2));
	// }

}
