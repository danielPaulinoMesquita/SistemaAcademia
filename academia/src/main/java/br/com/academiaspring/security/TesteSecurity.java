package br.com.academiaspring.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesteSecurity {
	//MÉTODO QUE SERVE PARA MOSTRAR COMO SERIA A SENHA 1234 CRIPTOGRAFADA
	 public static void main(String[] args) {
		 System.out.println(new BCryptPasswordEncoder().encode("1234"));
	 }
}
