programa
{
	
	funcao inicio()
	{
		/*
		 * Escreva um programa para ler 2 notas de um aluno, calcular e 
		 * imprimir a média final. Considere que a nota de aprovação é 9,5. 
		 * Logo após escrever a mensagem "Calcular a média de outro aluno Sim/Não?" 
		 * e solicitar um resposta. Se a resposta for "S", o programa deve ser executado 
		 * novamente, caso contrário deve ser encerrado exibindo a quantidade de alunos aprovados.
		 */

		cadeia continuar=""
		real valor1,valor2,resultado

		enquanto(continuar != "Não"){
			escreva("Digite a primeira nota do aluno: ")
			leia(valor1)

			escreva("Digite a segunda nota do aluno: ")
			leia(valor2)

			resultado = (valor1 + valor2) / 2
			
			escreva("A média final do alunos é: ",resultado,"\n")
			
			se(resultado >= 9.5) escreva("O aluno está aprovado!\n")
			senao escreva("O aluno está reprovado")

			escreva("\n\nCalcular a média de outro aluno Sim/Não?")
			leia(continuar)

		
			
			
		}
		 
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 589; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */