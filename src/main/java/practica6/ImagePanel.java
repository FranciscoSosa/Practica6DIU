package practica6;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(image != null){
            g.drawImage(image, (this.getWidth() - image.getWidth()) / 2
                    , (this.getHeight() - image.getHeight()) / 2, null);
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    
    private BufferedImage image = null;
}
