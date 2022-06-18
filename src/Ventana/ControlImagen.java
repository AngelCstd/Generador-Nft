package Ventana;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControlImagen {

    ImageIcon imagenes[] = {null, null, null, null, null, null, null, null, null, null};
    File archivos[][] = new File[10][50];
    int contador = 0;
    int n[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    boolean guardado = true;

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
        if (this.archivos[contador - 1][0] != null) {
            ImageIcon imagen = new ImageIcon(this.archivos[contador - 1][0].getAbsolutePath());
            this.imagenes[contador - 1] = imagen;
        }
    }

    public void cambiarImagenes() {
        if (guardado == true) {
            for (int i = 9; i >= 0; i--) {
                if (this.archivos[i][n[i]] != null) {
                    ImageIcon imagen = new ImageIcon(this.archivos[i][n[i]].getAbsolutePath());
                    this.imagenes[i] = imagen;
                } else {
                    n[i] = 0;
                    if (this.archivos[i][n[i]] != null) {
                        ImageIcon imagen = new ImageIcon(this.archivos[i][n[i]].getAbsolutePath());
                        this.imagenes[i] = imagen;
                        if (n[0]<=this.archivos[0].length && i ==0) {
                            guardado = false;
                        }else{
                        n[i - 1]++;    
                        }
                    } else {
                        if (n[0]<=this.archivos[0].length && i == 0) {
                            guardado = false;
                        }else{
                        n[i - 1]++;    
                        }
                    }
                }
            }
            n[9]++;
        } else {
        }

    }

    public boolean isGuardado() {
        return guardado;
    }
    

    public ImageIcon getImagen(int i) {
        return imagenes[i];
    }

    public ImageIcon[] getImagenes() {
        return imagenes;
    }

}
