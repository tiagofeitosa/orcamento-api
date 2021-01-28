package br.com.tgf.orcamento.orcamentoapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, updatable = false)
    @JsonBackReference
    private Cliente cliente;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @Column
    private String modelo;

    @Column(nullable = false, length = 7)
    @NotBlank
    private String placa;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veiculo", orphanRemoval = true)
    @JsonManagedReference
    private MedidasVeiculo medidasVeiculo;
}
