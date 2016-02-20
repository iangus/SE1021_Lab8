/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 2/19/2016
 */
public class NegativeManipulator implements PixelManipulator {
    public int transformPixel(int rgb, int row, int col){
        Pixel pixel = new Pixel(rgb);
        pixel.setRed(255 - pixel.getRed());
        pixel.setGreen(255 - pixel.getGreen());
        pixel.setBlue(255 - pixel.getBlue());
        return pixel.getSRGB();
    }
}
