import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Fenetre extends Canvas{

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    Balle ball = new Balle(300, 300, 2, 2, 25);
    //public ArrayList<Brick> listeBricks = new ArrayList<>();
    Brick brick1 = new Brick(10,10);
    Plateforme plateforme = new Plateforme();

    Fenetre() throws InterruptedException {
        JFrame fenetre = new JFrame("Casse brique");
        JPanel panneau = (JPanel) fenetre.getContentPane();
        panneau.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBounds(0, 0, WIDTH, HEIGHT);
        panneau.add(this);
        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.requestFocusInWindow();
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        setFocusable(true);
        fenetre.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        plateforme.x-=50;
                        System.out.println("a gauche");
                        break;
                    case KeyEvent.VK_RIGHT:
                        plateforme.x+=50;
                        System.out.println("a droite");
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        demarrer();
    }

    /*public boolean toucherPlateforme(Plateforme p, Balle b){
        boolean res = false;
        while (!(b.getX() <= p.x || b.getX() >= p.x+Plateforme.TAILLE) && (b.getY() < p.y)) {
            res=true;
            System.out.println("plateforme touché");
        }
        return res;
    }*/

    public void demarrer() throws InterruptedException {
        while(true) {

            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();
            dessin.setColor(Color.white);
            dessin.fillRect(0, 0, WIDTH, HEIGHT);
            if(ball.getY() + 50 >= plateforme.y &&
               ball.getX() + 50 >= plateforme.x &&
               ball.getX() <= plateforme.x + 10) {

                System.out.println("touche la plateforme");
            }else{
                plateforme.rembondirBalle(ball);
                ball.move();
            }
            dessin.setColor(ball.getColor());
            ball.dessiner(dessin);
            dessin.setColor(brick1.c);
            brick1.dessiner(dessin);
            dessin.setColor(plateforme.couleur);
            plateforme.dessiner(dessin);

            if (ball.getX() <= brick1.x+75 && ball.getY()<= brick1.y+50){
                System.out.println("touche");
                brick1.disabled=false;
                brick1.changeStatus();
                dessin.setColor(brick1.c);
                brick1.dessiner(dessin);
            }
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Fenetre();
    }






}