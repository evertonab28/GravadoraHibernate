package br.edu.ifms.application;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Album;
import br.edu.ifms.model.Artista;
import br.edu.ifms.model.Compositor;
import br.edu.ifms.model.Musica;
import br.edu.ifms.model.Usuario;
import java.util.List;

public class InsertApplication {

    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        DaoGenerico<Usuario> daoUser = new DaoGenerico<>();
        
        usuario.setUsuario("Administrador");
        usuario.setLogin("admin");
        usuario.setSenha("1");       
        
        
        //ALBUM
        Album album = new Album();
        DaoGenerico<Album> daoAlbum = new DaoGenerico<>();
        
        album.setAlbum("Album 1");
                
        //ARTISTA
        Artista artista = new Artista();
        DaoGenerico<Artista> daoArtista = new DaoGenerico<>();
        
        artista.setNomeArtista("Joao das Neves");
        artista.setTelefoneArtista("9999-9999");
        artista.setEnderecoArtista("Rua Joaquim, 25");
        
        //COMPOSITOR
        Compositor compositor = new Compositor();
        DaoGenerico<Compositor> daoCompositor = new DaoGenerico<>();
        
        compositor.setNomeCompositor("Jon Bon Jovi");
        compositor.setTelefoneCompositor("8888-8888");
        compositor.setEnderecoCompositor("Rua do Rock 'n Roll, 22");
  
        Musica musica = new Musica();
        DaoGenerico<Musica> daoMusica = new DaoGenerico<>();
        
        musica.setMusica("It's my Life");
        musica.setAlbum(album);
        musica.setArtista(artista);
        musica.setCompositor(compositor);
        
        Musica musica2 = new Musica();
        musica2.setMusica("Musica 2");
        musica2.setAlbum(album);
        musica2.setArtista(artista);
        musica2.setCompositor(compositor);
        
        
        //COMMIT
        daoUser.saveOrUpdate(usuario);
        
        daoAlbum.saveOrUpdate(album);
        daoArtista.saveOrUpdate(artista);
        daoCompositor.saveOrUpdate(compositor);
        daoMusica.saveOrUpdate(musica);
        daoMusica.saveOrUpdate(musica2);
        
        System.out.println("Entidades salvas com sucesso!");
        System.out.println("");                
        
        List<Musica> lista = daoMusica.findByForeignKey(Musica.class, album.getId(), "idalbum");
        for(Musica m : lista){
            System.out.println(m.getId());
        }
    }

}
