/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FInal_Exam;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Nama : Syahrizal Muhammad Nurjaya
 * NIM  : 20200140030
 * 
 * @author ACER
 */
@Entity
@Table(name = "surat")
@NamedQueries({
    @NamedQuery(name = "Surat.findAll", query = "SELECT s FROM Surat s"),
    @NamedQuery(name = "Surat.findById", query = "SELECT s FROM Surat s WHERE s.id = :id"),
    @NamedQuery(name = "Surat.findByNoSurat", query = "SELECT s FROM Surat s WHERE s.noSurat = :noSurat"),
    @NamedQuery(name = "Surat.findByJudul", query = "SELECT s FROM Surat s WHERE s.judul = :judul"),
    @NamedQuery(name = "Surat.findByTembusan", query = "SELECT s FROM Surat s WHERE s.tembusan = :tembusan"),
    @NamedQuery(name = "Surat.findByFile", query = "SELECT s FROM Surat s WHERE s.file = :file"),
    @NamedQuery(name = "Surat.findByWaktu", query = "SELECT s FROM Surat s WHERE s.waktu = :waktu")})
public class Surat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "no_surat")
    private String noSurat;
    @Column(name = "judul")
    private String judul;
    @Column(name = "tembusan")
    private String tembusan;
    @Column(name = "file")
    private String file;
    @Basic(optional = false)
    @Column(name = "waktu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktu;

    public Surat() {
    }

    public Surat(Integer id) {
        this.id = id;
    }

    public Surat(Integer id, Date waktu) {
        this.id = id;
        this.waktu = waktu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoSurat() {
        return noSurat;
    }

    public void setNoSurat(String noSurat) {
        this.noSurat = noSurat;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTembusan() {
        return tembusan;
    }

    public void setTembusan(String tembusan) {
        this.tembusan = tembusan;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Surat)) {
            return false;
        }
        Surat other = (Surat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FInal_Exam.Surat[ id=" + id + " ]";
    }
    
}
