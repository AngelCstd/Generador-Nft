package Ventana;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.*;

public class Panel extends JPanel implements Printable {

    public Panel() {
        iniciarPanel();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);

        ImageIcon imagen = randomCuerpo();
        g.drawImage(imagen.getImage(), 0, 0, 500, 500, this);
        ImageIcon imagen1 = randomOjos();
        g.drawImage(imagen1.getImage(), 0, 0, 500, 500, this);
        ImageIcon imagen2 = randomBoca();
        g.drawImage(imagen2.getImage(), 0, 0, 500, 500, this);
    }

    private void iniciarPanel() {
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(false);
    }
    private ImageIcon randomCuerpo() {
        ImageIcon fondo = new ImageIcon(getClass().getResource("fondo.png"));
        ImageIcon fondo1 = new ImageIcon(getClass().getResource("fondo1.png"));
        ImageIcon fondo2 = new ImageIcon(getClass().getResource("fondo2.png"));
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                return fondo;
            case 1:

                return fondo1;
            case 2:

                return fondo2;
        }
        return null;
    }
    private ImageIcon randomOjos() {
        ImageIcon ojos = new ImageIcon(getClass().getResource("ojos.png"));
        ImageIcon ojos1 = new ImageIcon(getClass().getResource("ojos1.png"));
        ImageIcon ojos2 = new ImageIcon(getClass().getResource("ojos2.png"));
        int random1 = (int) (Math.random() * 3);
        switch (random1) {
            case 0:
                return ojos;
            case 1:
                return ojos1;
            case 2:
               
               return ojos2;
        }
        return null;
    }

    private ImageIcon randomBoca() {
        ImageIcon boca = new ImageIcon(getClass().getResource("boca.png"));
        ImageIcon boca1 = new ImageIcon(getClass().getResource("boca1.png"));
        int random3 = (int) (Math.random() * 2);
        switch (random3) {
            case 0:
                return boca;
            case 1:
                return boca1;
        }
        return null;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
    if(pageIndex==0){
        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        printAll(graphics2d);
        return PAGE_EXISTS;
    }else{
        return NO_SUCH_PAGE;
    }
    }

}
