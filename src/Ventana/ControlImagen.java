package Ventana;

import java.io.File;
import javax.swing.ImageIcon;

public class ControlImagen {

    ImageIcon background = null, eyes = null, mouth = null;
    File archivos[][] = new File[10][50];
    int contador = 0;

    public ControlImagen() {

    }
    public void enviarArchivosControlImagen(File[] archivos){
        //guardo los archivos de la imagen en la matriz
        for (int i = 0; i < archivos.length; i++) {
            //se van guardando de uno en uno
        this.archivos[contador][i] = archivos[i];    
        }
        //aumenta el contador para que puedan seguirse guardando en la otra fila de la matriz
        contador++;
        
    }

    public void randomCuerpo() {
        //inicio un iterador que permita el flujo de archivos
        int i = 0;
        
        ImageIcon fondo = new ImageIcon(this.archivos[i][i].getAbsolutePath());
        this.background = fondo;
        this.eyes = fondo;
        this.mouth = fondo;

        
//        ImageIcon fondo = new ImageIcon(getClass().getResource("fondo.png"));
//        ImageIcon fondo1 = new ImageIcon(getClass().getResource("fondo1.png"));
//        ImageIcon fondo2 = new ImageIcon(getClass().getResource("fondo2.png"));
//        int random = (int) (Math.random() * 3);
//        switch (random) {
//            case 0:
//                this.background = fondo;
//                break;
//            case 1:
//
//                this.background = fondo1;
//                break;
//            case 2:
//
//                this.background = fondo2;
//                break;
//        }
    }

    public void randomOjos() {
        ImageIcon ojos = new ImageIcon(getClass().getResource("ojos.png"));
        ImageIcon ojos1 = new ImageIcon(getClass().getResource("ojos1.png"));
        ImageIcon ojos2 = new ImageIcon(getClass().getResource("ojos2.png"));
        int random1 = (int) (Math.random() * 3);
        switch (random1) {
            case 0:
                this.eyes = ojos;
                break;
            case 1:
                this.eyes = ojos1;
                break;
            case 2:

                this.eyes = ojos2;
                break;
        }
    }

    public void randomBoca() {
        ImageIcon boca = new ImageIcon(getClass().getResource("boca.png"));
        ImageIcon boca1 = new ImageIcon(getClass().getResource("boca1.png"));
        int random3 = (int) (Math.random() * 2);
        switch (random3) {
            case 0:
                this.mouth = boca;
                break;
            case 1:
                this.mouth = boca1;
                break;
        }
    }

    public ImageIcon getFondo() {
        return background;
    }

    public ImageIcon getOjos() {
        return eyes;
    }

    public ImageIcon getBoca() {
        return mouth;
    }

}
