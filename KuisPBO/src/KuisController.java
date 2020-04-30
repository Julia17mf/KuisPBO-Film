import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KuisController {

    KuisDAO kuisDAO;
    KuisModel kuisModel;
    KuisView kuisView;
    static String id, judul, tipe, episode, genre, status, rating;

    public KuisController(KuisDAO kuisDAO, KuisModel kuisModel, KuisView kuisView) {
        this.kuisDAO    = kuisDAO;
        this.kuisModel  = kuisModel;
        this.kuisView   = kuisView;

        if (kuisDAO.getJmlData() != 0) { //di sini untuk megecek apakah ada data atau tidak
            String dataMahasiswa[][] = kuisDAO.readKuis();
            kuisView.tabel.setModel((new JTable(dataMahasiswa, kuisView.namaKolom)).getModel());
        } else {
            //kalau tidak ada maka akan muncul pop up
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        kuisView.create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul    = kuisView.getJudul();
                String tipe     = kuisView.getTipe();
                String status   = kuisView.getStatus();
                String episode  = kuisView.getEpisode();
                String rating   = kuisView.getRating();
                String genre    = kuisView.getGenre();

                if (judul.isEmpty() || tipe.isEmpty() || status.isEmpty() || episode.isEmpty() || rating.isEmpty() || genre.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Harap Isi Semua Field");
                } else {
                    //memasukkan data ke dalam Model
                    kuisModel.setKuisModel(judul, tipe, episode, genre, status, rating);
                    //menjalankan perintah insert di DAO
                    kuisDAO.Insert(kuisModel);
                }

                kuisView.tfjudul.setText(null);
                kuisView.tftipe.setText(null);
                kuisView.tfepisode.setText(null);
                kuisView.tfrating.setText(null);
                kuisView.tfgenre.setText(null);
            }
        });

        kuisView.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tabelMouseClicked(e);
            }
        });

        kuisView.delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //memasukkan data ke dalam Model
                kuisModel.setId(id);
                //menjalankan perintah delete di DAO
                kuisDAO.Delete(kuisModel);

                kuisView.tfjudul.setText(null);
                kuisView.tftipe.setText(null);
                kuisView.tfepisode.setText(null);
                kuisView.tfrating.setText(null);
                kuisView.tfgenre.setText(null);
            }
        });

        kuisView.update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul    = kuisView.getJudul();
                String tipe     = kuisView.getTipe();
                String status   = kuisView.getStatus();
                String episode  = kuisView.getEpisode();
                String rating   = kuisView.getRating();
                String genre    = kuisView.getGenre();

                //memasukkan data ke dalam Model
                kuisModel.setId(id);
                //memasukkan data ke dalam Model
                kuisModel.setKuisModel(judul, tipe, episode, genre, status, rating);
                //menjalankan perintah update di DAO
                kuisDAO.Update(kuisModel);

                kuisView.tfjudul.setText(null);
                kuisView.tftipe.setText(null);
                kuisView.tfepisode.setText(null);
                kuisView.tfrating.setText(null);
                kuisView.tfgenre.setText(null);
            }
        });

        kuisView.refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dataMahasiswa[][] = kuisDAO.readKuis();
                kuisView.tabel.setModel((new JTable(dataMahasiswa, kuisView.namaKolom)).getModel());
            }
        });

        kuisView.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kuisView.setVisible(false);
                new KuisLogin();
            }
        });

        kuisView.search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = kuisView.getSearch();

                if (search.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Untuk mencari, harap diisi");
                } else {
                    //memasukkan data ke dalam Model
                    kuisModel.setJudul(search);

                    String dataMahasiswa[][] = kuisDAO.readSearch(kuisModel);
                    kuisView.tabel.setModel((new JTable(dataMahasiswa, kuisView.namaKolom)).getModel());
                }
            }
        });
    }

    private void tabelMouseClicked(MouseEvent e) {
        int baris   = kuisView.tabel.rowAtPoint(e.getPoint());
        id          = kuisView.tabel.getValueAt(baris,0).toString();
        judul       = kuisView.tabel.getValueAt(baris,1).toString();
        tipe        = kuisView.tabel.getValueAt(baris,2).toString();
        episode     = kuisView.tabel.getValueAt(baris,3).toString();
        genre       = kuisView.tabel.getValueAt(baris,4).toString();
        status      = kuisView.tabel.getValueAt(baris,5).toString();
        rating      = kuisView.tabel.getValueAt(baris,6).toString();

        kuisView.tfjudul.setText(judul);
        kuisView.tftipe.setText(tipe);
        kuisView.tfepisode.setText(episode);
        kuisView.tfrating.setText(rating);
        kuisView.tfgenre.setText(genre);
        kuisView.cbstatus.setSelectedItem(status);
    }
}
