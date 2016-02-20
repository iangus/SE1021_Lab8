import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
            lastFile = file;
            Scanner fileScan = new Scanner(file);
            fileScan.nextLine();
            boolean hasComments = true;
            String line = "";
            while(fileScan.hasNextLine() && hasComments){
                line = fileScan.nextLine();
                if(line.startsWith("#")){
                    continue;
                }else{
                    hasComments = false;
                }
            }
            Scanner lineScanner = new Scanner(line);
            int width = lineScanner.nextInt();
            int height = lineScanner.nextInt();
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
        FileWriter writer = new FileWriter(file);

        writer.write("P3\n" +
                getWidth() + " " + getHeight() + "\n" +
                "255\n");
        ArrayList<Pixel> pixels = getPixels();
        for(Pixel pixel : pixels){
            writer.write(pixelToString(pixel) + "    ");

        }
        writer.flush();
        writer.close();

    }

    private static String pixelToString(Pixel pixel){
        return "" + pixel.getRed() + " " + pixel.getGreen() +
                " " + pixel.getBlue();
    }

    private ArrayList<Pixel> getPixels(){
        int[] rgbArray = new int[getWidth() * getHeight()];
        buffer.getRGB(0,0,getWidth(),getHeight(),rgbArray,0,getWidth());
        ArrayList<Pixel> pixelList = new ArrayList<>();
        for(int rgb : rgbArray){
            pixelList.add(new Pixel(rgb));
        }
        return pixelList;
    }
}
