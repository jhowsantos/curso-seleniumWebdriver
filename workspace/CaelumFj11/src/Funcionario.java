public class Funcionario {
    String nome;
    String departamento;
    double salario;
    String dataEntrada;
    String numeroRg;
    boolean estaNaEmpresa;

    public double recebeAumento(double reajuste) {

        this.salario += reajuste;

        return this.salario;
    }

    public double calculaGanhoAnual() {

        return this.salario * 12;
    }
    
    public boolean demitido (boolean demitido){
    	
    	if(demitido == false){
    		this.estaNaEmpresa = true;
    		return false;
    	} else {
    		this.estaNaEmpresa = false;
    		return true;
    	}
    }
    
    public void mostra() {
    	
    	System.out.println("Nome : " + this.nome);
    	System.out.println("Departamento : " + this.departamento);
    	System.out.println("Salario : " + this.salario);
    	System.out.println("Data da Entrada : " + this.dataEntrada);
    	System.out.println("Numero do RG : " + this.numeroRg);
    	System.out.println("Esta na empresa ? : " + this.estaNaEmpresa);
    	System.out.println(calculaGanhoAnual());
    }


}
