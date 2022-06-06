package Ventana;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.*;

public class VentanaFrame extends JFrame {

    Panel panel;
    JButton buttonmostrar, buttonimprimir;

    public VentanaFrame() {

        inicializarFrame();
        inicializarComponentes();
        añadirComponentes();
        añadirListener();

        this.pack();
        this.setSize(500, 590);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private void inicializarFrame() {
        this.setTitle("NFT GENERATOR");
        this.getContentPane().setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {
        panel = new Panel();
        buttonmostrar = new JButton("Cargar imagen");
        buttonimprimir = new JButton("Imprimir");
    }

    private void añadirComponentes() {
        this.getContentPane().add(panel);
        this.getContentPane().add(buttonmostrar, BorderLayout.NORTH);
        this.getContentPane().add(buttonimprimir, BorderLayout.SOUTH);
    }

    private void añadirListener() {
        buttonmostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!panel.isVisible()) {
                    panel.repaint();
                    panel.setVisible(true);
                } else {
                    panel.removeAll();
                    panel.setVisible(false);
                }
            }
        });

        buttonimprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(panel);
                if (job.printDialog()) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {
                        JOptionPane.showMessageDialog(null, "La impresion se cancelo");
                    }
                }
            }
        });

    }

}
