package test;

import clase.Asistente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RF11Tests {

	public final static String USUARIO = "delucas";

	Asistente jenkins;

	@Before
	public void setup() {
		jenkins = new Asistente("jenkins");
	}

	@Test
	public void unidadesDeMasa() {
		
		
		Assert.assertEquals(
				"@delucas 1 kilo equivale a 1000 gramos",
				jenkins.escuchar("@jenkins cuántos gramos son 1 kilo")
			);

		Assert.assertEquals(
				"@delucas 1000 gramos equivalen a 1 kilo",
				jenkins.escuchar("@jenkins cuántos kilos son 1000 gramos")
			);
		
		Assert.assertEquals(
				"@delucas 1000 gramos equivalen a 35.27 onzas",
				jenkins.escuchar("@jenkins cuántas onzas son 1000 gramos")
			);		

		Assert.assertEquals(
				"@delucas 12.5 toneladas equivalen a 12500 kilos",
				jenkins.escuchar("@jenkins cuántos kilos son 12.5 toneladas")
			);
		
		Assert.assertEquals(
				"@delucas 100.25 onzas equivalen a 2.84 kilos",
				jenkins.escuchar("@jenkins cuántos kilos son 100.25 onzas")
			);
		
		Assert.assertEquals(
				"@delucas 25.26 libras equivalen a 11.46 kilos",
				jenkins.escuchar("@jenkins cuántos kilos son 25.26 libras")
			);
		
		Assert.assertEquals(
				"@delucas 38 stones equivalen a 241.31 kilos",
				jenkins.escuchar("@jenkins cuántos kilos son 38 stones")
			);
		
		
		Assert.assertEquals(
				"@delucas 38 kilos equivalen a 38000 gramos",
				jenkins.escuchar("@jenkins cuántos gramos son 38 kilos")
			);
		
		Assert.assertEquals(
				"@delucas 0.60 tonelada equivale a 600000 gramos",
				jenkins.escuchar("@jenkins cuántos gramos son 0.60 tonelada")
			);
		
		Assert.assertEquals(
				"@delucas 25.50 onzas equivalen a 722.91 gramos",
				jenkins.escuchar("@jenkins cuántos gramos son 25.50 onzas")
			);
		
		Assert.assertEquals(
				"@delucas 75.50 libras equivalen a 34246.26 gramos",
				jenkins.escuchar("@jenkins cuántos gramos son 75.50 libras")
			);
		
		Assert.assertEquals(
				"@delucas 20 stones equivalen a 127005.90 gramos",
				jenkins.escuchar("@jenkins cuántos gramos son 20 stones")
			);
		
		
		Assert.assertEquals(
				"@delucas 1500 kilos equivalen a 1.50 toneladas",
				jenkins.escuchar("@jenkins cuántas toneladas son 1500 kilos")
			);

		Assert.assertEquals(
				"@delucas 500000 gramos equivalen a 0.50 tonelada",
				jenkins.escuchar("@jenkins cuántas toneladas son 500000 gramos")
			);
		
		Assert.assertEquals(
				"@delucas 40000 onzas equivalen a 1.13 toneladas",
				jenkins.escuchar("@jenkins cuántas toneladas son 40000 onzas")
			);
		
		Assert.assertEquals(
				"@delucas 3600 libras equivalen a 1.63 toneladas",
				jenkins.escuchar("@jenkins cuántas toneladas son 3600 libras")
			);
		
		Assert.assertEquals(
				"@delucas 30000 stones equivalen a 190.51 toneladas",
				jenkins.escuchar("@jenkins cuántas toneladas son 30000 stones")
			);
		
		
		Assert.assertEquals(
				"@delucas 1 kilo equivale a 35.27 onzas",
				jenkins.escuchar("@jenkins cuántas onzas son 1 kilo")
			);
		
		Assert.assertEquals(
				"@delucas 2.5 kilos equivalen a 88.19 onzas",
				jenkins.escuchar("@jenkins cuántas onzas son 2.5 kilos")
			);
		
		Assert.assertEquals(
				"@delucas 80.50 gramos equivalen a 2.84 onzas",
				jenkins.escuchar("@jenkins cuántas onzas son 80.50 gramos")
			);
		
		Assert.assertEquals(
				"@delucas 2 toneladas equivalen a 70548 onzas",
				jenkins.escuchar("@jenkins cuántas onzas son 2 toneladas")
			);
		
		Assert.assertEquals(
				"@delucas 15.50 libras equivalen a 248 onzas",
				jenkins.escuchar("@jenkins cuántas onzas son 15.50 libras")
			);
		
		Assert.assertEquals(
				"@delucas 1 stone equivale a 224 onzas",
				jenkins.escuchar("@jenkins cuántos onzas son 1 stone")
			);

		Assert.assertEquals(
				"@delucas 2 stones equivalen a 448 onzas",
				jenkins.escuchar("@jenkins cuántos onzas son 2 stones")
			);
		
		Assert.assertEquals(
				"@delucas 0.25 stone equivale a 56 onzas",
				jenkins.escuchar("@jenkins cuántos onzas son 0.25 stone")
			);
		
		
		Assert.assertEquals(
				"@delucas 1 kilo equivale a 2.20 libras",
				jenkins.escuchar("@jenkins cuántas libras son 1 kilo")
			);

		Assert.assertEquals(
				"@delucas 2.50 kilos equivalen a 5.51 libras",
				jenkins.escuchar("@jenkins cuántas libras son 2.50 kilos")
			);
		
		Assert.assertEquals(
				"@delucas 500 gramos equivalen a 1.10 libras",
				jenkins.escuchar("@jenkins cuántas libras son 500 gramos")
			);
		
		Assert.assertEquals(
				"@delucas 2.50 toneladas equivalen a 5511.55 libras",
				jenkins.escuchar("@jenkins cuántas libras son 2.50 toneladas")
			);
		
		Assert.assertEquals(
				"@delucas 2 toneladas equivalen a 4409.24 libras",
				jenkins.escuchar("@jenkins cuántas libras son 2 toneladas")
			);
		
		Assert.assertEquals(
				"@delucas 1 onza equivale a 0.06 libra",
				jenkins.escuchar("@jenkins cuántas libras son 1 onza")
			);
		
		Assert.assertEquals(
				"@delucas 0.50 onza equivale a 0.03 libra",
				jenkins.escuchar("@jenkins cuántas libras son 0.50 onza")
			);
		
		Assert.assertEquals(
				"@delucas 1000 onzas equivalen a 62.50 libras",
				jenkins.escuchar("@jenkins cuántas libras son 1000 onzas")
			);

		Assert.assertEquals(
				"@delucas 1 stone equivale a 14 libras",
				jenkins.escuchar("@jenkins cuántas libras son 1 stone")
			);
		
		Assert.assertEquals(
				"@delucas 2 stones equivalen a 28 libras",
				jenkins.escuchar("@jenkins cuántas libras son 2 stones")
			);
		
		
		Assert.assertEquals(
				"@delucas 1 kilo equivale a 0.16 stone",
				jenkins.escuchar("@jenkins cuántos stones son 1 kilo")
			);

		Assert.assertEquals(
				"@delucas 2 toneladas equivalen a 314.95 stones",
				jenkins.escuchar("@jenkins cuántos stones son 2 toneladas")
			);
		
		Assert.assertEquals(
				"@delucas 5000 gramos equivalen a 0.79 stone",
				jenkins.escuchar("@jenkins cuántos stones son 5000 gramos")
			);
		
		Assert.assertEquals(
				"@delucas 1000 onzas equivalen a 4.46 stones",
				jenkins.escuchar("@jenkins cuántos stones son 1000 onzas")
			);

		Assert.assertEquals(
				"@delucas 448 onzas equivalen a 2 stones",
				jenkins.escuchar("@jenkins cuántos stones son 448 onzas")
			);

		Assert.assertEquals(
				"@delucas 28 libras equivalen a 2 stones",
				jenkins.escuchar("@jenkins cuántas stones son 28 libras")
			);

		Assert.assertEquals(
				"@delucas 224 onzas equivalen a 1 stone",
				jenkins.escuchar("@jenkins cuántos stones son 224 onzas")
			);

		Assert.assertEquals(
				"@delucas 14 libras equivalen a 1 stone",
				jenkins.escuchar("@jenkins cuántas stones son 14 libras")
			);
	

	}
	
	@Test
	public void unidadesDeLongitud() {
		
		
		Assert.assertEquals(
				"@delucas 1850 centímetros equivalen a 18.50 metros",
				jenkins.escuchar("@jenkins cuántos metros son 1850 centimetros")
			);

		Assert.assertEquals(
				"@delucas 2000 centímetros equivalen a 20 metros",
				jenkins.escuchar("@jenkins cuántos metros son 2000 centímetros")
			);
		
		Assert.assertEquals(
				"@delucas 18.5 kilómetros equivalen a 18500 metros",
				jenkins.escuchar("@jenkins cuántos metros son 18.5 kilometros")
			);
		
		Assert.assertEquals(
				"@delucas 0.50 kilómetro equivale a 500 metros",
				jenkins.escuchar("@jenkins cuántos metros son 0.50 kilómetro")
			);
		
		Assert.assertEquals(
				"@delucas 35 pulgadas equivalen a 0.89 metro",
				jenkins.escuchar("@jenkins cuántos metros son 35 pulgadas")
			);
		
		Assert.assertEquals(
				"@delucas 10 yardas equivalen a 9.14 metros",
				jenkins.escuchar("@jenkins cuántos metros son 10 yardas")
			);
		
		Assert.assertEquals(
				"@delucas 66.85 yardas equivalen a 61.13 metros",
				jenkins.escuchar("@jenkins cuántos metros son 66.85 yardas")
			);
		
		Assert.assertEquals(
				"@delucas 2.8 millas equivalen a 4506.16 metros",
				jenkins.escuchar("@jenkins cuántos metros son 2.8 millas")
			);
		
		
		Assert.assertEquals(
				"@delucas 0.25 metro equivale a 25 centímetros",
				jenkins.escuchar("@jenkins cuántos centimetros son 0.25 metro")
			);
		
		Assert.assertEquals(
				"@delucas 0.25 kilómetro equivale a 25000 centímetros",
				jenkins.escuchar("@jenkins cuántos centimetros son 0.25 kilometro")
			);
		
		Assert.assertEquals(
				"@delucas 14 pulgadas equivalen a 35.56 centímetros",
				jenkins.escuchar("@jenkins cuántos centímetros son 14 pulgadas")
			);
		
		Assert.assertEquals(
				"@delucas 32 pulgadas equivalen a 81.28 centímetros",
				jenkins.escuchar("@jenkins cuántos centímetros son 32 pulgadas")
			);
		
		Assert.assertEquals(
				"@delucas 52 pulgadas equivalen a 132.08 centímetros",
				jenkins.escuchar("@jenkins cuántos centímetros son 52 pulgadas")
			);
	
		Assert.assertEquals(
				"@delucas 2 yardas equivalen a 182.88 centímetros",
				jenkins.escuchar("@jenkins cuántos centímetros son 2 yardas")
			);
		
		Assert.assertEquals(
				"@delucas 3 millas equivalen a 482803.35 centímetros",
				jenkins.escuchar("@jenkins cuántos centímetros son 3 millas")
			);
		
		Assert.assertEquals(
				"@delucas 0.33 milla equivale a 53108.37 centímetros",
				jenkins.escuchar("@jenkins cuántos centímetros son 0.33 milla")
			);
		
		
		Assert.assertEquals(
				"@delucas 3500 metros equivalen a 3.50 kilómetros",
				jenkins.escuchar("@jenkins cuántos kilómetros son 3500 metros")
			);
		
		Assert.assertEquals(
				"@delucas 8000 centímetros equivalen a 0.08 kilómetro",
				jenkins.escuchar("@jenkins cuántos kilómetros son 8000 centímetros")
			);
		
		Assert.assertEquals(
				"@delucas 100000 pulgadas equivalen a 2.54 kilómetros",
				jenkins.escuchar("@jenkins cuántos kilómetros son 100000 pulgadas")
			);
		
		Assert.assertEquals(
				"@delucas 350 yardas equivalen a 0.32 kilómetro",
				jenkins.escuchar("@jenkins cuántos kilómetros son 350 yardas")
			);
		
		Assert.assertEquals(
				"@delucas 350 millas equivalen a 563.27 kilómetros",
				jenkins.escuchar("@jenkins cuántos kilómetros son 350 millas")
			);
		
		
		Assert.assertEquals(
				"@delucas 35 centímetros equivalen a 13.78 pulgadas",
				jenkins.escuchar("@jenkins cuántas pulgadas son 35 centímetros")
			);
		
		Assert.assertEquals(
				"@delucas 10 metros equivalen a 393.70 pulgadas",
				jenkins.escuchar("@jenkins cuántas pulgadas son 10 metros")
			);
		
		Assert.assertEquals(
				"@delucas 2 kilómetros equivalen a 78740.20 pulgadas",
				jenkins.escuchar("@jenkins cuántas pulgadas son 2 kilómetros")
			);
		
		Assert.assertEquals(
				"@delucas 2 yardas equivalen a 72 pulgadas",
				jenkins.escuchar("@jenkins cuántas pulgadas son 2 yardas")
			);
		
		Assert.assertEquals(
				"@delucas 1 milla equivale a 63360.05 pulgadas",
				jenkins.escuchar("@jenkins cuántas pulgadas son 1 milla")
			);
		
		
		Assert.assertEquals(
				"@delucas 1 metro equivale a 1.09 yardas",
				jenkins.escuchar("@jenkins cuántas yardas son 1 metro")
			);
		
		Assert.assertEquals(
				"@delucas 10 centímetros equivalen a 0.11 yarda",
				jenkins.escuchar("@jenkins cuántas yardas son 10 centímetros")
			);
		
		Assert.assertEquals(
				"@delucas 5 kilómetros equivalen a 5468.05 yardas",
				jenkins.escuchar("@jenkins cuántas yardas son 5 kilómetros")
			);
		
		Assert.assertEquals(
				"@delucas 50 pulgadas equivalen a 1.39 yardas",
				jenkins.escuchar("@jenkins cuántas yardas son 50 pulgadas")
			);
		
		Assert.assertEquals(
				"@delucas 40 millas equivalen a 70399.81 yardas",
				jenkins.escuchar("@jenkins cuántas yardas son 40 millas")
			);
		
		
		Assert.assertEquals(
				"@delucas 5000 metros equivalen a 3.11 millas",
				jenkins.escuchar("@jenkins cuántas millas son 5000 metros")
			);
		
		Assert.assertEquals(
				"@delucas 50 kilómetros equivalen a 31.07 millas",
				jenkins.escuchar("@jenkins cuántas millas son 50 kilómetros")
			);
		
		Assert.assertEquals(
				"@delucas 20000 centímetros equivalen a 0.12 milla",
				jenkins.escuchar("@jenkins cuántas millas son 20000 centímetros")
			);
	
		Assert.assertEquals(
				"@delucas 10000 pulgadas equivalen a 0.16 milla",
				jenkins.escuchar("@jenkins cuántas millas son 10000 pulgadas")
			);
		
		Assert.assertEquals(
				"@delucas 500 yardas equivalen a 0.28 milla",
				jenkins.escuchar("@jenkins cuántas millas son 500 yardas")
			);
		
		Assert.assertEquals(
				"@delucas 8000 yardas equivalen a 4.55 millas",
				jenkins.escuchar("@jenkins cuántas millas son 8000 yardas")
			);
		
		
		
	}
	
	@Test
	public void unidadesDeVolumen() {


		Assert.assertEquals(
				"@delucas 7850 mililitros equivalen a 7.85 litros",
				jenkins.escuchar("@jenkins cuántos litros son 7850 mililitros")
			);

		Assert.assertEquals(
				"@delucas 2.78 metros cúbicos equivalen a 2780 litros",
				jenkins.escuchar("@jenkins cuántos litros son 2.78 metros cúbicos")
			);
		
		Assert.assertEquals(
				"@delucas 2 metros cúbicos equivalen a 2000 litros",
				jenkins.escuchar("@jenkins cuántos litros son 2 metros cúbicos")
			);

		Assert.assertEquals(
				"@delucas 1 metro cúbico equivale a 1000 litros",
				jenkins.escuchar("@jenkins cuántos litros son 1 metro cúbico")
			);

		Assert.assertEquals(
				"@delucas 32 galones equivalen a 121.13 litros",
				jenkins.escuchar("@jenkins cuántos litros son 32 galones")
			);
		
		Assert.assertEquals(
				"@delucas 2.60 galones equivalen a 9.84 litros",
				jenkins.escuchar("@jenkins cuántos litros son 2.60 galones")
			);
		
		Assert.assertEquals(
				"@delucas 15 barriles equivalen a 2384.81 litros",
				jenkins.escuchar("@jenkins cuántos litros son 15 barriles")
			);
		
		Assert.assertEquals(
				"@delucas 10 barriles equivalen a 1589.87 litros",
				jenkins.escuchar("@jenkins cuántos litros son 10 barriles")
			);
		
		Assert.assertEquals(
				"@delucas 1 barril equivale a 158.99 litros",
				jenkins.escuchar("@jenkins cuántos litros son 1 barril")
			);
		
		Assert.assertEquals(
				"@delucas 15 cuartos equivalen a 14.20 litros",
				jenkins.escuchar("@jenkins cuántos litros son 15 cuartos")
			);
		
		Assert.assertEquals(
				"@delucas 10 cuartos equivalen a 9.46 litros",
				jenkins.escuchar("@jenkins cuántos litros son 10 cuartos")
			);
		
		Assert.assertEquals(
				"@delucas 1 cuarto equivale a 0.95 litro",
				jenkins.escuchar("@jenkins cuántos litros son 1 cuarto")
			);
		
		
		Assert.assertEquals(
				"@delucas 2.50 litros equivalen a 2500 mililitros",
				jenkins.escuchar("@jenkins cuántos mililitros son 2.50 litros")
			);
		
		Assert.assertEquals(
				"@delucas 0.85 litro equivale a 850 mililitros",
				jenkins.escuchar("@jenkins cuántos mililitros son 0.85 litro")
			);
		
		Assert.assertEquals(
				"@delucas 1 metro cúbico equivale a 1000000 mililitros",
				jenkins.escuchar("@jenkins cuántos mililitros son 1 metro cúbico")
			);
		
		Assert.assertEquals(
				"@delucas 1.6 metros cúbicos equivalen a 1600000 mililitros",
				jenkins.escuchar("@jenkins cuántos mililitros son 1.6 metros cúbicos")
			);
		
		Assert.assertEquals(
				"@delucas 2 galones equivalen a 7570.83 mililitros",
				jenkins.escuchar("@jenkins cuántos mililitros son 2 galones")
			);
		
		Assert.assertEquals(
				"@delucas 2 barriles equivalen a 317974.60 mililitros",
				jenkins.escuchar("@jenkins cuántos mililitros son 2 barriles")
			);
		
		Assert.assertEquals(
				"@delucas 1 cuarto equivale a 946.35 mililitros",
				jenkins.escuchar("@jenkins cuántos mililitros son 1 cuarto")
			);
		
		
		Assert.assertEquals(
				"@delucas 2800 litros equivalen a 2.80 metros cúbicos",
				jenkins.escuchar("@jenkins cuántos metros cúbicos son 2800 litros")
			);

		Assert.assertEquals(
				"@delucas 1000 litros equivalen a 1 metro cúbico",
				jenkins.escuchar("@jenkins cuántos metros cúbicos son 1000 litros")
			);
		
		Assert.assertEquals(
				"@delucas 100000 mililitros equivalen a 0.10 metro cúbico",
				jenkins.escuchar("@jenkins cuántos metros cúbicos son 100000 mililitros")
			);
		
		Assert.assertEquals(
				"@delucas 500 galones equivalen a 1.89 metros cúbicos",
				jenkins.escuchar("@jenkins cuántos metros cúbicos son 500 galones")
			);
		
		Assert.assertEquals(
				"@delucas 6.8 barriles equivalen a 1.08 metros cúbicos",
				jenkins.escuchar("@jenkins cuántos metros cúbicos son 6.8 barriles")
			);
		
		Assert.assertEquals(
				"@delucas 1500 cuartos equivalen a 1.42 metros cúbicos",
				jenkins.escuchar("@jenkins cuántos metros cúbicos son 1500 cuartos")
			);
		
		
		Assert.assertEquals(
				"@delucas 15 litros equivalen a 3.96 galones",
				jenkins.escuchar("@jenkins cuántos galones son 15 litros")
			);
		
		Assert.assertEquals(
				"@delucas 1 litro equivale a 0.26 galón",
				jenkins.escuchar("@jenkins cuántos galones son 1 litro")
			);
		
		Assert.assertEquals(
				"@delucas 1700 mililitros equivalen a 0.45 galón",
				jenkins.escuchar("@jenkins cuántos galones son 1700 mililitros")
			);
		
		Assert.assertEquals(
				"@delucas 15 metros cúbicos equivalen a 3962.58 galones",
				jenkins.escuchar("@jenkins cuántos galones son 15 metros cúbicos")
			);
		
		Assert.assertEquals(
				"@delucas 10 barriles equivalen a 420 galones",
				jenkins.escuchar("@jenkins cuántos galones son 10 barriles")
			);
		
		Assert.assertEquals(
				"@delucas 5 cuartos equivalen a 1.25 galones",
				jenkins.escuchar("@jenkins cuántos galones son 5 cuartos")
			);
		
		
		Assert.assertEquals(
				"@delucas 50 litros equivalen a 0.31 barril",
				jenkins.escuchar("@jenkins cuántos barriles son 50 litros")
			);
		
		Assert.assertEquals(
				"@delucas 10000 mililitros equivalen a 0.06 barril",
				jenkins.escuchar("@jenkins cuántos barriles son 10000 mililitros")
			);
		
		Assert.assertEquals(
				"@delucas 20 metros cúbicos equivalen a 125.80 barriles",
				jenkins.escuchar("@jenkins cuántos barriles son 20 metros cúbicos")
			);
		
		Assert.assertEquals(
				"@delucas 150 galones equivalen a 3.57 barriles",
				jenkins.escuchar("@jenkins cuántos barriles son 150 galones")
			);
		
		Assert.assertEquals(
				"@delucas 80 cuartos equivalen a 0.48 barril",
				jenkins.escuchar("@jenkins cuántos barriles son 80 cuartos")
			);
		
		
		Assert.assertEquals(
				"@delucas 1 litro equivale a 1.06 cuartos",
				jenkins.escuchar("@jenkins cuántos cuartos son 1 litro")
			);
		
		Assert.assertEquals(
				"@delucas 5000 mililitros equivalen a 5.28 cuartos",
				jenkins.escuchar("@jenkins cuántos cuartos son 5000 mililitros")
			);
		
		Assert.assertEquals(
				"@delucas 5 metros cúbicos equivalen a 5283.44 cuartos",
				jenkins.escuchar("@jenkins cuántos cuartos son 5 metros cúbicos")
			);
		
		Assert.assertEquals(
				"@delucas 10 galones equivalen a 40 cuartos",
				jenkins.escuchar("@jenkins cuántos cuartos son 10 galones")
			);
		
		Assert.assertEquals(
				"@delucas 5 barriles equivalen a 840 cuartos",
				jenkins.escuchar("@jenkins cuántos cuartos son 5 barriles")
			);
		
	}

	@Test
	public void unidadesDeTiempo() {

		Assert.assertEquals(
				"@delucas 1 segundo equivale a 1000 milisegundos",
				jenkins.escuchar("@jenkins cuántos milisegundos son 1 segundo")
			);

		Assert.assertEquals(
				"@delucas 3.5 segundos equivalen a 3500 milisegundos",
				jenkins.escuchar("@jenkins cuántos milisegundos son 3.5 segundos")
			);

		Assert.assertEquals(
				"@delucas 2 minutos equivalen a 120000 milisegundos",
				jenkins.escuchar("@jenkins cuántos milisegundos son 2 minutos")
			);

		Assert.assertEquals(
				"@delucas 1 hora equivale a 3600000 milisegundos",
				jenkins.escuchar("@jenkins cuántos milisegundos son 1 hora")
			);
		
		Assert.assertEquals(
				"@delucas 1 día equivale a 86400000 milisegundos",
				jenkins.escuchar("@jenkins cuántos milisegundos son 1 día")
			);
		
		Assert.assertEquals(
				"@delucas 1 semana equivale a 604800000 milisegundos",
				jenkins.escuchar("@jenkins cuántos milisegundos son 1 semana")
			);
		
		
		Assert.assertEquals(
				"@delucas 350 milisegundos equivalen a 0.35 segundo",
				jenkins.escuchar("@jenkins cuántos segundos son 350 milisegundos")
			);
		
		Assert.assertEquals(
				"@delucas 60 minutos equivalen a 3600 segundos",
				jenkins.escuchar("@jenkins cuántos segundos son 60 minutos")
			);
		
		Assert.assertEquals(
				"@delucas 24 horas equivalen a 86400 segundos",
				jenkins.escuchar("@jenkins cuántos segundos son 24 horas")
			);
		
		Assert.assertEquals(
				"@delucas 1 día equivale a 86400 segundos",
				jenkins.escuchar("@jenkins cuántos segundos son 1 día")
			);
		
		Assert.assertEquals(
				"@delucas 1 semana equivale a 604800 segundos",
				jenkins.escuchar("@jenkins cuántos segundos son 1 semana")
			);
		
		
		Assert.assertEquals(
				"@delucas 60000 milisegundos equivalen a 1 minuto",
				jenkins.escuchar("@jenkins cuántos minutos son 60000 milisegundos")
			);
		
		Assert.assertEquals(
				"@delucas 3600 segundos equivalen a 60 minutos",
				jenkins.escuchar("@jenkins cuántos minutos son 3600 segundos")
			);
		
		Assert.assertEquals(
				"@delucas 24 horas equivalen a 1440 minutos",
				jenkins.escuchar("@jenkins cuántos minutos son 24 horas")
			);
		
		Assert.assertEquals(
				"@delucas 1 día equivale a 1440 minutos",
				jenkins.escuchar("@jenkins cuántos minutos son 1 día")
			);
		
		Assert.assertEquals(
				"@delucas 2 días equivalen a 2880 minutos",
				jenkins.escuchar("@jenkins cuántos minutos son 2 días")
			);
		
		Assert.assertEquals(
				"@delucas 1 semana equivale a 10080 minutos",
				jenkins.escuchar("@jenkins cuántos minutos son 1 semana")
			);
		
		Assert.assertEquals(
				"@delucas 3600000 milisegundos equivalen a 1 hora",
				jenkins.escuchar("@jenkins cuántas horas son 3600000 milisegundos")
			);
		
		Assert.assertEquals(
				"@delucas 7200000 milisegundos equivalen a 2 horas",
				jenkins.escuchar("@jenkins cuántas horas son 7200000 milisegundos")
			);
		
		Assert.assertEquals(
				"@delucas 3600 segundos equivalen a 1 hora",
				jenkins.escuchar("@jenkins cuántas horas son 3600 segundos")
			);
		
		Assert.assertEquals(
				"@delucas 1440 minutos equivalen a 24 horas",
				jenkins.escuchar("@jenkins cuántas horas son 1440 minutos")
			);
		
		Assert.assertEquals(
				"@delucas 1 día equivale a 24 horas",
				jenkins.escuchar("@jenkins cuántas horas son 1 día")
			);
		
		Assert.assertEquals(
				"@delucas 3 días equivalen a 72 horas",
				jenkins.escuchar("@jenkins cuántas horas son 3 días")
			);
		
		Assert.assertEquals(
				"@delucas 1 semana equivale a 168 horas",
				jenkins.escuchar("@jenkins cuántas horas son 1 semana")
			);
		
		Assert.assertEquals(
				"@delucas 2 semanas equivalen a 336 horas",
				jenkins.escuchar("@jenkins cuántas horas son 2 semanas")
			);
		
		Assert.assertEquals(
				"@delucas 4 semanas equivalen a 672 horas",
				jenkins.escuchar("@jenkins cuántas horas son 4 semanas")
			);
		
		
		Assert.assertEquals(
				"@delucas 86400000 milisegundos equivalen a 1 día",
				jenkins.escuchar("@jenkins cuántos días son 86400000 milisegundos")
			);
		
		Assert.assertEquals(
				"@delucas 86400 segundos equivalen a 1 día",
				jenkins.escuchar("@jenkins cuántos días son 86400 segundos")
			);
		
		Assert.assertEquals(
				"@delucas 1440 minutos equivalen a 1 día",
				jenkins.escuchar("@jenkins cuántos días son 1440 minutos")
			);
		
		Assert.assertEquals(
				"@delucas 24 horas equivalen a 1 día",
				jenkins.escuchar("@jenkins cuántos días son 24 horas")
			);
		
		Assert.assertEquals(
				"@delucas 12 horas equivalen a 0.50 día",
				jenkins.escuchar("@jenkins cuántos días son 12 horas")
			);
		
		Assert.assertEquals(
				"@delucas 36 horas equivalen a 1.50 días",
				jenkins.escuchar("@jenkins cuántos días son 36 horas")
			);
		
		Assert.assertEquals(
				"@delucas 1 semana equivale a 7 días",
				jenkins.escuchar("@jenkins cuántos días son 1 semana")
			);
		
		Assert.assertEquals(
				"@delucas 2 semanas equivalen a 14 días",
				jenkins.escuchar("@jenkins cuántos días son 2 semanas")
			);
		
		
		Assert.assertEquals(
				"@delucas 604800000 milisegundos equivalen a 1 semana",
				jenkins.escuchar("@jenkins cuántas semanas son 604800000 milisegundos")
			);
		
		Assert.assertEquals(
				"@delucas 604800 segundos equivalen a 1 semana",
				jenkins.escuchar("@jenkins cuántas semanas son 604800 segundos")
			);
		
		Assert.assertEquals(
				"@delucas 10080 minutos equivalen a 1 semana",
				jenkins.escuchar("@jenkins cuántas semanas son 10080 minutos")
			);
		
		Assert.assertEquals(
				"@delucas 168 horas equivalen a 1 semana",
				jenkins.escuchar("@jenkins cuántas semanas son 168 horas")
			);
		
		Assert.assertEquals(
				"@delucas 7 días equivalen a 1 semana",
				jenkins.escuchar("@jenkins cuántas semanas son 7 días")
			);
		
		Assert.assertEquals(
				"@delucas 14 días equivalen a 2 semanas",
				jenkins.escuchar("@jenkins cuántas semanas son 14 días")
			);
		
		Assert.assertEquals(
				"@delucas 10.5 días equivalen a 1.50 semanas",
				jenkins.escuchar("@jenkins cuántas semanas son 10.5 días")
			);
		
	}
	
}