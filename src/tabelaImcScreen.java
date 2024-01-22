import javax.swing.*;
import java.awt.*;

public class tabelaImcScreen extends JFrame {

    public tabelaImcScreen() {
        setTitle("Classificação de IMC");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 3, 10, 5));

        // Cabeçalho
        adicionarCelula(panel, "Classificação", new Color(8, 151, 157), true, Color.WHITE, SwingConstants.CENTER);
        adicionarCelula(panel, "IMC Mínimo", new Color(8, 151, 157), true, Color.WHITE, SwingConstants.CENTER);
        adicionarCelula(panel, "IMC Máximo", new Color(8, 151, 157), true, Color.WHITE, SwingConstants.CENTER);

        // Dados
        adicionarCelula(panel, "Magreza", Color.WHITE, false, Color.BLACK, SwingConstants.CENTER);
        adicionarCelula(panel, "0", Color.WHITE, false, Color.BLACK, SwingConstants.CENTER);
        adicionarCelula(panel, "18.5", Color.WHITE, false, Color.BLACK, SwingConstants.CENTER);

        adicionarCelula(panel, "Normal", Color.white, false, Color.BLACK, SwingConstants.CENTER);
        adicionarCelula(panel, "18.5", Color.white, false, Color.BLACK, SwingConstants.CENTER);
        adicionarCelula(panel, "24.9", Color.white, false, Color.BLACK, SwingConstants.CENTER);

        adicionarCelula(panel, "Sobrepeso", Color.WHITE, false, Color.BLACK, SwingConstants.CENTER);
        adicionarCelula(panel, "25", Color.WHITE, false, Color.BLACK, SwingConstants.CENTER);
        adicionarCelula(panel, "29.9", Color.WHITE, false, Color.BLACK, SwingConstants.CENTER);

        adicionarCelula(panel, "Obesidade Grau I", Color.white, false, Color.BLACK, SwingConstants.CENTER);
        adicionarCelula(panel, "30", Color.white, false, Color.BLACK, SwingConstants.CENTER);
        adicionarCelula(panel, "34.9", Color.white, false, Color.BLACK, SwingConstants.CENTER);

        adicionarCelula(panel, "Obesidade Grau II", Color.WHITE, false, Color.BLACK, SwingConstants.CENTER);
        adicionarCelula(panel, "35", Color.WHITE, false, Color.BLACK, SwingConstants.CENTER);
        adicionarCelula(panel, "39.9", Color.WHITE, false, Color.BLACK, SwingConstants.CENTER);

        adicionarCelula(panel, "Obesidade Grau III", Color.white, false, Color.BLACK, SwingConstants.CENTER);
        adicionarCelula(panel, "40", Color.white, false, Color.BLACK, SwingConstants.CENTER);
        adicionarCelula(panel, "Máximo", Color.white, false, Color.BLACK, SwingConstants.CENTER);

        // Adicionar o JPanel ao JFrame
        getContentPane().add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void adicionarCelula(JPanel panel, String texto, Color corFundo, boolean negrito, Color corTexto, int alinhamento) {
        JLabel label = new JLabel(texto);
        label.setBackground(corFundo);
        label.setForeground(corTexto);
        label.setOpaque(true);
        if (negrito) {
            label.setFont(new Font("Inter", Font.BOLD, 17));
        } else {
            label.setFont(new Font("Inter", Font.PLAIN, 17));
        }
        label.setHorizontalAlignment(alinhamento);
        panel.add(label);
    }
      

}
