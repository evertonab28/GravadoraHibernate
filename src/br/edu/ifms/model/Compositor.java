package br.edu.ifms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compositor implements EntidadeBase {

    private Long id;
    private String nomeCompositor;
    private String enderecoCompositor;
    private String telefoneCompositor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "nome")
    public String getNomeCompositor() {
        return nomeCompositor;
    }

    public void setNomeCompositor(String nomeCompositor) {
        this.nomeCompositor = nomeCompositor;
    }

    @Column(name = "endereco")
    public String getEnderecoCompositor() {
        return enderecoCompositor;
    }

    public void setEnderecoCompositor(String enderecoCompositor) {
        this.enderecoCompositor = enderecoCompositor;
    }

    @Column(name = "telefone")
    public String getTelefoneCompositor() {
        return telefoneCompositor;
    }

    public void setTelefoneCompositor(String telefoneCompositor) {
        this.telefoneCompositor = telefoneCompositor;
    }

}
