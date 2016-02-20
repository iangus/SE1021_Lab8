/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 2/19/2016
 */
public class RedOnlyManipulator implements PixelManipulator {
    public int transformPixel(int rgb, int row, int col){
        Pixel pixel = new Pixel(rgb);
        pixel.setGreen(0);
        pixel.setBlue(0);
        return pixel.getSRGB();
    }
}
