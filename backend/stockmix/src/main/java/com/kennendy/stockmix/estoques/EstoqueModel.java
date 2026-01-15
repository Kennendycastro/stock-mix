package com.kennendy.stockmix.estoques;

import java.util.List;

import com.kennendy.stockmix.prdutos.ProdutosModel;

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
@Table(name ="tb_estouqes")
public class EstoqueModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstoque;
    private String nome;
    private String local;

    //Um estoque pode ter varios produtos.
    @OneToMany(mappedBy = "estoque")
    private List<ProdutosModel> produto;

}
