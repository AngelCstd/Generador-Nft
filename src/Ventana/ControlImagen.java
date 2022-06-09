package Ventana;

import javax.swing.ImageIcon;

public class ControlImagen {

    ImageIcon background = null, eyes = null, mouth = null;
    public ControlImagen(){
        randomCuerpo();
        randomOjos();
        randomBoca();
    }

    public ImageIcon randomCuerpo() {
        ImageIcon fondo = new ImageIcon(getClass().getResource("fondo.png"));
        ImageIcon fondo1 = new ImageIcon(getClass().getResource("fondo1.png"));
        ImageIcon fondo2 = new ImageIcon(getClass().getResource("fondo2.png"));
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                this.background = fondo;
                break;
            case 1:

                this.background = fondo1;
                break;
            case 2:

                this.background = fondo2;
                break;
        }
        return null;
    }

    public ImageIcon randomOjos() {
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
        return null;
    }

    public ImageIcon randomBoca() {
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
        return null;
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
