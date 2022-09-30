/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Feligres;
import Modelo.Parroquia;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Estudiante
 */
public class Control implements ActionListener {

    private Parroquia modelo;
    private Vista vista;

    public Control(Parroquia modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        actionListener(this);
    }

    private void actionListener(ActionListener control) {
        vista.jButton1.addActionListener(control);
        vista.jButton2.addActionListener(control);
        vista.jButton3.addActionListener(control);
        vista.jButton4.addActionListener(control);
        vista.jButton5.addActionListener(control);
        vista.jButton6.addActionListener(control);
        vista.jButton7.addActionListener(control);
        vista.jButton8.addActionListener(control);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Guardar")) {
            Modelo.Feligres feligres = new Feligres();
            modelo.setFeligres(feligres);
            feligres.setCedula(vista.txtCedula.getText());
            feligres.setNombre(vista.txtNombre.getText());
            feligres.setDireccion(vista.txtDireccion.getText());
            feligres.setTelefono(vista.txtTelefono.getText());
            feligres.setEstrato(Integer.parseInt(vista.txtEstrato.getText()));
            switch (vista.txtEstado.getText()) {
                case "Deudor":
                    feligres.setEstado(false);
                    break;
                case "Cumplido":
                    feligres.setEstado(true);
            }

        } else if (e.getActionCommand().equals("Limpiar")) {
            vista.txtCedula.setText("");
            vista.txtCedulaBuscar.setText("");
            vista.txtDiezmo.setText("");
            vista.txtDireccion.setText("");
            vista.txtEstado.setText("");
            vista.txtEstrato.setText("");
            vista.txtNombre.setText("");
            vista.txtTelefono.setText("");
            vista.areaResultados.setText("");

        } else if (e.getActionCommand().equals("Eliminar")) {
            modelo.EliminarFeligres(vista.txtCedula.getText());

        } else if (e.getActionCommand().equals("Actualizar")) {
            Modelo.Feligres feligres = modelo.getFeligres(vista.txtCedula.getText());
            if (feligres != null) {
                feligres.setNombre(vista.txtNombre.getText());
                feligres.setDireccion(vista.txtDireccion.getText());
                feligres.setTelefono(vista.txtTelefono.getText());
                feligres.setEstrato(Integer.parseInt(vista.txtEstrato.getText()));
                switch (vista.txtEstado.getText()) {
                    case "Deudor":
                        feligres.setEstado(false);
                        break;
                    case "Cumplido":
                        feligres.setEstado(true);
                }
            }

        } else if (e.getActionCommand().equals("Buscar")) {
            Modelo.Feligres feligres = modelo.getFeligres(vista.txtCedula.getText());
            if (feligres != null) {
                vista.txtNombre.setText(feligres.getNombre());
                vista.txtDireccion.setText(feligres.getDireccion());
                vista.txtTelefono.setText(feligres.getTelefono());
                vista.txtEstrato.setText(feligres.getEstrato() + "");
                if (feligres.isEstado()) {
                    vista.txtEstado.setText("Cumplido");
                } else {
                    vista.txtEstado.setText("Deudor");
                }
            }
        } else if (e.getActionCommand().equals("Consultar")) {
            if (!modelo.getFeligres(vista.txtCedulaBuscar.getText()).isEstado()) {
                vista.txtDiezmo.setText(modelo.valorDiezmo(vista.txtCedulaBuscar.getText()) + "");
            } else {
                vista.txtDiezmo.setText("0");
            }
        } else if (e.getActionCommand().equals("Pagar")) {
            modelo.getFeligres(vista.txtCedulaBuscar.getText()).setEstado(true);
            modelo.setTotalDiezmos(modelo.getTotalDiezmos() + Integer.parseInt(vista.txtDiezmo.getText()));
        } else if (e.getActionCommand().equals("Totalizar")) {
            vista.areaResultados.append("En total se ha recolectado $" + modelo.getTotalDiezmos() + " de diezmo");
        }
    }

}
