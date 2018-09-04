import javax.swing.*;

/**
 * @author Michał Mitros
 */

public class Krzaczkownica extends JFrame {

    private ControlPanel cp;

    public Krzaczkownica() {
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Krzaczkownica");
        setLayout(null);

        try {

            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);

        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e1) {
            ;
        }

        cp = new ControlPanel();
        cp.setBounds(0, 0, 600, 600);
        add(cp);

        setVisible(true);
        repaint();
    }

    public static void main(String[] args) {
        new Krzaczkownica();
    }
}