package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional //Transacao ativa para o banco de dados
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, page = 0, sort = {"crm"}, direction = Sort.Direction.DESC) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    //@PutMapping()
    @PutMapping(path = "teste")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id()); //LAZYLOAD e pode obter lancar execao se nao existir o Id
        //var medico = repository.findById(dados.id()).get();
        medico.atualizarInformacoes(dados); //Atualiza automaticamente, nao precisa chamar nada do repository, apenas setar os novos dados na entidade
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }

    @DeleteMapping("/logica/{id}")
    @Transactional
    public void deletarLogicamente(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
