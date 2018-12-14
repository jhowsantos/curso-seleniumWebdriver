package test;

import org.junit.Assert;
import org.junit.Test;

import main.Gerente;

public class DarPromocaoTest {
	
	@Test
	public void testGerenteAutorizadoParaDarPromocao(){
		
		//Criando um gerente com permissão para dar promoção
		Gerente gerente1 = new Gerente("José", true);
		//Criando um gerente sem permissão para dar promoção
		Gerente gerente2 = new Gerente("Silva", false);
		
		//Verifica se gerente1 pode dar promoção
		Assert.assertTrue(gerente1.isPodeDarPromocao());
		
		//Verifica se gerente2 não pode dar promoção
		Assert.assertFalse(gerente2.isPodeDarPromocao());
	}
	
	

}
