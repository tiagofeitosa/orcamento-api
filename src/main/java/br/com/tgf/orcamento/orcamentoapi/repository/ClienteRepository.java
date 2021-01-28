package br.com.tgf.orcamento.orcamentoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tgf.orcamento.orcamentoapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
