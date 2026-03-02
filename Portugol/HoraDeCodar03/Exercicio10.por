programa
{
	
	funcao inicio()
	{
		/*
		 * Escreva um programa em que o usuário informe 10 valores e 
		 * escreva quantos desses valores lidos estão entre os 
		 * números 24 e 42 (incluindo os valores 24 e 42) e quantos deles estão fora deste intervalo.
		 */

		cadeia numerosValidos=""
		inteiro valor
		
		para(inteiro i = 0; i < 10; i++){
			escreva("Digite um valor: ")
			leia(valor)

			se(valor >= 24 e valor <= 42){
				se(i == 9) numerosValidos += valor
				senao numerosValidos += ""+valor+" - "
			}
		}
		escreva("Os valores válidos informados foram: \n"+numerosValidos)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 597; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */