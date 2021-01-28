package br.com.tgf.orcamento.orcamentoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.tgf.orcamento.orcamentoapi.model.MedidasVeiculo;
import br.com.tgf.orcamento.orcamentoapi.repository.MedidasVeiculoRepository;

@RestController
@RequestMapping("/medidasVeiculo")
public class MedidasVeiculoController {

    @Autowired
    private MedidasVeiculoRepository medidasVeiculoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedidasVeiculo cadastrarMedidasVeiculo(@RequestBody MedidasVeiculo medidasVeiculo) {
        return medidasVeiculoRepository.save(medidasVeiculo);
    }

    @GetMapping
    public List<MedidasVeiculo> listarMedidasVeiculos() {
        return medidasVeiculoRepository.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public MedidasVeiculo buscarMedidasVeiculoPorId(@PathVariable Long id) {
        return medidasVeiculoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirMedidasVeiculo(@PathVariable Long id) {
        medidasVeiculoRepository.findById(id).map(medidasVeiculo -> {
            medidasVeiculoRepository.delete(medidasVeiculo);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarMedidasVeiculo(@PathVariable Long id, @RequestBody MedidasVeiculo medidasVeiculoAtualizado) {
        medidasVeiculoRepository.findById(id).map(medidasVeiculo -> {
            medidasVeiculoAtualizado.setId(medidasVeiculo.getId());
            return medidasVeiculoRepository.save(medidasVeiculoAtualizado);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
