/*
Saya Jasmine Noor Fawzia [2200598] mengerjakan soal TP2 dalam Mata Kuliah DPBO
untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan
Aamiin
*/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Menu extends JFrame{
    public static void main(String[] args) {
        // buat object window
        Menu window = new Menu();

        // atur ukuran window
        window.setSize(480, 560);
        // letakkan window di tengah layar
        window.setLocationRelativeTo(null);
        // isi window
        window.setContentPane(window.mainPanel);
        // ubah warna background
        window.getContentPane().setBackground(Color.white);
        // tampilkan window
        window.setVisible(true);
        // agar program ikut berhenti saat window diclose
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // index baris yang diklik
    private int selectedIndex = -1;
    // list untuk menampung semua mahasiswa
    private ArrayList<Mahasiswa> listMahasiswa;
    private Database database;

    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox jenisKelaminComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JRadioButton aktifRadioButton;
    private JRadioButton cutiRadioButton;
    private JRadioButton tidakAktifRadioButton;
    private JLabel statusMhsLabel;
    private JRadioButton lulusRadioButton;

    // constructor
    public Menu() {
        // inisialisasi listMahasiswa
        listMahasiswa = new ArrayList<>();

        // buat objek database
        database = new Database();

        // isi tabel mahasiswa
        mahasiswaTable.setModel(setTable());

        // ubah styling title
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        // atur isi combo box
        String[] jenisKelaminData = {"", "Laki-laki", "Perempuan"};
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel(jenisKelaminData));

        // mengelompokkan radio button status mahasiswa
        ButtonGroup statusMhsGroup = new ButtonGroup();
        statusMhsGroup.add(aktifRadioButton);
        statusMhsGroup.add(cutiRadioButton);
        statusMhsGroup.add(tidakAktifRadioButton);
        statusMhsGroup.add(lulusRadioButton);

        // sembunyikan button delete
        deleteButton.setVisible(false);

        // saat tombol add/update ditekan
        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex == -1) {
                    insertData();
                } else {
                    updateData();
                }
            }
        });

        // saat tombol delete ditekan
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex >= 0) {
                    deleteData();
                }
            }
        });

        // saat tombol cancel ditekan
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        // saat salah satu baris tabel ditekan
        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // ubah selectedIndex menjadi baris tabel yang diklik
                selectedIndex = mahasiswaTable.getSelectedRow();

                // simpan value textfield, combo box, dan radio button
                String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();
                String selectedNama = mahasiswaTable.getModel().getValueAt(selectedIndex, 2).toString();
                String selectedJenisKelamin = mahasiswaTable.getModel().getValueAt(selectedIndex, 3).toString();
                String selectedStatusMhs = mahasiswaTable.getModel().getValueAt(selectedIndex, 4).toString();

                // ubah isi textfield, combo box, dan radio button
                nimField.setText(selectedNim);
                namaField.setText(selectedNama);
                jenisKelaminComboBox.setSelectedItem(selectedJenisKelamin);
                if(selectedStatusMhs.equals("Aktif")){
                    aktifRadioButton.setSelected(true);
                }
                if(selectedStatusMhs.equals("Cuti")){
                    cutiRadioButton.setSelected(true);
                }
                if(selectedStatusMhs.equals("Tidak Aktif")){
                    tidakAktifRadioButton.setSelected(true);
                }
                if(selectedStatusMhs.equals("Lulus")){
                    lulusRadioButton.setSelected(true);
                }

                // ubah button "Add" menjadi "Update"
                addUpdateButton.setText("Update");
                // tampilkan button delete
                deleteButton.setVisible(true);
            }
        });
    }

    // method untuk mendapatkan status mahasiswa dari radio button yang dipilih
    private String getStatusMhs() {
        if (aktifRadioButton.isSelected()) {
            return "Aktif";
        } else if (cutiRadioButton.isSelected()) {
            return "Cuti";
        } else if (tidakAktifRadioButton.isSelected()) {
            return "Tidak Aktif";
        } else if (lulusRadioButton.isSelected()) {
            return "Lulus";
        } else {
            return ""; // atau sesuaikan dengan default status mahasiswa jika tidak ada yang dipilih
        }
    }

    // method untuk set tabel
    public final DefaultTableModel setTable() {
        // tentukan kolom tabel
        Object[] column = {"No", "NIM", "Nama", "Jenis kelamin", "Status Mahasiswa"};

        // buat objek tabel dengan kolom yang sudah dibuat
        DefaultTableModel temp = new DefaultTableModel(null, column);

        // isi tabel dengan listMahasiswa
        try {
            ResultSet resultSet = database.selectQuery("SELECT * FROM mahasiswa");

            int i = 0;
            while (resultSet.next()) {
                Object[] row = new Object[5];

                row[0] = i + 1;
                row[1] = resultSet.getString("nim");
                row[2] = resultSet.getString("nama");
                row[3] = resultSet.getString("jenis_kelamin");
                row[4] = resultSet.getString("status_mhs");

                temp.addRow(row);
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return temp; // return juga harus diganti
    }

    //method untuk memasukkan data
    public void insertData() {
        // ambil value dari textfield, combobox, dan radio button
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String statusMhs = getStatusMhs();

        // validasi input kosong
        if (nim.isEmpty() || nama.isEmpty() || jenisKelamin.isEmpty() || statusMhs.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // cek nim sudah ada atau belum
        try {
            ResultSet resultSet = database.selectQuery("SELECT * FROM mahasiswa WHERE nim='" + nim + "'");
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "NIM tersebut sudah ada dalam database!", "Error", JOptionPane.ERROR_MESSAGE);

                // reset nilai nim pada field teks menjadi kosong
                nimField.setText("");

                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // tambahkan data ke dalam database
        String sql = "INSERT INTO mahasiswa VALUES (null, '" + nim + "', '" + nama + "', '" + jenisKelamin + "', '" + statusMhs + "');";
        database.insertUpdateDeleteQuery(sql);

        // update tabel
        mahasiswaTable.setModel(setTable());

        // bersihkan form
        clearForm();

        // feedback
        System.out.println("Insert berhasil!");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
    }

    //method untuk mengubah data
    public void updateData() {
        // ambil data dari form
        String nimLama = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String statusMhs = getStatusMhs();

        // validasi input kosong
        if (nim.isEmpty() || nama.isEmpty() || jenisKelamin.isEmpty() || statusMhs.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // cek nim baru tidak sama dengan nim lama
        if (!nim.equals(nimLama)) {
            // cek nim baru sudah ada atau belum
            try {
                ResultSet resultSet = database.selectQuery("SELECT * FROM mahasiswa WHERE nim='" + nim + "'");
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "NIM tersebut sudah ada dalam database!", "Error", JOptionPane.ERROR_MESSAGE);

                    // reset nilai nim pada field teks menjadi nim semula
                    nimField.setText(nimLama);

                    return;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        // ubah data mahasiswa di database
        String sql = "UPDATE mahasiswa SET nim='" + nim + "', nama='" + nama + "', jenis_kelamin='" + jenisKelamin + "', status_mhs='" + statusMhs + "' WHERE nim='" + nimLama + "'";
        database.insertUpdateDeleteQuery(sql);

        // update tabel
        mahasiswaTable.setModel(setTable());

        // bersihkan form
        clearForm();

        // feedback
        System.out.println("Update berhasil!");
        JOptionPane.showMessageDialog(null, "Data berhasil diubah!");

    }

    //method untuk menghapus data
    public void deleteData() {
        // ambil nim dari baris yang dipilih
        String nim = nimField.getText();

        // confirmation prompt sebelum delete
        int confirm = JOptionPane.showConfirmDialog(null, "Yakin hapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        // jika mengonfirmasi untuk melanjutkan penghapusan
        if (confirm == JOptionPane.YES_OPTION) {
            // hapus data dari database
            String sql = "DELETE FROM mahasiswa WHERE nim='" + nim + "'";
            database.insertUpdateDeleteQuery(sql);

            // update tabel
            mahasiswaTable.setModel(setTable());

            // bersihkan form
            clearForm();

            // feedback
            System.out.println("Delete berhasil!");
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        }
    }

    //method untuk mengosongkan form
    public void clearForm() {
        // kosongkan semua texfield, combo box, dan radio button
        nimField.setText("");
        namaField.setText("");
        jenisKelaminComboBox.setSelectedItem("");
        aktifRadioButton.setSelected(false);
        cutiRadioButton.setSelected(false);
        tidakAktifRadioButton.setSelected(false);
        lulusRadioButton.setSelected(false);

        // ubah button "Update" menjadi "Add"
        addUpdateButton.setText("Add");
        // sembunyikan button delete
        deleteButton.setVisible(false);
        // ubah selectedIndex menjadi -1 (tidak ada baris yang dipilih)
        selectedIndex = -1;
    }
}
