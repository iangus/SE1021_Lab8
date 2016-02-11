import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.InputMismatchException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 2/10/2016
 */
public class JPEGPicture extends Picture {
    public JPEGPicture(){}

    public JPEGPicture(BufferedImage buffer){
        this.buffer = buffer;
    }

    public void load(File file) throws IOException{
        if(file != null){
            buffer = ImageIO.read(file);
            lastFile = file;
        }else{
            buffer = ImageIO.read(lastFile);
        }
    }

    public void store(File file) throws IOException{
        String extension = file.getName().substring(file.getName().lastIndexOf("."), file.getName().length());
        if(extension.equals(".jpg")){
            ImageIO.write(buffer,"jpeg",file);
            JOptionPane.showMessageDialog(null, "Image saved successfully.");
        }else{
            throw new InputMismatchException("Incorrect file extension used.");
        }
    }
}
