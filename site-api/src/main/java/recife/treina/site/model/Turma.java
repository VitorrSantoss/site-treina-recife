package recife.treina.site.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import recife.treina.site.constants.TurmaStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_turmas")
public class Turma {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "OBRIGATÓRIO o preenchimento do {numero}")
  @Column(nullable = false)
  private int numero;

  @NotNull(message = "OBRIGATÓRIO o preenchimento da {vigencia}")
  @Column(nullable = false)
  private Date vigencia;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private TurmaStatus status;
}
