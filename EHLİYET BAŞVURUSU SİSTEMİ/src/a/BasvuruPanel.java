package a;

/*
ONUR ŞAHİN 230609029
YUSUF AYKUT 230609004
EMRE İLERİ 230609003
YUSUF DÜNYA 230609054
*/
import javax.swing.*;
import java.awt.*;

public class BasvuruPanel extends JPanel {

    private JPanel mainPanel;

    public BasvuruPanel(JPanel mainPanel) { 
        this.mainPanel = mainPanel;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

        // Başlık ekliyoruz ve fontu büyütüyoruz
        JLabel titleLabel = new JLabel("Başvuru Formu", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));  // Fontu büyütüyoruz

        // UI elemanlarını oluşturuyoruz
        JLabel nameLabel = new JLabel("Adınız:");
        JTextField nameField = new JTextField(20);

        JLabel surnameLabel = new JLabel("Soyadınız:");
        JTextField surnameField = new JTextField(20);

        JLabel ageLabel = new JLabel("Yaşınız:");
        JTextField ageField = new JTextField(20);

        JLabel tcLabel = new JLabel("TC Kimlik No:");
        JTextField tcField = new JTextField(20);

        JLabel ehliyetTurLabel = new JLabel("Ehliyet Türü:");
        JComboBox<String> ehliyetTurComboBox = new JComboBox<>(new String[] {"Seçiniz", "M, A1 ve B1", "A2, B, BE, C1, C1E, F ve G", "A Ehliyet", "C, CE, D1 ve D1E", "D ve DE"});

        JButton submitButton = new JButton("Başvuruyu Gönder");
        JLabel resultLabel = new JLabel("");

        // Ders Seçim panelini ekliyoruz
        JPanel dersSecimPanel = new DersSecimPanel();

        // Başlığı en üste yerleştiriyoruz
        gbc.gridwidth = 2;
        addComponent(titleLabel, 0, 0, gbc); // Başlık üst tarafa taşındı
        
        // UI elemanlarını yerleştiriyoruz
        gbc.gridwidth = 1;  // Diğer bileşenlerin gridwidth'ini 1 yapıyoruz
        addComponent(nameLabel, 0, 1, gbc);
        addComponent(nameField, 1, 1, gbc);

        addComponent(surnameLabel, 0, 2, gbc);
        addComponent(surnameField, 1, 2, gbc);

        addComponent(ageLabel, 0, 3, gbc);
        addComponent(ageField, 1, 3, gbc);

        addComponent(tcLabel, 0, 4, gbc);
        addComponent(tcField, 1, 4, gbc);

        addComponent(ehliyetTurLabel, 0, 5, gbc);
        addComponent(ehliyetTurComboBox, 1, 5, gbc);

        addComponent(submitButton, 0, 6, gbc);
        gbc.gridwidth = 2;
        addComponent(resultLabel, 0, 7, gbc);
        addComponent(dersSecimPanel, 0, 8, gbc);

        // Başvuru gönder butonuna tıklama olayını ekliyoruz
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String ageText = ageField.getText();
            String tcText = tcField.getText();
            String selectedEhliyetTur = (String) ehliyetTurComboBox.getSelectedItem();

            // Ehliyet Türü seçilmedi mi kontrolü
            if ("Seçiniz".equals(selectedEhliyetTur)) {
                resultLabel.setText("Lütfen bir ehliyet türü seçiniz.");
                return;
            }

            try {
                int age = Integer.parseInt(ageText);

                if (tcText.length() != 11 || !tcText.matches("[0-9]+")) {
                    resultLabel.setText("Geçerli bir TC Kimlik numarası giriniz.");
                } else if (!((DersSecimPanel) dersSecimPanel).isAnyCourseSelected()) {
                    resultLabel.setText("Lütfen ders seçiminizi yapınız.");
                } else if (EhliyetTurleriPanel.isEligibleForLicense(selectedEhliyetTur, age)) {
                    boolean tcVarMi = false;
                    for (String[] basvuru : BasvuruListesiPanel.basvuranlar) {
                        if (basvuru[3].equals(tcText)) {
                            tcVarMi = true;
                            break;
                        }
                    }

                    if (tcVarMi) {
                        resultLabel.setText("Bu TC Kimlik numarası ile daha önce başvuru yapılmıştır.");
                    } else {
                        // Ders saatleri alınacak ve başvuruya eklenecek
                        String dersSaatleri = ((DersSecimPanel) dersSecimPanel).getSelectedDersSaatleri();
                        BasvuruListesiPanel.addBasvuru(name, surname, age, tcText, selectedEhliyetTur, dersSaatleri);

                        resultLabel.setText("Başvurunuz onaylandı.");
                    }
                } else {
                    resultLabel.setText("Yaşınız, " + selectedEhliyetTur + " ehliyeti için uygun değil.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Geçerli bir yaş giriniz.");
            }
        });
    }

    // Bileşenleri yerleştiren yardımcı metot
    private void addComponent(Component component, int gridx, int gridy, GridBagConstraints gbc) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        add(component, gbc);
    }
}
