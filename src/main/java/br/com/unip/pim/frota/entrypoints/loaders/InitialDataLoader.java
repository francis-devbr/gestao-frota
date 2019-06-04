package br.com.unip.pim.frota.entrypoints.loaders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.Contato;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.Pessoa;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.Telefone;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.base.TipoPessoa;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.empresa.Cargo;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.empresa.Empresa;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.empresa.Funcionario;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Bairro;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Cidade;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Endereco;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Estado;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Logradouro;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.Pais;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.localizacao.TipoLogradouro;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.login.Privilegio;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.login.Regra;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.login.Usuario;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.motorista.Cnh;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.motorista.Motorista;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo.Categoria;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo.Marca;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo.Modelo;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo.TipoCombustivel;
import br.com.unip.pim.frota.dataproviders.database.orm.entities.veiculo.Veiculo;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.CargoRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.CategoriaRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.EmpresaRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.FuncionarioRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.MarcaRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.ModeloRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.MotoristaRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.PessoaRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.PrivilegioRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.RegraRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.TipoCombustivelRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.UsuarioRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.VeiculoRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao.BairroRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao.CidadeRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao.EstadoRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao.LogradouroRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao.PaisRepository;
import br.com.unip.pim.frota.dataproviders.database.orm.repositories.localizacao.TipoLogradouroRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InitialDataLoader implements
		ApplicationListener<ContextRefreshedEvent> {

	private final UsuarioRepository usuarioRepository;

	private final RegraRepository regraRepository;

	private final PrivilegioRepository privilegioRepository;

	private final PaisRepository paisRepository;

	private final EstadoRepository estadoRepository;

	private final CidadeRepository cidadeRepository;

	private final BairroRepository bairroRepository;

	private final TipoLogradouroRepository tipoLogradouroRepository;

	private final LogradouroRepository logradouroRepository;

	private final PessoaRepository pessoaRepository;

	private final FuncionarioRepository funcionarioRepository;

	private final CargoRepository cargoRepository;

	private final EmpresaRepository empresaRepository;

	private final MotoristaRepository motoristaRepository;

	private final ModeloRepository modeloRepository;

	private final MarcaRepository marcaRepository;

	private final TipoCombustivelRepository tipoCombustivelRepository;

	private final CategoriaRepository categoriaRepository;

	private final VeiculoRepository veiculoRepository;

	private void initPrivilegesAndRoles() {

		// == create initial privileges
		Privilegio readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilegio writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		Privilegio masterPrivilege = createPrivilegeIfNotFound("MASTER_PRIVILEGE");

		// == create initial roles
		List<Privilegio> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);

		List<Privilegio> userPrivileges = Arrays.asList(readPrivilege);
		createRoleIfNotFound("ROLE_USER", userPrivileges);

		List<Privilegio> guestPrivileges = Arrays.asList(readPrivilege);
		createRoleIfNotFound("ROLE_GUEST", guestPrivileges);

		List<Privilegio> masterPrivileges = Arrays.asList(masterPrivilege);
		createRoleIfNotFound("ROLE_MASTER", masterPrivileges);

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		initPrivilegesAndRoles();

		createPaises();

		createUfPaisBr();

		createTipoLogradouro();

		createLogradourosUfSP();

		createEmpresa();

		createFuncionarioSupervisor();

		createFuncionarioAtendente();

		createFuncionarioTecnico();

		createMotorista();

		createVeiculo();
	}

	private void createVeiculo() {

		Modelo modelo = Modelo.builder()
				.nome("Uno fire")
				.isEnable(true)
				.build();
		modelo = modeloRepository.save(modelo);

		Marca marca = Marca.builder()
				.nome("Fiat")
				.modelos(Arrays.asList(modelo))
				.isEnable(true)
				.build();
		marca = marcaRepository.save(marca);

		TipoCombustivel tipoCombustivel = TipoCombustivel.builder()
				.nome("Gasolina")
				.isEnable(true)
				.build();
		tipoCombustivel = tipoCombustivelRepository.save(tipoCombustivel);

		Categoria categoria = Categoria.builder()
				.nome("Passeio")
				.isEnable(true)
				.build();
		categoria = categoriaRepository.save(categoria);

		Veiculo veiculo = Veiculo.builder()
				.placa("XPT4122")
				.chassi("fsgafsgasfg")
				.renavam("sasasasasasas")
				.marca(marca)
				.anoFabricacao(2018)
				.anoModelo(2018)
				.cor("branco")
				.tipoCombustivel(tipoCombustivel)
				.categoria(categoria)
				.valorPago(BigDecimal.valueOf(30.000))
				.kmInicial(BigDecimal.ZERO)
				.kmAtual(BigDecimal.TEN)
				.mesIpva(1)
				.isEnable(true)
				.build();

		veiculoRepository.save(veiculo);
	}

	private void createTipoLogradouro() {

		List<TipoLogradouro> tiposLogradouro = new ArrayList<>();

		TipoLogradouro tipoLogradouro = TipoLogradouro.builder()
				.nome("Rua")
				.build();
		tiposLogradouro.add(tipoLogradouro);

		tipoLogradouro = TipoLogradouro.builder()
				.nome("Avenida")
				.build();
		tiposLogradouro.add(tipoLogradouro);

		tipoLogradouro = TipoLogradouro.builder()
				.nome("Travessa")
				.build();
		tiposLogradouro.add(tipoLogradouro);

		tipoLogradouro = TipoLogradouro.builder()
				.nome("Passagem")
				.build();
		tiposLogradouro.add(tipoLogradouro);

		tipoLogradouro = TipoLogradouro.builder()
				.nome("Praça")
				.build();
		tiposLogradouro.add(tipoLogradouro);

		tipoLogradouroRepository.saveAll(tiposLogradouro);
	}

	private void createLogradourosUfSP() {

		List<Cidade> cidades = new ArrayList<>();
		List<Bairro> bairros = new ArrayList<>();
		List<Logradouro> logradouros = new ArrayList<>();

		Estado estado = estadoRepository.findBySigla("SP");

		Cidade cidade = Cidade.builder()
				.estado(estado)
				.nome("Sao Paulo")
				.build();
		cidades.add(cidade);

		Bairro bairro = Bairro.builder()
				.cidade(cidade)
				.nome("Bela Vista")
				.build();
		bairros.add(bairro);

		TipoLogradouro tipoLogradouro = tipoLogradouroRepository.findByNome("Rua");

		Logradouro logradouro = Logradouro.builder()
				.cep("01308040")
				.tipoLogradouro(tipoLogradouro)
				.nome("São Miguel")
				.bairro(bairro)
				.build();
		logradouros.add(logradouro);

		bairro = Bairro.builder()
				.cidade(cidade)
				.nome("Cambuci")
				.build();
		bairros.add(bairro);

		tipoLogradouro = tipoLogradouroRepository.findByNome("Rua");

		logradouro = Logradouro.builder()
				.cep("01543000")
				.tipoLogradouro(tipoLogradouro)
				.nome("Heitor Peixoto")
				.complemento("- até 429/430")
				.bairro(bairro)
				.build();
		logradouros.add(logradouro);

		cidade = Cidade.builder()
				.estado(estado)
				.nome("Diadema")
				.build();
		cidades.add(cidade);

		bairro = Bairro.builder()
				.cidade(cidade)
				.nome("Eldorado")
				.build();
		bairros.add(bairro);

		tipoLogradouro = tipoLogradouroRepository.findByNome("Praça");

		logradouro = Logradouro.builder()
				.cep("09971370")
				.tipoLogradouro(tipoLogradouro)
				.nome("Gilberto")
				.complemento("(Pr Vermelha)")
				.bairro(bairro)
				.build();
		logradouros.add(logradouro);

		bairro = Bairro.builder()
				.cidade(cidade)
				.nome("Centro")
				.build();
		bairros.add(bairro);

		tipoLogradouro = tipoLogradouroRepository.findByNome("Rua");
		logradouro = Logradouro.builder()
				.cep("09910030")
				.tipoLogradouro(tipoLogradouro)
				.nome("Antônio Pedrozelli")
				.complemento("(Prq S Setembro)")
				.bairro(bairro)
				.build();
		logradouros.add(logradouro);

		bairro = Bairro.builder()
				.cidade(cidade)
				.nome("Serraria")
				.build();
		bairros.add(bairro);

		tipoLogradouro = tipoLogradouroRepository.findByNome("Passagem");
		logradouro = Logradouro.builder()
				.cep("09990104")
				.tipoLogradouro(tipoLogradouro)
				.nome("Mãe Rainha")
				.bairro(bairro)
				.build();
		logradouros.add(logradouro);

		tipoLogradouro = tipoLogradouroRepository.findByNome("Travessa");
		logradouro = Logradouro.builder()
				.cep("09980243")
				.tipoLogradouro(tipoLogradouro)
				.nome("Antônio Bispo José dos Reis")
				.bairro(bairro)
				.build();
		logradouros.add(logradouro);

		cidadeRepository.saveAll(cidades);

		bairroRepository.saveAll(bairros);

		logradouroRepository.saveAll(logradouros);
	}

	private void createUfPaisBr() {

		Pais pais = paisRepository.findBySigla("BR");

		List<Estado> estados = new ArrayList<>();

		Estado estado = Estado.builder().sigla("AC").nome("Acre").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("AL").nome("Alagoas").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("AM").nome("Amazonas").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("AP").nome("Amapá").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("BA").nome("Bahia").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("CE").nome("Ceará").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("DF").nome("Distrito Federal").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("ES").nome("Espírito Santo").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("GO").nome("Goiás").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("MA").nome("Maranhão").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("MG").nome("Minas Gerais").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("MS").nome("Mato Grosso do Sul").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("MT").nome("Mato Grosso").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("PA").nome("Pará").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("PB").nome("Paraíba").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("PE").nome("Pernambuco").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("PI").nome("Piauí").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("PR").nome("Paraná").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("RJ").nome("Rio de Janeiro").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("RN").nome("Rio Grande do Norte").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("RO").nome("Rondônia").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("RR").nome("Roraima").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("RS").nome("Rio Grande do Sul").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("SC").nome("Santa Catarina").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("SE").nome("Sergipe").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("SP").nome("São Paulo").pais(pais).build();
		estados.add(estado);

		estado = Estado.builder().sigla("TO").nome("Tocantins").pais(pais).build();
		estados.add(estado);

		estadoRepository.saveAll(estados);
	}

	private void createPaises() {

		List<Pais> paises = new ArrayList<>();

		Pais pais = Pais.builder().sigla("AD").nome("Andorra").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AE").nome("Emirados Árabes Unidos").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AF").nome("Afeganistão").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AG").nome("Antígua e Barbuda").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AI").nome("Anguilla").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AL").nome("Albânia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AM").nome("Armênia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AN").nome("Antilhas Holandesas").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AO").nome("Angola").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AQ").nome("Antártida").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AR").nome("Argentina").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AS").nome("Samoa Americana").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AT").nome("Áustria").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AU").nome("Austrália").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AW").nome("Aruba").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AX").nome("Ilhas Aland").build();
		paises.add(pais);

		pais = Pais.builder().sigla("AZ").nome("Azerbaijão").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BA").nome("Bósnia-Herzegóvina").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BB").nome("Barbados").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BD").nome("Bangladesh").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BE").nome("Bélgica").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BF").nome("Burkina Fasso").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BG").nome("Bulgária").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BH").nome("Bahrein").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BI").nome("Burundi").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BJ").nome("Benin").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BL").nome("São Bartolomeu").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BM").nome("Bermudas").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BN").nome("Brunei").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BO").nome("Bolívia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BQ").nome("Bonaire, Sint Eustatius e Saba").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BR").nome("Brasil").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BS").nome("Bahamas").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BT").nome("Butão").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BV").nome("Ilha Bouvet (Território da Noruega)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BW").nome("Botsuana").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BY").nome("Belarus").build();
		paises.add(pais);

		pais = Pais.builder().sigla("BZ").nome("Belize").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CA").nome("Canadá").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CC").nome("Ilhas Cocos").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CD").nome("República Democrática do Congo (ex-Zaire)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CF").nome("República Centro-Africana").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CG").nome("Congo").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CH").nome("Suíça").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CI").nome("Costa do Marfim").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CK").nome("Ilhas Cook").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CL").nome("Chile").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CM").nome("Camarões").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CN").nome("China").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CO").nome("Colômbia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CR").nome("Costa Rica").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CU").nome("Cuba").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CV").nome("Cabo Verde").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CW").nome("Curaçao").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CX").nome("Ilha Natal").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CY").nome("Chipre").build();
		paises.add(pais);

		pais = Pais.builder().sigla("CZ").nome("República Tcheca").build();
		paises.add(pais);

		pais = Pais.builder().sigla("DE").nome("Alemanha").build();
		paises.add(pais);

		pais = Pais.builder().sigla("DJ").nome("Djibuti").build();
		paises.add(pais);

		pais = Pais.builder().sigla("DK").nome("Dinamarca").build();
		paises.add(pais);

		pais = Pais.builder().sigla("DM").nome("Dominica").build();
		paises.add(pais);

		pais = Pais.builder().sigla("DO").nome("República Dominicana").build();
		paises.add(pais);

		pais = Pais.builder().sigla("DZ").nome("Argélia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("EC").nome("Equador").build();
		paises.add(pais);

		pais = Pais.builder().sigla("EE").nome("Estônia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("EG").nome("Egito").build();
		paises.add(pais);

		pais = Pais.builder().sigla("EH").nome("Saara Ocidental (Ex-Spanish Sahara)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("ER").nome("Eritréia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("ES").nome("Espanha").build();
		paises.add(pais);

		pais = Pais.builder().sigla("ET").nome("Etiópia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("FI").nome("Finlândia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("FJ").nome("Fiji").build();
		paises.add(pais);

		pais = Pais.builder().sigla("FK").nome("Ilhas Falkland (Malvinas)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("FM").nome("Micronésia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("FO").nome("Ilhas Faroes").build();
		paises.add(pais);

		pais = Pais.builder().sigla("FR").nome("França").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GA").nome("Gabão").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GB").nome("Grã-Bretanha (Reino Unido, UK)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GD").nome("Granada").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GE").nome("Geórgia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GF").nome("Guiana Francesa").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GG").nome("Guernsey").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GH").nome("Gana").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GI").nome("Gibraltar").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GL").nome("Groelândia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GM").nome("Gâmbia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GN").nome("Guiné").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GP").nome("Guadalupe").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GQ").nome("Guiné Equatorial").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GR").nome("Grécia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GS").nome("Ilhas Geórgia do Sul e Sandwich do Sul").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GT").nome("Guatemala").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GU").nome("Guam (Território dos Estados Unidos)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GW").nome("Guiné-Bissau").build();
		paises.add(pais);

		pais = Pais.builder().sigla("GY").nome("Guiana").build();
		paises.add(pais);

		pais = Pais.builder().sigla("HK").nome("Hong Kong").build();
		paises.add(pais);

		pais = Pais.builder().sigla("HM").nome("Ilhas Heard e McDonald (Território da Austrália)")
				.build();
		paises.add(pais);

		pais = Pais.builder().sigla("HN").nome("Honduras").build();
		paises.add(pais);

		pais = Pais.builder().sigla("HR").nome("Croácia (Hrvatska)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("HT").nome("Haiti").build();
		paises.add(pais);

		pais = Pais.builder().sigla("HU").nome("Hungria").build();
		paises.add(pais);

		pais = Pais.builder().sigla("ID").nome("Indonésia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("IE").nome("Irlanda").build();
		paises.add(pais);

		pais = Pais.builder().sigla("IL").nome("Israel").build();
		paises.add(pais);

		pais = Pais.builder().sigla("IM").nome("Ilha do Homem").build();
		paises.add(pais);

		pais = Pais.builder().sigla("IN").nome("Índia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("IO").nome("Território Britânico do Oceano índico").build();
		paises.add(pais);

		pais = Pais.builder().sigla("IQ").nome("Iraque").build();
		paises.add(pais);

		pais = Pais.builder().sigla("IR").nome("Irã").build();
		paises.add(pais);

		pais = Pais.builder().sigla("IS").nome("Islândia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("IT").nome("Itália").build();
		paises.add(pais);

		pais = Pais.builder().sigla("JE").nome("Jersey").build();
		paises.add(pais);

		pais = Pais.builder().sigla("JM").nome("Jamaica").build();
		paises.add(pais);

		pais = Pais.builder().sigla("JO").nome("Jordânia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("JP").nome("Japão").build();
		paises.add(pais);

		pais = Pais.builder().sigla("KE").nome("Kênia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("KG").nome("Kyrgyzstan").build();
		paises.add(pais);

		pais = Pais.builder().sigla("KH").nome("Camboja").build();
		paises.add(pais);

		pais = Pais.builder().sigla("KI").nome("Kiribati").build();
		paises.add(pais);

		pais = Pais.builder().sigla("KM").nome("Ilhas Comores").build();
		paises.add(pais);

		pais = Pais.builder().sigla("KN").nome("São Cristóvão e Névis").build();
		paises.add(pais);

		pais = Pais.builder().sigla("KP").nome("Coréia do Norte").build();
		paises.add(pais);

		pais = Pais.builder().sigla("KR").nome("Coréia do Sul").build();
		paises.add(pais);

		pais = Pais.builder().sigla("KW").nome("Kuait").build();
		paises.add(pais);

		pais = Pais.builder().sigla("KY").nome("Ilhas Cayman").build();
		paises.add(pais);

		pais = Pais.builder().sigla("KZ").nome("Cazaquistão").build();
		paises.add(pais);

		pais = Pais.builder().sigla("LA").nome("Laos").build();
		paises.add(pais);

		pais = Pais.builder().sigla("LB").nome("Líbano").build();
		paises.add(pais);

		pais = Pais.builder().sigla("LC").nome("Santa Lúcia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("LI").nome("Liechtenstein").build();
		paises.add(pais);

		pais = Pais.builder().sigla("LK").nome("Sri Lanka").build();
		paises.add(pais);

		pais = Pais.builder().sigla("LR").nome("Libéria").build();
		paises.add(pais);

		pais = Pais.builder().sigla("LS").nome("Lesoto").build();
		paises.add(pais);

		pais = Pais.builder().sigla("LT").nome("Lituânia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("LU").nome("Luxemburgo").build();
		paises.add(pais);

		paises.add(pais);
		pais = Pais.builder().sigla("LV").nome("Látvia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("LY").nome("Líbia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MA").nome("Marrocos").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MC").nome("Mônaco").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MD").nome("Moldova").build();
		paises.add(pais);

		pais = Pais.builder().sigla("ME").nome("Montenegro").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MF").nome("São Martim").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MG").nome("Madagascar").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MH").nome("Ilhas Marshall").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MK").nome("Macedônia (República Yugoslava)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("ML").nome("Mali").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MM").nome("Myanma (Ex-Burma)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MN").nome("Mongólia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MO").nome("Macau").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MP").nome("Ilhas Marianas do Norte").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MQ").nome("Martinica").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MR").nome("Mauritânia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MS").nome("Montserrat").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MT").nome("Malta").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MU").nome("Maurício").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MV").nome("Maldivas").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MW").nome("Malaui").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MX").nome("Mexico").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MY").nome("Malásia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("MZ").nome("Moçambique").build();
		paises.add(pais);

		pais = Pais.builder().sigla("NA").nome("Namíbia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("NC").nome("Nova Caledônia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("NE").nome("Níger").build();
		paises.add(pais);

		pais = Pais.builder().sigla("NF").nome("Ilhas Norfolk").build();
		paises.add(pais);

		pais = Pais.builder().sigla("NG").nome("Nigéria").build();
		paises.add(pais);

		pais = Pais.builder().sigla("NI").nome("Nicarágua").build();
		paises.add(pais);

		pais = Pais.builder().sigla("NL").nome("Holanda").build();
		paises.add(pais);

		pais = Pais.builder().sigla("NO").nome("Noruega").build();
		paises.add(pais);

		pais = Pais.builder().sigla("NP").nome("Nepal").build();
		paises.add(pais);

		pais = Pais.builder().sigla("NR").nome("Nauru").build();
		paises.add(pais);

		pais = Pais.builder().sigla("NU").nome("Niue").build();
		paises.add(pais);

		pais = Pais.builder().sigla("NZ").nome("Nova Zelândia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("OM").nome("Omã").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PA").nome("Panamá").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PE").nome("Peru").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PF").nome("Polinésia Francesa").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PG").nome("Papua-Nova Guiné").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PH").nome("Filipinas").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PK").nome("Paquistão").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PL").nome("Polônia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PM").nome("St. Pierre and Miquelon").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PN").nome("Ilha Pitcairn").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PR").nome("Porto Rico").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PS").nome("Territórios Palestinos Ocupados").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PT").nome("Portugal").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PW").nome("Palau").build();
		paises.add(pais);

		pais = Pais.builder().sigla("PY").nome("Paraguai").build();
		paises.add(pais);

		pais = Pais.builder().sigla("QA").nome("Qatar").build();
		paises.add(pais);

		pais = Pais.builder().sigla("RE").nome("Ilha Reunião").build();
		paises.add(pais);

		pais = Pais.builder().sigla("RO").nome("Romênia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("RS").nome("Sérvia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("RU").nome("Federação Russa").build();
		paises.add(pais);

		pais = Pais.builder().sigla("RW").nome("Ruanda").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SA").nome("Arábia Saudita").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SB").nome("Ilhas Solomão").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SC").nome("Ilhas Seychelles").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SD").nome("Sudão").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SE").nome("Suécia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SG").nome("Cingapura").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SH").nome("Santa Helena").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SI").nome("Eslovênia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SJ").nome("Ilhas Svalbard e Jan Mayen").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SK").nome("Eslováquia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SL").nome("Serra Leoa").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SM").nome("San Marino").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SN").nome("Senegal").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SO").nome("Somália").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SR").nome("Suriname").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SS").nome("Sudão do Sul").build();
		paises.add(pais);

		pais = Pais.builder().sigla("ST").nome("São Tomé e Príncipe").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SV").nome("El Salvador").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SX").nome("São Martinho (Parte Holandesa)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SY").nome("Síria").build();
		paises.add(pais);

		pais = Pais.builder().sigla("SZ").nome("Suazilândia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TC").nome("Ilhas Turks e Caicos").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TD").nome("Chade").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TF").nome("Territórios do Sul da França").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TG").nome("Togo").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TH").nome("Tailândia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TJ").nome("Tadjiquistão").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TK").nome("Ilhas Tokelau").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TL").nome("Timor Leste (Ex-East Timor)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TM").nome("Turcomenistão").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TN").nome("Tunísia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TO").nome("Tonga").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TR").nome("Turquia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TT").nome("Trinidad and Tobago").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TV").nome("Tuvalu").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TW").nome("Taiwan").build();
		paises.add(pais);

		pais = Pais.builder().sigla("TZ").nome("Tanzânia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("UA").nome("Ucrânia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("UG").nome("Uganda").build();
		paises.add(pais);

		pais = Pais.builder().sigla("UM").nome("Ilhas Menores dos Estados Unidos").build();
		paises.add(pais);

		pais = Pais.builder().sigla("US").nome("Estados Unidos").build();
		paises.add(pais);

		pais = Pais.builder().sigla("UY").nome("Uruguai").build();
		paises.add(pais);

		pais = Pais.builder().sigla("UZ").nome("Uzbequistão").build();
		paises.add(pais);

		pais = Pais.builder().sigla("VA").nome("Vaticano").build();
		paises.add(pais);

		pais = Pais.builder().sigla("VC").nome("Saint Vincente e Granadinas").build();
		paises.add(pais);

		pais = Pais.builder().sigla("VE").nome("Venezuela").build();
		paises.add(pais);

		pais = Pais.builder().sigla("VG").nome("Ilhas Virgens (Inglaterra)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("VI").nome("Ilhas Virgens (Estados Unidos)").build();
		paises.add(pais);

		pais = Pais.builder().sigla("VN").nome("Vietnam").build();
		paises.add(pais);

		pais = Pais.builder().sigla("VU").nome("Vanuatu").build();
		paises.add(pais);

		pais = Pais.builder().sigla("WF").nome("Ilhas Wallis e Futuna").build();
		paises.add(pais);

		pais = Pais.builder().sigla("WS").nome("Samoa Ocidental").build();
		paises.add(pais);

		pais = Pais.builder().sigla("YE").nome("Iêmen").build();
		paises.add(pais);

		pais = Pais.builder().sigla("YT").nome("Mayotte").build();
		paises.add(pais);

		pais = Pais.builder().sigla("ZA").nome("África do Sul").build();
		paises.add(pais);

		pais = Pais.builder().sigla("ZM").nome("Zâmbia").build();
		paises.add(pais);

		pais = Pais.builder().sigla("ZW").nome("Zimbábue").build();
		paises.add(pais);

		paisRepository.saveAll(paises);
	}

	private void createEmpresa() {

		Logradouro logradouro = logradouroRepository.findByCep("01308040");

		Endereco endereco = Endereco.builder()
				.logradouro(logradouro)
				.numero("201")
				.build();

		Telefone telefone = Telefone.builder()
				.tipo("Fixo")
				.ddd("11")
				.numero("41414141")
				.isEnable(true)
				.build();

		Contato contato = Contato.builder()
				.tipo("Comercial")
				.telefones(Arrays.asList(telefone))
				.email("sac@rgb.com")
				.build();

		Pessoa pessoa = Pessoa.builder()
				.nome("RGB Locações de Automóveis")
				.tipoPessoa(TipoPessoa.JURIDICA)
				.cpfOuCnpj("72907711000155")
				.enderecos(Arrays.asList(endereco))
				.contatos(Arrays.asList(contato))
				.build();

		Empresa empresa = Empresa.builder()
				.pessoa(pessoa)
				.inscricaoEstadual("775085384078")
				.isEnable(true)
				.build();
		empresaRepository.save(empresa);
	}

	private void createMotorista() {

		Pessoa pessoa = pessoaRepository.findByCpfOuCnpj("06160044001");

		Cnh cnh = Cnh.builder()
				.categoria("A")
				.numero("77378246452")
				.renovaEm(LocalDate.parse("2019-01-01"))
				.build();

		Motorista motorista = Motorista.builder()
				.pessoa(pessoa)
				.cnh(cnh)
				.isEnable(true)
				.build();

		motoristaRepository.save(motorista);

	}

	private void createFuncionarioSupervisor() {

		List<Telefone> telefones = new ArrayList<>();

		Logradouro logradouro = logradouroRepository.findByCep("09910030");

		Endereco endereco = Endereco.builder()
				.logradouro(logradouro)
				.numero("400")
				.build();

		Telefone telefone = Telefone.builder()
				.tipo("Celular")
				.ddd("11")
				.numero("947020140")
				.isEnable(true)
				.build();
		telefones.add(telefone);

		telefone = Telefone.builder()
				.tipo("Fixo")
				.ddd("11")
				.numero("41414141")
				.isEnable(true)
				.build();
		telefones.add(telefone);

		Contato contato = Contato.builder()
				.tipo("Pessoal")
				.telefones(telefones)
				.email("fnolivei@outlook.com")
				.build();

		Regra regra = regraRepository.findByNome("ROLE_ADMIN");

		Pessoa pessoa = Pessoa.builder()
				.nome("Francis Oliveira")
				.tipoPessoa(TipoPessoa.FISICA)
				.cpfOuCnpj("31406826898")
				.enderecos(Arrays.asList(endereco))
				.contatos(Arrays.asList(contato))
				.build();

		Cargo cargo = createCargoIfNotFound("Supervisor");

		Empresa empresa = empresaRepository
				.findByPessoa(pessoaRepository.findByCpfOuCnpj("72907711000155"));

		Funcionario funcionario = Funcionario.builder()
				.pessoa(pessoa)
				.sexo("M")
				.empresa(empresa)
				.cargo(cargo)
				.isEnable(true)
				.build();

		funcionarioRepository.save(funcionario);

		createUsuarioIfNotFound("supervisor", "1234", regra, pessoa);
	}

	private void createFuncionarioTecnico() {

		List<Telefone> telefones = new ArrayList<>();

		Regra regra = regraRepository.findByNome("ROLE_USER");

		Empresa empresa = empresaRepository
				.findByPessoa(pessoaRepository.findByCpfOuCnpj("72907711000155"));

		Logradouro logradouro = logradouroRepository.findByCep("09980243");

		Endereco endereco = Endereco.builder()
				.logradouro(logradouro)
				.numero("1800")
				.build();

		Telefone telefone = Telefone.builder()
				.tipo("Celular")
				.ddd("11")
				.numero("996959630")
				.isEnable(true)
				.build();
		telefones.add(telefone);

		telefone = Telefone.builder()
				.tipo("Fixo")
				.ddd("11")
				.numero("37284341")
				.isEnable(true)
				.build();
		telefones.add(telefone);

		Contato contato = Contato.builder()
				.tipo("Pessoal")
				.telefones(telefones)
				.email("rogerio.silva@outlook.com")
				.build();

		Pessoa pessoa = Pessoa.builder()
				.nome("Rogerio Silva")
				.tipoPessoa(TipoPessoa.FISICA)
				.cpfOuCnpj("06160044001")
				.enderecos(Arrays.asList(endereco))
				.contatos(Arrays.asList(contato))
				.build();

		Cargo cargo = createCargoIfNotFound("Tecnico");

		Funcionario funcionario = Funcionario.builder()
				.pessoa(pessoa)
				.sexo("M")
				.empresa(empresa)
				.cargo(cargo)
				.isEnable(true)
				.build();

		funcionarioRepository.save(funcionario);

		createUsuarioIfNotFound("tecnico001", "1234", regra, pessoa);
	}

	private void createFuncionarioAtendente() {

		List<Telefone> telefones = new ArrayList<>();

		Regra regra = regraRepository.findByNome("ROLE_USER");

		Empresa empresa = empresaRepository
				.findByPessoa(pessoaRepository.findByCpfOuCnpj("72907711000155"));

		Logradouro logradouro = logradouroRepository.findByCep("09980243");

		Endereco endereco = Endereco.builder()
				.logradouro(logradouro)
				.numero("800")
				.build();

		Telefone telefone = Telefone.builder()
				.tipo("Celular")
				.ddd("11")
				.numero("999959630")
				.isEnable(true)
				.build();
		telefones.add(telefone);

		telefone = Telefone.builder()
				.tipo("Fixo")
				.ddd("11")
				.numero("36284141")
				.isEnable(true)
				.build();
		telefones.add(telefone);

		Contato contato = Contato.builder()
				.tipo("Pessoal")
				.telefones(telefones)
				.email("rafaela.silva@outlook.com")
				.build();

		Pessoa pessoa = Pessoa.builder()
				.nome("Rafaela Silva")
				.tipoPessoa(TipoPessoa.FISICA)
				.cpfOuCnpj("21175305839")
				.enderecos(Arrays.asList(endereco))
				.contatos(Arrays.asList(contato))
				.build();

		Cargo cargo = createCargoIfNotFound("Atendente");

		Funcionario funcionario = Funcionario.builder()
				.pessoa(pessoa)
				.sexo("F")
				.empresa(empresa)
				.cargo(cargo)
				.isEnable(true)
				.build();

		funcionarioRepository.save(funcionario);

		createUsuarioIfNotFound("atendente001", "1234", regra, pessoa);

	}

	private Cargo createCargoIfNotFound(String nome) {

		Cargo cargo = cargoRepository.findByNome(nome);
		if (cargo == null) {
			cargo = cargoRepository.save(Cargo.builder()
					.nome(nome)
					.isEnable(true)
					.build());
		}

		return cargo;
	}

	private void createUsuarioIfNotFound(String username, String password, Regra regra,
			Pessoa pessoa) {

		Usuario usuario = usuarioRepository.findByUsername(username);

		if (usuario == null) {
			usuario = usuarioRepository.save(Usuario.builder()
					.username(username)
					.password(password)
					.regras(Arrays.asList(regra))
					.pessoa(pessoa)
					.isEnable(true)
					.build());
		}
		usuarioRepository.save(usuario);

	}

	private Privilegio createPrivilegeIfNotFound(String name) {

		Privilegio privilege = privilegioRepository.findByNome(name);
		if (privilege == null) {
			privilege = Privilegio.builder().nome(name).build();
			privilegioRepository.save(privilege);
		}
		return privilege;
	}

	private Regra createRoleIfNotFound(
			String name, Collection<Privilegio> privileges) {

		Regra role = regraRepository.findByNome(name);
		if (role == null) {
			role = Regra.builder().nome(name).privilegios(privileges).build();
			regraRepository.save(role);
		}
		return role;
	}
}
