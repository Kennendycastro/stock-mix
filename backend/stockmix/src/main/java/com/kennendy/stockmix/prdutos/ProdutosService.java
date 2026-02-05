package com.kennendy.stockmix.prdutos;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;
    private final ProdutosMapper produtosMapper;

    public ProdutosService(ProdutosRepository produtosRepository, ProdutosMapper produtosMapper) {
        this.produtosRepository = produtosRepository;
        this.produtosMapper = produtosMapper;
    }

    // Listar
    public List<ProdutosDTO> listarPordutos() {
        List<ProdutosModel> produtos = produtosRepository.findAll();
        return produtos.stream()
                .map(produtosMapper::map)
                .collect(Collectors.toList());
    }

    public ProdutosDTO listarProdutosId(Long id) {

        Optional<ProdutosModel> produtoId = produtosRepository.findById(id);
        return produtoId.map(produtosMapper::map).orElse(null);
    }

    // Cadastrar

    public ProdutosDTO cadastrarProduto(ProdutosDTO produtoDTO) {
        ProdutosModel produto = produtosMapper.map(produtoDTO);
        produto = produtosRepository.save(produto);
        return produtosMapper.map(produto);
    }

    // Deletar

    public void deletarProduto(Long id) {

        produtosRepository.deleteById(id);

    }

    // Atualizar
    public ProdutosDTO atualizarProduto(Long id, ProdutosDTO produto) {
        Optional<ProdutosModel> produtoExiste = produtosRepository.findById(id);
        if (produtoExiste.isPresent()) {

            ProdutosModel produtoatualizado = produtosMapper.map(produto);
            produtoatualizado.setIdProduto(id);
            ProdutosModel produtoSalvo = produtosRepository.save(produtoatualizado);
            return produtosMapper.map(produtoSalvo);

        }
        return null;

    }

    public ProdutosDTO atualizarProdutoParcial(Long id, ProdutosDTO produtosDTO) {
        ProdutosModel produtoAtualizado = produtosRepository.findById(id)
            .orElse(null);
        if (produtosDTO.getNome() != null) {
            produtoAtualizado.setNome(produtosDTO.getNome());

        }
        if (produtosDTO.getDataChegada() != null) {
            produtoAtualizado.setDataChegada(produtosDTO.getDataChegada());

        }
        if (produtosDTO.getPreco() != null) {
            produtoAtualizado.setPreco(produtosDTO.getPreco());

        }
        if (produtosDTO.getQuantidade() != null) {

            produtoAtualizado.setQuantidade(produtosDTO.getQuantidade());

        }
        if (produtosDTO.getEstoque() != null) {

            produtoAtualizado.setEstoque(produtosDTO.getEstoque());
        }

        ProdutosModel produtoSalvo = produtosRepository.save(produtoAtualizado);

        return produtosMapper.map(produtoSalvo);
    }

}
