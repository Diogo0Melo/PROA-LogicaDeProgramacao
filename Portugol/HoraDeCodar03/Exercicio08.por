programa
{
	
	funcao inicio()
	{
		/*
		 *  Ler um valor N e imprimir todos os valores inteiros entre 1 (inclusive) e N (inclusive). Considere que o N será sempre maior que ZERO.
			N  é um valor informado pelo usuário
		 */

		inteiro valorFinal, valorInicial = 1

		escreva("Digite o valor final a ser impresso: ")
		leia(valorFinal)
			
		enquanto(valorInicial <= valorFinal){
			escreva("\n",valorInicial++)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 416; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */