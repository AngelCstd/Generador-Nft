package Ventana;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import javax.swing.*;

public class Panel extends JPanel implements Printable {

    ControlImagen c = new ControlImagen();
    boolean pintado = false;

    public Panel() {
        iniciarPanel();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (pintado == true && c.getImagen1() != null) {
            g.drawImage(c.getImagen1().getImage(), 0, 0, 500, 500, this);

            if (pintado == true && c.getImagen2() != null) {
                g.drawImage(c.getImagen2().getImage(), 0, 0, 500, 500, this);

                if (pintado == true && c.getImagen3() != null) {
                    g.drawImage(c.getImagen3().getImage(), 0, 0, 500, 500, this);

                    if (pintado == true && c.getImagen4() != null) {
                        g.drawImage(c.getImagen4().getImage(), 0, 0, 500, 500, this);

                        if (pintado == true && c.getImagen5() != null) {
                            g.drawImage(c.getImagen5().getImage(), 0, 0, 500, 500, this);

                            if (pintado == true && c.getImagen6() != null) {
                                g.drawImage(c.getImagen6().getImage(), 0, 0, 500, 500, this);
                                
                                if (pintado == true && c.getImagen7() != null) {
                                    g.drawImage(c.getImagen7().getImage(), 0, 0, 500, 500, this);

                                    if (pintado == true && c.getImagen8() != null) {
                                        g.drawImage(c.getImagen8().getImage(), 0, 0, 500, 500, this);

                                        if (pintado == true && c.getImagen9() != null) {
                                            g.drawImage(c.getImagen9().getImage(), 0, 0, 500, 500, this);
                                            
                                            if (pintado == true && c.getImagen10() != null) {
                                                g.drawImage(c.getImagen10().getImage(), 0, 0, 500, 500, this);
                                            }
                                        }
                                        
                                    }
                                }
                            }
                        }
                    }
                }
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

    public void cambiarImagen() {
        pintado = true;
        c.mostrarImagenes();
        repaint();
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex == 0) {
            Graphics2D graphics2d = (Graphics2D) graphics;
            graphics2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            printAll(graphics2d);
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }

}
