
/**
 * SE1021 - 032
 * Winter 2016
 * Lab 8
 * Name: Ian Guswiler
 * Created: 2/19/2016
 */

/**
 * Grayscale implementation of the PixelManipulator
 * @author Ian Guswiler
 * @verison 2/19/2016
 */
public class GrayscaleManipulator implements PixelManipulator {

    /**
     * Calculates an rgb value for a given pixel that will create a grayscale image
     * @param rgb starting sRGB value for the selected pixel
     * @param row ignored
     * @param col ignored
     * @return calculated sRGB value for the grayscale pixel
     */
    public int transformPixel(int rgb, int row, int col){
        Pixel pixel = new Pixel(rgb);
        pixel.setRed((int) ((0.2126 * pixel.getRed()) + (0.7152 * pixel.getGreen()) + (0.0722 * pixel.getBlue())));
        pixel.setGreen((int) ((0.2126 * pixel.getRed()) + (0.7152 * pixel.getGreen()) + (0.0722 * pixel.getBlue())));
        pixel.setBlue((int) ((0.2126 * pixel.getRed()) + (0.7152 * pixel.getGreen()) + (0.0722 * pixel.getBlue())));
        return pixel.getSRGB();
    }
}
