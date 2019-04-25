package br.edu.ifms.controller;

import br.edu.ifms.view.PrincipalView;
import br.edu.ifms.view.UsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class PrincipalController implements ActionListener{

    private PrincipalView pView;
    private UsuarioView usuarioView;
    
    public PrincipalController(){
        pView = new PrincipalView();
        pView.jMenuUsuario.addActionListener(this);
        pView.jMenuAlbum.addActionListener(this);
        pView.jMenuArtista.addActionListener(this);
        pView.jMenuCompositor.addActionListener(this);
        pView.jMenuMusica.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == pView.jMenuUsuario){
            
            
            
        }
        if(ae.getSource() == pView.jMenuAlbum){
            
        }
        if(ae.getSource() == pView.jMenuArtista){
            
        }
        if(ae.getSource() == pView.jMenuCompositor){
            
        }
        if(ae.getSource() == pView.jMenuMusica){
            
        }
        
    }
    
}
