package a;

/*
ONUR ŞAHİN 230609029
YUSUF AYKUT 230609004
EMRE İLERİ 230609003
YUSUF DÜNYA 230609054
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

     public MenuPanel(JPanel mainPanel, JPanel ehliyetTurleriPanel, JPanel basvuruPanel, JPanel basvuruListesiPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(45, 45, 45)); // Koyu gri arka plan rengi

        // Butonlar için estetik düzen
        JButton ehliyetTurleriButton = createStyledButton("Ehliyet Türleri", mainPanel, ehliyetTurleriPanel, "Ehliyet Türleri");
        JButton basvuruButton = createStyledButton("Başvuru", mainPanel, basvuruPanel, "Başvuru");
        JButton basvuruListesiButton = createStyledButton("Başvuru Listesi", mainPanel, basvuruListesiPanel, "Başvuru Listesi");
        JButton odemeBilgileriButton = createStyledButton("Ödeme Bilgileri", mainPanel, null, "Ödeme Bilgileri");

        // Çıkış Butonu
        JButton cikisButton = new JButton("Çıkış");
        cikisButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        cikisButton.setBackground(new Color(255, 105, 180)); // Canlı pembe
        cikisButton.setForeground(Color.WHITE);
        cikisButton.setMaximumSize(new Dimension(160, 40)); // Buton boyutunu ayarlıyoruz
        cikisButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cikisButton.setBorder(BorderFactory.createBevelBorder(10)); // Yuvarlatılmış köşeler
        cikisButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this, "Uygulamadan çıkmak istediğinizden emin misiniz?", "Çıkış", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0); // Programı kapatır
            }
        });

        // Butonları ekliyoruz
        add(ehliyetTurleriButton);
        add(Box.createVerticalStrut(10)); // Butonlar arasında boşluk bırakıyoruz
        add(basvuruButton);
        add(Box.createVerticalStrut(10));
        add(basvuruListesiButton);
        add(Box.createVerticalStrut(10));
        add(odemeBilgileriButton);
        add(Box.createVerticalStrut(10));
        add(cikisButton);
    }

    private JButton createStyledButton(String text, JPanel mainPanel, JPanel panelToShow, String cardName) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBackground(new Color(70, 70, 70)); // Koyu gri buton arka planı
        button.setForeground(Color.WHITE); // Buton yazı rengi beyaz
        button.setMaximumSize(new Dimension(160, 40)); // Buton boyutunu ayarlıyoruz
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBorder(BorderFactory.createBevelBorder(10)); // Yuvarlatılmış köşeler
        button.addActionListener(e -> {
            CardLayout cl = (CardLayout) (mainPanel.getLayout());
            cl.show(mainPanel, cardName); // Menüdeki paneli gösteriyoruz
        });
        return button;
    }
}
