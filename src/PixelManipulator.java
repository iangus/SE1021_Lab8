/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 2/19/2016
 */

/**
 * Describes a transformation from one sRGB color to another
 *
 * @author Ian Guswiler
 * @verison 2/19/2016
 */
public interface PixelManipulator {
    /**
     * Applies a transformation to an individual pixel
     * @param rgb the color of the pixel to be transformed
     * @param row the index of the row in which the pixel is found
     * @param col the index of the column in which the pixel is found
     * @return the color of the transformed pixel in sRGB format
     */
    int transformPixel(int rgb, int row, int col);
}
