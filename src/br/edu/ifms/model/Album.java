package br.edu.ifms.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

@Entity
public class Album implements EntidadeBase {

    private Long id;
    private String album;
    private Date datalancamento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "album")
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Column(name = "datalançamento")
    @Type(type = "date")
//    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date Datalancamento) {
        this.datalancamento = Datalancamento;
    }

    @Override
    public String toString() {
        return getAlbum();
    }

}
