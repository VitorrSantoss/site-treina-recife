package recife.treina.site.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import recife.treina.site.dto.UsuarioDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_usuarios")
public class Usuario {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "OBRIGATÓRIO o preenchimento do {nome}")
  @Column(nullable = false)
  private String nome;

  @NotNull(message = "OBRIGATÓRIO o preenchimento do {email}")
  @Column(nullable = false)
  private String email;

  @NotNull(message = "OBRIGATÓRIO o preenchimento do {cpf}")
  @Column(nullable = false)
  private String cpf;

  @NotNull(message = "OBRIGATÓRIO o preenchimento do {telefone}")
  @Column(nullable = false)
  private String telefone;

  public UsuarioDto converteUserDto(){
    UsuarioDto dto = new UsuarioDto();

    dto.setId(id);
    dto.setNome(nome);
    dto.setEmail(email);
    dto.setCpf(cpf);
    dto.setTelefone(telefone);
    
    return dto;
  }

}
