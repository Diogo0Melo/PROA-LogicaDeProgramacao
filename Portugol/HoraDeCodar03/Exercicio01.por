programa
{
	inclua biblioteca Util
	
	funcao inicio()
	{
		/*
		 * Crie uma bomba relógio (usando somente código - para deixar claro!) 
		 * cuja contagem regressiva vá de 30 a 0. No final da repetição escreva "EXPLOSÃO".
		 */


		cadeia ativarBomba

		escreva("s - para ativar, n - para não ativar")
		escreva("\nDigite uma das opções acima: ")
		leia(ativarBomba)

		se(ativarBomba == "s"){
			escreva("Bomba ativada!!! Iniciando sequência de auto-explosão!")
			para(inteiro i = 30; i >= 0; i--){
				escreva("\nA bomba irá explodir em "+i+" segundos")
				Util.aguarde(1000)
			}
			escreva("\nEXPLOSÃO")
		}senao se(ativarBomba == "n"){
			escreva("A Bomba não foi ativada!")
		}senao escreva("opção inválida! Programa Encerrado.")
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 299; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */