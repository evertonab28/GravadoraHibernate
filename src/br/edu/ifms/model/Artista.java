package br.edu.ifms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artista implements EntidadeBase {

    private Long id;
    private String nomeArtista;
    private String enderecoArtista;
    private String telefoneArtista;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "artista")
    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    @Column(name = "endereco")
    public String getEnderecoArtista() {
        return enderecoArtista;
    }

    public void setEnderecoArtista(String enderecoArtista) {
        this.enderecoArtista = enderecoArtista;
    }

    @Column(name = "telefone")
    public String getTelefoneArtista() {
        return telefoneArtista;
    }

    public void setTelefoneArtista(String telefoneArtista) {
        this.telefoneArtista = telefoneArtista;
    }
    
    
}
