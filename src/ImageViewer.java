import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * SE1021 - 032
 * Winter 2016
 * Lab
 * Name: Ian Guswiler
 * Created: 2/4/2016
 */
public class ImageViewer extends JFrame {
    private ImageIcon displayImage;
    private static final JFileChooser fc = new JFileChooser();
    private Picture picture;
    private static final long serialVersionUID = 1L;

    public ImageViewer(){
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridBagLayout());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(7, 1));
        buttonsPanel.add(createButton("Load", e -> {
            loadImage();
        }));
        buttonsPanel.add(createButton("Save", e -> System.out.println("Save pressed")));
        buttonsPanel.add(createButton("Reload", e -> System.out.println("Reload pressed")));
        buttonsPanel.add(createButton("Grayscale", e -> System.out.println("Grayscale pressed")));
        buttonsPanel.add(createButton("Red", e -> System.out.println("Red pressed")));
        buttonsPanel.add(createButton("Red-Gray", e -> System.out.println("Red-Gray pressed")));
        buttonsPanel.add(createButton("Negative", e -> System.out.println("Negative pressed")));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.5;
        gbc.weightx = 0.5;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
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
                picture.load(fc.getSelectedFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ImageViewer viewer = new ImageViewer();
        viewer.setVisible(true);
    }
}
