package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroDTO;
import br.com.zup.Cadastros.cadastro.dtos.ResumoCadastroDTO;
import org.hibernate.validator.constraints.br.CPF;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void realizarCadastro(@RequestBody CadastroDTO cadastroDTO){
        Cadastro cadastro = modelMapper.map(cadastroDTO, Cadastro.class);

        cadastroService.salvarCadastro(cadastro);
    }

    @GetMapping
    public List<ResumoCadastroDTO> exibirResumoDeCadastros(@RequestParam(required = false) Boolean moraSozinho,
                                                           @RequestParam(required = false) Integer idade,
                                                           @RequestParam(required = false) Boolean temPet){
        List<ResumoCadastroDTO> cadastroDTOS = new ArrayList<>();
        for (Cadastro cadastro : cadastroService.exibirtodosOsCadastros(moraSozinho, idade, temPet)){
            ResumoCadastroDTO resumoCadastroDTO = modelMapper.map(cadastro, ResumoCadastroDTO.class);
            cadastroDTOS.add(resumoCadastroDTO);
        }
        return cadastroDTOS;
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCadastro(@PathVariable String cpf){
        cadastroService.deletarCadastro(cpf);
    }

    @GetMapping("/{cpf}")
    // CUIDADO: USAR A MODEL DIRETAMENTE NO RETORNO É POSSIVEL, PORÉM SE UM DIA ELA FOR ALTERADA COM UM DADO SENSIVEL VC
    // TERÀ PROBELMAS DE FALHA DE SEGURANÇA POIS SERÁ EXIBIDO OS DADOS INTEIROS DA MODEL
    public Cadastro exibirCadastroPorId(@PathVariable String cpf){
        return cadastroService.pesquisarCadastroPorID(cpf);
    }

}
