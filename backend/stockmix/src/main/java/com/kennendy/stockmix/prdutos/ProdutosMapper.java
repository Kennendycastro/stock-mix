package com.kennendy.stockmix.prdutos;

import org.springframework.stereotype.Component;

@Component
public class ProdutosMapper {
    
    public ProdutosModel map(ProdutosDTO produtosDTO){
        ProdutosModel produtosModel = new ProdutosModel();
        produtosModel.setIdProduto(produtosDTO.getIdProduto());
        produtosModel.setNome(produtosDTO.getNome());
        produtosModel.setDataChegada(produtosDTO.getDataChegada());
        produtosModel.setPreco(produtosDTO.getPreco());
        produtosModel.setQuantidade(produtosDTO.getQuantidade());
        produtosModel.setEstoque(produtosDTO.getEstoque());

        return produtosModel;
    }


    public ProdutosDTO map(ProdutosModel produtosModel){
        ProdutosDTO produtosDTO = new ProdutosDTO();
        produtosDTO.setIdProduto(produtosModel.getIdProduto());
        produtosDTO.setNome(produtosModel.getNome());
        produtosDTO.setDataChegada(produtosModel.getDataChegada());
        produtosDTO.setPreco(produtosModel.getPreco());
        produtosDTO.setQuantidade(produtosModel.getQuantidade());
        produtosDTO.setEstoque(produtosModel.getEstoque());

        return produtosDTO;

    }
}
