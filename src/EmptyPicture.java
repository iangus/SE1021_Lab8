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

/**
 * Represents an empty picture that is loaded when the program is first opened
 *
 * @author Ian Guswiler
 * @version 2/19/2016
 */
public class EmptyPicture extends Picture{
    public static final int DEFAULT_HEIGHT = 600;
    public static final int DEFAULT_WIDTH = 800;

    /**
     * Constructs the empty picture with given default value dimensions
     */
    public EmptyPicture(){
        buffer = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    /**
     * Constructs the empty picture with custom input dimensions
     * @param width desired pixel width for the empty picture
     * @param height desired pixel height for the empty picture
     */
    public EmptyPicture(int width, int height){
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    /**
     * Has no functionality for the empty picture type
     * @param file Ignored
     * @throws IOException
     */
    public void load(File file) throws IOException{}

    /**
     * Has no functionality for the empty picture type
     * @param file Ignored
     * @throws IOException
     */
    public void store(File file) throws IOException{}
}
