import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 2/10/2016
 */
public class EmptyPicture extends Picture{
    public static final int DEFAULT_HEIGHT = 600;
    public static final int DEFAULT_WIDTH = 800;


    public EmptyPicture(){
        buffer = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    public EmptyPicture(int width, int height){
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void load(File file) throws IOException{}

    public void store(File file) throws IOException{}
}
