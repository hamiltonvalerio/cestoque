package br.ipen.cestoque.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.domain.InsumoMovimentacao;
import br.ipen.cestoque.domain.Localizacao;
import br.ipen.cestoque.domain.Movimentacao;
import br.ipen.cestoque.repositories.InsumoLocalizacaoRepository;
import br.ipen.cestoque.repositories.InsumoMovimentacaoRepository;
import br.ipen.cestoque.repositories.InsumoRepository;
import br.ipen.cestoque.repositories.MovimentacaoRepository;
import br.ipen.cestoque.resources.utils.ComparaInsumoLocalizacao;
import br.ipen.cestoque.resources.utils.GeraLoteRecebimentoCR;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository repo;
	// private EntradaRepository repo;

	@Autowired
	private InsumoMovimentacaoRepository insumoMovimentacaoRepository;

	@Autowired
	private InsumoRepository insumoRepository;

	@Autowired
	private InsumoLocalizacaoRepository insumoLocalizacaoRepository;

	@Autowired
	private InsumoService insumoService;
	
	@Autowired
	private ComparaInsumoLocalizacao comparaInsumoLocalizacao;
	
	@Autowired
	private LocalizacaoService localizacaoService; 
	
	@Autowired
	private GeraLoteRecebimentoCR gera;
	

	/*
	 * public MovimentacaoService(final MovimentacaoMapper movimentacaoMapper, final
	 * InsumoMovimentacaoMapper insumomovimentacaoMapper) { this.movimentacaoMapper
	 * = movimentacaoMapper; this.insumomovimentacaoMapper =
	 * insumomovimentacaoMapper; }
	 */

	@Transactional
	public Movimentacao insert(Movimentacao obj) {
		List<Insumo> insumos = new ArrayList<>();
		List<InsumoLocalizacao> insumosLocalizacoesDestino = new ArrayList<>();
		List<InsumoLocalizacao> insumosLocalizacoesOrigem = new ArrayList<>();
		Insumo insumo;
		Double quant;
		Double quantidadeutilizada;
		Double quantidadedescartada;

		Localizacao localizacaoOrigem = new Localizacao();
		InsumoLocalizacao insumoLocalizacaoOrigem;
		localizacaoOrigem = obj.getLocalizacaoOrigem();

		Localizacao localizacaoDestino = new Localizacao();
		InsumoLocalizacao insumoLocalizacaoDestino;
		localizacaoDestino = obj.getLocalizacaoDestino();

		obj.setId(null);
		obj.setUsualt(UserService.authenticated().getUsername());
		obj.setDatalt(new Date(System.currentTimeMillis()));
		obj = repo.save(obj);
		
		InsumoMovimentacao imdestino = new InsumoMovimentacao();
		List<InsumoMovimentacao> itensMovimentados = new ArrayList<>();
 
		for (InsumoMovimentacao im : obj.getItens()) {
			imdestino = new InsumoMovimentacao(); 
			im.setLocalizacao(localizacaoDestino);
			im.setLocalizacaoOrigem(localizacaoOrigem);
			im.setUsualt(UserService.authenticated().getNome());
			im.setDatalt(new Date(System.currentTimeMillis()));
			
			
			
			insumo = new Insumo();
			insumo = insumoService.find(im.getInsumo().getId());
			insumo.setUnidade(im.getInsumo().getUnidade());
			insumo.setValor(im.getInsumo().getValor());
			quant = im.getQuantidadeMovimentada();
			quantidadeutilizada = im.getQuantidadeUtilizada() == null ? 0.0 : im.getQuantidadeUtilizada(); 
			quantidadedescartada = im.getQuantidadeDescartada() == null ? 0.0 : im.getQuantidadeDescartada();
			im.setInsumo(insumo);
			if (im.getInsumo().getQuantidade() == null) {
				im.getInsumo().setQuantidade(0.0);
			}
			insumo.setQuantidade(im.getInsumo().getQuantidade());
			insumos.add(insumo);

			insumoLocalizacaoDestino = new InsumoLocalizacao();

			insumoLocalizacaoOrigem = new InsumoLocalizacao();
			
			if(localizacaoOrigem.getGerasublote() != null) {
				if(localizacaoOrigem.getGerasublote() == true) {
					if(localizacaoOrigem.getIrradiacao() == true &&  im.getIrradiado() == true) {
						if(im.getSubloteLEI()==null) {
							insumoLocalizacaoOrigem = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoOrigem, im.getLoteLEI());
							im.setSubloteLEI(im.getLoteLEI());
							im.setLoteLEI(gera.gerarLei());
							insumoLocalizacaoDestino = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoDestino, im.getLoteLEI());
						}else {
							insumoLocalizacaoOrigem = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoOrigem, im.getLoteLEI());
							insumoLocalizacaoDestino = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoDestino, im.getLoteLEI());
						}
					}else {
						insumoLocalizacaoOrigem = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoOrigem, im.getLoteLEI());
						insumoLocalizacaoDestino = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoDestino, im.getLoteLEI());
					}
				}else {
					insumoLocalizacaoOrigem = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoOrigem, im.getLoteLEI());
					insumoLocalizacaoDestino = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoDestino, im.getLoteLEI());
				}
			}else if(localizacaoDestino.getGerasublote() != null) {
				if(localizacaoDestino.getGerasublote() == true) {
					insumoLocalizacaoOrigem = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoOrigem, im.getLoteLEI());
					insumoLocalizacaoDestino = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoDestino, im.getLoteLEI());
				}else {
					insumoLocalizacaoOrigem = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoOrigem, im.getLoteLEI());
					insumoLocalizacaoDestino = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoDestino, im.getLoteLEI());
				}
			}else {
				insumoLocalizacaoOrigem = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoOrigem, im.getLoteLEI());
				insumoLocalizacaoDestino = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, localizacaoDestino, im.getLoteLEI());
			}
			
			
			
			
			
			if (insumoLocalizacaoDestino == null) {
				insumoLocalizacaoDestino = new InsumoLocalizacao();
				if(obj.getLocalizacaoDestino().getLocalizacaofilha() == true) {
					if(obj.getLocalizacaoDestino().getObjlocalizacaofilha().getId() == obj.getLocalizacaoOrigem().getId()) {
						if(im.getQuantidadeUtilizada() != null) {
							if(im.getQuantidadeUtilizada() > 0) {
								Localizacao locutil = localizacaoService.findByLocalizacaoUtilizado(obj.getLocalizacaoOrigem().getId());
								//se eu tenho uma localização de utilização eu insiro nesta localização um novo insumolocalização
								//senão eu insiro no resultado
								if(locutil != null) {
									insumoLocalizacaoDestino.setAprovado(im.getAprovado());
									insumoLocalizacaoDestino.setDataAprovacao(im.getDataAprovacao());
									insumoLocalizacaoDestino.setDataIrradiacao(im.getDataIrradiacao());
									insumoLocalizacaoDestino.setDataValidade(im.getDataValidade());
									insumoLocalizacaoDestino.setLoteCR(im.getLoteCR());
									insumoLocalizacaoDestino.setLoteFornecedor(im.getLoteFornecedor());
									insumoLocalizacaoDestino.setLoteProducao(im.getLoteProducao());
									
									//qtd utilizada
									insumoLocalizacaoDestino.setQuantidade(im.getQuantidadeUtilizada());
									insumoLocalizacaoDestino.setQuantidadeUtilizada(im.getQuantidadeUtilizada());
									
									
									insumoLocalizacaoDestino.setInsumo(insumo);
									
									//localizacao insumos utilizados
									insumoLocalizacaoDestino.setLocalizacao(locutil);
									
									insumoLocalizacaoDestino.setLoteRecebimento(im.getLoteRecebimento());
									insumoLocalizacaoDestino.setLoteLEI(im.getLoteLEI());
									insumoLocalizacaoDestino.setSubloteLEI(im.getSubloteLEI());
									insumoLocalizacaoDestino.setQuantidadeVolume(im.getQuantidadeVolume());
									insumoLocalizacaoDestino.setUnidadeEntrada(im.getUnidadeEntrada());
									insumoLocalizacaoDestino.setUnidadeRecebida(im.getUnidadeRecebida());
									insumoLocalizacaoDestino.setDataPrevisaoControle(im.getDataPrevisaoControle());
									insumoLocalizacaoDestino.setIrradiado(im.getIrradiado());
									//
								}
							}
						}else if(im.getQuantidadeDescartada() != null) {
							if(im.getQuantidadeDescartada() > 0) {
								Localizacao locutil = localizacaoService.findByLocalizacaoDescartado(obj.getLocalizacaoOrigem().getId());
								insumoLocalizacaoDestino.setAprovado(im.getAprovado());
								insumoLocalizacaoDestino.setDataAprovacao(im.getDataAprovacao());
								insumoLocalizacaoDestino.setDataIrradiacao(im.getDataIrradiacao());
								insumoLocalizacaoDestino.setDataValidade(im.getDataValidade());
								insumoLocalizacaoDestino.setLoteCR(im.getLoteCR());
								insumoLocalizacaoDestino.setLoteFornecedor(im.getLoteFornecedor());
								insumoLocalizacaoDestino.setLoteProducao(im.getLoteProducao());
								
								//qtd utilizada
								insumoLocalizacaoDestino.setQuantidade(im.getQuantidadeDescartada());
								insumoLocalizacaoDestino.setQuantidadeDescartada(im.getQuantidadeDescartada());
								
								insumoLocalizacaoDestino.setInsumo(insumo);
								
								//localizacao insumos descartado
								insumoLocalizacaoDestino.setLocalizacao(locutil);
								
								insumoLocalizacaoDestino.setLoteRecebimento(im.getLoteRecebimento());
								insumoLocalizacaoDestino.setLoteLEI(im.getLoteLEI());
								insumoLocalizacaoDestino.setSubloteLEI(im.getSubloteLEI());
								insumoLocalizacaoDestino.setQuantidadeVolume(im.getQuantidadeVolume());
								insumoLocalizacaoDestino.setUnidadeEntrada(im.getUnidadeEntrada());
								insumoLocalizacaoDestino.setUnidadeRecebida(im.getUnidadeRecebida());
								insumoLocalizacaoDestino.setDataPrevisaoControle(im.getDataPrevisaoControle());
								insumoLocalizacaoDestino.setIrradiado(im.getIrradiado());
							}	
						}
						insumoLocalizacaoDestino.setUsualt(UserService.authenticated().getNome());
						insumoLocalizacaoDestino.setDatalt(new Date(System.currentTimeMillis()));
						
						//insere a movimentação utilizada
						
						InsumoMovimentacao movim = new InsumoMovimentacao(insumoLocalizacaoDestino);
						movim.setLocalizacaoOrigem(localizacaoOrigem);
						itensMovimentados.add(movim);
						insumosLocalizacoesDestino.add(insumoLocalizacaoDestino);
					}
					InsumoLocalizacao insumoLocalizacaoDestinoResultado = new InsumoLocalizacao();
					insumoLocalizacaoDestinoResultado.setAprovado(im.getAprovado());
					insumoLocalizacaoDestinoResultado.setDataAprovacao(im.getDataAprovacao());
					insumoLocalizacaoDestinoResultado.setDataIrradiacao(im.getDataIrradiacao());
					insumoLocalizacaoDestinoResultado.setDataValidade(im.getDataValidade());
					insumoLocalizacaoDestinoResultado.setLoteCR(im.getLoteCR());
					insumoLocalizacaoDestinoResultado.setLoteFornecedor(im.getLoteFornecedor());
					insumoLocalizacaoDestinoResultado.setLoteProducao(im.getLoteProducao());
					insumoLocalizacaoDestinoResultado.setQuantidade(quant);
					insumoLocalizacaoDestinoResultado.setInsumo(insumo);
					insumoLocalizacaoDestinoResultado.setLocalizacao(obj.getLocalizacaoDestino());
					insumoLocalizacaoDestinoResultado.setLoteRecebimento(im.getLoteRecebimento());
					insumoLocalizacaoDestinoResultado.setLoteLEI(im.getLoteLEI());
					insumoLocalizacaoDestinoResultado.setSubloteLEI(im.getSubloteLEI());
					insumoLocalizacaoDestinoResultado.setQuantidadeVolume(im.getQuantidadeVolume());
					insumoLocalizacaoDestinoResultado.setUnidadeEntrada(im.getUnidadeEntrada());
					insumoLocalizacaoDestinoResultado.setUnidadeRecebida(im.getUnidadeRecebida());
					insumoLocalizacaoDestinoResultado.setDataPrevisaoControle(im.getDataPrevisaoControle());
					insumoLocalizacaoDestinoResultado.setIrradiado(im.getIrradiado());
					insumoLocalizacaoDestinoResultado.setUsualt(UserService.authenticated().getNome());
					insumoLocalizacaoDestinoResultado.setDatalt(new Date(System.currentTimeMillis()));
					
					insumosLocalizacoesDestino.add(insumoLocalizacaoDestinoResultado);
				}else {
					insumoLocalizacaoDestino.setAprovado(im.getAprovado());
					insumoLocalizacaoDestino.setDataAprovacao(im.getDataAprovacao());
					insumoLocalizacaoDestino.setDataIrradiacao(im.getDataIrradiacao());
					insumoLocalizacaoDestino.setDataValidade(im.getDataValidade());
					insumoLocalizacaoDestino.setLoteCR(im.getLoteCR());
					insumoLocalizacaoDestino.setLoteFornecedor(im.getLoteFornecedor());
					insumoLocalizacaoDestino.setLoteProducao(im.getLoteProducao());
					insumoLocalizacaoDestino.setQuantidade(quant);
					insumoLocalizacaoDestino.setInsumo(insumo);
					insumoLocalizacaoDestino.setLocalizacao(obj.getLocalizacaoDestino());
					insumoLocalizacaoDestino.setLoteRecebimento(im.getLoteRecebimento());
					insumoLocalizacaoDestino.setLoteLEI(im.getLoteLEI());
					insumoLocalizacaoDestino.setSubloteLEI(im.getSubloteLEI());
					insumoLocalizacaoDestino.setQuantidadeVolume(im.getQuantidadeVolume());
					insumoLocalizacaoDestino.setUnidadeEntrada(im.getUnidadeEntrada());
					insumoLocalizacaoDestino.setUnidadeRecebida(im.getUnidadeRecebida());
					insumoLocalizacaoDestino.setDataPrevisaoControle(im.getDataPrevisaoControle());
					insumoLocalizacaoDestino.setIrradiado(im.getIrradiado());
					insumoLocalizacaoDestino.setUsualt(UserService.authenticated().getNome());
					insumoLocalizacaoDestino.setDatalt(new Date(System.currentTimeMillis()));
					
					insumosLocalizacoesDestino.add(insumoLocalizacaoDestino);
				}
		
			} else {
				if(insumoLocalizacaoDestino.getLocalizacao().getLocalizacaofilha() == true) {
					if(quantidadedescartada > 0) {
						//joga pra descarte
						Localizacao locutil = localizacaoService.findByLocalizacaoDescartado(insumoLocalizacaoDestino.getLocalizacao().getObjlocalizacaofilha().getId());
						if(locutil != null) {
							InsumoLocalizacao insumoLocalizacaoDestinoDescarte = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, locutil, im.getLoteLEI());
							if(insumoLocalizacaoDestinoDescarte != null) {
								insumoLocalizacaoDestinoDescarte.setAprovado(im.getAprovado());
								insumoLocalizacaoDestinoDescarte.setQuantidade(insumoLocalizacaoDestinoDescarte.getQuantidade() + quantidadedescartada);
								insumoLocalizacaoDestinoDescarte.setLoteLEI(im.getLoteLEI());
								insumoLocalizacaoDestinoDescarte.setSubloteLEI(im.getSubloteLEI());
								insumoLocalizacaoDestinoDescarte.setQuantidadeVolume(im.getQuantidadeVolume());
								insumoLocalizacaoDestinoDescarte.setUnidadeEntrada(im.getUnidadeEntrada());
								insumoLocalizacaoDestinoDescarte.setUnidadeRecebida(im.getUnidadeRecebida());
								insumoLocalizacaoDestinoDescarte.setDataPrevisaoControle(im.getDataPrevisaoControle());
								insumoLocalizacaoDestinoDescarte.setIrradiado(im.getIrradiado());
							}else {
								insumoLocalizacaoDestinoDescarte = new InsumoLocalizacao(im);
								insumoLocalizacaoDestinoDescarte.setId(null);
								insumoLocalizacaoDestinoDescarte.setLocalizacao(locutil);
								insumoLocalizacaoDestinoDescarte.setAprovado(im.getAprovado());
								insumoLocalizacaoDestinoDescarte.setQuantidade((insumoLocalizacaoDestinoDescarte.getQuantidade() != null ?insumoLocalizacaoDestinoDescarte.getQuantidade(): 0.0)  + quantidadedescartada);
								insumoLocalizacaoDestinoDescarte.setLoteLEI(im.getLoteLEI());
								insumoLocalizacaoDestinoDescarte.setSubloteLEI(im.getSubloteLEI());
								insumoLocalizacaoDestinoDescarte.setQuantidadeVolume(im.getQuantidadeVolume());
								insumoLocalizacaoDestinoDescarte.setUnidadeEntrada(im.getUnidadeEntrada());
								insumoLocalizacaoDestinoDescarte.setUnidadeRecebida(im.getUnidadeRecebida());
								insumoLocalizacaoDestinoDescarte.setDataPrevisaoControle(im.getDataPrevisaoControle());
								insumoLocalizacaoDestinoDescarte.setIrradiado(im.getIrradiado());
							}
							insumoLocalizacaoDestinoDescarte.setUsualt(UserService.authenticated().getNome());
							insumoLocalizacaoDestinoDescarte.setDatalt(new Date(System.currentTimeMillis()));
							InsumoMovimentacao movim = new InsumoMovimentacao(insumoLocalizacaoDestinoDescarte);
							movim.setLocalizacaoOrigem(localizacaoOrigem);
							itensMovimentados.add(movim);
							insumosLocalizacoesDestino.add(insumoLocalizacaoDestinoDescarte);
						}
						
					}else if(quantidadeutilizada > 0) {
						//joga pra utilizada
						Localizacao locutil = localizacaoService.findByLocalizacaoUtilizado(insumoLocalizacaoDestino.getLocalizacao().getObjlocalizacaofilha().getId());
						if(locutil != null) {
							InsumoLocalizacao insumoLocalizacaoDestinoUtilizado = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, locutil, im.getLoteLEI());
							if(insumoLocalizacaoDestinoUtilizado != null) {
								insumoLocalizacaoDestinoUtilizado.setAprovado(im.getAprovado());
								insumoLocalizacaoDestinoUtilizado.setQuantidade(insumoLocalizacaoDestinoUtilizado.getQuantidade() + quantidadeutilizada);
								insumoLocalizacaoDestinoUtilizado.setLoteLEI(im.getLoteLEI());
								insumoLocalizacaoDestinoUtilizado.setSubloteLEI(im.getSubloteLEI());
								insumoLocalizacaoDestinoUtilizado.setQuantidadeVolume(im.getQuantidadeVolume());
								insumoLocalizacaoDestinoUtilizado.setUnidadeEntrada(im.getUnidadeEntrada());
								insumoLocalizacaoDestinoUtilizado.setUnidadeRecebida(im.getUnidadeRecebida());
								insumoLocalizacaoDestinoUtilizado.setDataPrevisaoControle(im.getDataPrevisaoControle());
								insumoLocalizacaoDestinoUtilizado.setIrradiado(im.getIrradiado());
								insumoLocalizacaoDestinoUtilizado.setQuantidadeUtilizada(im.getQuantidadeUtilizada());
							}else {
								insumoLocalizacaoDestinoUtilizado = new InsumoLocalizacao(im);
								insumoLocalizacaoDestinoUtilizado.setId(null);
								insumoLocalizacaoDestinoUtilizado.setLocalizacao(locutil);
								insumoLocalizacaoDestinoUtilizado.setAprovado(im.getAprovado());
								insumoLocalizacaoDestinoUtilizado.setQuantidade((insumoLocalizacaoDestinoUtilizado.getQuantidade() != null ?insumoLocalizacaoDestinoUtilizado.getQuantidade(): 0.0)  + quantidadeutilizada);
								insumoLocalizacaoDestinoUtilizado.setLoteLEI(im.getLoteLEI());
								insumoLocalizacaoDestinoUtilizado.setSubloteLEI(im.getSubloteLEI());
								insumoLocalizacaoDestinoUtilizado.setQuantidadeVolume(im.getQuantidadeVolume());
								insumoLocalizacaoDestinoUtilizado.setUnidadeEntrada(im.getUnidadeEntrada());
								insumoLocalizacaoDestinoUtilizado.setUnidadeRecebida(im.getUnidadeRecebida());
								insumoLocalizacaoDestinoUtilizado.setDataPrevisaoControle(im.getDataPrevisaoControle());
								insumoLocalizacaoDestinoUtilizado.setIrradiado(im.getIrradiado());
								insumoLocalizacaoDestinoUtilizado.setQuantidadeUtilizada(im.getQuantidadeUtilizada());
							}
							insumoLocalizacaoDestinoUtilizado.setUsualt(UserService.authenticated().getNome());
							insumoLocalizacaoDestinoUtilizado.setDatalt(new Date(System.currentTimeMillis()));
							InsumoMovimentacao movim = new InsumoMovimentacao(insumoLocalizacaoDestinoUtilizado);
							movim.setLocalizacaoOrigem(localizacaoOrigem);
							itensMovimentados.add(movim);
							insumosLocalizacoesDestino.add(insumoLocalizacaoDestinoUtilizado);
						}
					}
					/*else {
						Double novaQuantidade = insumoLocalizacaoDestino.getQuantidade() + quant + quantidadeutilizada + quantidadedescartada;
						insumoLocalizacaoDestino.setAprovado(im.getAprovado());
						insumoLocalizacaoDestino.setQuantidade(novaQuantidade);
						insumoLocalizacaoDestino.setLoteLEI(im.getLoteLEI());
						insumoLocalizacaoDestino.setQuantidadeVolume(im.getQuantidadeVolume());
						insumoLocalizacaoDestino.setUnidadeEntrada(im.getUnidadeEntrada());
						insumoLocalizacaoDestino.setUnidadeRecebida(im.getUnidadeRecebida());
						insumoLocalizacaoDestino.setDataPrevisaoControle(im.getDataPrevisaoControle());
						insumoLocalizacaoDestino.setIrradiado(im.getIrradiado());	
					}*/
					Double quantidaderestante = insumoLocalizacaoOrigem.getQuantidade() - quantidadeutilizada - quantidadedescartada;
					if(quantidaderestante > 0) {
						InsumoLocalizacao insumoLocalizacaoDestinoRestante = insumoLocalizacaoRepository.findDuplicadoLoteLei(insumo, insumoLocalizacaoDestino.getLocalizacao(), im.getLoteLEI());
						if(insumoLocalizacaoDestinoRestante != null) {
							insumoLocalizacaoDestinoRestante.setAprovado(im.getAprovado());
							insumoLocalizacaoDestinoRestante.setQuantidade(insumoLocalizacaoDestinoRestante.getQuantidade() + quantidaderestante);
							insumoLocalizacaoDestinoRestante.setLoteLEI(im.getLoteLEI());
							insumoLocalizacaoDestinoRestante.setSubloteLEI(im.getSubloteLEI());
							insumoLocalizacaoDestinoRestante.setQuantidadeVolume(im.getQuantidadeVolume());
							insumoLocalizacaoDestinoRestante.setUnidadeEntrada(im.getUnidadeEntrada());
							insumoLocalizacaoDestinoRestante.setUnidadeRecebida(im.getUnidadeRecebida());
							insumoLocalizacaoDestinoRestante.setDataPrevisaoControle(im.getDataPrevisaoControle());
							insumoLocalizacaoDestinoRestante.setIrradiado(im.getIrradiado());
						}else {
							insumoLocalizacaoDestinoRestante = new InsumoLocalizacao();
							insumoLocalizacaoDestinoRestante.setAprovado(im.getAprovado());
							insumoLocalizacaoDestinoRestante.setDataAprovacao(im.getDataAprovacao());
							insumoLocalizacaoDestinoRestante.setDataIrradiacao(im.getDataIrradiacao());
							insumoLocalizacaoDestinoRestante.setDataValidade(im.getDataValidade());
							insumoLocalizacaoDestinoRestante.setLoteCR(im.getLoteCR());
							insumoLocalizacaoDestinoRestante.setLoteFornecedor(im.getLoteFornecedor());
							insumoLocalizacaoDestinoRestante.setLoteProducao(im.getLoteProducao());
							insumoLocalizacaoDestinoRestante.setQuantidade(quantidaderestante);
							insumoLocalizacaoDestinoRestante.setInsumo(insumo);
							insumoLocalizacaoDestinoRestante.setLocalizacao(insumoLocalizacaoDestino.getLocalizacao());
							insumoLocalizacaoDestinoRestante.setLoteRecebimento(im.getLoteRecebimento());
							insumoLocalizacaoDestinoRestante.setLoteLEI(im.getLoteLEI());
							insumoLocalizacaoDestinoRestante.setSubloteLEI(im.getSubloteLEI());
							insumoLocalizacaoDestinoRestante.setQuantidadeVolume(im.getQuantidadeVolume());
							insumoLocalizacaoDestinoRestante.setUnidadeEntrada(im.getUnidadeEntrada());
							insumoLocalizacaoDestinoRestante.setUnidadeRecebida(im.getUnidadeRecebida());
							insumoLocalizacaoDestinoRestante.setDataPrevisaoControle(im.getDataPrevisaoControle());
							insumoLocalizacaoDestinoRestante.setIrradiado(im.getIrradiado());
						}
						insumoLocalizacaoDestinoRestante.setUsualt(UserService.authenticated().getNome());
						insumoLocalizacaoDestinoRestante.setDatalt(new Date(System.currentTimeMillis()));
						
						insumosLocalizacoesDestino.add(insumoLocalizacaoDestinoRestante);
					}
					
					insumosLocalizacoesDestino.add(insumoLocalizacaoDestino);
				}else {
					Double novaQuantidade = insumoLocalizacaoDestino.getQuantidade() + quant + quantidadeutilizada + quantidadedescartada;
					insumoLocalizacaoDestino.setAprovado(im.getAprovado());
					insumoLocalizacaoDestino.setQuantidade(novaQuantidade);
					insumoLocalizacaoDestino.setLoteLEI(im.getLoteLEI());
					insumoLocalizacaoDestino.setSubloteLEI(im.getSubloteLEI());
					insumoLocalizacaoDestino.setQuantidadeVolume(im.getQuantidadeVolume());
					insumoLocalizacaoDestino.setUnidadeEntrada(im.getUnidadeEntrada());
					insumoLocalizacaoDestino.setUnidadeRecebida(im.getUnidadeRecebida());
					insumoLocalizacaoDestino.setDataPrevisaoControle(im.getDataPrevisaoControle());
					insumoLocalizacaoDestino.setIrradiado(im.getIrradiado());
					insumoLocalizacaoDestino.setDataIrradiacao(im.getDataIrradiacao());
					insumoLocalizacaoDestino.setUsualt(UserService.authenticated().getNome());
					insumoLocalizacaoDestino.setDatalt(new Date(System.currentTimeMillis()));
					insumoLocalizacaoDestino.setDataValidade(im.getDataValidade());
					
					
					insumosLocalizacoesDestino.add(insumoLocalizacaoDestino);
				}

			}

			if (insumoLocalizacaoOrigem.getQuantidade() == null) {
				insumoLocalizacaoOrigem.setQuantidade(0.0);
			}
		
			
			Double novaQuantidade = insumoLocalizacaoOrigem.getQuantidade() - quant - quantidadeutilizada - quantidadedescartada;
			insumoLocalizacaoOrigem.setQuantidade(novaQuantidade);
			insumoLocalizacaoOrigem.setUsualt(UserService.authenticated().getNome());
			insumoLocalizacaoOrigem.setDatalt(new Date(System.currentTimeMillis()));
			insumosLocalizacoesOrigem.add(insumoLocalizacaoOrigem);

			im.setMovimentacao(obj);
			
			this.atualizaAprovacaoLoteLei(im);
			
			itensMovimentados.add(im);
		    
		}

		insumoLocalizacaoRepository.saveAll(insumosLocalizacoesDestino);
		
		
		
		
		insumoLocalizacaoRepository.saveAll(insumosLocalizacoesOrigem);
		
		//AQUI
		insumoMovimentacaoRepository.saveAll(itensMovimentados);
		insumoRepository.saveAll(insumos);
		return obj;
	}
	
	public void atualizaAprovacaoLoteLei(InsumoMovimentacao in) {
		if(in.getAprovado() != null) {
			if(in.getAprovado() == true) {
				insumoLocalizacaoRepository.updateAprovacaoPorLoteLEI(true,in.getLoteLEI());
			}else {
				insumoLocalizacaoRepository.updateAprovacaoPorLoteLEI(false, in.getLoteLEI());
			}
		}
	}

	public List<Movimentacao> findAll() {
		List<Movimentacao> lista = repo.findAllByOrderByIdDesc();
		return lista;
	}

	public Page<Movimentacao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public List<InsumoMovimentacao> movimentacoesPorLoteLEI(String loteLEI) {
		// TODO Auto-generated method stub
		List<InsumoMovimentacao> lista = insumoMovimentacaoRepository.movimentacoesPorLoteLEI(loteLEI);
		return lista;
	}

}
