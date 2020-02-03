import java.awt.event.*;

public class ConverterEvent implements Runnable, ActionListener, ItemListener {
    ConverterMain gui;
    Thread convert;
    Converter converter = new FahrenheitConverter();

    public ConverterEvent(ConverterMain in) {
        gui = in;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        if (command.equals("Konwertuj")) {
            convert();
        }
        if (command.equals("Wyczyść")) {
            reset();
        }
    }


    void convert() {
        convert = new Thread(this);
        convert.start();
        gui.reset.setEnabled(true);

    }

    void reset() {
        gui.resultNumberLabel.setText("32.0");
        gui.inputLabel.setText("℃");
        gui.resultLabel.setText("℉");
        gui.input.setValue(0.0);
        gui.celsiusToF.setSelected(true);
    }


    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        Object item = itemEvent.getItem();
        if (item == gui.fahrenheitToC) {
            gui.inputLabel.setText("℉");
            gui.resultLabel.setText("℃");
            celsiusz();
            convert();
        }
        if (item == gui.celsiusToF) {
            gui.inputLabel.setText("℃");
            gui.resultLabel.setText("℉");
            fahrenheit();
            convert();
        }
    }

    public Converter celsiusz() {
        return converter = new CelsiuseConverter();
    }

    public Converter fahrenheit() {
        return converter = new FahrenheitConverter();
    }

    @Override
    public void run() {
        Thread.currentThread();
        double in = (double) gui.input.getValue();
        double result = converter.calculate(in);
        gui.resultNumberLabel.setText(String.valueOf(result));
    }
}