import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
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
public abstract class Picture {
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

    public abstract void load(File file) throws IOException;

    public Picture(BufferedImage buffer){
        this.buffer = buffer;
    }

    public Picture(){

    }

    public abstract void store(File file) throws IOException;
}
