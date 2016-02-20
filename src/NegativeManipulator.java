/**
 * SE1021 - 032
 * Winter 2016
 * Lab 8
 * Name: Ian Guswiler
 * Created: 2/19/2016
 */

/**
 * Negative implementation of the PixelManipulator
 *
 * @author Ian Guswiler
 * @version 2/19/2016
 */
public class NegativeManipulator implements PixelManipulator {

    /**
     * Creates an sRGB value for a given pixel that will create a negative image
     * @param rgb initial sRGB value for the pixel
     * @param row ignored
     * @param col ignored
     * @return calculated sRGB value that will result in a negative pixel
     */
    public int transformPixel(int rgb, int row, int col){
        Pixel pixel = new Pixel(rgb);
        pixel.setRed(255 - pixel.getRed());
        pixel.setGreen(255 - pixel.getGreen());
        pixel.setBlue(255 - pixel.getBlue());
        return pixel.getSRGB();
    }
}
