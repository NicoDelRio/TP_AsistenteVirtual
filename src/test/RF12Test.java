package test;

import clase.Asistente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RF12Test {

    public final static String USUARIO = "delucas"; 
    
    Asistente jenkins;
    
    @Before
    public void setup() {
      jenkins = new Asistente("jenkins");
    }
    
    @Test
    public void leyesRobotica() {
        String[] mensajes = {
                "@jenkins, recuerdame las 3 leyes de la robotica",
                "¿@jenkins, cuales son las 3 leyes de la robotica?"
            };
            for (String mensaje : mensajes) {
              Assert.assertEquals("@delucas, las 3 leyes de la robótica son:" + "\n"
              + "1- Un robot no puede hacer daño a un ser humano o, por inanición, "
              + "permitir que un ser humano sufra daño." + "\n"
              + "2- Un robot debe obedecer las ordenes dadas por los seres humanos, "
              + "excepto si estas órdenes entrasen en conflicto con la primera ley." + "\n"
              + "3- Un robot debe proteger su propia existencia en la medida en que esta "
              + "protección no entre en conflicto con la primera o la segunda ley.",
                  jenkins.escuchar(mensaje)
              );
            }
    }

}
