package a;

/*
ONUR ŞAHİN 230609029
YUSUF AYKUT 230609004
EMRE İLERİ 230609003
YUSUF DÜNYA 230609054
*/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OdemeBilgileriPanel extends JPanel {

    public OdemeBilgileriPanel() {
        setLayout(new BorderLayout());

        // Başlık kısmını ekliyoruz
        JLabel titleLabel = new JLabel("Ödeme Bilgileri", JLabel.CENTER);
        titleLabel.setFont(new Font("Roboto", Font.BOLD, 36)); // Farklı bir yazı tipi ve büyüklük
        titleLabel.setPreferredSize(new Dimension(0, 80));
        titleLabel.setForeground(new Color(44, 44, 46)); // Antrasit gri rengi
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Başlık etrafına boşluk ekledik
        add(titleLabel, BorderLayout.NORTH);

        // Ödeme Bilgileri Tablosu
        String[] columnNames = {"Ödeme Bilgisi", "Tutar"};
        Object[][] paymentDetails = {
            {"Ehliyete Yazılma Ücreti", "11.000 TL"},
            {"Harç Ücreti", "5.678 TL"},
            {"Yazılı Sınav Ücreti", "1.200 TL"},
            {"Direksiyon Sınavı Ücreti", "1.350 TL"},
            {"Tekrar Sınav Ücreti", "4.000 TL"}
        };

        JTable table = new JTable(paymentDetails, columnNames);
        table.setFont(new Font("Roboto", Font.PLAIN, 22)); // Daha modern font ve boyut
        table.setForeground(Color.WHITE); // Yazı rengi beyaz
        table.setBackground(new Color(45, 45, 45)); // Koyu gri arka plan
        table.setRowHeight(50); // Satır yüksekliğini büyütüyoruz (50'ye çıkardık)
        table.setSelectionBackground(new Color(255, 105, 180)); // Seçili satır rengi
        table.setSelectionForeground(Color.WHITE); // Seçili satır yazı rengi
        table.setGridColor(new Color(200, 200, 200)); // Satır çizgileri rengi
        table.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Tabloya ince kenarlık ekledik

        // Tabloyu ekliyoruz, kaydırma çubuğu olmadan direkt ekrana tam sığacak şekilde
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(800, 300)); // Tabloyu ekrana sığdıracak şekilde boyutlandırıyoruz
        add(tableScrollPane, BorderLayout.CENTER);

        // Metin kısmı
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Metin düzenlenemez
        textArea.setText(
            "Yazılı Sınav\n" +
            "Kapsam: Trafik kuralları, ilk yardım, motor bilgisi gibi konulardan sorular içerir.\n\n" +
            "Süre: Sınav genellikle 50-60 dakika sürer.\n\n" +
            "Soru Sayısı: Ortalama olarak 50-60 soru bulunur.\n\n" +
            "Geçme Notu: Geçme notu genellikle 70 puan civarındadır.\n\n" +
            "Direksiyon Sınavı\n" +
            "Değerlendirme: Direksiyon hakimiyeti, trafik kurallarına uyma, park etme gibi beceriler değerlendirilir.\n\n" +
            "Süre: Sınav genellikle 30-45 dakika sürer.\n\n" +
            "Geçme Kriterleri: Hatalı park, trafik kurallarına uymama gibi hatalar geçme kriterlerini etkiler.\n\n" +
            "Hazırlık\n" +
            "Teorik Bilgi: Kitapçıklar ve online testler ile teorik bilginizi arttırın.\n\n" +
            "Pratik: Sık sık araç kullanarak direksiyon becerinizi geliştirin."
        );
        textArea.setFont(new Font("Roboto", Font.PLAIN, 18)); // Yazı tipi ve boyutunu güncelledik
        textArea.setBackground(new Color(45, 45, 45)); // Koyu gri arka plan
        textArea.setForeground(Color.WHITE); // Yazı rengi beyaz
        textArea.setCaretColor(Color.WHITE); // İmleci beyaz yaptık
        textArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Metne ince kenarlık ekledik

        // Metin kısmını bir panelin ortasına yerleştiriyoruz
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(new Color(45, 45, 45)); // Aynı koyu gri arka plan
        textPanel.add(textArea, BorderLayout.CENTER);
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10)); // Panel etrafına boşluk ekledik

        add(textPanel, BorderLayout.SOUTH);
    }
}
