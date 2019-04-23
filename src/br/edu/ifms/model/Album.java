package br.edu.ifms.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album implements EntidadeBase {

    private Long id;
    private String album;
    private Date Datacadastro;

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

    @Column(name = "datacadastro")
    public Date getDatacadastro() {
        return Datacadastro;
    }

    public void setDatacadastro(Date Datacadastro) {
        this.Datacadastro = Datacadastro;
    }

}
