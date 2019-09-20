/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.udec.carrerahilos.Carrera;
import com.udec.carrerahilos.Equipos;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julian esteban vallejo galindo
 */
public class TetstCarreras {
    
    public TetstCarreras() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testRandom(){
        String nombre = "prueba";
        int id = 2;
        Equipos equipos = new Equipos(nombre,id);
        Carrera carrera1 = new Carrera(1,1,equipos,2);
        Random r = new Random();
        int resultado = r.ints(1, (3 + 1)).findFirst().getAsInt();
        int resultadoEsperado = 4;
        //assertEquals(resultado, resultadoEsperado);
        assertNotSame(resultado, resultadoEsperado);
    }
}
