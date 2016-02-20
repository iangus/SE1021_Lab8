/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 2/19/2016
 */
public class RedGrayManipulator implements PixelManipulator {
    public int transformPixel(int rgb, int row, int col){
        Pixel pixel = new Pixel(rgb);
        int newRgb;
        if(row % 2 == 0){
            newRgb = new RedOnlyManipulator().transformPixel(rgb, row, col);
        }else{
            newRgb = new GrayscaleManipulator().transformPixel(rgb, row, col);
        }
        return newRgb;
    }
}
