package com.kennendy.stockmix.prdutos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.kennendy.stockmix.estoques.EstoqueModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_produtos")
public class ProdutosModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    private String nome;
    private LocalDateTime dataChegada;

    @Column(precision = 10, scale = 2)
    private BigDecimal preco;

    //Um produto tem um único estoque.
    @ManyToOne
    @JoinColumn(name = "estoque_id") //FK
    private EstoqueModel estoque;
}
