programa
{
	
   	real saldo = 150.00// Float
   	cadeia nome = "", extrato = "Depósito de R$300.00\nSaque de R$100.00\nTransferência enviada de R$100.00\nTransferência recebida de R$50.00\n"
   	inteiro senha = 3589
	
	funcao inicio() {
		
		inteiro opcao 
		
		se(nome == "") perguntarNome()

		escreva("Olá, "+nome+" é um prazer ter você aqui!\n")
		
		escreva("Escolha uma opção:\n")
		escreva("1. Ver saldo\n")
		escreva("2. Ver extrato\n")
		escreva("3. Fazer saque\n")
		escreva("4. Fazer depósito\n")
		escreva("5. Fazer transferência\n")
		escreva("6. Sair\n")
		leia(opcao)

		escreva("A opção selecionada foi: " +opcao + "\n")

    		escolha(opcao){
    			caso 1:
				verSaldo()
    			pare
    			caso 2:
				verExtrato()
    			pare
    			caso 3:
				fazerSaque()
    			pare
    			caso 4:
				fazerDeposito()
    			pare
    			caso 5:
				fazerTransferencia()
    			pare
    			caso 6:
				sair()
    			pare
    			caso contrario:
				erro()
    			pare
    		}

	}

	funcao perguntarNome(){
		escreva("Qual o seu nome? ")
		leia(nome)
	}

	funcao verSaldo(){

		se(nao senhaCorreta()) {
			verSaldo()
			retorne
		}
		
	    escreva("Seu saldo atual é: ", saldo, "\n")
	    inicio()
	}

	funcao verExtrato(){

		se(nao senhaCorreta()) {
			verExtrato()
			retorne
		}
		
		escreva("\nExtrato:\n"+extrato)
		inicio()
	}

	funcao fazerSaque(){
	
		real saque
		
		se(nao senhaCorreta()) {
			fazerSaque()
			retorne
		}
	
		escreva("Qual o valor para saque? ")
		leia(saque)
	
		se (saque <= 0 ou saque > saldo){
	        erroOperacao()
	        fazerSaque()
		} senao {
			saldo = saldo - saque
			extrato += "Saque de R$" + saque + "\n"
			verSaldo()
		}
	}
	
	funcao fazerDeposito() {

		real deposito
		
		escreva("Qual o valor para depósito? ")
		leia(deposito)
		
		se (deposito <= 0){
			erroOperacao()
			fazerDeposito()
		} senao {
			saldo = saldo + deposito
			extrato += "Depósito de R$" + deposito + "\n"
			verSaldo()
		}
	}

	funcao fazerTransferencia(){

		inteiro numeroDaConta
		real valorDaTransferencia
		
		se(nao senhaCorreta()) {
			fazerTransferencia()
			retorne
		}

		escreva("Qual o número da conta a qual será feita a transferência? ")
		leia(numeroDaConta)

		escreva("Qual o valor a ser transferido? ")
		leia(valorDaTransferencia)

		se(valorDaTransferencia <= 0 ou valorDaTransferencia > saldo){
			erroOperacao()
			fazerTransferencia()
		} senao {
			saldo -= valorDaTransferencia
			extrato += "Transferência enviada de R$" + valorDaTransferencia + "\n"
			verSaldo()
		}
		
	}

	
	funcao logico senhaCorreta(){

		inteiro senhaInformada

		escreva("Para realizar a operação por favor informe sua senha: ")
		leia(senhaInformada)
		
		se(senhaInformada == senha)	retorne verdadeiro
	
		erroOperacao()
		retorne falso
		
	}

	funcao erro() {
		escreva("Opção Inválida\n")
		inicio()
	}

	funcao erroOperacao(){
		escreva("Operação não autorizada\n")
	}

	funcao sair(){
		escreva(nome+", foi um prazer ter você por aqui!")
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 474; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */