package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clase.Asistente;

public class RF14Tests {

	public final static String USUARIO = "delucas";

	Asistente jenkins;

	@Before
	public void setup() {
		jenkins = new Asistente("jenkins");
	}

	@Test
	public void transferenciaDeDeudas() {
		Assert.assertEquals(
				"@delucas anotado.",
				jenkins.escuchar("@jenkins @juan me debe $50")
			);
		Assert.assertEquals(
				"@delucas @juan te debe $50",
				jenkins.escuchar("@jenkins cu�nto me debe @juan?")
			);
		Assert.assertEquals(
				"@delucas anotado.",
				jenkins.escuchar("@jenkins le debo $60 a @maria")
			);
		
		Assert.assertEquals(
				"@delucas le deb�s $60 a @maria. @juan te debe $50",
				jenkins.escuchar("@jenkins cual es mi estado de deudas?")
			);
		
		Assert.assertEquals(
				"@delucas bueno.",
				jenkins.escuchar("@jenkins simplificar deudas con @juan y @maria")
			);
		
		Assert.assertEquals(
				"@delucas le deb�s $10 a @maria",
				jenkins.escuchar("@jenkins cual es mi estado de deudas?")
			);
		// por detr�s, ahora @juan le debe $50 a @maria. Podr�a probarse,
		// cambiando el interlocutor del asistente
	}
	
	@Test
	public void deudasGrupalesCasoUno() {
		
		Assert.assertEquals(
				"@delucas anotado.",
				jenkins.escuchar("@jenkins con @juan y @maria gastamos $300 y pag� @juan")
			);
		
		Assert.assertEquals(
				"@delucas le deb�s $100 a @juan",
				jenkins.escuchar("@jenkins cual es mi estado de deudas?")
			);
		// @maria le debe otros $100 a @juan
	
	}
	
	@Test
	public void deudasGrupalesCasoDos() {
		Assert.assertEquals(
				"@delucas anotado.",
				jenkins.escuchar("@jenkins con @juan y @maria gastamos $300 y pagu� yo")
			);
		
		Assert.assertEquals(
				"@delucas @juan te debe $100. @maria te debe $100",
				jenkins.escuchar("@jenkins cual es mi estado de deudas?")
			);
	}
	
	@Test
	public void deudasSimples() {
		Assert.assertEquals(
				"@delucas anotado.",
				jenkins.escuchar("@jenkins @juan me debe $500")
			);
		Assert.assertEquals(
				"@delucas @juan te debe $500",
				jenkins.escuchar("@jenkins cu�nto me debe @juan?")
			);
		
		Assert.assertEquals(
				"@delucas anotado.",
				jenkins.escuchar("@jenkins @juan me pag� $501")
			);
		Assert.assertEquals(
				"@delucas @juan no te debe nada. Vos le deb�s $1",
				jenkins.escuchar("@jenkins cu�nto me debe @juan?")
			);
		Assert.assertEquals(
				"@delucas deb�s $1 a @juan",
				jenkins.escuchar("@jenkins cu�nto le debo a @juan?")
			);
		
		Assert.assertEquals(
				"@delucas anotado.",
				jenkins.escuchar("@jenkins le pagu� a @juan $10")
			);
		Assert.assertEquals(
				"@delucas @juan te debe $9",
				jenkins.escuchar("@jenkins cu�nto me debe @juan?")
			);
		Assert.assertEquals(
				"@delucas no le deb�s nada. @juan te debe $9",
				jenkins.escuchar("@jenkins cu�nto le debo a @juan?")
			);
	}

}