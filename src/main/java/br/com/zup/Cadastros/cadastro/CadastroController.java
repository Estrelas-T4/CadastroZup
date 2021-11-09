package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroDTO;
import br.com.zup.Cadastros.cadastro.dtos.ResumoCadastroDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    /*
    check todo  1 - crie um metodo para cadastrar uma pessoa.
     Para um cadastro todo os campos são obrigatórios EXCETO o campo dataDoCadastro que deve ser preenchido pelo proprio sistema e o client não deve saber da existencia desse campo
    todo 2 - Faça um metodo que retorna a lista inteira de cadastros ou filtrado por cadastros que moram sozinhos, que tem pet ou por idade.
     nessa lista deve ser retornado apenas os campos ID, NOME e SOBRENOME.
     todo 3 - faça um metodo para DELETAR um cadastro por id.
     todo 4 - faça um metodo que retorna TODOS os dados de um usuario pesquisado pelo ID.
     */

}
