package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter // Criar os getter para as proriedades
@NoArgsConstructor // Cria construtor default sem parametros
@AllArgsConstructor //Criar construtor com todos parametros
@EqualsAndHashCode(of = "id") // Apenas para a prorpriedade id
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded //Classe separada mas os campos pertence na mesma tabela, no caso medicos
    private Endereco endereco;

}
