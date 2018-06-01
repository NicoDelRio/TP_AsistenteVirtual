package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clase.Asistente;

public class RF13Tests {

	public final static String USUARIO = "delucas";

	Asistente jenkins;

	@Before
	public void setup() {
		jenkins = new Asistente("jenkins");
	}

	@Test
	public void chuckNorrisFacts() {
		
		
		Assert.assertEquals(
				"¡Hola, @delucas!",
				jenkins.escuchar("Hola @jenkins.")
			);

		Assert.assertEquals(
				"@delucas, Chuck Norris arrojó una granada y mató a 50 personas, luego explotó.",
				jenkins.escuchar("@jenkins puedes decir una Chuck Norris Facts?")
			);

		Assert.assertEquals(
				"No es nada, @delucas",
				jenkins.escuchar("gracias @jenkins")
			);		

		Assert.assertEquals(
				"@delucas, Chuck Norris contó hasta el infinito. Dos veces.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"@delucas, Chuck Norris puede recoger naranjas de un manzano y hacer la mejor limonada que haya probado en su vida.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"@delucas, Una vez, una cobra mordió la pierna de Chuck Norris. Después de cinco días de dolor insoportable, la cobra murió.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"No es nada, @delucas",
				jenkins.escuchar("gracias @jenkins")
			);	
		
		Assert.assertEquals(
				"@delucas, No existe una teoría de la evolución, solo una lista de las criaturas que Chuck Norris permite vivir.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"@delucas, Chuck Norris puede matar a tus amigos imaginarios.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"@delucas, Chuck Norris es la única persona que puede golpear un cíclope entre los ojos.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"@delucas, Chuck Norris puede estrangularte con un teléfono inalámbrico.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"@delucas, Chuck puede prender fuego a las hormigas con una lupa. Por la noche.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"@delucas, Chuck Norris hace llorar a las cebollas.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"@delucas, Chuck Norris es la razón por la que Waldo se está escondiendo.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"@delucas, El tipo de sangre de Chuck Norris es AK-47.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"@delucas, Chuck Norris arrojó una granada y mató a 50 personas, luego explotó.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"@delucas, Chuck Norris contó hasta el infinito. Dos veces.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);

		Assert.assertEquals(
				"@delucas, Chuck Norris puede recoger naranjas de un manzano y hacer la mejor limonada que haya probado en su vida.",
				jenkins.escuchar("@jenkins dime otra historia de Chuck Norris")
			);



	}

}
