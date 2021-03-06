USE [master]
GO
/****** Object:  Database [pimdb]    Script Date: 05/06/2019 13:07:27 ******/
CREATE DATABASE [pimdb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'pimdb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\pimdb.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'pimdb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\pimdb_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [pimdb] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [pimdb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [pimdb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [pimdb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [pimdb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [pimdb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [pimdb] SET ARITHABORT OFF 
GO
ALTER DATABASE [pimdb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [pimdb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [pimdb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [pimdb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [pimdb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [pimdb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [pimdb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [pimdb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [pimdb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [pimdb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [pimdb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [pimdb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [pimdb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [pimdb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [pimdb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [pimdb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [pimdb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [pimdb] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [pimdb] SET  MULTI_USER 
GO
ALTER DATABASE [pimdb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [pimdb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [pimdb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [pimdb] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [pimdb] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [pimdb] SET QUERY_STORE = OFF
GO
USE [pimdb]
GO
/****** Object:  Table [dbo].[bairro]    Script Date: 05/06/2019 13:07:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bairro](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[nome] [varchar](255) NOT NULL,
	[cidade_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cargo]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cargo](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[is_enable] [bit] NOT NULL,
	[nome] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[categoria]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categoria](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[is_enable] [bit] NOT NULL,
	[nome] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cidade]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cidade](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[nome] [varchar](255) NOT NULL,
	[estado_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cliente]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cliente](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[is_enable] [bit] NOT NULL,
	[pessoa_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cnh]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cnh](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[categoria] [varchar](255) NULL,
	[numero] [varchar](255) NULL,
	[renova_em] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[contato]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[contato](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[email] [varchar](255) NULL,
	[tipo] [varchar](255) NULL,
	[pessoa_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_4ds5brlm0e7etaij4k5twocp4] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[contato_telefones]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[contato_telefones](
	[contato_id] [bigint] NOT NULL,
	[telefones_id] [bigint] NOT NULL,
 CONSTRAINT [UK_j7phcrt6msvkvyebefw79da1r] UNIQUE NONCLUSTERED 
(
	[telefones_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[convenio]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[convenio](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[is_enable] [bit] NOT NULL,
	[nome] [varchar](255) NOT NULL,
	[tipo_convenio] [varchar](255) NOT NULL,
	[empresa_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[empresa]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[empresa](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[inscricao_estadual] [varchar](255) NULL,
	[is_enable] [bit] NOT NULL,
	[pessoa_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[endereco]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[endereco](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[complemento] [varchar](255) NULL,
	[numero] [varchar](255) NULL,
	[logradouro_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[entrada_saida]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[entrada_saida](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[entrada_em] [datetime2](7) NOT NULL,
	[saida_em] [datetime2](7) NULL,
	[convenio_id] [bigint] NULL,
	[motorista_id] [bigint] NULL,
	[veiculo_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[estado]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[estado](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[nome] [varchar](255) NOT NULL,
	[sigla] [varchar](255) NOT NULL,
	[pais_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_pw4erk59cah8l9fqtecanxfu6] UNIQUE NONCLUSTERED 
(
	[sigla] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[fornecedor]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[fornecedor](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[is_enable] [bit] NOT NULL,
	[pessoa_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[funcionario]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[funcionario](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[is_enable] [bit] NOT NULL,
	[sexo] [varchar](255) NOT NULL,
	[cargo_id] [bigint] NULL,
	[empresa_id] [bigint] NULL,
	[pessoa_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[infracao]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[infracao](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[infracao_cometida_em] [date] NOT NULL,
	[observacao] [varchar](255) NULL,
	[veiculo_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[logradouro]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[logradouro](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[cep] [varchar](255) NOT NULL,
	[complemento] [varchar](255) NULL,
	[local] [varchar](255) NULL,
	[nome] [varchar](255) NOT NULL,
	[bairro_id] [bigint] NOT NULL,
	[tipo_logradouro_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[manutencao]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[manutencao](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[fim] [date] NULL,
	[inicio] [date] NULL,
	[tipo_manutencao_id] [bigint] NULL,
	[veiculo_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[marca]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[marca](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[is_enable] [bit] NOT NULL,
	[nome] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[marca_modelos]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[marca_modelos](
	[marca_id] [bigint] NOT NULL,
	[modelos_id] [bigint] NOT NULL,
 CONSTRAINT [UK_i9hfcd39aaor4ke6j8r0ct3yq] UNIQUE NONCLUSTERED 
(
	[modelos_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[modelo]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[modelo](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[is_enable] [bit] NOT NULL,
	[nome] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[motorista]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[motorista](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[is_enable] [bit] NULL,
	[cnh_id] [bigint] NOT NULL,
	[pessoa_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pais]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pais](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[nome] [varchar](255) NOT NULL,
	[sigla] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_7b0d28r9d2qha1wglpybggx68] UNIQUE NONCLUSTERED 
(
	[sigla] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pessoa]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pessoa](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[cpf_cnpj] [varchar](255) NOT NULL,
	[foto] [varchar](255) NULL,
	[nome] [varchar](50) NOT NULL,
	[tipo_pessoa] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_9vvdt95by5ct6u0k2fv3sk1nu] UNIQUE NONCLUSTERED 
(
	[cpf_cnpj] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pessoas_enderecos]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pessoas_enderecos](
	[pessoa_id] [bigint] NOT NULL,
	[endereco_id] [bigint] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[privilegio]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[privilegio](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[nome] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[regra]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[regra](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[nome] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[regras_privilegios]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[regras_privilegios](
	[regra_id] [bigint] NOT NULL,
	[privilegio_id] [bigint] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[reserva]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reserva](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[entrega_em] [datetime2](7) NULL,
	[retira_em] [datetime2](7) NOT NULL,
	[funcionario_id] [bigint] NULL,
	[motorista_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sinistro]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sinistro](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[data_hora] [date] NOT NULL,
	[descricao] [varchar](255) NOT NULL,
	[veiculo_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[telefone]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[telefone](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[ddd] [varchar](255) NOT NULL,
	[is_enable] [bit] NOT NULL,
	[numero] [varchar](255) NOT NULL,
	[tipo] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tipo_combustivel]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tipo_combustivel](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[is_enable] [bit] NOT NULL,
	[nome] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tipo_logradouro]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tipo_logradouro](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[nome] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tipo_manutencao]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tipo_manutencao](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[is_enable] [varchar](255) NOT NULL,
	[nome] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[usuario]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[usuario](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[is_enable] [bit] NOT NULL,
	[password] [varchar](255) NOT NULL,
	[username] [varchar](255) NOT NULL,
	[pessoa_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_863n1y3x0jalatoir4325ehal] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[usuarios_regras]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[usuarios_regras](
	[usuario_id] [bigint] NOT NULL,
	[regra_id] [bigint] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[veiculo]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[veiculo](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[ano_fabricacao] [int] NOT NULL,
	[ano_modelo] [int] NOT NULL,
	[chassi] [varchar](255) NOT NULL,
	[cor] [varchar](255) NOT NULL,
	[is_enable] [bit] NOT NULL,
	[km_atual] [numeric](19, 2) NOT NULL,
	[km_inicial] [numeric](19, 2) NOT NULL,
	[mes_ipva] [int] NOT NULL,
	[placa] [varchar](255) NOT NULL,
	[pneu_trocado_em] [date] NULL,
	[renavam] [varchar](255) NOT NULL,
	[valor_pago] [numeric](19, 2) NOT NULL,
	[categoria_id] [bigint] NOT NULL,
	[marca_id] [bigint] NOT NULL,
	[tipo_combustivel_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[viagem]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[viagem](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[version] [bigint] NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_by] [varchar](255) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[destino] [varchar](255) NOT NULL,
	[origem] [varchar](255) NOT NULL,
	[viagem_realizada_em] [date] NULL,
	[motorista_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[viagem_funcionarios]    Script Date: 05/06/2019 13:07:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[viagem_funcionarios](
	[viagem_id] [bigint] NOT NULL,
	[funcionarios_id] [bigint] NOT NULL,
 CONSTRAINT [UK_bqfxxnjrp15y6pyukvo5aswe1] UNIQUE NONCLUSTERED 
(
	[funcionarios_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[bairro]  WITH CHECK ADD  CONSTRAINT [FKgmx8his7a51210gcsaunulx8b] FOREIGN KEY([cidade_id])
REFERENCES [dbo].[cidade] ([id])
GO
ALTER TABLE [dbo].[bairro] CHECK CONSTRAINT [FKgmx8his7a51210gcsaunulx8b]
GO
ALTER TABLE [dbo].[cidade]  WITH CHECK ADD  CONSTRAINT [FKkworrwk40xj58kevvh3evi500] FOREIGN KEY([estado_id])
REFERENCES [dbo].[estado] ([id])
GO
ALTER TABLE [dbo].[cidade] CHECK CONSTRAINT [FKkworrwk40xj58kevvh3evi500]
GO
ALTER TABLE [dbo].[cliente]  WITH CHECK ADD  CONSTRAINT [FKje7d3c1jdkexkpnkmx3894wfi] FOREIGN KEY([pessoa_id])
REFERENCES [dbo].[pessoa] ([id])
GO
ALTER TABLE [dbo].[cliente] CHECK CONSTRAINT [FKje7d3c1jdkexkpnkmx3894wfi]
GO
ALTER TABLE [dbo].[contato]  WITH CHECK ADD  CONSTRAINT [FKqcaicb387g3yd3xfy44qravfh] FOREIGN KEY([pessoa_id])
REFERENCES [dbo].[pessoa] ([id])
GO
ALTER TABLE [dbo].[contato] CHECK CONSTRAINT [FKqcaicb387g3yd3xfy44qravfh]
GO
ALTER TABLE [dbo].[contato_telefones]  WITH CHECK ADD  CONSTRAINT [FK1ug2r297aet87vmd1ic1isj5l] FOREIGN KEY([contato_id])
REFERENCES [dbo].[contato] ([id])
GO
ALTER TABLE [dbo].[contato_telefones] CHECK CONSTRAINT [FK1ug2r297aet87vmd1ic1isj5l]
GO
ALTER TABLE [dbo].[contato_telefones]  WITH CHECK ADD  CONSTRAINT [FKegjfynpsw60vop25503cnuh3w] FOREIGN KEY([telefones_id])
REFERENCES [dbo].[telefone] ([id])
GO
ALTER TABLE [dbo].[contato_telefones] CHECK CONSTRAINT [FKegjfynpsw60vop25503cnuh3w]
GO
ALTER TABLE [dbo].[convenio]  WITH CHECK ADD  CONSTRAINT [FK32m6iphftb1wham5cj5p2b2j7] FOREIGN KEY([empresa_id])
REFERENCES [dbo].[empresa] ([id])
GO
ALTER TABLE [dbo].[convenio] CHECK CONSTRAINT [FK32m6iphftb1wham5cj5p2b2j7]
GO
ALTER TABLE [dbo].[empresa]  WITH CHECK ADD  CONSTRAINT [FK9kgqkm56i6kqj7hwhnb2ec6l4] FOREIGN KEY([pessoa_id])
REFERENCES [dbo].[pessoa] ([id])
GO
ALTER TABLE [dbo].[empresa] CHECK CONSTRAINT [FK9kgqkm56i6kqj7hwhnb2ec6l4]
GO
ALTER TABLE [dbo].[endereco]  WITH CHECK ADD  CONSTRAINT [FKfqhmmh8wqua4ly9mbrat8tnnq] FOREIGN KEY([logradouro_id])
REFERENCES [dbo].[logradouro] ([id])
GO
ALTER TABLE [dbo].[endereco] CHECK CONSTRAINT [FKfqhmmh8wqua4ly9mbrat8tnnq]
GO
ALTER TABLE [dbo].[entrada_saida]  WITH CHECK ADD  CONSTRAINT [FK91qc5804ry7m7g9etx79g395h] FOREIGN KEY([convenio_id])
REFERENCES [dbo].[convenio] ([id])
GO
ALTER TABLE [dbo].[entrada_saida] CHECK CONSTRAINT [FK91qc5804ry7m7g9etx79g395h]
GO
ALTER TABLE [dbo].[entrada_saida]  WITH CHECK ADD  CONSTRAINT [FKmr93swu188qjwmmq5d77ax830] FOREIGN KEY([motorista_id])
REFERENCES [dbo].[motorista] ([id])
GO
ALTER TABLE [dbo].[entrada_saida] CHECK CONSTRAINT [FKmr93swu188qjwmmq5d77ax830]
GO
ALTER TABLE [dbo].[entrada_saida]  WITH CHECK ADD  CONSTRAINT [FKr0u8cuc7x2pbe13eh3gd87cs9] FOREIGN KEY([veiculo_id])
REFERENCES [dbo].[veiculo] ([id])
GO
ALTER TABLE [dbo].[entrada_saida] CHECK CONSTRAINT [FKr0u8cuc7x2pbe13eh3gd87cs9]
GO
ALTER TABLE [dbo].[estado]  WITH CHECK ADD  CONSTRAINT [FKlsmaqvrvjo414pa0u6kiusg5] FOREIGN KEY([pais_id])
REFERENCES [dbo].[pais] ([id])
GO
ALTER TABLE [dbo].[estado] CHECK CONSTRAINT [FKlsmaqvrvjo414pa0u6kiusg5]
GO
ALTER TABLE [dbo].[fornecedor]  WITH CHECK ADD  CONSTRAINT [FK3oondxq9yqmgchrb4rb4vt3c] FOREIGN KEY([pessoa_id])
REFERENCES [dbo].[pessoa] ([id])
GO
ALTER TABLE [dbo].[fornecedor] CHECK CONSTRAINT [FK3oondxq9yqmgchrb4rb4vt3c]
GO
ALTER TABLE [dbo].[funcionario]  WITH CHECK ADD  CONSTRAINT [FK11oirr3bht1opfypgfsb1o3i6] FOREIGN KEY([pessoa_id])
REFERENCES [dbo].[pessoa] ([id])
GO
ALTER TABLE [dbo].[funcionario] CHECK CONSTRAINT [FK11oirr3bht1opfypgfsb1o3i6]
GO
ALTER TABLE [dbo].[funcionario]  WITH CHECK ADD  CONSTRAINT [FK1mmiur94efkujcsaab0cdgskv] FOREIGN KEY([cargo_id])
REFERENCES [dbo].[cargo] ([id])
GO
ALTER TABLE [dbo].[funcionario] CHECK CONSTRAINT [FK1mmiur94efkujcsaab0cdgskv]
GO
ALTER TABLE [dbo].[funcionario]  WITH CHECK ADD  CONSTRAINT [FK4cm1kg523jlopyexjbmi6y54j] FOREIGN KEY([empresa_id])
REFERENCES [dbo].[empresa] ([id])
GO
ALTER TABLE [dbo].[funcionario] CHECK CONSTRAINT [FK4cm1kg523jlopyexjbmi6y54j]
GO
ALTER TABLE [dbo].[infracao]  WITH CHECK ADD  CONSTRAINT [FKbn42pyemnkf0r0p5w61oevjvq] FOREIGN KEY([veiculo_id])
REFERENCES [dbo].[veiculo] ([id])
GO
ALTER TABLE [dbo].[infracao] CHECK CONSTRAINT [FKbn42pyemnkf0r0p5w61oevjvq]
GO
ALTER TABLE [dbo].[logradouro]  WITH CHECK ADD  CONSTRAINT [FKpi29vkkbetxidw2ntnqrgsoce] FOREIGN KEY([tipo_logradouro_id])
REFERENCES [dbo].[tipo_logradouro] ([id])
GO
ALTER TABLE [dbo].[logradouro] CHECK CONSTRAINT [FKpi29vkkbetxidw2ntnqrgsoce]
GO
ALTER TABLE [dbo].[logradouro]  WITH CHECK ADD  CONSTRAINT [FKrmu3i6m96ut34bag821urktyg] FOREIGN KEY([bairro_id])
REFERENCES [dbo].[bairro] ([id])
GO
ALTER TABLE [dbo].[logradouro] CHECK CONSTRAINT [FKrmu3i6m96ut34bag821urktyg]
GO
ALTER TABLE [dbo].[manutencao]  WITH CHECK ADD  CONSTRAINT [FK2ewgu0wmj4odoger32uaxlqpi] FOREIGN KEY([tipo_manutencao_id])
REFERENCES [dbo].[tipo_manutencao] ([id])
GO
ALTER TABLE [dbo].[manutencao] CHECK CONSTRAINT [FK2ewgu0wmj4odoger32uaxlqpi]
GO
ALTER TABLE [dbo].[manutencao]  WITH CHECK ADD  CONSTRAINT [FKm7fav74sh3y93kr8tp2fb4ay1] FOREIGN KEY([veiculo_id])
REFERENCES [dbo].[veiculo] ([id])
GO
ALTER TABLE [dbo].[manutencao] CHECK CONSTRAINT [FKm7fav74sh3y93kr8tp2fb4ay1]
GO
ALTER TABLE [dbo].[marca_modelos]  WITH CHECK ADD  CONSTRAINT [FK7pep8g8m5cgq1d1lqtu78st5b] FOREIGN KEY([marca_id])
REFERENCES [dbo].[marca] ([id])
GO
ALTER TABLE [dbo].[marca_modelos] CHECK CONSTRAINT [FK7pep8g8m5cgq1d1lqtu78st5b]
GO
ALTER TABLE [dbo].[marca_modelos]  WITH CHECK ADD  CONSTRAINT [FKflj57cotyja1d789xy5y2e36q] FOREIGN KEY([modelos_id])
REFERENCES [dbo].[modelo] ([id])
GO
ALTER TABLE [dbo].[marca_modelos] CHECK CONSTRAINT [FKflj57cotyja1d789xy5y2e36q]
GO
ALTER TABLE [dbo].[motorista]  WITH CHECK ADD  CONSTRAINT [FKa62akdheeydyxtubrqhxfb4t5] FOREIGN KEY([pessoa_id])
REFERENCES [dbo].[pessoa] ([id])
GO
ALTER TABLE [dbo].[motorista] CHECK CONSTRAINT [FKa62akdheeydyxtubrqhxfb4t5]
GO
ALTER TABLE [dbo].[motorista]  WITH CHECK ADD  CONSTRAINT [FKc60nbk8rl64cjkblunny1sqhk] FOREIGN KEY([cnh_id])
REFERENCES [dbo].[cnh] ([id])
GO
ALTER TABLE [dbo].[motorista] CHECK CONSTRAINT [FKc60nbk8rl64cjkblunny1sqhk]
GO
ALTER TABLE [dbo].[pessoas_enderecos]  WITH CHECK ADD  CONSTRAINT [FK15059k2hlbinetbs0wyrgn4rh] FOREIGN KEY([endereco_id])
REFERENCES [dbo].[endereco] ([id])
GO
ALTER TABLE [dbo].[pessoas_enderecos] CHECK CONSTRAINT [FK15059k2hlbinetbs0wyrgn4rh]
GO
ALTER TABLE [dbo].[pessoas_enderecos]  WITH CHECK ADD  CONSTRAINT [FKnta2yuhmbo4nwvkyy9o2ggbiv] FOREIGN KEY([pessoa_id])
REFERENCES [dbo].[pessoa] ([id])
GO
ALTER TABLE [dbo].[pessoas_enderecos] CHECK CONSTRAINT [FKnta2yuhmbo4nwvkyy9o2ggbiv]
GO
ALTER TABLE [dbo].[regras_privilegios]  WITH CHECK ADD  CONSTRAINT [FKmvoduxpriu3288t78tj84njla] FOREIGN KEY([regra_id])
REFERENCES [dbo].[regra] ([id])
GO
ALTER TABLE [dbo].[regras_privilegios] CHECK CONSTRAINT [FKmvoduxpriu3288t78tj84njla]
GO
ALTER TABLE [dbo].[regras_privilegios]  WITH CHECK ADD  CONSTRAINT [FKpcil3vafv7lum5x3eg0see8eq] FOREIGN KEY([privilegio_id])
REFERENCES [dbo].[privilegio] ([id])
GO
ALTER TABLE [dbo].[regras_privilegios] CHECK CONSTRAINT [FKpcil3vafv7lum5x3eg0see8eq]
GO
ALTER TABLE [dbo].[reserva]  WITH CHECK ADD  CONSTRAINT [FK9bfa7otmqudoodqyk2a54xeh3] FOREIGN KEY([funcionario_id])
REFERENCES [dbo].[funcionario] ([id])
GO
ALTER TABLE [dbo].[reserva] CHECK CONSTRAINT [FK9bfa7otmqudoodqyk2a54xeh3]
GO
ALTER TABLE [dbo].[reserva]  WITH CHECK ADD  CONSTRAINT [FKf1j5eiuw06tjtkv0m0tud30nl] FOREIGN KEY([motorista_id])
REFERENCES [dbo].[motorista] ([id])
GO
ALTER TABLE [dbo].[reserva] CHECK CONSTRAINT [FKf1j5eiuw06tjtkv0m0tud30nl]
GO
ALTER TABLE [dbo].[sinistro]  WITH CHECK ADD  CONSTRAINT [FKjsh6i7iu10yetbedk18pqqsfe] FOREIGN KEY([veiculo_id])
REFERENCES [dbo].[veiculo] ([id])
GO
ALTER TABLE [dbo].[sinistro] CHECK CONSTRAINT [FKjsh6i7iu10yetbedk18pqqsfe]
GO
ALTER TABLE [dbo].[usuario]  WITH CHECK ADD  CONSTRAINT [FK9kjbckbnh9ryosephjpbojisa] FOREIGN KEY([pessoa_id])
REFERENCES [dbo].[pessoa] ([id])
GO
ALTER TABLE [dbo].[usuario] CHECK CONSTRAINT [FK9kjbckbnh9ryosephjpbojisa]
GO
ALTER TABLE [dbo].[usuarios_regras]  WITH CHECK ADD  CONSTRAINT [FKh147pt5ydv9s9wc4dhsweraq2] FOREIGN KEY([regra_id])
REFERENCES [dbo].[regra] ([id])
GO
ALTER TABLE [dbo].[usuarios_regras] CHECK CONSTRAINT [FKh147pt5ydv9s9wc4dhsweraq2]
GO
ALTER TABLE [dbo].[usuarios_regras]  WITH CHECK ADD  CONSTRAINT [FKjmxsksnxhynad4m28nyrtqs39] FOREIGN KEY([usuario_id])
REFERENCES [dbo].[usuario] ([id])
GO
ALTER TABLE [dbo].[usuarios_regras] CHECK CONSTRAINT [FKjmxsksnxhynad4m28nyrtqs39]
GO
ALTER TABLE [dbo].[veiculo]  WITH CHECK ADD  CONSTRAINT [FK4phy75rfo7q383d91ioqmwf1c] FOREIGN KEY([categoria_id])
REFERENCES [dbo].[categoria] ([id])
GO
ALTER TABLE [dbo].[veiculo] CHECK CONSTRAINT [FK4phy75rfo7q383d91ioqmwf1c]
GO
ALTER TABLE [dbo].[veiculo]  WITH CHECK ADD  CONSTRAINT [FK9g5yovckuf4squ6rf8vpxu809] FOREIGN KEY([marca_id])
REFERENCES [dbo].[marca] ([id])
GO
ALTER TABLE [dbo].[veiculo] CHECK CONSTRAINT [FK9g5yovckuf4squ6rf8vpxu809]
GO
ALTER TABLE [dbo].[veiculo]  WITH CHECK ADD  CONSTRAINT [FKk6dtgwuxbxu3o7ygkt7c5eu9f] FOREIGN KEY([tipo_combustivel_id])
REFERENCES [dbo].[tipo_combustivel] ([id])
GO
ALTER TABLE [dbo].[veiculo] CHECK CONSTRAINT [FKk6dtgwuxbxu3o7ygkt7c5eu9f]
GO
ALTER TABLE [dbo].[viagem]  WITH CHECK ADD  CONSTRAINT [FKk4vj43tm5w0b5v2b9xwl5h9x2] FOREIGN KEY([motorista_id])
REFERENCES [dbo].[motorista] ([id])
GO
ALTER TABLE [dbo].[viagem] CHECK CONSTRAINT [FKk4vj43tm5w0b5v2b9xwl5h9x2]
GO
ALTER TABLE [dbo].[viagem_funcionarios]  WITH CHECK ADD  CONSTRAINT [FKmilh3eykwmiil5hriqx5j9h06] FOREIGN KEY([viagem_id])
REFERENCES [dbo].[viagem] ([id])
GO
ALTER TABLE [dbo].[viagem_funcionarios] CHECK CONSTRAINT [FKmilh3eykwmiil5hriqx5j9h06]
GO
ALTER TABLE [dbo].[viagem_funcionarios]  WITH CHECK ADD  CONSTRAINT [FKpi0ymb68uyna1prjwhjb19ra2] FOREIGN KEY([funcionarios_id])
REFERENCES [dbo].[funcionario] ([id])
GO
ALTER TABLE [dbo].[viagem_funcionarios] CHECK CONSTRAINT [FKpi0ymb68uyna1prjwhjb19ra2]
GO
USE [master]
GO
ALTER DATABASE [pimdb] SET  READ_WRITE 
GO
