
/**
 * SE1021 - 032
 * Winter 2016
 * Lab 8
 * Name: Ian Guswiler
 * Created: 2/19/2016
 */

import java.awt.image.BufferedImage;

/**
 * Transformation object to take in a BufferedImage and manipulate it
 *
 * @author Ian Guswiler
 * @version 2/19/2016
 */
public class ImageTransform {
    protected BufferedImage buffer;
    protected PixelManipulator transform;

    /**
     * Constructs an ImageTransformer using a given BufferedImage and manipulator type
     * @param buffer image to be transformed
     * @param transform type of transformation to be done to the image
     */
    public ImageTransform(BufferedImage buffer, PixelManipulator transform){
        this.buffer = buffer;
        this.transform = transform;
    }

    /**
     * uses the selected manipulator type to transform each pixel of the specified image
     */
    public void transformImage(){
        for(int y = 0; y < buffer.getHeight(); y++){
            for(int x = 0; x < buffer.getWidth(); x++){
                int rgb = transform.transformPixel(buffer.getRGB(x,y),y,x);
                buffer.setRGB(x,y,rgb);
            }
        }
    }
}
