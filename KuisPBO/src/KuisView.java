import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;

public class KuisView extends JFrame {
    JLabel ljudul, ltipe, lstatus, lepisode, lrating, lgenre;
    JTextField tfjudul, tftipe, tfepisode, tfrating, tfgenre, tfsearch;
    JButton search, refresh, create, update, delete, exit;
    JComboBox cbstatus;
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID", "Judul", "Tipe", "Episode", "Genre", "Status", "Rating"};
    Statement statement;
    String[] status = {"Belum", "Selesai"};

    public KuisView() {
        setTitle("Peminjaman Film");

        //TABEL
        tableModel  = new DefaultTableModel(namaKolom, 0);
        tabel       = new JTable(tableModel);
        scrollPane  = new JScrollPane(tabel);

        //LABEL
        ljudul      = new JLabel("Judul");
        ltipe       = new JLabel("Tipe");
        lstatus     = new JLabel("Status");
        lepisode    = new JLabel("Episode");
        lrating     = new JLabel("Rating");
        lgenre      = new JLabel("Genre");

        //TEXTFIELD
        tfjudul     = new JTextField();
        tftipe      = new JTextField();
        tfepisode   = new JTextField();
        tfrating    = new JTextField();
        tfgenre     = new JTextField();
        tfsearch    = new JTextField();

        //BUTTON
        search  = new JButton("Search");
        refresh = new JButton("Refresh");
        create  = new JButton("Create");
        update  = new JButton("Update");
        delete  = new JButton("Delete");
        exit    = new JButton("Exit");

        //COMBOBOX
        cbstatus  = new JComboBox(status);

        setLayout(null);

        add(ljudul); add(ltipe); add(lstatus);
        add(lepisode); add(lrating); add(lgenre);

        add(tfjudul); add(tftipe); add(tfepisode);
        add(tfrating); add(tfgenre); add(tfsearch);

        add(search); add(refresh); add(create);
        add(update); add(delete); add(exit);

        add(cbstatus); add(scrollPane);

        scrollPane.setBounds(20, 20, 760, 150);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ljudul.setBounds(20, 190, 50, 20);
        tfjudul.setBounds(20, 220, 300, 20);
        ltipe.setBounds(20, 250, 50, 20);
        tftipe.setBounds(20, 280, 120, 20);
        lstatus.setBounds(200, 250, 50, 20);
        cbstatus.setBounds(200, 280, 120, 20);
        lepisode.setBounds(20, 310, 50, 20);
        tfepisode.setBounds(20, 340, 120, 20);
        lrating.setBounds(200, 310, 50, 20);
        tfrating.setBounds(200, 340, 120, 20);
        lgenre.setBounds(20, 370, 50, 20);
        tfgenre.setBounds(20, 400, 300, 20);
        tfsearch.setBounds(350, 220, 320, 20);
        search.setBounds(680, 220, 100, 20);
        refresh.setBounds(350, 400, 80, 20);
        create.setBounds(440, 400, 80, 20);
        update.setBounds(530, 400, 80, 20);
        delete.setBounds(620, 400, 80, 20);
        exit.setBounds(710, 400, 70, 20);

        setSize(820, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public String getJudul() {
        return tfjudul.getText();
    }

    public String getTipe() {
        return tftipe.getText();
    }

    public String getStatus() {
        return cbstatus.getSelectedItem().toString();
    }

    public String getEpisode() {
        return tfepisode.getText();
    }

    public String getRating() {
        return tfrating.getText();
    }

    public String getGenre() {
        return tfgenre.getText();
    }

    public String getSearch() {
        return tfsearch.getText();
    }
}