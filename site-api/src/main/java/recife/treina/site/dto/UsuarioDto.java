package recife.treina.site.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
  
  private Long id;
  private String nome;
  private String email;
  private String cpf;
  private String telefone;
}
