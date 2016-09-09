package br.com.maisa.avaliacao;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import br.com.maisa.avaliacao.entity.User;
import br.com.maisa.avaliacao.repository.UserRepository;

@SpringBootApplication
public class Application extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }
    
    @Bean
	public CommandLineRunner loadData(UserRepository repository) {
		return (args) -> {
			BufferedReader bufferedReader = null;
			
			try {
				Resource resource = new ClassPathResource("input"); 
				InputStream resourceInputStream = resource.getInputStream();
				bufferedReader = new BufferedReader(new InputStreamReader(resourceInputStream));
				String line = "";
				
				while ((line = bufferedReader.readLine()) != null) {
					String[] collumns = line.split(" ");
					
					User user = new User(collumns[0],
							Long.valueOf(collumns[2]),
							Long.valueOf(collumns[4]));
					
					repository.save(user);
				}
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (bufferedReader != null) {
						bufferedReader.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		};
	}
}
