
/**
 * SE1021 - 032
 * Winter 2016
 * Lab 8
 * Name: Ian Guswiler
 * Created: 2/4/2016
 */

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
 * User interface and event handling for the program
 *
 * @author Ian Guswiler
 * @version 2/19/2016
 */
public class ImageViewer extends JFrame {
    private ImageIcon displayImage = new ImageIcon();
    private static final JFileChooser fc = new JFileChooser();
    private Picture picture = new EmptyPicture();
    private static final long serialVersionUID = 1L;

    /**
     * Builds the program gui
     */
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

    /**
     * creates a generic JButton with given label and actionListener
     * @param label label to be put on the button
     * @param listener actionListener for the button
     * @return returns the JButton that was created
     */
    private JButton createButton(String label, ActionListener listener){
        JButton button = new JButton(label);
        button.addActionListener(listener);
        return button;
    }

    /**
     * Makes use of the file chooser to load an image from a file
     */
    private void loadImage(){
        int returnVal = fc.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            try {
                selectPictureType(fc.getSelectedFile());
                picture.load(fc.getSelectedFile());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InputMismatchException e1){
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Reloads the last successfully loaded file
     */
    private void reloadImage(){
        if(picture != null){
            try {
                picture.load(picture.lastFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Makes use of the file chooser to save the image to a file
     */
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

    /**
     * Determines the user selected file type and creates the correct picture class to go along with it
     * @param file selected file to check the type of
     */
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
                throw new InputMismatchException("File type " + extension + " is not supported");
        }
    }

    /**
     * Determines the user selected file type and creates the correct picture class with a preloaded bufferedImage
     * @param file selected file to check the type of
     * @param buffer bufferedImage to be loaded into the picture
     */
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
                throw new InputMismatchException("File type " + extension + " is not supported");
        }
    }

    /**
     * creates the gui and sets it as visible
     * @param args ignored
     */
    public static void main(String[] args) {
        ImageViewer viewer = new ImageViewer();
        viewer.setVisible(true);
    }

    /**
     * updates the displayed image
     */
    public void updateImage(){
        displayImage.setImage(picture.getImage());
    }

    /**
     * transforms the current image depending on the selected manipulator type
     * @param manipulator type of manipulator to be used on the image
     */
    private void transformImage(PixelManipulator manipulator){
        ImageTransform transformer = new ImageTransform(picture.getImage(), manipulator);
        transformer.transformImage();
        picture.buffer = transformer.buffer;
    }
}
