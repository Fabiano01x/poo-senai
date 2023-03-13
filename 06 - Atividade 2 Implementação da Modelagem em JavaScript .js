class Cliente{

	constructor(pNome, pEndereco){
		this.Nome = pNome;
		this.Endereco = pEndereco;
	}
	get Nome(){
		return this.nome;
	}
	set Nome(pNome){
		this.nome = pNome;		
	}
	get Endereco(){
		return this.endereco;
	}
	set Endereco(pEndereco){
		this.endereco = pEndereco;
	}
}

class PessoaFisica extends Cliente {

	constructor(pNome, pEndereco, pCPF, pDataNascimento){
		super(pNome, pEndereco);
		this.CPF = pCPF;
		this.DataNascimento = pDataNascimento;
	}
	get CPF(){
		return this.cpf;
	}
	set CPF(pCPF){
		this.cpf = pCPF;
	}
	get DataNascimento(){
		return this.dataNascimento;
	}
	set DataNascimento(pDataNascimento){
		this.dataNascimento = pDataNascimento;
	}


}

 class PessoaJuridica extends Cliente {

	constructor(pNome, pEndereco, pCNPJ, pRazaoSocial){
		super(pNome, pEndereco);
		this.CNPJ = pCNPJ;
		this.RazaoSocial = pRazaoSocial;
	}

	get CNPJ(){
		return this.cnpj;
	}
	set CNPJ(pCNPJ){
		this.cnpj = pCNPJ;
	}
	get RazaoSocial(){
		return this.razaoSocial;
	}
	set RazaoSocial(pRazaoSocial){
		this.razaoSocial = pRazaoSocial;
	}

}


var pessoa_fisica = new PessoaFisica('Paulo', 'Rua Limeira, 3224', '022.534.56-03', '01/03/2003');

console.log("Cliente: "+ pessoa_fisica.Nome +"   |   Endereço: "+ pessoa_fisica.Endereco +"   |   CPF: "+ pessoa_fisica.CPF +"   |   Data de nascimento: "+ pessoa_fisica.DataNascimento);
console.log("\n\n");


var pessoa_juridica = new PessoaJuridica('Clara', 'Rua Dom Pedro, 1432', '07.538.980/0033-54', 'Lavim ltda');
console.log("Cliente: "+ pessoa_juridica.Nome +"   |   Endereço: "+ pessoa_juridica.Endereco +"   |   CNPJ: "+ pessoa_juridica.CNPJ +"   |   Razão Social: "+ pessoa_juridica.RazaoSocial);
