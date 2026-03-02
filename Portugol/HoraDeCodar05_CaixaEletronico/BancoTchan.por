programa
{
	inclua biblioteca Texto
   	inclua biblioteca Util
	inclua biblioteca Tipos
	
	cadeia bancoDeDados[10][6], senha, conta = "", nome, saldoEmConta, saldoEmMaos, extrato
	inteiro contasRegistradas = 0, localClienteBD = -1
	logico bancoDeDadosNaoIniciado = verdadeiro

	funcao inicio() {
		
		cadeia opcao
		inteiro opcaoInteiro = -1 
		
		se (bancoDeDadosNaoIniciado) iniciarBancoDeDados()
			
		escreva("Bem Vindo ao Banco Tchan!!!\n")
		escreva("\n1 - Criar Conta, 2 - Entrar na Conta, 0 - Encerrar\n")
		escreva("Digite uma das opções acima: ")
		leia(opcao)

		se(Tipos.cadeia_e_inteiro(opcao, 10)){
			
			opcaoInteiro = Tipos.cadeia_para_inteiro(opcao, 10)
			
			se (opcaoInteiro >= 0 e opcaoInteiro <= 2){
				
				escolha(opcaoInteiro){
					
					caso 0: 
						sair()
					pare
					caso 1:
						criarConta()
					pare
					caso 2:
						entrarConta()
					pare
					
				}
			}senao {
				erro()
			}
		}senao {
			erro()
		}	
	}

	funcao vazio iniciarBancoDeDados(){
		para(inteiro i = 0; i < 10; i++){
        		para(inteiro j = 0; j < 5; j++){
          		bancoDeDados[i][j] = ""
          		bancoDeDadosNaoIniciado = falso
        		}
     	 }
	}

	funcao vazio criarConta(){
		
		escreva("\n\nCRIAÇÃO DE CONTA\n\n")
		
		nome = cadastrarNome()
		senha = cadastrarSenha()

		salvarNoBD()

		escreva("\nSua Conta Foi Criada Com Sucesso!!!\n")
		escreva("Para acessar use a opção 2 no inicio.\n")
		escreva("Lembre-se o número da sua conta é ",conta," use ele e sua senha para entrar!")

		limparDados()
		pausarFluxo()
		inicio()
		
	}

	funcao cadeia cadastrarNome(){
		
		cadeia nomeTemp
		
		escreva("\nPara voltar aperte ENTER\n")
		escreva("Digite seu nome: ")
		leia(nomeTemp)
		
		se(nomeTemp == "")	inicio()

		validarNome(nomeTemp)

		retorne nomeTemp
		
	}

	funcao vazio validarNome(cadeia nome){
		
		inteiro tamanho = Texto.numero_caracteres(nome)
		
		se (tamanho == 0) {
			escreva("Erro: O nome não pode estar vazio!\n")
			cadastrarNome()
			retorne 
		}

		inteiro fim = tamanho - 1

		se (Texto.obter_caracter(nome, 0) == ' ' ou Texto.obter_caracter(nome, fim) == ' ') {
			escreva("Nome Inválido: Não pode começar ou terminar com espaços.\n")
			cadastrarNome()
		}
		
	}

	funcao cadeia cadastrarSenha(){
		
		cadeia senhaTemp
		
		escreva("\nPara voltar aperte ENTER\n")
		escreva("\nSua senha só pode conter números e deve ter 4 dígitos! Ex: 0000 \n")
		escreva("Crie uma senha: ")
		
		leia(senhaTemp)
		
		se(senhaTemp == "")	cadastrarNome()
		
		validarSenha(senhaTemp)

		retorne senhaTemp
	}

	funcao vazio validarSenha(cadeia senha){
		
		se(Tipos.cadeia_e_inteiro(senha, 10)){
			
			para (inteiro i = 0; i <= 9; i++ ){
				
				para (inteiro j = 0; j <= 9; j++){
					
					para (inteiro k = 0; k <= 9; k++){
						
						para (inteiro l = 0; l <= 9; l++){
							
							cadeia senhaValida = Tipos.inteiro_para_cadeia(i, 10) + Tipos.inteiro_para_cadeia(j, 10) + Tipos.inteiro_para_cadeia(k, 10) + Tipos.inteiro_para_cadeia(l, 10)
							
							se (senha == senhaValida) {
								confirmarSenha(senha)
								retorne
							}
						}
					}
				}
			}
		}
			mensagemDeErroGenerica()
			cadastrarSenha()
			retorne
	}

	funcao vazio confirmarSenha(cadeia senha){
		
		escreva("\nPara voltar aperte ENTER\n")
		
		cadeia senhaTemp
		
		escreva("Digite sua senha novamente: ")
		leia(senhaTemp)
		
		se(senhaTemp == "")	cadastrarSenha()
		
		senao se(senhaTemp == senha) retorne
		
		senao {
			mensagemDeErroGenerica()
			confirmarSenha(senha)
			retorne
		}
	}

	funcao vazio salvarNoBD(){
		para(inteiro i = 0; i < 10; i++){
			para(inteiro j = 0; j < 1; j++){
				se(bancoDeDados[i][j] == ""){
					bancoDeDados[i][0] = senha
					bancoDeDados[i][1] = atribuirNumeroConta()
					bancoDeDados[i][2] = nome
					bancoDeDados[i][3] = "0"
					bancoDeDados[i][4] = "0"
					bancoDeDados[i][5] = ""
					retorne
				}
			}
		}
	}

	funcao cadeia atribuirNumeroConta(){
		conta = Texto.preencher_a_esquerda('0', 4, (""+ ++contasRegistradas))
		retorne conta
	}

	funcao vazio entrarConta(){
		
		escreva("\n\nACESSAR CONTA\n\n")
		
		cadeia conta = verificarConta()
		inteiro informacoesCliente = verificarSenha(conta)
		
		se (informacoesCliente != -1){
			
			senha = bancoDeDados[informacoesCliente][0]
			conta = bancoDeDados[informacoesCliente][1]
			nome = bancoDeDados[informacoesCliente][2]
			saldoEmConta = bancoDeDados[informacoesCliente][3]
			saldoEmMaos = bancoDeDados[informacoesCliente][4]
			extrato = bancoDeDados[informacoesCliente][5]
			localClienteBD = informacoesCliente
			
			menu()
			retorne
		}
	}
	
	funcao cadeia verificarConta(){
		
		escreva("\nPara voltar aperte ENTER\n")
		escreva("Digite o número da sua conta: ")
		
		leia(conta)
		
		se (conta == "") inicio()
		
		para(inteiro i = 0; i < 10; i++){
			
			para(inteiro j = 0; j < 1; j++){
				
				se (bancoDeDados[i][1] == conta e bancoDeDados[i][1] != "")	retorne conta
			}
		}	
		mensagemDeErroGenerica()
		inicio()
		retorne ""
	}
	
	funcao inteiro verificarSenha(cadeia conta){
		
		inteiro localDaContaNoBD = -1
		
		escreva("\nPara voltar aperte ENTER\n")
		escreva("Digite sua senha: ")
		
		leia(senha)
		
		se (senha == "")	inicio()
		
		para(inteiro i = 0; i < 10; i++){
			
			para(inteiro j = 0; j < 1; j++){
				
				se (bancoDeDados[i][0] == senha e bancoDeDados[i][0] != "" e bancoDeDados[i][1] == conta) {
					localDaContaNoBD = i
					retorne localDaContaNoBD
				}
			}
		}
		mensagemDeErroGenerica()
		inicio()
		retorne localDaContaNoBD
	}

	funcao menu(){
		
		cadeia opcaoCadeia
		inteiro opcaoInteiro
		
		escreva("\nOlá, "+nome+"! é um prazer ter você aqui!\n")
		escreva("Escolha uma opção:\n")
		escreva("1. Ver Saldo\n")
		escreva("2. Ver Extrato\n")
		escreva("3. Fazer Depósito\n")
		escreva("4. Fazer Saque\n")
		escreva("5. Fazer Transferência\n")
		escreva("6. Trabalhar!!!\n")
		escreva("0. Sair\n")
		
		leia(opcaoCadeia)

		opcaoInteiro = validarOpcao(opcaoCadeia)

    		escolha(opcaoInteiro){
    			caso 0:
    				limparDados()
				inicio()
    			pare
    			caso 1:
				verSaldo()
    			pare
    			caso 2:
				verExtrato()
    			pare
    			caso 3:
    				fazerDeposito()
    			pare
    			caso 4:
				fazerSaque()
    			pare
    			caso 5:
				fazerTransferencia()
    			pare
    			caso 6:
				trabalhar()
    			pare
    		}
	}

	funcao verSaldo(){
		
	   escreva("\nSeu saldo em conta é de R$",saldoEmConta,"\nSeu saldo em mãos é de R$",saldoEmMaos)
	   
	   pausarFluxo()
	   menu()
	}
	
	funcao verExtrato(){
		
		se(extrato == "") escreva("Não há extratos disponiveis")
		
		senao {
			escreva("\n\nExtrato:\n\n",extrato)
		}
		
		pausarFluxo()
		menu()
	}

	funcao fazerDeposito() {
		
		cadeia valorDepositar = ""
		real valorDepositarReal, saldoEmContaReal, saldoEmMaosReal

		escreva("\nPara voltar aperte ENTER")
		escreva("\nDigite o valor a ser depósitado: ")
		
		leia(valorDepositar)

		se(valorDepositar == "")	menu()

		senao se(Tipos.cadeia_e_real(valorDepositar) ou Tipos.cadeia_e_inteiro(valorDepositar,10)){
		
			valorDepositarReal = Tipos.cadeia_para_real(valorDepositar)
			saldoEmContaReal = Tipos.cadeia_para_real(saldoEmConta)
			saldoEmMaosReal = Tipos.cadeia_para_real(saldoEmMaos)
		
			se(valorDepositarReal <= saldoEmMaosReal e valorDepositarReal > 0){
				
				saldoEmMaosReal -= valorDepositarReal
				saldoEmContaReal += valorDepositarReal
				escreva("Você depósitou R$"+valorDepositarReal)
					
				extrato += ("\nDepósito de R$"+valorDepositarReal)

				saldoEmConta = Tipos.real_para_cadeia(saldoEmContaReal)
				saldoEmMaos = Tipos.real_para_cadeia(saldoEmMaosReal)
					
				bancoDeDados[localClienteBD][3] = saldoEmConta
				bancoDeDados[localClienteBD][4] = saldoEmMaos
				bancoDeDados[localClienteBD][5] = extrato
				
				pausarFluxo()
				menu()
				retorne
			}senao {
				mensagemDeErroGenerica()
				fazerDeposito()
				retorne
			}
				
		}senao {
			mensagemDeErroGenerica()
			fazerDeposito()
			retorne
		}
		retorne
	}

	funcao vazio fazerSaque(){
		
		cadeia valorSacar = ""
		real valorSacarReal, saldoEmContaReal, saldoEmMaosReal

		escreva("\nPara voltar aperte ENTER")
		escreva("\nDigite o valor a ser sacado: ")
		
		leia(valorSacar)

		se(valorSacar == "") {
			menu()
			retorne
		}
		
		senao se(Tipos.cadeia_e_real(valorSacar) ou Tipos.cadeia_e_inteiro(valorSacar,10)){
			
			valorSacarReal = Tipos.cadeia_para_real(valorSacar)
			saldoEmContaReal = Tipos.cadeia_para_real(saldoEmConta)
			saldoEmMaosReal = Tipos.cadeia_para_real(saldoEmMaos)

			se(valorSacarReal <= saldoEmContaReal e valorSacarReal > 0){
				
				saldoEmMaosReal += valorSacarReal
				saldoEmContaReal -= valorSacarReal
				escreva("Você sacou R$"+valorSacarReal)
					
				extrato += ("\nSaque de R$"+valorSacarReal)

				saldoEmConta = Tipos.real_para_cadeia(saldoEmContaReal)
				saldoEmMaos = Tipos.real_para_cadeia(saldoEmMaosReal)
					
				bancoDeDados[localClienteBD][3] = saldoEmConta
				bancoDeDados[localClienteBD][4] = saldoEmMaos
				bancoDeDados[localClienteBD][5] = extrato
				
				pausarFluxo()
				menu()
				retorne
					
			}senao {
				mensagemDeErroGenerica()
				fazerSaque()
				retorne
			}
			
				
		}senao {
			mensagemDeErroGenerica()
			fazerSaque()
			retorne
		}
			
	}
	
	funcao vazio fazerTransferencia(){
		
		cadeia contaTransferencia = "", valorTransferencia = ""
		real valorTransferenciaReal = 0, saldoEmContaReal
		logico valorTransferenciaInvalido
		
			
		escreva("\nPara voltar aperte ENTER\n")
		escreva("Digite o número da conta para onde você fara a transferência: ")
		
		leia(contaTransferencia)
		
		se(contaTransferencia == "") {
			menu()
			retorne
		}senao se(contaTransferencia == conta){
			
			escreva("Transferir para a mesma conta não faz sentido, né?")
			pausarFluxo()
			menu()
			retorne
			
		}
		
		inteiro localDaContaTransferencia = validarContaTransferencia(contaTransferencia)
		
		se(localDaContaTransferencia != -1){
			
			saldoEmContaReal = Tipos.cadeia_para_real(saldoEmConta)
			
			faca{
			
				escreva("\nPara voltar aperte ENTER\n")
				escreva("Digite o valor a ser transferido: ")
				
				leia(valorTransferencia)

				se(valorTransferencia == "") {
					menu()
					retorne
				}

				valorTransferenciaInvalido = validarValorTransferencia(valorTransferencia, saldoEmContaReal)
				
			}enquanto(valorTransferenciaInvalido)
			
			cadeia nomeTransferencia = bancoDeDados[localDaContaTransferencia][2]
			cadeia numeroContaTransferencia = Texto.preencher_a_esquerda('0', 4, (""+(localDaContaTransferencia+1)))
			cadeia extratoContaTransferencia = bancoDeDados[localDaContaTransferencia][5]
			real saldoEmContaTransferencia = Tipos.cadeia_para_real(bancoDeDados[localDaContaTransferencia][3])

			valorTransferenciaReal = Tipos.cadeia_para_real(valorTransferencia)
			
			saldoEmContaReal -= valorTransferenciaReal
			saldoEmContaTransferencia +=  valorTransferenciaReal
			
			escreva("Você transferiu R$"+valorTransferenciaReal+" para "+nomeTransferencia+" com a conta "+numeroContaTransferencia)
					
			extrato += ("\nTransferência enviada de R$"+valorTransferenciaReal+" para conta "+numeroContaTransferencia )
			extratoContaTransferencia += ("\nTransferência recebida de R$"+valorTransferenciaReal+ " do(a) " + nome + " com a conta "+conta )
			
			bancoDeDados[localClienteBD][3] = Tipos.real_para_cadeia(saldoEmContaReal)
			bancoDeDados[localClienteBD][5] = extrato

			bancoDeDados[localDaContaTransferencia][3] = Tipos.real_para_cadeia(saldoEmContaTransferencia)
			bancoDeDados[localDaContaTransferencia][5] = extratoContaTransferencia

			pausarFluxo()
			menu()
			
		}
		senao{
			mensagemDeErroGenerica()
			menu()
			retorne
		}
		
	}

	
	funcao inteiro validarContaTransferencia(cadeia contaTransferencia){

		inteiro contaTransferenciaInteiro = 0
		cadeia numeroContaTransferenciaBD = ""

		para (inteiro i = 0; i < 10; i++){
				para (inteiro j = 0; j < 1; j++){
					se(bancoDeDados[i][1] == contaTransferencia) {
						contaTransferenciaInteiro = i
						numeroContaTransferenciaBD = bancoDeDados[contaTransferenciaInteiro][1]
					}
				}	
			}

		 

		se(contaTransferenciaInteiro > contasRegistradas ou numeroContaTransferenciaBD != contaTransferencia ){
			
			mensagemDeErroGenerica()
			menu()
			retorne -1
			
		}senao{
			
			retorne contaTransferenciaInteiro
		}
	}

	funcao logico validarValorTransferencia(cadeia valorTransferencia, real saldoEmContaReal){

		real valorTransferenciaReal
		
		se(Tipos.cadeia_e_inteiro(valorTransferencia,10) ou Tipos.cadeia_e_real(valorTransferencia)){
			
			valorTransferenciaReal = Tipos.cadeia_para_real(valorTransferencia)

			se (saldoEmContaReal >= valorTransferenciaReal e saldoEmContaReal > 0){
				retorne falso
			}
			
		}
		mensagemDeErroGenerica()
		retorne verdadeiro
		
	}

	funcao vazio trabalhar(){
		inteiro salario = Util.sorteia(57, 909), debitos = Util.sorteia(15, 500), valorRefeicao = Util.sorteia(30, 150)
		real saldoEmMaosReal, saldoEmContaReal = Tipos.cadeia_para_real(saldoEmConta)
		cadeia opcao
		
		escreva("\n\nTRABALHANDO!!!")
		Util.aguarde(1000)
		escreva(".")
		Util.aguarde(1000)
		escreva(".")
		Util.aguarde(1000)
		escreva(".")
		Util.aguarde(1000)
		escreva(".")
		Util.aguarde(1000)
		escreva(".")
		Util.aguarde(1000)
		escreva(".")
		Util.aguarde(1000)
		escreva(".")
		Util.aguarde(1000)
		escreva(".\n\n")

		escreva("\nVocê concluiu sua jornada de trabalho e recebeu R$:",salario,"\n")
		
		saldoEmMaosReal = Tipos.cadeia_para_real(saldoEmMaos)
		saldoEmMaosReal += salario
		saldoEmMaos = Tipos.real_para_cadeia(saldoEmMaosReal)

		bancoDeDados[localClienteBD][4] = saldoEmMaos
		
		pausarFluxo()
		
		escreva("Agora que você possui dinheiro está na hora de pagar suas contas.\n")
		escreva("Deseja pagar suas contas? S ou N\n")
		
		leia(opcao)

		escreva("Independente da opção você é obrigado a pagar suas contas!\n")
		escreva("O valor de R$",debitos," foi usado para pagar suas contas.\n")

		se(saldoEmMaosReal >= debitos) saldoEmMaosReal -= debitos
		senao {
			saldoEmContaReal -= debitos
			extrato += "\nPagamento Enviado de R$" + debitos
		}

		pausarFluxo()

		escreva("Agora que suas contas estão paga você precisa de algo para comer\n")
		escreva("Deseja comprar algo para comer? S ou N\n")

		leia(opcao)

		escreva("Independente da opção você precisa comer!\n")

		se (saldoEmMaosReal >= valorRefeicao ) {
			
			saldoEmMaosReal -= valorRefeicao
			escreva("Você comprou algo para comer e gastou R$"+valorRefeicao,"\n")
			
		}
		senao se(saldoEmContaReal >= -1000){
			
			saldoEmContaReal -= valorRefeicao
			escreva("Você comprou algo para comer e gastou R$"+valorRefeicao,"\n")
			extrato += "\nPagamento Enviado de R$" + valorRefeicao
		}

		senao{
			escreva("Parece que você não tem dinheiro suficiente para comprar algo e seu débito ja esta no limite.\n")
			escreva("Por não conseguir comprar algo para comer, agora você joga no VASCÃO! pesei o clima, Desculpa!\n")
			escreva("Sua Conta foi Encerrada. Até a próxima!\n")

			para(inteiro i = 0; i < 6; i++){
				bancoDeDados[localClienteBD][i] = ""
			}
			
			limparDados()
			pausarFluxo()
			inicio()
			retorne
		}

		saldoEmConta = Tipos.real_para_cadeia(saldoEmContaReal)
		saldoEmMaos = Tipos.real_para_cadeia(saldoEmMaosReal)

		bancoDeDados[localClienteBD][3] = saldoEmConta
		bancoDeDados[localClienteBD][4] = saldoEmMaos
		bancoDeDados[localClienteBD][5] = extrato
			
		pausarFluxo()
		menu()
		retorne
	}
	funcao limparDados(){
		senha = ""
		nome = ""
		conta = ""
	}
	funcao inteiro validarOpcao(cadeia opcao){
	
		inteiro opcaoInteiro
	
		se(Tipos.cadeia_e_inteiro(opcao, 10)){
			
			opcaoInteiro = Tipos.cadeia_para_inteiro(opcao,10)
			
			se (opcaoInteiro >= 0 e opcaoInteiro <= 6) retorne opcaoInteiro
		}
		erro()
		retorne 0
	}


	
	funcao vazio erro() {
		
		escreva("\nOpção Inválida\n")
		
		pausarFluxo()
		
		se(conta == "") inicio()
		
		senao menu()
	}

	funcao vazio mensagemDeErroGenerica(){
		escreva("\nAlgo deu errado! Tente denovo.\n")
	}

	funcao vazio pausarFluxo(){
		
		cadeia continuar
		
		escreva("\nAperte enter para continuar\n")
		
		leia(continuar)
	}

	funcao vazio sair(){
		escreva("Programa Encerrado!")
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 12997; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {bancoDeDados, 7, 8, 12}-{localClienteBD, 8, 32, 14}-{conta, 203, 9, 5}-{conta, 242, 38, 5}-{localDaContaTransferencia, 462, 10, 25}-{numeroContaTransferencia, 485, 10, 24}-{contaTransferencia, 518, 49, 18}-{contaTransferenciaInteiro, 520, 10, 25}-{numeroContaTransferenciaBD, 521, 9, 26};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */