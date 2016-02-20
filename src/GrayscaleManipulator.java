/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 2/19/2016
 */
public class GrayscaleManipulator implements PixelManipulator {
    public int transformPixel(int rgb, int row, int col){
        Pixel pixel = new Pixel(rgb);
        pixel.setRed((int) ((0.2126 * pixel.getRed()) + (0.7152 * pixel.getGreen()) + (0.0722 * pixel.getBlue())));
        pixel.setGreen((int) ((0.2126 * pixel.getRed()) + (0.7152 * pixel.getGreen()) + (0.0722 * pixel.getBlue())));
        pixel.setBlue((int) ((0.2126 * pixel.getRed()) + (0.7152 * pixel.getGreen()) + (0.0722 * pixel.getBlue())));
        return pixel.getSRGB();
    }
}
