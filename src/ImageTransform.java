import java.awt.image.BufferedImage;

/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 2/19/2016
 */
public class ImageTransform {
    protected BufferedImage buffer;
    protected PixelManipulator transform;

    public ImageTransform(BufferedImage buffer, PixelManipulator transform){
        this.buffer = buffer;
        this.transform = transform;
    }

    public void transformImage(){
        for(int y = 0; y < buffer.getHeight(); y++){
            for(int x = 0; x < buffer.getWidth(); x++){
                int rgb = transform.transformPixel(buffer.getRGB(x,y),y,x);
                buffer.setRGB(x,y,rgb);
            }
        }
    }
}
