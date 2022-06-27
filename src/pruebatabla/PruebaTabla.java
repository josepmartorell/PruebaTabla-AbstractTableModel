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
    };

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Prueba Tabla");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
        
        /*manual interface positioning*/
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point middle = new Point((int) (screenSize.width / (float)2.22), screenSize.height / 2);
        Point newLocation = new Point(middle.x - (frame.getWidth() / 2), 
                                      middle.y - (frame.getHeight() / 2));
        frame.setLocation(newLocation);

        Container c = frame.getContentPane();
        final ModeloTabla modeloTabla = new ModeloTabla();
        JTable tabla = new JTable(modeloTabla);
        c.add(tabla, BorderLayout.CENTER);
        JButton botonAnadeFila = new JButton("Añadir fila");
        /*botonAnadeFila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modeloTabla.anadeFila();
                frame.pack();
            }
        });*/
        botonAnadeFila.addActionListener((ActionEvent e) -> {
            modeloTabla.anadeFila();
            frame.pack();
        });
        
        c.add(botonAnadeFila, BorderLayout.SOUTH);
        frame.pack();
        
        /*SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });*/
        SwingUtilities.invokeLater(() -> {
            frame.setVisible(true);
        });
    }
}