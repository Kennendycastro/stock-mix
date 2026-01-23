package com.kennendy.stockmix.estoques;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kennendy.stockmix.prdutos.ProdutosModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name ="tb_estoques")
public class EstoqueModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstoque;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String localizacao;

    //Um estoque pode ter varios produtos.
    @OneToMany(mappedBy = "estoque")
    @JsonIgnore //evitar o loop de serialização
    private List<ProdutosModel> produto;

}
