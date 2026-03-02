programa
{
	
	funcao inicio()
	{
		/*
		 * Escreva um programa para imprimir todas as tabuadas de 1 a N. N será informado pelo usuário.
		 */

		inteiro valorTabuadaFinal, valorFinalDaMultiplicacao

		escreva("Escreva o valor da última tabuada: ")
		leia(valorTabuadaFinal)

		escreva("Escreva o último multiplicador das tabuadas: ")
		leia(valorFinalDaMultiplicacao)
		
		para(inteiro i = 1; i <= valorTabuadaFinal; i++){

			para(inteiro j = 1; j<= valorFinalDaMultiplicacao; j++){

				escreva(""+i+" x "+j+" = "+ (i*j)+"\n")
				
			}
			escreva("\n\n")
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 543; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */