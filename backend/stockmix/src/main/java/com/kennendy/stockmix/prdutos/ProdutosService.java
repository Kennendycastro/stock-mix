package com.kennendy.stockmix.prdutos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProdutosService {
    
    private ProdutosRepository produtosRepository;


    public ProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    //Listar 
    public  List<ProdutosModel> listarPordutos(){

        return produtosRepository.findAll();
    }

    public ProdutosModel listarProdutosId(Long id){

        Optional<ProdutosModel> produtoId = produtosRepository.findById(id);
        return produtoId.orElse(null);
    }


}
