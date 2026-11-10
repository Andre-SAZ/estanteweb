package br.com.estanteweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstantewebApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstantewebApplication.class, args);
	}

}

//Questão 1.2
//Tomcat initialized with port 8080 (http)

//Questão 1.3
//Status Code: 404 Not Found

//Questão extra 1.4: O erro 404 Not Found ocorre quando o servidor não consegue encontrar o 
//recurso solicitado. Isso pode acontecer por vários motivos, como por exemplo uma URL 
//incorreta ou inexistente.

//Questão 2.1
//Status Code: 200 OK

//Questão 2.3
//[ERROR] Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:4.1.0:run (default-cli) on project estanteweb: Process terminated with exit code: 1 -> [Help 1]
//[ERROR] 
//[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
//[ERROR] Re-run Maven using the -X switch to enable full debug logging.
//[ERROR] 
//[ERROR] For more information about the errors and possible solutions, please read the following articles:
//[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException

//Questão extra 2.4: Ocorreu um erro quando eu tentei iniciar o servidor/subir a aplicação
//Foi melhor ter descoberto o erro antes de tentar acessar a aplicação, pois assim eu 
//poderia ter corrigido o erro antes de tentar acessar a aplicação e não teria recebido o erro 404 Not Found.

//Questão 3.1
//