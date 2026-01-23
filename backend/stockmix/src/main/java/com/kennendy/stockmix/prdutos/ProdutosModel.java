package com.kennendy.stockmix.prdutos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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

    @Column(nullable = false)
    private String nome;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataChegada;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;

    //Um produto tem um único estoque.
    @ManyToOne
    @JoinColumn(name = "estoque_id", nullable = false) //FK
    private EstoqueModel estoque;
}
