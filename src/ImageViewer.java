
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 2/4/2016
 */
public class ImageViewer extends JFrame {
    private ImageIcon displayImage = new ImageIcon();
    private static final JFileChooser fc = new JFileChooser();
    private Picture picture = new EmptyPicture();
    private static final long serialVersionUID = 1L;

    public ImageViewer(){
        setSize(910, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());

        JLabel image = new JLabel();
        displayImage.setImage(picture.getImage());
        image.setIcon(displayImage);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(7, 1));
        buttonsPanel.add(createButton("Load", e -> {
            loadImage();
            updateImage();
            image.setIcon(displayImage);
            image.revalidate();
            pack();
        }));
        buttonsPanel.add(createButton("Save", e -> {
            saveImage();
        }));
        buttonsPanel.add(createButton("Reload", e -> {
            reloadImage();
            updateImage();
            image.setIcon(displayImage);
            image.repaint();
            pack();
        }));
        buttonsPanel.add(createButton("Grayscale", e -> {
            transformImage(new GrayscaleManipulator());
            updateImage();
            image.repaint();
        }));
        buttonsPanel.add(createButton("Red", e -> {
            transformImage(new RedOnlyManipulator());
            updateImage();
            image.repaint();
        }));
        buttonsPanel.add(createButton("Red-Gray", e -> {
            transformImage(new RedGrayManipulator());
            updateImage();
            image.repaint();
        }));
        buttonsPanel.add(createButton("Negative", e -> {
            transformImage(new NegativeManipulator());
            updateImage();
            image.repaint();
        }));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 1;
        add(image, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        add(buttonsPanel, gbc);

    }

    private JButton createButton(String label, ActionListener listener){
        JButton button = new JButton(label);
        button.addActionListener(listener);
        return button;
    }

    private void loadImage(){
        int returnVal = fc.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            try {
                selectPictureType(fc.getSelectedFile());
                picture.load(fc.getSelectedFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void reloadImage(){
        if(picture != null){
            try {
                picture.load(picture.lastFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveImage(){
        int returnVal = fc.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            try{
                selectPictureType(fc.getSelectedFile(), picture.buffer);
                picture.store(fc.getSelectedFile());
            } catch (IOException e){
                e.printStackTrace();
            } catch (InputMismatchException e1){
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void selectPictureType(File file){
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        switch (extension){
            case ".jpg":
                picture = new JPEGPicture();
                break;
            case ".png":
                picture = new PNGPicture();
                break;
            case ".ppm":
                picture = new PPMPicture();
                break;
            case ".bmp":
                picture = new BMPPicture();
                break;
            default:
                picture = new EmptyPicture();
                JOptionPane.showMessageDialog(null, "File type " + extension + " is not supported", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void selectPictureType(File file, BufferedImage buffer){
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        switch (extension){
            case ".jpg":
                picture = new JPEGPicture(buffer);
                break;
            case ".png":
                picture = new PNGPicture(buffer);
                break;
            case ".ppm":
                picture = new PPMPicture(buffer);
                break;
            case ".bmp":
                picture = new BMPPicture(buffer);
                break;
            default:
                System.out.println("Something didn't work");
        }
    }

    public static void main(String[] args) {
        ImageViewer viewer = new ImageViewer();
        viewer.setVisible(true);
    }

    public void updateImage(){
        displayImage.setImage(picture.getImage());
    }

    private void transformImage(PixelManipulator manipulator){
        ImageTransform transformer = new ImageTransform(picture.getImage(), manipulator);
        transformer.transformImage();
        picture.buffer = transformer.buffer;
    }
}
