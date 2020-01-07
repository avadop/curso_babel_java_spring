package start;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * Configuracion de roles y usuarios, los roles son para definir segun el rol
	 * cuales son los permisos de cada usuario. Los usuarios pueden obtenerse de 
	 * la base de datos, de memoria o de un Ldap (bd usuarios)*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user1")
	        .password("{noop}user1") //lo de {noop} se pone para no obligar a usar mecanismo de encriptacion
	        .roles("USER")
	        .and()
	    .withUser("admin")
        	.password("{noop}admin")
        	.roles("USER", "ADMINISTRATOR");
		
		/*Para encriptar la contraseña se hace de la siguiente manera*/
		/* auth.inMemoryAuthentication()
	        .withUser("user1")
	          .password(new BCryptPasswordEncoder().encode("user1"))
	          .roles("USER")
	          .and()
	        .withUser("admin")
	          .password(new BCryptPasswordEncoder().encode("admin"))
	          .roles("USER", "ADMIN");*/
		
		/*En caso de querer configurarlo desde la base de datos el codigo seria el siguiente*/
		/*auth.jdbcAuthentication().dataSource(dataSource)
        	.usersByUsernameQuery("select username, password, enabled"
            	+ " from users where username=?")
        	.authoritiesByUsernameQuery("select username, authority "
            	+ "from authorities where username=?");*/
	}
	
	//definicion de politicas de seguridad, quien va a poder hacer que 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		//Solo podran hacer peticiones post de agregar contactos los administradores
		.antMatchers(HttpMethod.POST,"/addContacto").hasRole("ADMINISTRATOR")
		/*.authenticated simplemente pide que estes registrado para 
		poder acceder a la funcion, sin ningun rol en particular*/
		.antMatchers("/contactos").authenticated()
		/* Cuando no especificas el metodo http pero si la ruta, se hace referencia a 
		 * todos los metodos que se llaman desde la ruta*/
		.antMatchers("/eliminarEmail/*").authenticated()
		//.antMatchers("/**").authenticated()
		.and()
		.httpBasic();
	
	}
}
