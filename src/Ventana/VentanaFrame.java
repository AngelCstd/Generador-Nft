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
    boolean mostrarMensaje = true;

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
        JOptionPane.showMessageDialog(null, "Al cargar las imagenes se recomienda que las "
                + "agregues con seleccion multiple, \napretando Ctrl y seleccionando tus opciones, igualmente tendras que "
                + "escoger \ntus imagenes en orden de profundidad, la que se considera el fondo va a ir \nprimero y "
                + "asi sucesivame de no ser asi vas a tener que reiniciar \nel programa para que funcione correctamente, al terminar de"
                + " cargar \ntus imagenes solo aprieta guardar y se guardaran en una carpeta");

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

                //Creamos objeto y habilitamos la seleccion multiple
                JFileChooser fc = new JFileChooser();
                fc.setMultiSelectionEnabled(true);

                //creamos un filtro y se lo ponemos para que solo se escojan imagenes
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("*PNG, JPG, GIF", "png", "jpg", "gif");
                fc.setFileFilter(filtro);

                //abrimos la ventana para guardar la opcion seleccionada y agregamos la accion si se pone aceptar
                int seleccion = fc.showOpenDialog(panel);
                if (seleccion == JFileChooser.APPROVE_OPTION) {

                    //vamos a agregar los archivos a un arreglo de archivos y lo mandamos y despues mostramos las imagenes
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
                panel.cambiarImagen();
//                PrinterJob job = PrinterJob.getPrinterJob();
//                job.setPrintable(panel);
//                if (job.printDialog()) {
//                    try {
//                        job.print();
//                    } catch (PrinterException ex) {
//                        JOptionPane.showMessageDialog(null, "La impresion se cancelo");
//                    }
//                }
            }
        });

    }

}
