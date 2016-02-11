import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 2/4/2016
 */
public class Picture {
    protected BufferedImage buffer;
    protected File lastFile;

    public int getHeight(){
        return buffer.getHeight();
    }

    public BufferedImage getImage(){
        return buffer;
    }

    public int getWidth(){
        return buffer.getWidth();
    }

    public void load(File file) throws IOException{
        try {
            buffer = ImageIO.read(file);
            lastFile = file;
        } catch (IOException e) {
            throw new IOException(file.getName() + " IOexception error");
        }
    }

    public Picture(BufferedImage buffer){
        this.buffer = buffer;
    }

    public Picture(){

    }

    public void store(File file){

    }
}
