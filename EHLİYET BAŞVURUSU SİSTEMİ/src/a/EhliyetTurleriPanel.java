package a;

/*
ONUR ŞAHİN 230609029
YUSUF AYKUT 230609004
EMRE İLERİ 230609003
YUSUF DÜNYA 230609054
*/
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class EhliyetTurleriPanel extends JPanel {

    private JPanel mainPanel;
    public static String selectedEhliyetTur = "";

    // Ehliyet türleri ve yaş sınırları
    private static final HashMap<String, Integer> ehliyetTurleri = new HashMap<>();
    private static final HashMap<String, String> ehliyetTurleriBilgiler = new HashMap<>();

    static {
        ehliyetTurleri.put("M, A1 ve B1", 16);
        ehliyetTurleri.put("A2, B, BE, C1, C1E, F ve G", 18);
        ehliyetTurleri.put("A Ehliyet", 20);
        ehliyetTurleri.put("C, CE, D1 ve D1E", 21);
        ehliyetTurleri.put("D ve DE", 24);

        // Ehliyet türleri hakkında açıklamalar
        ehliyetTurleriBilgiler.put("M, A1 ve B1", "16 yaşından itibaren, küçük araçlar için ehliyetlerdir.");
        ehliyetTurleriBilgiler.put("A2, B, BE, C1, C1E, F ve G", "18 yaşından itibaren, motorlu taşıtlar için alınabilecek ehliyet türleridir.");
        ehliyetTurleriBilgiler.put("A Ehliyet", "20 yaşından itibaren, büyük motosikletler için alınacak ehliyettir.");
        ehliyetTurleriBilgiler.put("C, CE, D1 ve D1E", "21 yaşından itibaren, kamyon ve büyük araçlar için ehliyet türleridir.");
        ehliyetTurleriBilgiler.put("D ve DE", "24 yaşından itibaren, otobüs ve büyük araçlar için ehliyet türleridir.");
    }

     public EhliyetTurleriPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        setLayout(new BorderLayout());

        // Başlık ekliyoruz
        JLabel titleLabel = new JLabel("Ehliyet Türleri Hakkında Bilgi", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30)); // Başlık fontunu iyileştirdik
        titleLabel.setPreferredSize(new Dimension(0, 70)); // Başlık yüksekliğini artırdık
        titleLabel.setForeground(new Color(48, 48, 48)); // Başlık rengini daha dikkat çekici hale getirdik
        add(titleLabel, BorderLayout.NORTH);

        // İçeriği göstermek için bir panel oluşturuyoruz
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(ehliyetTurleri.size(), 1, 20, 20)); // GridLayout ile düzenleme
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Kenarlardan boşluk
        contentPanel.setBackground(new Color(35, 35, 35)); // Daha koyu gri arka plan

        // Ehliyet türleri ve açıklamaları ekliyoruz
        for (String ehliyet : ehliyetTurleri.keySet()) {
            JPanel ehliyetPanel = new JPanel();
            ehliyetPanel.setLayout(new BorderLayout(10, 10)); // İçeriği hizalamak için BorderLayout kullanıyoruz
            ehliyetPanel.setBackground(new Color(45, 45, 45)); // Panel arka planını koyu gri yapıyoruz
            ehliyetPanel.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1)); // Panel kenarına ince bir çizgi ekliyoruz

            // Ehliyet türü yazısı
            JLabel label = new JLabel(ehliyet + " (Yaş: " + ehliyetTurleri.get(ehliyet) + ")", JLabel.LEFT);
            label.setFont(new Font("Segoe UI", Font.BOLD, 18)); // Ehliyet türü yazısı fontu
            label.setForeground(new Color(211, 211, 211)); // Açık gri renk

            // Açıklama metni
            JTextArea textArea = new JTextArea(ehliyetTurleriBilgiler.get(ehliyet));
            textArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            textArea.setEditable(false);
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setBackground(new Color(45, 45, 45)); // Panelle uyumlu arka plan rengi
            textArea.setForeground(new Color(211, 211, 211)); // Yazı rengi (açık gri)
            textArea.setPreferredSize(new Dimension(400, 100));

            // Paneli düzenli hale getirmek için ekliyoruz
            ehliyetPanel.add(label, BorderLayout.NORTH);
            ehliyetPanel.add(textArea, BorderLayout.CENTER);

            contentPanel.add(ehliyetPanel);
        }

        // ContentPanel'i ekliyoruz
        JScrollPane scrollPane = new JScrollPane(contentPanel); // İçeriğin kaydırılabilir olmasını sağlıyoruz
        add(scrollPane, BorderLayout.CENTER);
    }

    // Ehliyet türüne ve yaşa göre uygunluk kontrolü yapan metot
    public static boolean isEligibleForLicense(String ehliyetTur, int age) {
        return ehliyetTurleri.get(ehliyetTur) <= age;
    }
}
