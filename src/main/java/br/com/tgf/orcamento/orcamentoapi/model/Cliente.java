package br.com.tgf.orcamento.orcamentoapi.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razao_social", nullable = false)
    @NotBlank
    private String razaoSocial;

    @Column(length = 11)
    private Long telefone;

    @Column(length = 2)
    private Integer ddd;

    @Column
    @Email
    private String email;

    @Column(length = 11)
    @CPF
    private String cpf;

    @Column(length = 14)
    @CNPJ
    private String cnpj;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cliente", orphanRemoval = true)
    @JsonManagedReference
    private List<Veiculo> veiculos;

    @PrePersist
    public void gerarDataDeCadastro() {
        setDataCadastro(LocalDate.now());
    }
}
