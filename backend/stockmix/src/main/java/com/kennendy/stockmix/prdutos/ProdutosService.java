package com.kennendy.stockmix.prdutos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProdutosService {
    
    private ProdutosRepository produtosRepository;
    private ProdutosMapper produtosMapper;


    public ProdutosService(ProdutosRepository produtosRepository, ProdutosMapper produtosMapper) {
        this.produtosRepository = produtosRepository;
        this.produtosMapper = produtosMapper;
    }

    //Listar 
    public  List<ProdutosModel> listarPordutos(){

        return produtosRepository.findAll();
    }

    public ProdutosModel listarProdutosId(Long id){

        Optional<ProdutosModel> produtoId = produtosRepository.findById(id);
        return produtoId.orElse(null);
    }

    //Cadastrar

    public ProdutosDTO cadastrarProduto(ProdutosDTO produtoDTO){
        ProdutosModel produto = produtosMapper.map(produtoDTO);
        produto = produtosRepository.save(produto);
        return produtosMapper.map(produto);
    }


    //Deletar

    public void deletarProduto(Long id){

       produtosRepository.deleteById(id);

    }


    //Atualizar

    public ProdutosModel atualizarProduto(Long id, ProdutosModel produto){

        if (produtosRepository.existsById(id)) {

            produto.setIdProduto(id);
            
            return produtosRepository.save(produto);

            
        }
        return null;


    }


}
