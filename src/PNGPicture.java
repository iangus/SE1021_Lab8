
/**
 * SE1021 - 032
 * Winter 2016
 * Lab 8
 * Name: Ian Guswiler
 * Created: 2/10/2016
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Represents images that are to be stored in the PNG(.png) format
 *
 * @author Ian Guswiler
 * @version 2/19/2016
 */
public class PNGPicture extends Picture{

    /**
     * Constructs a PNGPicture object with no buffered image
     */
    public PNGPicture(){}

    /**
     * Constructs new PNGPicture given a buffer that is passed in
     * @param buffer this is the BufferedImage that is the source for this bitmap
     */
    public PNGPicture(BufferedImage buffer){
        super(buffer);
    }

    /**
     * Load a picture from an image file
     * @param file the file containing the image
     * @throws IOException
     */
    public void load(File file) throws IOException{
        if(file != null){
            buffer = ImageIO.read(file);
            lastFile = file;
        }else{
            buffer = ImageIO.read(lastFile);
        }
    }

    /**
     * Save the picture to an image file
     * @param file the file to be written
     * @throws IOException
     */
    public void store(File file) throws IOException{
        String extension = file.getName().substring(file.getName().lastIndexOf("."), file.getName().length());
        if(extension.equals(".png")){
            ImageIO.write(buffer,"png",file);
            JOptionPane.showMessageDialog(null, "Image saved successfully.");
        }else{
            throw new InputMismatchException("Incorrect file extension used.");
        }
    }
}
