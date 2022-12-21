import java.awt.*;

public class Balle {
    public int x;
    public int y;
    public int xSpeed;
    public int ySpeed;
    public int size;

    public Color getColor() {
        return color;
    }



    private Color color;

    public Balle(int x, int y, int xSpeed, int ySpeed, int size) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.size = size;
        this.color=Color.blue;
    }


    public void move() {
        x += xSpeed;
        y += ySpeed;

        if (x >= Fenetre.WIDTH - 50 || x <=0) {
            xSpeed = -xSpeed;
        }

        if (y >= Fenetre.WIDTH - 50 || y <=0) {
            ySpeed = -ySpeed;
        }
    }



    public void dessiner(Graphics2D dessin){
        dessin.fillOval(x, y, 50, 50);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
