package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void realizarCadastro(@RequestBody CadastroDTO cadastroDTO){
        Cadastro cadastro = new Cadastro();
        cadastro.setBairro(cadastroDTO.getBairro());
        cadastro.setCidade(cadastroDTO.getCidade());
        cadastro.setCpf(cadastroDTO.getCpf());
        cadastro.setIdade(cadastroDTO.getIdade());
        cadastro.setNome(cadastroDTO.getNome());
        cadastro.setTemPet(cadastroDTO.isTemPet());
        cadastro.setMoraSozinho(cadastroDTO.isMoraSozinho());
        cadastro.setSobrenome(cadastroDTO.getSobrenome());
        cadastro.setNomeDoParenteProximo(cadastroDTO.getNomeDoParenteProximo());

        cadastroService.salvarCadastro(cadastro);
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
