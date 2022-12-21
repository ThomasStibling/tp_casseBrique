import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Plateforme {
    public int x;
    public int y;
    public static final int TAILLE = 100;
    public Color couleur;

    public Plateforme(){
        this.x=200;
        this.y=450;
        this.couleur=Color.BLACK;
    }

    public void dessiner(Graphics2D dessin){
        dessin.fillRect(x, y, TAILLE, 10);
    }

    public void rembondirBalle(Balle b){
        if (b.x >= Plateforme.TAILLE - 50 || b.x <=0) {
            b.xSpeed = +b.xSpeed;
        }

        /*if (b.y >= Plateforme.TAILLE - 50 || b.y <=0) {
            b.ySpeed = -b.ySpeed;
        }*/

    }


}
