import javax.swing.*;
import java.sql.*;

public class KuisDAO {
    private Connection koneksi;
    private Statement statement;

    public KuisDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url  = "jdbc:mysql://localhost/kuis_pbo?serverTimezone=UTC";
            koneksi     = DriverManager.getConnection(url, "root", "");
            statement   = koneksi.createStatement();
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class Not Found : " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Exception : " + ex);
        }
    }

    public String[][] readKuis() {
        try {
            int jmlData = 0; //menampung jumlah data
            //baris sejumlah data, kolom nya ada 3
            String data[][] = new String[getJmlData()][7];
            //pengambilan data dalam java dari database
            String query    = "SELECT * FROM film";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) { //lanjut ke data selanjutnya jmlData bertambah
                data[jmlData][0] = resultSet.getString("id");
                data[jmlData][1] = resultSet.getString("judul");
                data[jmlData][2] = resultSet.getString("tipe");
                data[jmlData][3] = resultSet.getString("episode");
                data[jmlData][4] = resultSet.getString("genre");
                data[jmlData][5] = resultSet.getString("status");
                data[jmlData][6] = resultSet.getString("rating");
                jmlData++; //barisnya selalu berpindah
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void Insert(KuisModel Model) {
        try {
            String query = "INSERT INTO film VALUES (NULL, '" + Model.getJudul() + "', '" + Model.getTipe() + "', '" + Model.getEpisode() + "', '" + Model.getGenre() + "', '" + Model.getStatus() + "', '" + Model.getRating() + "')";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data disimpan");
        } catch (Exception sql) {
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void Delete(KuisModel Model) {
        try {
            String query = "DELETE FROM film WHERE id = '" + Model.getId() + "'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");
        } catch (Exception sql) {
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void Update(KuisModel Model) {
        try {
            String query = "UPDATE film SET judul = '" + Model.getJudul() + "', tipe = '" + Model.getTipe() + "', episode = '" + Model.getEpisode() + "', genre = '" + Model.getGenre() + "', status = '" + Model.getStatus() + "', rating = '" + Model.getRating() + "' WHERE id = '" + Model.getId() + "'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil diupdate");
        } catch (Exception sql) {
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readSearch(KuisModel Model) {
        try {
            int jmlData     = 0; //menampung jumlah data
            String judul    = Model.getJudul();
            //baris sejumlah data, kolom nya ada 3
            String data[][] = new String[getJmlSearch(judul)][7];
            //pengambilan data dalam java dari database
            String query    = "SELECT * FROM film WHERE judul LIKE '%" + Model.getJudul() + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) { //lanjut ke data selanjutnya jmlData bertambah
                data[jmlData][0] = resultSet.getString("id");
                data[jmlData][1] = resultSet.getString("judul");
                data[jmlData][2] = resultSet.getString("tipe");
                data[jmlData][3] = resultSet.getString("episode");
                data[jmlData][4] = resultSet.getString("genre");
                data[jmlData][5] = resultSet.getString("status");
                data[jmlData][6] = resultSet.getString("rating");
                jmlData++; //barisnya selalu berpindah
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getJmlData() {
        int jmlData = 0;
        try {
            //pengambilan data ke dalam java dari database
            String query = "SELECT * FROM film";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public int getJmlSearch(String judul) {
        int jmlData = 0;
        try {
            //pengambilan data ke dalam java dari database
            String query = "SELECT * FROM film WHERE judul LIKE '%" + judul + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
}
