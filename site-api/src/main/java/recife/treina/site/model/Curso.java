package recife.treina.site.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import recife.treina.site.dto.CursoDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_cursos")
public class Curso {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "OBRIGATÓRIO o preenchimento do {nome}")
  @Column(nullable = false)
  private String nome;

  @OneToMany
  @JoinColumn(nullable = false)
  private Usuario usuario;

  @OneToMany
  @JoinColumn(nullable = false)
  private Turma turma;
  
  
  public CursoDto converteCursoDto(){
    CursoDto dto = new CursoDto();

    dto.setId(id);
    dto.setNome(nome);

    return dto;
  }

}
