
/**
 * SE1021 - 032
 * Winter 2016
 * Lab 8
 * Name: Ian Guswiler
 * Created: 2/19/2016
 */

/**
 * Defines a transformation that removes all green and blue components to leave only the red color remaining
 *
 * @author Ian Guswiler
 * @version 2/19/2016
 */
public class RedOnlyManipulator implements PixelManipulator {

    /**
     * Removes green and blue components of a color
     * @param rgb the color of the pixel to be transformed
     * @param row the index of the row in which the pixel is found
     * @param col the index of the column in which the pixel is found
     * @return
     */
    public int transformPixel(int rgb, int row, int col){
        Pixel pixel = new Pixel(rgb);
        pixel.setGreen(0);
        pixel.setBlue(0);
        return pixel.getSRGB();
    }
}
