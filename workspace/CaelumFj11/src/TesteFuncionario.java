
public class TesteFuncionario {
	public static void main(String[] args){
		
		//Funcionario 1
		Funcionario func = new Funcionario();
		func.nome = "Jhonatas";
		func.departamento = "TI";
		func.salario = 1000;
		func.dataEntrada = "10/09/2017";
		func.numeroRg = "49.009.311-5";
		func.estaNaEmpresa = true;
		
		//Funcionario 2
		Funcionario func2 = new Funcionario();
		func2.nome = "Joao";
		func2.departamento = "ADM";
		func2.salario = 1200;
		func2.dataEntrada = "10/09/2015";
		func2.numeroRg = "40.109.300-5";
		func2.estaNaEmpresa = true;
		
		//Funcionario 3
		Funcionario func3 = func;
		
		/*
		System.out.printf("Funcionario foi contrado com o salario R$ %.2f\n" , func.salario);
		System.out.println("Todos os funcionarios receberam um bonus de R$ 500,00");
		
		func.recebeAumento(500);
		
		System.out.printf("Seu salario com reajuste é : %.2f\n" , func.salario);
		
		double ganhoAnual = func.calculaGanhoAnual();
		
		System.out.printf("O ganho anual do funcionario é : %.2f\n ", ganhoAnual);
		
		System.out.println("==================================================================");
		
		System.out.println("Data de contratação: " + func.dataEntrada);
		
		func.demitido(true);
		
		if(func.estaNaEmpresa == true){
			System.out.println("O funcionario esta ativo");
		} else {
			System.out.println("O funcionario foi desligado");
		}
		*/
		
		func.mostra();
		
		System.out.println("==================================================================");
		
		func2.mostra();
		
		System.out.println("==================================================================");
		
		if(func == func2) {
			System.out.println("Funcionario 1 igual funcionario 2");
		} else {
			System.out.println("Funcionario 1 diferente do funcionario 2");
		}
		
		if(func == func3) {
			System.out.println("Funcionario 1 igual funcionario 3");
		} else {
			System.out.println("Funcionario 1 diferente do funcionario 3");
		}
	}
}
