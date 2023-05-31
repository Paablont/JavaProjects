/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pablo [pvillasenorr01@educastillalamancha.es]
 */
public class SerMitologicoTest {
    static SerMitologico instance = new SerMitologico() {
        @Override
        public String establecerPatron() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    };
    static JaponesPVR japo = new JaponesPVR();
    public SerMitologicoTest() {
    }
    
    /**
     * Test para comprobar si el ritual pasado coincide con el patron
     */
    @Test
    public void testValidarRitual() {
        System.out.println("validarRitual");
        String patron = japo.establecerPatron();
        String ritual = "abd2@";
        
        boolean expResult = true;
        boolean result = instance.validarRitual(patron, ritual);
        assertEquals(expResult, result);
       
    }

    
}
