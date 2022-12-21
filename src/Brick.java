import java.awt.*;

public class Brick {
    public int x;
    public int y;
    public Color c;
    public boolean disabled;

    public Brick(int a, int b){
        this.x = a;
        this.y = b;
        this.c = Color.GREEN;
        this.disabled = true;
    }

    public void dessiner(Graphics2D dessin){
        dessin.fillRect(x, y, 75, 50);
    }

    public void changeStatus(){
        if (disabled){
            this.c= Color.GREEN;
        }
        if (!disabled){
            this.c= Color.WHITE;
        }
    }
}
