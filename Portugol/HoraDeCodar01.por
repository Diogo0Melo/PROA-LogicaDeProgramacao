programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		/* Exercicio 1
		 * Escreva um programa que crie uma variável chamada "nome_do_carro" e atribua-a um valor "Fusca". Exiba-a ao usuário.
		 */
		
		 cadeia nome_do_carro = "Fusca"
		 escreva(nome_do_carro)


		 /* Exericio 2
		  *  Escreva um programa em que o usuário informe o seu nome e exiba a mensagem "Olá, [NomeDoUsuario]".
		  */

		 cadeia nome_do_usuario
		 escreva("\n\nQual seu nome: ")
		 leia(nome_do_usuario)

		 escreva("\nOlá, "+ nome_do_usuario)

		  /* Exercicio 3
		   *  Escreva um programa em que o usuário informe o seu nome e em seguida o programa perguntará a idade do usuário. 
		   *  Agora o programa deve exibir a mensagem "Olá, [NomeDoUsuario], sua idade é [idade]".
		   */

		escreva("\n\nQual seu nome: ")
		leia(nome_do_usuario)

		inteiro idade_do_usuario
		escreva("\nQual sua idade: ")
		leia(idade_do_usuario)

		escreva("\nOlá, "+nome_do_usuario+", sua idade é "+idade_do_usuario +" anos")


		/* Exercicio 4
		 *  Considerando a figura abaixo, escreva um programa para cada forma que calcule e exiba em tela cada uma de suas respectivas áreas.
		 *  O usuário irá informar os valores de cada variável.
		 */


		real areaRetangulo, areaQuadrado, areaLosango, areaTrapezio, areaParalelogramo, areaTriangulo, areaCirculo
		
		areaRetangulo = calcularAreaRetangulo()
		escreva("\nA área do retângulo é: "+areaRetangulo)

		areaQuadrado = calcularAreaQuadrado()
		escreva("\nA área do quadrado é: "+areaQuadrado)

		areaLosango = calcularAreaLosango()
		escreva("\nA área do Losango é: "+areaLosango)

		areaTrapezio = calcularAreaTrapezio()
		escreva("\nA área do trápezio é: ")

		areaParalelogramo = calcularAreaParalelogramo()
		escreva("\nA área do paralelogramo é: "+areaParalelogramo)

		areaTriangulo = calcularAreaTriangulo()
		escreva("\nA área do triângulo é: "+areaTriangulo)

		areaCirculo = calcularAreaCirculo()
		escreva("\nA área do círculo é: "+areaCirculo)
		  
	}

	funcao real calcularAreaRetangulo(){
			real base, altura
			escreva("\n\nQual a base do seu retângulo: ")
			leia(base)

			escreva("\nQual a altura do seu retângulo: ")
			leia(altura)
			
			retorne base * altura
		}

	funcao real calcularAreaQuadrado(){
		real lado

		escreva("\n\nQual o valor de um dos lados do quadrado: ")
		leia(lado)

		retorne lado * lado
		
		}

	funcao real calcularAreaLosango(){
		real diagonalMaior, diagonalMenor
		
		escreva("\n\nDigite o valor da maior diagonal do losango: ")
		leia(diagonalMaior)

		escreva("\nDigite o valor da menor diagonal do lasango: ")
		leia(diagonalMenor)

		retorne diagonalMaior * diagonalMenor / 2
		
		}

	funcao real calcularAreaTrapezio(){
		real baseMaior, baseMenor, altura

		escreva("\n\nQual o valor da maior base do trápezio: ")
		leia(baseMaior)

		escreva("\nQual o valor da menor base do trápezio: ")
		leia(baseMenor)

		escreva("\nQual a altura do trápezio: ")
		leia(altura)

		retorne (baseMaior + baseMenor) * altura / 2
		
		}

	funcao real calcularAreaParalelogramo(){
		real base, altura
		
		escreva("\n\nDigite o valor da base do paralelogramo: ")
		leia(base)

		escreva("\nDigite o valor da altura do paralelogramo: ")
		leia(altura)

		retorne base * altura
		}

	funcao real calcularAreaTriangulo(){
		real base, altura

		escreva("\n\nQual o valor da base do triângulo: ")
		leia(base)

		escreva("\nQual o valor da altura do triângulo: ")
		leia(altura)

		retorne base * altura / 2
		}

	funcao real calcularAreaCirculo(){
		real raio

		escreva("\n\nDigite o valor do raio do círculo: ")
		leia(raio)

		retorne mat.PI * mat.potencia(raio, 2.0) 
		
		}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1524; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */