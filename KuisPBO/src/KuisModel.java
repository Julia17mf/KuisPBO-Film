public class KuisModel {
    private String judul, tipe, episode, genre, status, rating, id;

    public void setKuisModel(String sjudul, String stipe, String sepisode, String sgenre, String sstatus, String srating) {
        this.judul      = sjudul;
        this.tipe       = stipe;
        this.episode    = sepisode;
        this.genre      = sgenre;
        this.status     = sstatus;
        this.rating     = srating;
    }

    public  void setJudul(String sjudul) {
        this.judul = sjudul;
    }
    public String getJudul() {
        return judul;
    }

    public String getTipe() {
        return tipe;
    }

    public String getEpisode() {
        return episode;
    }

    public String getGenre() {
        return genre;
    }

    public String getStatus() {
        return status;
    }

    public String getRating() {
        return rating;
    }

    public void setId(String sid) {
        this.id = sid;
    }

    public String getId() {
        return id;
    }
}
