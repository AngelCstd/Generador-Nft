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
                    randomOjos();
                    randomBoca();
                    randomCuerpo();
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
                if(job.printDialog()){
                    try {
                        job.print();
                    } catch (PrinterException ex) {
                        JOptionPane.showMessageDialog(null, "La impresion se cancelo");
                    }
                }
            }
        });

    }

   
    
    
    private void randomCuerpo() {
        JLabel fondo = new JLabel(new ImageIcon("fondo.png"));
        JLabel fondo1 = new JLabel(new ImageIcon("fondo1.png"));
        JLabel fondo2 = new JLabel(new ImageIcon("fondo2.png"));
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                fondo.setBounds(0, 0, 500, 500);
                panel.add(fondo);
                break;
            case 1:
                fondo1.setBounds(0, 0, 500, 500);
                panel.add(fondo1);
                break;
            case 2:
                fondo2.setBounds(0, 0, 500, 500);
                panel.add(fondo2);
                break;

        }
    }

    private void randomOjos() {
        JLabel ojos = new JLabel(new ImageIcon("ojos.png"));
        JLabel ojos1 = new JLabel(new ImageIcon("ojos1.png"));
        JLabel ojos2 = new JLabel(new ImageIcon("ojos2.png"));
        int random1 = (int) (Math.random() * 3);
        switch (random1) {
            case 0:
                ojos.setBounds(0, 0, 500, 500);
                panel.add(ojos);
                break;
            case 1:
                ojos1.setBounds(0, 0, 500, 500);
                panel.add(ojos1);
                break;
            case 2:
                int random2 = (int) (Math.random() * 3);//Le da menor porcentaje de que salga los cuernitos
                switch (random2) {
                    case 0:
                        ojos.setBounds(0, 0, 500, 500);
                        panel.add(ojos);
                        break;
                    case 1:
                        ojos1.setBounds(0, 0, 500, 500);
                        panel.add(ojos1);
                        break;
                    case 2:
                        ojos2.setBounds(0, 0, 500, 500);
                        panel.add(ojos2);
                        break;

                }
                break;
        }
    }

    private void randomBoca() {
        JLabel boca = new JLabel(new ImageIcon("boca.png"));
        JLabel boca1 = new JLabel(new ImageIcon("boca1.png"));
        int random3 = (int) (Math.random() * 2);
        switch (random3) {
            case 0:
                boca.setBounds(0, 0, 500, 500);
                panel.add(boca);
                break;
            case 1:
                boca1.setBounds(0, 0, 500, 500);
                panel.add(boca1);
                break;
        }
    }
}
