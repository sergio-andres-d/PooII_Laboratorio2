/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Parroquia {

    private ArrayList<Feligres> feligreses;
    private int totalDiezmos;

    public Parroquia() {
        feligreses=new ArrayList<>();
    }

    public int valorDiezmo(String cedula) {
        int estrato = 0;
        int diezmo = 0;
        for (Feligres f : feligreses) {
            if (f.getCedula().equals(cedula)) {
                estrato = f.getEstrato();
                break;
            }
        }
        if (estrato == 1) {
            diezmo = 250000;
        } else if (estrato >= 2 && estrato <= 3) {
            diezmo = 500000;
        } else if (estrato >= 3) {
            estrato = 1000000;
        }
        return diezmo;
    }

    public Feligres getFeligres(String cedula) {
        for (Feligres f : feligreses) {
            if (f.getCedula().equals(cedula)) {
                return f;
            }
        }
        return null;
    }

    public void setFeligres(Feligres feligres) {
        feligreses.add(feligres);
    }
    
    public void EliminarFeligres(String cedula){
        Feligres f;
        for (int i=feligreses.size()-1;i>=0;i--) {
            f=feligreses.get(i);
            if (f.getCedula().equals(cedula)) {
                feligreses.remove(i);
            }
        }
        
    }

    public int getTotalDiezmos() {
        return totalDiezmos;
    }

    public void setTotalDiezmos(int totalDiezmos) {
        this.totalDiezmos = totalDiezmos;
    }

}
