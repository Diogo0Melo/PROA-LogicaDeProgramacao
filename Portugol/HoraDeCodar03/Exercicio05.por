programa
{
	
	funcao inicio()
	{
		/*
		 * Faça um algoritmo que calcule e escreva a média aritmética dos dois números inteiros 
		 * informados pelo usuário e todos os números inteiros entre eles. 
		 * Considere que o primeiro sempre será menor que o segundo.
		 */

		inteiro valor1, valor2, resultado, divisor = 0, soma = 0
		escreva("Digite um valor: ")
		leia(valor1)

		escreva("Digite um segundo valor: ")
		leia(valor2)

		para(inteiro i = valor1; i <= valor2; i++){
			soma += i
			divisor++
		}

		resultado = soma / divisor

		escreva("A média aritmética entre a soma dos valores de ",valor1," até ",valor2," é: ", resultado)
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 466; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */