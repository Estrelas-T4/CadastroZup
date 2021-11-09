package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.exceptions.CadastroDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public Cadastro salvarCadastro(Cadastro cadastro) {
        if(cadastroRepository.existsById(cadastro.getCpf())){
            throw new CadastroDuplicadoException();
        }

        cadastro.setDataDoCadastro(LocalDate.now());
        return cadastroRepository.save(cadastro);
    }

    public List<Cadastro> exibirtodosOsCadastros(Boolean moraSozinho, Integer idade, Boolean temPet){
        if (moraSozinho != null){
            return cadastroRepository.findAllByMoraSozinho(moraSozinho);
        }else if(idade != null){
            return cadastroRepository.findAllByIdade(idade);
        }else if(temPet != null){
            return cadastroRepository.findAllByTemPet(temPet);
        }
        List<Cadastro> cadastros = (List<Cadastro>) cadastroRepository.findAll();
        return cadastros;
    }
}
