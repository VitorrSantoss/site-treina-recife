package recife.treina.site.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import recife.treina.site.dto.UsuarioDto;
import recife.treina.site.model.Usuario;
import recife.treina.site.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;


  // 1º EndPoint
  @GetMapping
  public ResponseEntity<List<UsuarioDto>> listarTodosUsuarios(){
    return ResponseEntity.ok().body(usuarioService.getAllUser());
  }
  
  // 2º EndPoint
  @GetMapping("/{id}")
  public ResponseEntity<UsuarioDto> listarUsuarioPeloId(Long id){
    UsuarioDto usuario = usuarioService.getUserById(id);

    if(Objects.isNull(usuario)){
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().body(usuario);
  
  }

  // 3º EndPoint
  @PostMapping("/{id}")
  public ResponseEntity<Usuario> cadastrarUsuarioPeloId(@RequestBody Usuario usuario){
    return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUser(usuario));
  }

  // 4º EndPoint
  @PutMapping("/{id}")
  public ResponseEntity<Usuario> atualizarUsuarioPeloId(@PathVariable("id") Long id, @RequestBody Usuario dadosUsuario){
    UsuarioDto usuario = usuarioService.getUserById(id);

    if(Objects.isNull(usuario)){
      return ResponseEntity.noContent().build();
    }
    
    dadosUsuario.setId(id);

    return ResponseEntity.ok().body(usuarioService.saveUser(dadosUsuario));

  }

  // 5º EndPoint
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarUsuarioPeloId(@PathVariable("id") Long id){
    UsuarioDto usuario = usuarioService.getUserById(id);

    if(Objects.isNull(usuario)){
      return ResponseEntity.notFound().build();
    }

    usuarioService.deteleUserById(id);

    return ResponseEntity.noContent().build();
  }


}
