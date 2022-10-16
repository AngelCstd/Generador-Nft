package Ventana;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Panel extends JPanel {

    ControlImagen c = new ControlImagen();
    boolean pintado = false;
    boolean cambiar = false;
    ImageIcon imagenes[] = new ImageIcon[10];
    BufferedImage image;
    Graphics gr;
    String destino = "C:/GeneradorNFT/";
    int i = 1;
    String numerador = String.valueOf(i);
    String terminoRuta = " imagen.png";

    public Panel() {
        iniciarPanel();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < c.getImagenes().length; i++) {
            if (pintado == true && c.getImagen(i) != null) {
                g.drawImage(c.getImagen(i).getImage(), 0, 0, 500, 500, this);
            }
        }
        if (pintado == false) {

        }
    }

    private void iniciarPanel() {
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(false);
    }

    public void enviarArchivosPanel(File[] archivos) {
        c.enviarArchivosControlImagen(archivos);
    }

    public void cargaCambioImagenes() {
        pintado = true;
        if (cambiar == false) {
            c.mostrarImagenes();
            repaint();
        }
        if (cambiar == true) {
            c.cambiarImagenes();
            repaint();
        }
    }

    public void cambioImagenEnabled(boolean enable) {
        this.cambiar = enable;
    }

    public void iniciarImagen() {
        this.image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        this.gr = image.createGraphics();
        this.paint(gr);
        File folder = new File(destino);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(destino + numerador + terminoRuta);
        try {
            ImageIO.write(image, "png", file); // Salvar la imagen en el fichero
        } catch (IOException ex) {
            System.out.println("Error al guardar archivo.");
        }
        i++;
        this.numerador = String.valueOf(i);
    }
    
    public boolean isGuardadoC(){
        return c.isGuardado();
    }

}
