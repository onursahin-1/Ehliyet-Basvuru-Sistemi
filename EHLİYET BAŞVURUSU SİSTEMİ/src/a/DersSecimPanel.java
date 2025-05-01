package a;

/*
ONUR ŞAHİN 230609029
YUSUF AYKUT 230609004
EMRE İLERİ 230609003
YUSUF DÜNYA 230609054
*/
import javax.swing.*;
import java.awt.*;

public class DersSecimPanel extends JPanel {
    private JCheckBox[] checkBoxes;
    private JButton confirmButton;

    public DersSecimPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255, 239, 213)); // Pastel bir açık bej arka plan
        checkBoxes = new JCheckBox[] {
            new JCheckBox("Pazartesi 09:00 - 12:00"),
            new JCheckBox("Salı 13:00 - 16:00"),
            new JCheckBox("Çarşamba 10:00 - 13:00"),
            new JCheckBox("Perşembe 14:00 - 17:00")
        };
        
        for (JCheckBox checkBox : checkBoxes) {
            checkBox.setBackground(new Color(255, 239, 213)); // Checkbox'ların arka plan rengi
            add(checkBox);
        }

        confirmButton = new JButton("Ders Seçimlerini Onayla");
        confirmButton.setBackground(new Color(152, 251, 152)); // Pastel yeşil arka plan
        confirmButton.setForeground(Color.BLACK); // Siyah yazı
        add(confirmButton);
    }

    // Herhangi bir ders seçilip seçilmediğini kontrol eden metot
    public boolean isAnyCourseSelected() {
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    // Seçilen dersleri döndüren metot
    public String getSelectedCourses() {
        StringBuilder selectedCourses = new StringBuilder();
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                if (selectedCourses.length() > 0) {
                    selectedCourses.append(", ");
                }
                selectedCourses.append(checkBox.getText());
            }
        }
        return selectedCourses.toString();
    }

    // Ders saatlerini döndüren metot
    public String getSelectedDersSaatleri() {
        return getSelectedCourses();
    }
}
