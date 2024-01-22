import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class imcScreen extends JFrame implements ActionListener {

    private JFrame frame = new JFrame();
    private JLabel labeTitulolImc = new JLabel();
    private JLabel labelAltura = new JLabel();
    private JLabel labelPeso = new JLabel();
    private JLabel labelImc = new JLabel();
    private JLabel labelClassificao = new JLabel();
    private JTextField inputAltura = new JTextField();
    private JTextField inputPeso = new JTextField();
    private JButton btnCalcular = new JButton();
    private JButton btnTabela = new JButton();

    public imcScreen() {

        labeTitulolImc.setText("IMC");
        labeTitulolImc.setFont(new Font("Inter", Font.BOLD, 40));
        labeTitulolImc.setBounds(155, 10, 130, 90);

        labelAltura.setText("Altura (ex.: 1.70)");
        labelAltura.setFont(new Font("Inter", Font.BOLD, 17));
        labelAltura.setBounds(40, 70, 150, 90);

        labelPeso.setText("Peso (ex.: 69.2)");
        labelPeso.setFont(new Font("Inter", Font.BOLD, 17));
        labelPeso.setBounds(40, 150, 150, 90);

        inputAltura.setBounds(40, 130, 300, 30);
        inputAltura.setBackground(new Color(233, 233, 233));
        inputAltura.setForeground(Color.BLACK);
        inputAltura.setFont(new Font("Inter", Font.BOLD, 17));

        // colocar margem na digitacao
        EmptyBorder margemBorder = new EmptyBorder(0, 6, 0, 0);
        inputAltura.setBorder(margemBorder);

        inputAltura.setDocument(new limiteCaracteres(4));
    
   

        inputAltura.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {//tecla desejada 
                        inputPeso.requestFocusInWindow();//input que eu quero ir :)
                    }
                }
            });

        inputPeso.setBounds(40, 210, 300, 30);
        inputPeso.setBackground(new Color(233, 233, 233));
        inputPeso.setForeground(Color.BLACK);
        inputPeso.setFont(new Font("Inter", Font.BOLD, 17));
        inputPeso.setBorder(margemBorder);

        inputPeso.setDocument(new limiteCaracteres(5));


        inputPeso.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                   btnCalcular.doClick();
            }
            
        });

        btnCalcular.setText("CALCULAR");
        btnCalcular.setBorder(null);
        btnCalcular.setBackground(new Color(8, 151, 157));
        btnCalcular.setFont(new Font("Inter", Font.BOLD, 20));
        btnCalcular.setForeground(Color.white);
        btnCalcular.setBounds(40, 260, 300, 40);
        btnCalcular.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // mudar a cor do botao quando o mouse entra no botao.
        btnCalcular.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCalcular.setBackground(new Color(8, 127, 157));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnCalcular.setBackground(new Color(8, 151, 157));
            }
        });


        btnTabela.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnTabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnTabela.setBackground(new Color(8, 127, 157));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnTabela.setBackground(new Color(8, 151, 157));
            }
        });

        btnCalcular.addActionListener(this);
        btnTabela.addActionListener(this);

        frame.add(labelImc);
        frame.add(labelClassificao);
        frame.add(labeTitulolImc);
        frame.add(labelAltura);
        frame.add(labelPeso);
        frame.add(inputAltura);
        frame.add(inputPeso);
        frame.add(btnCalcular);
        frame.add(btnTabela);

        frame.setTitle("Calcular IMC");
        frame.setSize(400, 550);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(254, 252, 255));
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // acao de clicar botao
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            try {
                if (inputAltura.getText().equals("") && inputPeso.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor inserir todos os dados", frame.getTitle(),
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Tenta converter os valores para float
                    float peso = Float.parseFloat(inputPeso.getText());
                    float altura = Float.parseFloat(inputAltura.getText());

                    // Verifica se os valores são inteiros
                    if (altura == (int) altura && peso == (int) peso) {
                        JOptionPane.showMessageDialog(null, "Por favor, digitar valores decimais, como no exemplo",
                                frame.getTitle(), JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        float calcImc = peso / (altura * altura);
                        String resultImc = String.format("%.1f", calcImc);

                        labelImc.setText("Seu IMC: " + resultImc);
                        labelImc.setFont(new Font("Inter", Font.BOLD, 20));
                        labelImc.setBounds(40, 310, 230, 35);
                        // labelImc.setOpaque(true); // Adicione esta linha para tornar o fundo visível
                        // labelImc.setBackground(Color.BLACK);

                        String classificacao = "";

                        if (calcImc >= 40) {
                            classificacao = "OBESIDADE III";
                        } else if (calcImc >= 35) {
                            classificacao = "OBESIDADE II";
                        } else if (calcImc >= 30) {
                            classificacao = "OBESIDADE I";
                        } else if (calcImc >= 25) {
                            classificacao = "SOBREPESO";
                        } else if (calcImc >= 18) {
                            classificacao = "NORMAL";
                        } else {
                            classificacao = "MAGREZA";
                        }

                        labelClassificao.setText("Classificação: " + classificacao);
                        labelClassificao.setFont(new Font("Inter", Font.BOLD, 20));
                        labelClassificao.setBounds(40, 320, 350, 90);

                        btnTabela.setText("VER TABELA IMC");
                        btnTabela.setBorder(null);
                        btnTabela.setBackground(new Color(8, 151, 157));
                        btnTabela.setFont(new Font("Inter", Font.BOLD, 20));
                        btnTabela.setForeground(Color.white);
                        btnTabela.setBounds(40, 390, 300, 40);

                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, digitar os dados corretamente", frame.getTitle(),
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == btnTabela) {
            new tabelaImcScreen();

        }

    }

}
