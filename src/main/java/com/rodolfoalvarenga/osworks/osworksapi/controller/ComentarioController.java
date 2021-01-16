package com.rodolfoalvarenga.osworks.osworksapi.controller;

import com.rodolfoalvarenga.osworks.osworksapi.domain.exception.EntidadeNaoEncontradaException;
import com.rodolfoalvarenga.osworks.osworksapi.domain.model.OrdemServico;
import com.rodolfoalvarenga.osworks.osworksapi.domain.repository.OrdemServicoRepository;
import com.rodolfoalvarenga.osworks.osworksapi.domain.service.GestaoOrdemServicoService;
import com.rodolfoalvarenga.osworks.osworksapi.model.Comentario;
import com.rodolfoalvarenga.osworks.osworksapi.model.ComentarioInput;
import com.rodolfoalvarenga.osworks.osworksapi.model.ComentarioModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {

    @Autowired
    private GestaoOrdemServicoService gestaoOrdemServico;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ComentarioModel> listar(@PathVariable Long ordemServicoId) {
        OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada"));

        return toCollectionModel(ordemServico.getComentarios());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioModel adicionar(@PathVariable Long ordemServicoId,
                                     @Valid @RequestBody ComentarioInput comentarioInput) {

        Comentario comentario = gestaoOrdemServico.adicionarComentario(ordemServicoId, comentarioInput.getDescricao());

        return toModel(comentario);
    }

    private ComentarioModel toModel(Comentario comentario) {
        return modelMapper.map(comentario, ComentarioModel.class);
    }

    private List<ComentarioModel> toCollectionModel(List<Comentario> comentarios) {
        return comentarios.stream()
                .map(comentario -> toModel(comentario))
                .collect(Collectors.toList());
    }
}
