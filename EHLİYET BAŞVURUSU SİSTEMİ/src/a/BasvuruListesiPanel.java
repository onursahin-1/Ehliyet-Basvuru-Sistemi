package a;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class BasvuruListesiPanel extends JPanel {

    public static ArrayList<String[]> basvuranlar = new ArrayList<>();
    private JTable table;
    private static DefaultTableModel tableModel;

    public BasvuruListesiPanel() {
        setLayout(new BorderLayout());
        
        // Panel arka plan rengini değiştirelim
        setBackground(new Color(45, 45, 45)); // Koyu gri

        // Tablomuzun başlıkları
        String[] columnNames = {"Ad", "Soyad", "Yaş", "TC Kimlik No", "Ehliyet Türü", "Ders Seçimleri"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Tabloyu kaydırılabilir hale getiriyoruz
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Tablo teması ve renklerini ayarlıyoruz
        table.setBackground(new Color(50, 50, 50)); // Koyu gri arka plan
        table.setForeground(Color.WHITE); // Yazı rengi beyaz
        table.setFont(new Font("Arial", Font.PLAIN, 14)); // Yazı tipi

        // Başlık hücrelerini özelleştiriyoruz
        table.getTableHeader().setBackground(new Color(70, 70, 70)); // Başlık arka plan rengi
        table.getTableHeader().setForeground(Color.WHITE); // Başlık yazı rengi
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16)); // Başlık fontu

        // Hücrelere yatayda ortalanmış bir yazı stili ekleyelim
        table.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? new Color(60, 60, 60) : new Color(80, 80, 80)); // Alternatif satır renkleri
                c.setForeground(Color.WHITE); // Yazı rengi beyaz
                setHorizontalAlignment(CENTER); // Yatayda ortalanmış
                return c;
            }
        });

        // Sütun genişliklerini ayarlıyoruz
        adjustColumnWidths();

        // Başvuru listesine öğe ekleme (güncel listeyi yansıtma)
        updateBasvuruListesi();
    }

    // Sütun genişliklerini ayarlayan metot
    private void adjustColumnWidths() {
        table.getColumnModel().getColumn(0).setPreferredWidth(100); // Ad
        table.getColumnModel().getColumn(1).setPreferredWidth(100); // Soyad
        table.getColumnModel().getColumn(2).setPreferredWidth(50);  // Yaş
        table.getColumnModel().getColumn(3).setPreferredWidth(100); // TC Kimlik No
        table.getColumnModel().getColumn(4).setPreferredWidth(150); // Ehliyet Türü
        table.getColumnModel().getColumn(5).setPreferredWidth(200); // Ders Seçimleri
    }

    // Başvuru listesini güncelleyen metot
    public static void updateBasvuruListesi() {
        // Başvuru bilgilerini tablonun içine ekliyoruz
        tableModel.setRowCount(0); // Tablodaki mevcut satırları temizliyoruz

        // Başvuru listesindeki her başvuru için ders saati bilgilerini ekliyoruz
        for (String[] basvuru : basvuranlar) {
            String dersSaatleri = basvuru[5]; // Ders saatleri, BaşvuruPanel'den alınan veridir.
            Object[] row = new Object[] {basvuru[0], basvuru[1], basvuru[2], basvuru[3], basvuru[4], dersSaatleri};
            tableModel.addRow(row);
        }
    }

    // Başvuru listesindeki ders saatini kullanıcıdan alacak bir metot ekliyoruz.
    public static void addBasvuru(String name, String surname, int age, String tc, String ehliyetTur, String dersSaatleri) {
        // Başvuru verilerini basvuranlar listesine ekliyoruz
        basvuranlar.add(new String[] {name, surname, String.valueOf(age), tc, ehliyetTur, dersSaatleri});
        
        // Başvuru listesi güncelleniyor
        updateBasvuruListesi();
    }
}
