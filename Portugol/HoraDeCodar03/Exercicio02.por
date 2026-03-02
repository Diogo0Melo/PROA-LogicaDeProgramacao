programa
{
	
	funcao inicio()
	{
		/*
		 * Escreva um algoritmo para ler 2 valores informados pelo usuário e enquanto o segundo 
		 * valor informado for igual ou menor que ZERO, deve ser lido um novo valor, mas para a 
		 * mesma variável. Ou seja, para o segundo valor não pode ser aceito o valor zero nem um valor negativo. 

		O seu programa deve imprimir o resultado da divisão do primeiro valor lido pelo segundo valor e exibir o resultado ao usuário.

		 */

		inteiro valor1, valor2 = 0

		escreva("Digite um valor: ")
		leia(valor1)

		enquanto(valor2 <= 0){
			escreva("\nDigite um segundo valor maior que 0: ")
			leia(valor2)
		}

		inteiro resultado = valor1 / valor2

		escreva("A divisão de "+ valor1+" por "+ valor2+ " é: "+resultado)
		
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 9; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */