import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConverterMain extends JFrame {

    ConverterEvent converter = new ConverterEvent(this);

    JPanel choicePanel = new JPanel();
    ButtonGroup choice = new ButtonGroup();
    JCheckBox fahrenheitToC = new JCheckBox("Fahrenheit do Celsiusz", false);
    JCheckBox celsiusToF = new JCheckBox("Celsiusz do Fahrenheit", true);

    JPanel inputResultPanel = new JPanel();
    JSpinner input = new JSpinner(new SpinnerNumberModel(0.0, -459.0, 459.0, 0.1));
    JLabel inputLabel = new JLabel("℃");
    JLabel equelsLabel = new JLabel("=");
    JLabel resultNumberLabel = new JLabel("32");
    JLabel resultLabel = new JLabel("℉");

    JPanel convertPanel = new JPanel();
    JButton convert = new JButton("Konwertuj");
    JButton reset = new JButton("Wyczyść");

    public ConverterMain() {
        super("Konwerter temperatury");

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        GridLayout layout = new GridLayout(3,5);
        setLayout(layout);

        convert.addActionListener(converter);
        input.addChangeListener(changeEvent -> converter.convert());
        reset.addActionListener(converter);
        reset.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                if (isEnter(keyEvent))
                converter.reset();
            }
        });
        fahrenheitToC.addItemListener(converter);
        celsiusToF.addItemListener(converter);

        FlowLayout layout1 =new FlowLayout(FlowLayout.CENTER, 10, 10);
        choice.add(fahrenheitToC);
        choice.add(celsiusToF);
        choicePanel.setLayout(layout1);
        choicePanel.add(fahrenheitToC);
        choicePanel.add(celsiusToF);
        add(choicePanel);

        inputResultPanel.setLayout(layout1);
        inputResultPanel.add(input);
        inputResultPanel.add(inputLabel);
        inputResultPanel.add(equelsLabel);
        inputResultPanel.add(resultNumberLabel);
        inputResultPanel.add(resultLabel);
        add(inputResultPanel);

        convertPanel.setLayout(layout1);
        convertPanel.add(convert);
        convertPanel.add(reset);
        add(convertPanel);

        setVisible(true);
        input.requestFocus(true);
    }

    private boolean isEnter (KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            return true;
        } else {
            return false;
        }
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            //Ignoruj błędy.
        }
    }

    public static void main(String[] args) {
        ConverterMain.setLookAndFeel();
        new ConverterMain();
    }
}