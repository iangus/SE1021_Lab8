import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 2/10/2016
 */
public class PPMPicture extends Picture{
    public PPMPicture(){}

    public PPMPicture(BufferedImage buffer){
        super(buffer);
    }

    public void load(File file) throws IOException{
        if(file != null){
            Scanner fileScan = new Scanner(file);
            fileScan.nextLine();
            int width = fileScan.nextInt();
            int height = fileScan.nextInt();
            fileScan.nextInt();
            ArrayList<Pixel> pixelList = new ArrayList<>();
            while(fileScan.hasNextInt()){
                pixelList.add(new Pixel(fileScan.nextInt(), fileScan.nextInt(), fileScan.nextInt()));
            }
            int[] rgbArray = new int[pixelList.size()];
            for(int i = 0; i<pixelList.size();i++){
                rgbArray[i] = pixelList.get(i).getSRGB();
            }
            buffer = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            buffer.setRGB(0,0,width,height,rgbArray,0,width);
        }
    }

    public void store(File file) throws IOException{

    }

    private static String pixelToString(Pixel pixel){
        return "" + pixel.getRed() + " " + pixel.getGreen() +
                " " + pixel.getBlue();
    }
}
