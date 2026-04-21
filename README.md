# 🛥️ Lógica de Programação - PROA

Este repositório contém as soluções para os exercícios de **Lógica de Programação** do curso do **Instituto PROA**. Os exercícios ("Hora de Codar") foram desenvolvidos utilizando tanto a linguagem **Kotlin** quanto **Portugol**.

## 📁 Estrutura do Projeto

O projeto está dividido em duas partes principais dentro do diretório raiz:

### 🔹 Kotlin (`Kotlin/`)
Contém as soluções e sistemas desenvolvidos na linguagem Kotlin, evoluindo desde conceitos básicos até aplicações orientadas a objetos.

* 🔢 **HoraDeCodar01** a **HoraDeCodar04**: Exercícios fundamentais de lógica abordando variáveis, estruturas condicionais, laços de repetição e manipulação de dados básicos.
* 🏦 **HoraDeCodar05**: Um projeto simulando um **Sistema de Caixa Eletrônico (Banco Tchan)**. O sistema contempla as seguintes operações bancárias:
  * 🆕 **Criação de Conta** (com validação de nome e senha numérica)
  * 🔐 **Acesso à Conta** (autenticação por número da conta e senha)
  * 💰 **Gestão Financeira** (ver saldo, depositar, sacar e transferir entre contas)
  * 🧾 **Extrato Bancário** (histórico de todas as transações)
  * 💼 **Mecânicas de Dinheiro** ("Trabalhar" para ganhar dinheiro e "Pagar Boletos" aleatórios com risco de exclusão por inadimplência)
  * 🐯 **Minigame** (aposta no "Tigrinho" com multiplicadores)
* 🏨 **HoraDeCodar07**: Um projeto completo e estruturado simulando um **Sistema de Gestão de Hotel**. O sistema está modularizado contemplando:
  * 🔑 **Autenticação de Funcionários** e navegação por **Menus**
  * 🛏️ **Gestão de Hóspedes** (cadastro, pesquisa, atualização e exclusão)
  * 📅 **Reservas de Quartos**
  * 🎉 **Gestão de Eventos** (reserva de auditórios, custo de garçons e buffet)
  * 🛠️ **Manutenção de Ares-Condicionados**
  * ⛽ **Abastecimento de veículos**
  * 📊 **Geração de Relatórios**
* 🐾 **HoraDeCodar08**: Um projeto simulando um jogo de **Bichinho Virtual (Virtual Pet)**, focado em Orientação a Objetos. O sistema está modularizado contemplando:
  * 🧬 **Base** (definição da estrutura principal e atributos do Pet)
  * 🎮 **Lógica do Jogo** (criação de pets, validações de entrada e mecânicas de interação do Virtual Pet)
  * 🐕 **Catálogo de Animais** (implementações específicas de animais como Cachorro, Gato, Cavalo, Coelho, etc.)
  * ⚙️ **Utilitários** (funções auxiliares para o jogo)

### 🔹 Portugol (`Portugol/`)
Contém os algoritmos desenvolvidos em pseudocódigo utilizando o **Portugol Studio**. Esta etapa foca na base puramente lógica antes da transição para o Kotlin.

* 🔢 Exercícios equivalentes das trilhas **HoraDeCodar01**, **HoraDeCodar02**, **HoraDeCodar03**.
* 🏦 **HoraDeCodar05**: Projeto em pseudocódigo simulando o **Sistema de Caixa Eletrônico (Banco Tchan)**. O sistema contempla as lógicas básicas de:
  * 🆕 **Criação de Conta** (nome, senha e geração de número da conta)
  * 🔐 **Acesso e Autenticação** (autenticação por número da conta e senha)
  * 💰 **Operações Bancárias** (ver saldo, depositar, sacar, transferir e extrato)
  * 💼 **Mecânicas Extras** ("Trabalhar" para ganhar dinheiro, gerenciar débitos, comprar refeições com risco de falência e exclusão da conta)

## 💻 Tecnologias e Ferramentas Utilizadas
* 🟣 **Kotlin**
* 📝 **Portugol (Portugol Studio)**
* 💻 **IntelliJ IDEA**
* 🐙 **Git e GitHub**
* ☕ **JDK 21+ (Java Development Kit)**

## 📚 Demonstrações
> Clique nos títulos abaixo para expandir e assistir ao vídeo de cada exercício em execução.
<details>
  <summary><b>🎬 Hora de Codar 05 - BancoTchan (Portugol)</b></summary>
  <br>
  <p align="center">
    <video src="https://github.com/user-attachments/assets/7230403f-470a-41dc-aa88-1e41cd20af82" width="100%" controls>
      Seu navegador não suporta a reprodução de vídeos.
    </video>
  </p>
</details>

<details>
  <summary><b>🎬 Hora de Codar 05 - BancoTchan (Kotlin)</b></summary>
  <br>
  <p align="center">
    <video src="https://github.com/user-attachments/assets/dab7165b-35a3-46bf-9fd3-83f5fa46ba22" width="100%" controls>Seu navegador não suporta a reprodução de vídeos.</video>

  </p>
</details>
<details>
  <summary><b>🎬 Hora de Codar 07 - Tasokare Hotel (Kotlin)</b></summary>
  <br>
  <p align="center">
    <video src="https://github.com/user-attachments/assets/0e8cb645-7bc1-4f4c-86c7-51cd5c945e8a" width="100%" controls>Seu navegador não suporta a reprodução de vídeos.</video>
  </p>
</details>
<details>
  <summary><b>🎬 Hora de Codar 08 - Pet Virtual (Kotlin)</b></summary>
  <br>
  <p align="center">
    <video src="https://github.com/user-attachments/assets/42be03b1-ba57-4ab8-96d9-1c1f269abe7e" width="100%" controls>Seu navegador não suporta a reprodução de vídeos.</video>
  </p>
</details>

## 🎯 Objetivo
Desenvolver, consolidar e evoluir o pensamento lógico de programação, começando pelas bases dos algoritmos e progredindo até a construção de mini-sistemas bem estruturados, utilizando boas práticas e separação de responsabilidades.

## 🚀 Como Executar (Passo a Passo)

### 🟣 Para os projetos em Kotlin:
1. Clique no botão verde **Code** e baixe o ZIP completo deste repositório.
2. Extraia os arquivos do ZIP para uma pasta em seu computador.
3. Abra a sua IDE de preferência (como o IntelliJ IDEA) e inicie um **Novo Projeto Kotlin**.
4. Copie a pasta que você extraiu e cole para dentro do diretório principal de código do seu novo projeto (geralmente dentro da pasta `src/main/kotlin`).
5. Abra a pasta do exercício na sua IDE, localize o arquivo `.kt` desejado ou o arquivo `Main.kt` (para exercícios que possuem múltiplos arquivos) e execute o programa clicando no botão de *Run* (▶️).

### 📝 Para os projetos em Portugol:
1. Baixe os arquivos com a extensão `.por` localizados dentro do diretório `Portugol/`.
2. Para executar, você tem duas opções:
  * **Via Navegador (Recomendado pela praticidade):** Acesse o site [Portugol Webstudio](https://portugol.dev/), cole o código do arquivo baixado no editor online ou use a opção de abrir arquivo, e clique em executar.
  * **Instalação Local:** Faça o download e instale o [Portugol Studio](https://univali-lite.github.io/Portugol-Studio/). Abra o programa, clique em "Abrir Arquivo", selecione o `.por` que você baixou e clique em "Executar".

---
👨‍💻 **Desenvolvido por Diogo Melo**
