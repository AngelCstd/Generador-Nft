package Ventana;

import java.io.File;
import javax.swing.ImageIcon;

public class ControlImagen {

    ImageIcon imagen1 = null, imagen2 = null, imagen3 = null, imagen4 = null, imagen5 = null, imagen6 = null, imagen7 = null;
    ImageIcon imagen8 = null, imagen9 = null, imagen10 = null;
    File archivos[][] = new File[10][50];
    int contador = 0;
    //inicio un iterador que permita el flujo de archivos
    int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0;

    public ControlImagen() {

    }

    public void enviarArchivosControlImagen(File[] archivos) {
        //guardo los archivos de la imagen en la matriz de uno en uno
        for (int i = 0; i < archivos.length; i++) {
            this.archivos[contador][i] = archivos[i];
        }
        //aumenta el contador para que puedan seguirse guardando en la otra fila de la matriz al usar el metodo nuevamente
        contador++;

    }

    public void mostrarImagenes() {
        //creo condicionales para que se puedan cargar las imagenes
        if (this.archivos[0][a] != null) {
            ImageIcon image1 = new ImageIcon(this.archivos[0][a].getAbsolutePath());
            this.imagen1 = image1;
            a++;
            if (this.archivos[1][b] != null) {
                ImageIcon image2 = new ImageIcon(this.archivos[1][b].getAbsolutePath());
                this.imagen2 = image2;
                b++;
                if (this.archivos[2][c] != null) {
                    ImageIcon image3 = new ImageIcon(this.archivos[2][c].getAbsolutePath());
                    this.imagen3 = image3;
                    c++;
                    if (this.archivos[3][d] != null) {
                        ImageIcon image4 = new ImageIcon(this.archivos[3][d].getAbsolutePath());
                        this.imagen4 = image4;
                        d++;
                        if (this.archivos[4][e] != null) {
                            ImageIcon image5 = new ImageIcon(this.archivos[4][e].getAbsolutePath());
                            this.imagen5 = image5;
                            e++;
                            if (this.archivos[5][f] != null) {
                                ImageIcon image6 = new ImageIcon(this.archivos[5][f].getAbsolutePath());
                                this.imagen6 = image6;
                                f++;
                                if (this.archivos[6][g] != null) {
                                    ImageIcon image7 = new ImageIcon(this.archivos[6][g].getAbsolutePath());
                                    this.imagen7 = image7;
                                    g++;
                                    if (this.archivos[7][h] != null) {
                                        ImageIcon image8 = new ImageIcon(this.archivos[7][h].getAbsolutePath());
                                        this.imagen8 = image8;
                                        h++;
                                        if (this.archivos[8][i] != null) {
                                            ImageIcon image9 = new ImageIcon(this.archivos[8][i].getAbsolutePath());
                                            this.imagen9 = image9;
                                            i++;
                                            if (this.archivos[9][j] != null) {
                                                ImageIcon image10 = new ImageIcon(this.archivos[9][j].getAbsolutePath());
                                                this.imagen10 = image10;
                                                j++;

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
    }

    public ImageIcon getImagen1() {
        return imagen1;
    }

    public ImageIcon getImagen2() {
        return imagen2;
    }

    public ImageIcon getImagen3() {
        return imagen3;
    }

    public ImageIcon getImagen4() {
        return imagen4;
    }

    public ImageIcon getImagen5() {
        return imagen5;
    }

    public ImageIcon getImagen6() {
        return imagen6;
    }

    public ImageIcon getImagen7() {
        return imagen7;
    }

    public ImageIcon getImagen8() {
        return imagen8;
    }

    public ImageIcon getImagen9() {
        return imagen9;
    }

    public ImageIcon getImagen10() {
        return imagen10;
    }

}
