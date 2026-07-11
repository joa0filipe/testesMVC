package com.example.calculadorafp;

import org.springframework.ui.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class CalculadorafpApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadorafpApplication.class, args);
	}
}
@Controller
class CalculadoraController {

	@GetMapping("/")
	public String AbrirPagina(){
		return "front";
	}

	@GetMapping("/calcular")
	public String conta(
			@RequestParam double num1,
			@RequestParam String operacao,
			@RequestParam double num2,
			Model telaHtml) {

		double ResultadoFinal = 0;
		int erro = 0;

		switch (operacao) {
			case "+":
				ResultadoFinal = num1 + num2;
				break;
			case "/":
				if (num2 != 0) ResultadoFinal = num1 / num2;
				else erro = 1;
				break;
			case "-":
				ResultadoFinal = num1 - num2;
				break;
			case "*":
				ResultadoFinal = num1 * num2;
				break;
		}

		if (erro == 1) telaHtml.addAttribute("resultado", "erro");
		else telaHtml.addAttribute("resultado", ResultadoFinal);

		return "front";
	}
}