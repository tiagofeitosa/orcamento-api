package br.com.tgf.orcamento.orcamentoapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedidasVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "id_veiculo", unique = true, updatable = false, nullable = false)
    private Veiculo veiculo;

    @Column(name = "porta_direita_largura", scale = 2)
    private Double portaDireitaX;

    @Column(name = "porta_direita_altura", scale = 2)
    private Double portaDireitaY;

    @Column(name = "porta_esquerda_largura", scale = 2)
    private Double portaEsquerdaX;

    @Column(name = "porta_esquerda_altura", scale = 2)
    private Double portaEsquerdaY;

    @Column(name = "lateral_direita_largura", scale = 2)
    private Double lateralDireitaX;

    @Column(name = "lateral_direita_altura", scale = 2)
    private Double lateralDireitaY;

    @Column(name = "lateral_esquerda_largura", scale = 2)
    private Double lateralEsquerdaX;

    @Column(name = "lateral_esquerda_altura", scale = 2)
    private Double lateralEsquerdaY;

    @Column(name = "testeira_largura", scale = 2)
    private Double testeiraX;

    @Column(name = "testeira_altura", scale = 2)
    private Double testeiraY;

    @Column(name = "traseira_largura", scale = 2)
    private Double traseiraX;

    @Column(name = "traseira_altura", scale = 2)
    private Double traseiraY;

    @Column(name = "frente_largura", scale = 2)
    private Double frenteX;

    @Column(name = "frente_altura", scale = 2)
    private Double frenteY;

    @Column(name = "capo_largura", scale = 2)
    private Double capoX;

    @Column(name = "capo_altura", scale = 2)
    private Double capoY;

    @Column(name = "teto_largura", scale = 2)
    private Double tetoX;

    @Column(name = "teto_altura", scale = 2)
    private Double tetoY;

}
