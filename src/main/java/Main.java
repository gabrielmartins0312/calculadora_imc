import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    private JLabel pesoLabel, alturaLabel, resultadoLabel, escalaLabel;
    private JTextField pesoTextField, alturaTextField;
    private JButton calcularButton;
    private JPanel panel;

    public Main() {
        setTitle("Calculadora IMC");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        pesoLabel = new JLabel("Peso (kg): ");
        alturaLabel = new JLabel("Altura (m): ");
        resultadoLabel = new JLabel("");
        escalaLabel = new JLabel("");

        pesoTextField = new JTextField(10);
        alturaTextField = new JTextField(10);

        calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(this);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(pesoLabel);
        panel.add(pesoTextField);
        panel.add(alturaLabel);
        panel.add(alturaTextField);
        panel.add(calcularButton);
        panel.add(resultadoLabel);
        panel.add(escalaLabel);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcularButton) {
            try {
                double peso = Double.parseDouble(pesoTextField.getText());
                double altura = Double.parseDouble(alturaTextField.getText());

                double imc = peso / (altura * altura);

                String resultado = "Seu IMC é: " + String.format("%.2f", imc) + ". ";
                if (imc < 18.5)
                    resultado += "Você está abaixo do peso.";
                else if (imc >= 18.5 && imc < 24.9)
                    resultado += "Você está com peso normal.";
                else if (imc >= 24.9 && imc < 29.9)
                    resultado += "Você está com sobrepeso.";
                else
                    resultado += "Você está obeso.";

                resultadoLabel.setText(resultado);

                // Exemplo de escala de IMC
                escalaLabel.setText("> Escala IMC:  " +
                        " Abaixo do peso: < 18.5 |" +
                        " Peso normal: 18.5 - 24.9 |" +
                        " Sobrepeso: 24.9 - 29.9 |" +
                        " Obesidade: >= 30 |");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para peso e altura.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
