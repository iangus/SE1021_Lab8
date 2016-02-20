
/**
 * SE1021 - 032
 * Winter 2016
 * Lab 8
 * Name: Ian Guswiler
 * Created: 2/4/2016
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Abstract class that represents an image
 *
 * @author Ian Guswiler
 * @version 2/19/2016
 */
public abstract class Picture {
    protected BufferedImage buffer;
    protected File lastFile;

    /**
     * Gets the height of the picture
     * @return the height of the picture
     */
    public int getHeight(){
        return buffer.getHeight();
    }

    /**
     * Gets the image associated with the picture
     * @return The image associated with the picture
     */
    public BufferedImage getImage(){
        return buffer;
    }

    /**
     * Gets the width of the picture
     * @return the width of the picture
     */
    public int getWidth(){
        return buffer.getWidth();
    }

    /**
     * Loads a picture from an image file
     * @param file
     * @throws IOException
     */
    public abstract void load(File file) throws IOException;

    /**
     * Constructs a new picture given a buffer that is passed in
     * @param buffer
     */
    public Picture(BufferedImage buffer){
        this.buffer = buffer;
    }

    /**
     * Constructs a picture object with no buffered image
     */
    public Picture(){

    }

    /**
     * Save the picture to an image file
     * @param file the file to be written
     * @throws IOException
     */
    public abstract void store(File file) throws IOException;
}
