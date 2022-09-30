/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio30092022;

import Control.Control;
import Modelo.Parroquia;
import Vista.Vista;

/**
 *
 * @author Estudiante
 */
public class Laboratorio30092022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista vista=new Vista();
        Parroquia modelo= new Parroquia();
        Control control=new Control(modelo, vista);
        // TODO code application logic here
    }
    
}
