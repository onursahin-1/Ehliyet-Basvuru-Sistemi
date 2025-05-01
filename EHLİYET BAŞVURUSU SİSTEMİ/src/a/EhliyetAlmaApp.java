package a;

/*
ONUR ŞAHİN 230609029
YUSUF AYKUT 230609004
EMRE İLERİ 230609003
YUSUF DÜNYA 230609054
*/
import javax.swing.*;
import java.awt.*;

 public class EhliyetAlmaApp {
    public static void main(String[] args) {
        // Ana pencereyi oluşturuyoruz
        JFrame frame = new JFrame("Ehliyet Alma Uygulaması");
        
        // Tam ekran yapıyoruz
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true); // Pencere başlık çubuğunu kaldırıyoruz
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ana paneli oluşturuyoruz
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());

        // Modülleri oluşturuyoruz
        EhliyetTurleriPanel ehliyetTurleriPanel = new EhliyetTurleriPanel(mainPanel);
        BasvuruPanel basvuruPanel = new BasvuruPanel(mainPanel);
        BasvuruListesiPanel basvuruListesiPanel = new BasvuruListesiPanel();
        OdemeBilgileriPanel odemeBilgileriPanel = new OdemeBilgileriPanel();

        // Menü panelini oluşturuyoruz
        JPanel menuPanel = new MenuPanel(mainPanel, ehliyetTurleriPanel, basvuruPanel, basvuruListesiPanel);

        // Ana pencereye ekliyoruz
        mainPanel.add(basvuruPanel, "Başvuru"); // Başvuru ekranını varsayılan olarak ekliyoruz
        mainPanel.add(ehliyetTurleriPanel, "Ehliyet Türleri");
        mainPanel.add(basvuruListesiPanel, "Başvuru Listesi");
        mainPanel.add(odemeBilgileriPanel, "Ödeme Bilgileri");

        // Frame'de menü panelini sol tarafa, içerik panelini ortada yerleştiriyoruz
        frame.setLayout(new BorderLayout());
        frame.add(menuPanel, BorderLayout.WEST); // Menü panelini sol tarafa ekliyoruz
        frame.add(mainPanel, BorderLayout.CENTER); // Ana içerik paneli ortada

        frame.setVisible(true); // Görünür yapıyoruz
    }
}
