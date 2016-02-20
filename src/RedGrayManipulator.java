
/**
 * SE1021 - 032
 * Winter 2016
 * Lab 8
 * Name: Ian Guswiler
 * Created: 2/19/2016
 */

/**
 * Transforms a color image into an image in which every other rows contains either grayscale pixels or pixels with
 * only the red content from the original image
 *
 * @author Ian Guswiler
 * @version 2/19/2016
 */
public class RedGrayManipulator implements PixelManipulator {

    /**
     * Transforms from a color to a grayscale representation of the color if the row is even of to the red-only
     * component of the color if the row is odd
     * @param rgb the color of the pixel to be transformed
     * @param row the index of the row in which the pixel is found
     * @param col the index of the column in which the pixel is found
     * @return
     */
    public int transformPixel(int rgb, int row, int col){
        int newRgb;
        if(row % 2 != 0){
            newRgb = new RedOnlyManipulator().transformPixel(rgb, row, col);
        }else{
            newRgb = new GrayscaleManipulator().transformPixel(rgb, row, col);
        }
        return newRgb;
    }
}
