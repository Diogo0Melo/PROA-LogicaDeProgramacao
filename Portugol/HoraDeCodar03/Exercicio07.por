programa
{
	
	funcao inicio()
	{
		/*
		 * Escreva um algoritmo para ler as notas de avaliações de um aluno, 
		 * calcule e imprima a média (simples) desse aluno. Só devem ser aceitos 
		 * valores válidos durante a leitura (0 a 10) para cada nota. São 6 notas ao total.
			Caso o valor informado para qualquer uma das notas esteja fora do limite estabelecido, 
			deve ser solicitado um novo valor ao usuário. 
		 */

		inteiro resultado,  soma = 0

		para(inteiro i = 0; i < 6; i++){
			inteiro nota = -1
			enquanto(nota < 0 ou nota >10){
				escreva("\nDigite a ",(i+1),"º nota do aluno (0 a 10): ")
				leia(nota)
				
			}
			soma += nota
		}

		resultado = soma / 6

		escreva("A média do aluno é: ",resultado)
		
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 513; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */