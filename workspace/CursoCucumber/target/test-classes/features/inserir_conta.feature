#language: pt
Funcionalidade: Cadastro de contas
	Como um usuário 
	Gostaria de cadastrar contas
	Para que eu possa distribuir meu dinheiro de uma forma mais organizada

	Contexto: 
		Dado que estou acessando a aplicação
		Quando informo o usuário "jhonatas@teste.com"
		E a senha "teste"
		E seleciono entrar
		Então visualizo a página inicial
		Quando seleciono Contas
		E seleciono Adicionar

	Esquema do Cenário: Deve validar regras cadastro contas
		Quando informo a conta "<conta>"
		E seleciono Salvar
		Então recebo a mensagem "<mensagem>"
		
		Exemplos:
			| conta 					|           mensagem 		    				 |
			| Conta de teste	| Conta adicionada com sucesso! 		 |
			|                 |   Informe o nome da conta 				 |
			| Conta de teste  | Já existe uma conta com esse nome! |
		
	