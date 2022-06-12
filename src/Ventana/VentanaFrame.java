package Ventana;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaFrame extends JFrame {

    File archivos[];
    Panel panel;
    JButton buttonCargarImagen, buttonimprimir;
    ControlImagen c;

    //iniciamos la ventana con el cerrado y las medidas y agregamos los componentes
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
//Inicializamos ventana

    private void inicializarFrame() {
        this.setTitle("NFT GENERATOR");
        this.getContentPane().setLayout(new BorderLayout());
    }
//inicializamos componentes

    private void inicializarComponentes() {
        panel = new Panel();
        buttonCargarImagen = new JButton("Cargar imagen");
        buttonimprimir = new JButton("Imprimir");
    }
//los componentes los añadimos a la ventana

    private void añadirComponentes() {
        this.getContentPane().add(panel);
        panel.setVisible(true);
        this.getContentPane().add(buttonCargarImagen, BorderLayout.NORTH);
        this.getContentPane().add(buttonimprimir, BorderLayout.SOUTH);
    }
//agregamos las acciones a los botones

    private void añadirListener() {
        buttonCargarImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Creamos objeto
                JFileChooser fc = new JFileChooser();
                //habilitamos la seleccion multiple
                fc.setMultiSelectionEnabled(true);
                //creamos un filtro y se lo ponemos para que solo se escojan imagenes
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("*PNG, JPG, GIF", "png", "jpg", "gif");
                fc.setFileFilter(filtro);
                //abrimos la ventana para guardar la opcion seleccionada
                int seleccion = fc.showOpenDialog(panel);
                //si se pone aceptar
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    //vamos a agregar los archivos a un arreglo de archivos
                    archivos = fc.getSelectedFiles();
                    panel.enviarArchivosPanel(archivos);
                    panel.cambiarImagen();
                }
                if (seleccion == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "Ha cancelado la carga de imagen");
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
