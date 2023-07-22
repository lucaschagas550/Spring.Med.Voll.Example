package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

//JPARepository <Entidade, Tipo do ID>
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
