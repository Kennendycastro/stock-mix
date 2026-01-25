package com.kennendy.stockmix.prdutos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.kennendy.stockmix.estoques.EstoqueModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDTO {

    private Long idProduto;
    private String nome;
    private LocalDateTime dataChegada;
    private BigDecimal preco;
    private int quantidade;
    private EstoqueModel estoque;

    
}
