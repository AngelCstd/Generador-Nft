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
        if (pintado == true) {
            g.drawImage(c.getFondo().getImage(), 0, 0, 500, 500, this);
            g.drawImage(c.getOjos().getImage(), 0, 0, 500, 500, this);
            g.drawImage(c.getBoca().getImage(), 0, 0, 500, 500, this);
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
        c.randomCuerpo();
//        c.randomBoca();
//        c.randomOjos();
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
