package recife.treina.site.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recife.treina.site.dto.UsuarioDto;
import recife.treina.site.model.Usuario;
import recife.treina.site.persistence.UsuarioPersist;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioPersist usuarioPersist;

  public List<UsuarioDto> getAllUser(){
    List<Usuario> usuarios = usuarioPersist.findAll();

    List<UsuarioDto> dtos = new ArrayList<>();

    for(Usuario usuario : usuarios){
      dtos.add(usuario.converteUserDto());
    }

    return dtos;

  }

  public UsuarioDto getUserById(Long id){
    Optional<Usuario> usuarioOpt = usuarioPersist.findById(id);

    if(usuarioOpt.isPresent()){
      Usuario usuario = usuarioOpt.get();

      return usuario.converteUserDto();
    }

    return null;

  }
  
  public void deteleUserById(Long id){
    usuarioPersist.deleteById(id);
  }

  public Usuario saveUser(Usuario usuario){
    return usuarioPersist.save(usuario);
  }

}
