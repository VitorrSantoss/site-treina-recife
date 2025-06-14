package recife.treina.site.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDto {

  private Long id;
  private int numero;
  private Date vigencia;

}
