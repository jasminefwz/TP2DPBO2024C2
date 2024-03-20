/*
Saya Jasmine Noor Fawzia [2200598] mengerjakan soal TP2 dalam Mata Kuliah DPBO
untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan
Aamiin
*/

public class Mahasiswa {
    private String nim;
    private String nama;
    private String jenisKelamin;
    private String statusMhs;

    public Mahasiswa(String nim, String nama, String jenisKelamin, String statusMhs) {
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.statusMhs = statusMhs;
    }

    // set atribut
    public void setNim(String nim) {
        this.nim = nim;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    public void setStatusMhs(String statusMhs) {
        this.statusMhs = statusMhs;
    }

    // get atribut
    public String getNim() {
        return this.nim;
    }
    public String getNama() {
        return this.nama;
    }
    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
    public String getStatusMhs() {
        return this.statusMhs;
    }
}
