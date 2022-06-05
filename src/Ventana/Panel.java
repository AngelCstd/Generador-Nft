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

    private void iniciarPanel() {
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(false);
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
