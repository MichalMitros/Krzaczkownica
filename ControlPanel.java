import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Michał Mitros
 */
public class ControlPanel extends JPanel implements ActionListener{

    private JButton randButton;
    private JLabel signLabel;
    private JButton pisanieButton;
    private JButton czytanieButton;
    private JTextField wprowField;
    private JLabel resultLabel;
    private JButton okButton;
    private JLabel scoreLabel;
    private JButton resetButton;
    private Hiragana hiragana;
    private int index = -1;
    private int total = 0;
    private int good = 0;
    private boolean isChecking = false;

    public ControlPanel() {
        setLayout(null);

        hiragana = new Hiragana();

        randButton = new JButton("Losuj");
        randButton.setBounds(225, 440, 150, 50);
        randButton.setFont(new Font("Courier New", Font.BOLD, 16));
        randButton.addActionListener(this);
        add(randButton);

        signLabel = new JLabel(" ", JLabel.CENTER);
        signLabel.setBounds(0, 120, 600, 260);
        signLabel.setFont(new Font("Courier New", Font.BOLD, 220));
        signLabel.setForeground(Color.WHITE);
        add(signLabel);

        pisanieButton = new JButton("Pisanie");
        pisanieButton.setBounds(50, 30, 100, 30);
        pisanieButton.setEnabled(false);
        pisanieButton.addActionListener(this);
        pisanieButton.setFocusable(false);
        add(pisanieButton);

        czytanieButton = new JButton("Czytanie");
        czytanieButton.setBounds(155, 30, 100, 30);
        czytanieButton.setEnabled(true);
        czytanieButton.addActionListener(this);
        czytanieButton.setFocusable(false);
        add(czytanieButton);

        wprowField = new JTextField();
        wprowField.setBounds(200, 440, 125, 40);
        wprowField.setVisible(false);
        add(wprowField);

        okButton = new JButton("OK");
        okButton.setBounds(330, 440, 80, 40);
        okButton.addActionListener(this);
        okButton.setVisible(false);
        add(okButton);

        resultLabel = new JLabel("", JLabel.RIGHT);
        resultLabel.setBounds(100, 420, 95, 80);
        resultLabel.setFont(new Font("Courier New", Font.BOLD, 32));
        resultLabel.setForeground(Color.GREEN);
        resultLabel.setVisible(false);
        add(resultLabel);

        scoreLabel = new JLabel("Wynik: 0/0", JLabel.LEFT);
        scoreLabel.setBounds(375, 50, 210, 50);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Courier New", Font.BOLD, 22));
        scoreLabel.setVisible(false);
        add(scoreLabel);

        resetButton = new JButton("Reset");
        resetButton.setBounds(375, 100, 100, 30);
        resetButton.setFocusable(false);
        resetButton.setVisible(false);
        resetButton.addActionListener(this);
        add(resetButton);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if(o == randButton) {
            if(!isChecking) {
                index = hiragana.getRandomIndex();
                index = 30+(int)(Math.random()*16);
                signLabel.setFont(new Font("Courier New", Font.BOLD, 150));
                signLabel.setText(hiragana.getHepburnFromIndex(index));
                randButton.setText("Sprawdź");
                isChecking = true;
            } else {
                signLabel.setFont(new Font("Courier New", Font.PLAIN, 220));
                signLabel.setText(hiragana.getSignFromIndex(index));
                randButton.setText("Losuj");
                isChecking = false;
            }
        }
        if(o == pisanieButton) {
            czytanieButton.setEnabled(true);
            pisanieButton.setEnabled(false);
            randButton.setVisible(true);
            signLabel.setText("");
            wprowField.setVisible(false);
            okButton.setVisible(false);
            resultLabel.setVisible(false);
            scoreLabel.setVisible(false);
            resetButton.setVisible(false);
            index = -1;
            isChecking = false;
            randButton.setText("Losuj");
        }
        if(o == czytanieButton) {
            pisanieButton.setEnabled(true);
            czytanieButton.setEnabled(false);
            randButton.setVisible(false);
            wprowField.setVisible(true);
            okButton.setVisible(true);
            resultLabel.setVisible(true);
            scoreLabel.setVisible(true);
            resetButton.setVisible(true);
            resultLabel.setText("");
            wprowField.setText("");
            index = hiragana.getRandomIndex();
            signLabel.setText(hiragana.getSignFromIndex(index));
            signLabel.setFont(new Font("Courier New", Font.PLAIN, 220));
        }
        if(o == okButton) {
            if(hiragana.isCorrect(wprowField.getText(), index)) {
                resultLabel.setForeground(Color.GREEN);
                resultLabel.setText("✔");
                good++;
            } else {
                resultLabel.setForeground(Color.RED);
                resultLabel.setText("x");
            }
            index = hiragana.getRandomIndex();
            //if(index <= 30) index = 30+(int)(Math.random()*28);
            signLabel.setText(hiragana.getSignFromIndex(index));
            total++;
            wprowField.setText("");
            scoreLabel.setText("Wynik: " + good + "/" + total);
        }
        if(o == resetButton) {
            total = 0;
            good = 0;
            scoreLabel.setText("Wynik: " + good + "/" + total);
        }
    }
}