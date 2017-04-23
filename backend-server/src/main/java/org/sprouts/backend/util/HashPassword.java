package org.sprouts.backend.util;

import java.util.Scanner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class HashPassword {

	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new StandardPasswordEncoder();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Please, type the password that you want to hash: [\\q to quit]");
			
			String input = scanner.nextLine();
			
			if("\\q".equals(input)) {
				break;
			}
			
			System.out.println(passwordEncoder.encode(input));
		}
		
		scanner.close();
	}
}
