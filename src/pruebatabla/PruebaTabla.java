/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package pruebatabla;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author jtech
 */
public class PruebaTabla {

    private static class ModeloTabla extends AbstractTableModel {
        private int numFilas = 2;
        
        @Override
        public int getRowCount() { return numFilas; }
        
        @Override
        public int getColumnCount() { return 2; }
        
        @Override
        public Object getValueAt(int row, int column) {
            return row + ", " + column;
        }
        public void anadeFila() {
            numFilas++;
            fireTableRowsInserted(numFilas - 1, numFilas - 1);
        }
        public void eliminaFila() {
            if (numFilas >= 1){
                numFilas--;
                fireTableRowsInserted(numFilas - 1, numFilas - 1);
            }
        }
    };

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Prueba Tabla");
        frame.setLayout(null);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final ModeloTabla modeloTabla = new ModeloTabla();
        JTable tabla = new JTable(modeloTabla);
        tabla.setBounds(10,10,880,310);
        frame.add(tabla);
        
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(10,10,880,310);
        frame.add(scroll);
        
        JButton botonAnadeFila = new JButton("Añadir fila");
        botonAnadeFila.setBounds(43, 360, 800, 25);
        botonAnadeFila.addActionListener((ActionEvent e) -> {
            modeloTabla.anadeFila();
        });
        
        frame.add(botonAnadeFila);
        
        JButton botonEliminarFila = new JButton("Eliminar fila");
        botonEliminarFila.setBounds(43, 400, 800, 25);
        botonEliminarFila.addActionListener((ActionEvent e) -> {
            modeloTabla.eliminaFila();
        });
        
        frame.add(botonEliminarFila);
        
        SwingUtilities.invokeLater(() -> {
            frame.setSize(900, 520);
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
            frame.setLocation(x, y);
            frame.setResizable(false);
            frame.setVisible(true);
        });
    }
}