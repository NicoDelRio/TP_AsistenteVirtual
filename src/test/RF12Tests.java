package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clase.Asistente;

public class RF12Tests {

	public final static String USUARIO = "delucas";

	Asistente jenkins;

	@Before
	public void setup() {
		jenkins = new Asistente("jenkins");
	}

	@Test
	public void leyesRobotica() {
		
        String[] mensajes = {
                "@jenkins, recuerdame las 3 leyes de la robótica",
                "¿@jenkins, cuales son las 3 leyes de la robótica?",
                "@jenkins dime las 3 leyes de la robótica",
                "@jenkins decime las leyes de la robótica"
            };
        
        for (String mensaje : mensajes) {
			Assert.assertEquals(
					"@delucas, las tres leyes de la robótica son: \n" +
					"1- Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.\n" + 
					"2- Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.\n" + 
					"3- Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley",
					jenkins.escuchar(mensaje)
			);
        };

		Assert.assertEquals(
				"@delucas, la primera ley de la robótica es: \n" +
				"Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.",
				jenkins.escuchar("@jenkins dime la primera ley de la robótica.")
			);	

		Assert.assertEquals(
				"@delucas, la primera ley de la robótica es: \n" +
				"Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.",
				jenkins.escuchar("@jenkins dime la 1ra ley de la robótica.")
			);	
		
		Assert.assertEquals(
				"@delucas, la segundea ley de la robótica es: \n" +
				"Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.",
				jenkins.escuchar("@jenkins dime la segundea ley de la robótica.")
			);	

		Assert.assertEquals(
				"@delucas, la segundea ley de la robótica es: \n" +
				"Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.",
				jenkins.escuchar("@jenkins dime la 2da ley de la robótica.")
			);	
		
		Assert.assertEquals(
				"@delucas, la tercera ley de la robótica es: \n" +
						"Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley",
				jenkins.escuchar("@jenkins dime la tercera ley de la robótica.")
			);	
		
		Assert.assertEquals(
				"@delucas, la tercera ley de la robótica es: \n" +
						"Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley",
				jenkins.escuchar("@jenkins dime la 3ra ley de la robótica.")
			);	
		
	}
}
