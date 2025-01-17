USE [master]
GO
/****** Object:  Database [MyGreatLove]    Script Date: 09/11/2020 12:48:08 ******/
CREATE DATABASE [MyGreatLove]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MyGreatLove', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\MyGreatLove.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'MyGreatLove_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\MyGreatLove_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [MyGreatLove] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MyGreatLove].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MyGreatLove] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MyGreatLove] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MyGreatLove] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MyGreatLove] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MyGreatLove] SET ARITHABORT OFF 
GO
ALTER DATABASE [MyGreatLove] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [MyGreatLove] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MyGreatLove] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MyGreatLove] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MyGreatLove] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MyGreatLove] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MyGreatLove] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MyGreatLove] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MyGreatLove] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MyGreatLove] SET  DISABLE_BROKER 
GO
ALTER DATABASE [MyGreatLove] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MyGreatLove] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MyGreatLove] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MyGreatLove] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MyGreatLove] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MyGreatLove] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MyGreatLove] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MyGreatLove] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [MyGreatLove] SET  MULTI_USER 
GO
ALTER DATABASE [MyGreatLove] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MyGreatLove] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MyGreatLove] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MyGreatLove] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [MyGreatLove] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [MyGreatLove] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [MyGreatLove] SET QUERY_STORE = OFF
GO
USE [MyGreatLove]
GO
/****** Object:  Table [dbo].[Articulos]    Script Date: 09/11/2020 12:48:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Articulos](
	[IdArticulo] [int] IDENTITY(1,1) NOT NULL,
	[Articulo] [varchar](50) NOT NULL,
	[Precio] [real] NOT NULL,
	[Cantidad] [int] NOT NULL,
	[IdTipoArticulo] [int] NOT NULL,
	[Estado] [bit] NOT NULL,
	[LinkImagen] [varchar](200) NULL,
	[Descripcion] [varchar](200) NULL,
	[Promocion] [bit] NULL,
 CONSTRAINT [PK_Articulos] PRIMARY KEY CLUSTERED 
(
	[IdArticulo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Conyugues]    Script Date: 09/11/2020 12:48:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Conyugues](
	[Dni] [int] NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[Apellido] [varchar](50) NOT NULL,
	[Estado] [int] NOT NULL,
	[IdPareja] [int] NULL,
 CONSTRAINT [PK_Conyugues] PRIMARY KEY CLUSTERED 
(
	[Dni] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cuentas]    Script Date: 09/11/2020 12:48:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cuentas](
	[IdCuenta] [int] IDENTITY(1,1) NOT NULL,
	[Usuario] [varchar](50) NOT NULL,
	[Clave] [varchar](50) NOT NULL,
	[Admin] [bit] NOT NULL,
	[Estado] [bit] NOT NULL,
 CONSTRAINT [PK_Cuentas] PRIMARY KEY CLUSTERED 
(
	[IdCuenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Depositos]    Script Date: 09/11/2020 12:48:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Depositos](
	[IdDepositos] [int] IDENTITY(500,1) NOT NULL,
	[IdPareja] [int] NOT NULL,
	[Monto] [int] NOT NULL,
	[Tarjeta] [varchar](20) NOT NULL,
	[Dni] [int] NOT NULL,
	[Fecha] [date] NOT NULL,
	[Invitado] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Depositos] PRIMARY KEY CLUSTERED 
(
	[IdDepositos] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DetalleOperaciones]    Script Date: 09/11/2020 12:48:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetalleOperaciones](
	[idDetalle] [int] IDENTITY(1,1) NOT NULL,
	[IdOperacion] [int] NOT NULL,
	[IdArticulo] [int] NOT NULL,
	[PrecioUnitario] [real] NULL,
	[Cantidad] [int] NOT NULL,
	[Monto] [real] NOT NULL,
 CONSTRAINT [PK_DetalleOperaciones] PRIMARY KEY CLUSTERED 
(
	[idDetalle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Operaciones]    Script Date: 09/11/2020 12:48:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Operaciones](
	[IdOperacion] [int] IDENTITY(1,1) NOT NULL,
	[IdPareja] [int] NOT NULL,
	[Fecha] [date] NOT NULL,
	[Cargado] [bit] NOT NULL,
 CONSTRAINT [PK_Operaciones_1] PRIMARY KEY CLUSTERED 
(
	[IdOperacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Parejas]    Script Date: 09/11/2020 12:48:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Parejas](
	[IdPareja] [int] IDENTITY(107,3) NOT NULL,
	[Monto] [real] NOT NULL,
	[Estado] [bit] NOT NULL,
	[IdCuenta] [int] NULL,
 CONSTRAINT [PK_Parejas] PRIMARY KEY CLUSTERED 
(
	[IdPareja] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Peticiones]    Script Date: 09/11/2020 12:48:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Peticiones](
	[idPeticion] [int] IDENTITY(107,3) NOT NULL,
	[idConyugue] [int] NOT NULL,
 CONSTRAINT [PK_Peticiones] PRIMARY KEY CLUSTERED 
(
	[idPeticion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TipoArticulos]    Script Date: 09/11/2020 12:48:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoArticulos](
	[IdTipoArticulo] [int] IDENTITY(1,1) NOT NULL,
	[Tipo] [varchar](50) NOT NULL,
 CONSTRAINT [PK_TipoArticulos] PRIMARY KEY CLUSTERED 
(
	[IdTipoArticulo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Articulos] ON 

INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (3, N'Lampara LED', 120, 52, 1, 1, N'https://d26lpennugtm8s.cloudfront.net/stores/313/470/products/a60_12w_calida1-de35400fcfa246767b15326341395934-1024-1024.jpg', N'Lampara LED de bajo consumo, ideal para ahorrar energia.', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (4, N'Coche de Bebe Individual Pirulitos', 4000, 15, 6, 1, N'https://d26lpennugtm8s.cloudfront.net/stores/597/843/products/687796-mla25710259346_062017-o-f832bd554b8103b4f115133089959387-640-0.jpg', N'Cochecito Paseo indivudual para bebes entre 6 meses a 2 aÃ??Ã?Â±os.', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (6, N'Bicicleta Fija Premium Stark', 3550, 9, 3, 1, N'https://casarosario.com.ar/wp-content/uploads/2020/04/BICI-312.jpg', N'Bicicleta Fija Premium ideal para hacer ejercicio en casa.', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (7, N'Televisor 40 Pulgadas Philips Smart TV', 35000, 21, 3, 1, N'https://i.blogs.es/dfbf50/philips/450_1000.jpg', N'Television 40 pulgadas Smart TV - Netflix - Youtube - PrimeVideo - Disney +', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (8, N'Sillon Nordico', 15000, 8, 1, 1, N'https://giftcollection.com.ar/3464-large_default/sillon-nordico-individual.jpg', N'Sillon Nordico Noruego, individual material extraido del cuero de Oso Pardo.', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (9, N'Lavarropa Dream', 24750, 27, 4, 1, N'https://drean.com.ar/images/next/galeria-10-drean-next.jpg', N'Lavarropa Dream multifuncio + Garantia 24 meses.', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (10, N'Heladera Gafa', 50000, 16, 4, 1, N'https://www.carrefour.com.ar/media/catalog/product/7/7/7791758118002_03.jpg', N'Heladera Gafa Metalico 12 meses de Garantia.', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (11, N'Microhondas Furious', 14000, 18, 4, 1, N'https://www.casasilvia.com/media/catalog/product/cache/1/image/650x/040ec09b1e35df139433887a97daa66f/m/g/mg28f3k3tas.jpg', N'Microhondas Forius 12 meses de Garatia', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (12, N'Macetas Elegant', 2500, 9, 2, 1, N'https://viveroislaverde.com/wp-content/uploads/2018/05/MCPR.jpg', N'Macetas Elegant JardinerÃ­a, Se vende por unidad.', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (13, N'Notebook DELL', 120000, 3, 5, 1, N'https://www.comeros.com.ar/wp-content/uploads/2020/05/DELL-14-LATITUDE-5400_2-29.jpg', N'Notebook Dell I7 9na 8gb 256sd', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (14, N'Cuna BEBE Rosa', 16000, 24, 6, 1, N'https://d26lpennugtm8s.cloudfront.net/stores/867/715/products/20191128_1823211-6759d7973fb67bf54015751280348354-640-0.jpg', N'Cuna Bebe Rosa hasta 3 aÃ±os. ', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (15, N'Ipad', 25000, 9, 3, 1, N'https://i.blogs.es/e1a472/que-ipad-comprar/450_1000.jpg', N'Ipad Pro Garantia 24 meses', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (16, N'Tijera de Podar', 1500, 44, 2, 1, N'https://d26lpennugtm8s.cloudfront.net/stores/001/127/623/products/tijera-podar-bahco-p138-221-1aa7db9e627740a09a15901164015669-640-0.png', N'Tijera de Podar Super Max ', 0)
INSERT [dbo].[Articulos] ([IdArticulo], [Articulo], [Precio], [Cantidad], [IdTipoArticulo], [Estado], [LinkImagen], [Descripcion], [Promocion]) VALUES (17, N'Monitor LED LG 21"', 18000, 15, 5, 1, N'https://www.lg.com/ar/images/monitores/md05871415/gallery/medium01.jpg', N'Monitor LED 21" LG 60fps Garantia 12 meses.', 0)
SET IDENTITY_INSERT [dbo].[Articulos] OFF
GO
INSERT [dbo].[Conyugues] ([Dni], [Nombre], [Apellido], [Estado], [IdPareja]) VALUES (5456456, N'Nina', N'Miranad', 1, 311)
INSERT [dbo].[Conyugues] ([Dni], [Nombre], [Apellido], [Estado], [IdPareja]) VALUES (6454587, N'Roberto', N'Bolanios', 1, 308)
INSERT [dbo].[Conyugues] ([Dni], [Nombre], [Apellido], [Estado], [IdPareja]) VALUES (7564564, N'Florinda', N'Meza', 1, 308)
INSERT [dbo].[Conyugues] ([Dni], [Nombre], [Apellido], [Estado], [IdPareja]) VALUES (15482525, N'Fabricio', N'Zamparo', 1, 320)
INSERT [dbo].[Conyugues] ([Dni], [Nombre], [Apellido], [Estado], [IdPareja]) VALUES (25156156, N'Rodrigo', N'Navarro', 1, 314)
INSERT [dbo].[Conyugues] ([Dni], [Nombre], [Apellido], [Estado], [IdPareja]) VALUES (26456456, N'Romina', N'Peralta', 1, 314)
INSERT [dbo].[Conyugues] ([Dni], [Nombre], [Apellido], [Estado], [IdPareja]) VALUES (34578965, N'Facundo', N'Roldan', 1, 305)
INSERT [dbo].[Conyugues] ([Dni], [Nombre], [Apellido], [Estado], [IdPareja]) VALUES (35454655, N'Valeria', N'Almada', 1, 317)
INSERT [dbo].[Conyugues] ([Dni], [Nombre], [Apellido], [Estado], [IdPareja]) VALUES (38444777, N'Valentina', N'Jerez', 1, 305)
INSERT [dbo].[Conyugues] ([Dni], [Nombre], [Apellido], [Estado], [IdPareja]) VALUES (42342342, N'Horacio', N'Gomez', 1, 317)
INSERT [dbo].[Conyugues] ([Dni], [Nombre], [Apellido], [Estado], [IdPareja]) VALUES (48465456, N'Donatto', N'Racciati', 1, 311)
INSERT [dbo].[Conyugues] ([Dni], [Nombre], [Apellido], [Estado], [IdPareja]) VALUES (54545614, N'Juan', N'Campos', 1, 320)
GO
SET IDENTITY_INSERT [dbo].[Cuentas] ON 

INSERT [dbo].[Cuentas] ([IdCuenta], [Usuario], [Clave], [Admin], [Estado]) VALUES (83, N'admin', N'admin', 1, 1)
INSERT [dbo].[Cuentas] ([IdCuenta], [Usuario], [Clave], [Admin], [Estado]) VALUES (84, N'valen', N'123456', 0, 1)
INSERT [dbo].[Cuentas] ([IdCuenta], [Usuario], [Clave], [Admin], [Estado]) VALUES (85, N'florinda', N'123456', 0, 1)
INSERT [dbo].[Cuentas] ([IdCuenta], [Usuario], [Clave], [Admin], [Estado]) VALUES (86, N'nina', N'123456', 0, 1)
INSERT [dbo].[Cuentas] ([IdCuenta], [Usuario], [Clave], [Admin], [Estado]) VALUES (87, N'rodri', N'123456', 0, 1)
INSERT [dbo].[Cuentas] ([IdCuenta], [Usuario], [Clave], [Admin], [Estado]) VALUES (88, N'vale', N'123456', 0, 1)
INSERT [dbo].[Cuentas] ([IdCuenta], [Usuario], [Clave], [Admin], [Estado]) VALUES (89, N'juana', N'123456', 0, 0)
SET IDENTITY_INSERT [dbo].[Cuentas] OFF
GO
SET IDENTITY_INSERT [dbo].[Depositos] ON 

INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (511, 305, 20000, N'56465456465', 6545645, CAST(N'2020-11-09' AS Date), N'Jose velez')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (512, 305, 15000, N'42343242', 22222222, CAST(N'2020-11-09' AS Date), N'Paulina Rubio')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (513, 305, 45000, N'56456456', 56165156, CAST(N'2020-11-09' AS Date), N'Perez Junior')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (514, 308, 85000, N'56456456456', 15615616, CAST(N'2020-11-09' AS Date), N'Facundo Roldan')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (515, 311, 25000, N'164156561561', 51561561, CAST(N'2020-11-09' AS Date), N'Carlos Gardel')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (516, 311, 15000, N'4564564564561', 9456654, CAST(N'2020-11-09' AS Date), N'Julio Sosa')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (517, 311, 23000, N'44645465156', 1561651, CAST(N'2020-11-09' AS Date), N'Jorge Arduh')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (518, 314, 15450, N'5156165165', 15616516, CAST(N'2020-11-09' AS Date), N'Facundo Roldan')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (519, 314, 12000, N'1515615616548945', 16156156, CAST(N'2020-11-09' AS Date), N'Valentina Jerez')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (520, 314, 15000, N'8946516515616511', 16515615, CAST(N'2020-11-09' AS Date), N'Sapito Rodriguez')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (521, 317, 45000, N'48465156156', 15615615, CAST(N'2020-11-09' AS Date), N'Jorge Zamparo')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (522, 317, 20000, N'8484651115423423', 51515615, CAST(N'2020-11-09' AS Date), N'Esteban Zoldano')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (523, 317, 130000, N'5435425235236234', 43432423, CAST(N'2020-11-09' AS Date), N'Felipe Colombo')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (524, 320, 40000, N'4354353543643643', 43543534, CAST(N'2020-11-09' AS Date), N'Facundo Gomes')
INSERT [dbo].[Depositos] ([IdDepositos], [IdPareja], [Monto], [Tarjeta], [Dni], [Fecha], [Invitado]) VALUES (525, 320, 150000, N'432432432523532', 42323423, CAST(N'2020-11-09' AS Date), N'Antonio Banderas')
SET IDENTITY_INSERT [dbo].[Depositos] OFF
GO
SET IDENTITY_INSERT [dbo].[DetalleOperaciones] ON 

INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (43, 36, 9, 24750, 1, 24750)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (44, 36, 8, 15000, 1, 15000)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (45, 36, 3, 120, 4, 480)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (46, 36, 6, 3550, 1, 3550)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (47, 37, 3, 120, 3, 360)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (48, 37, 4, 4000, 1, 4000)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (49, 37, 8, 15000, 2, 30000)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (50, 38, 10, 50000, 1, 50000)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (51, 39, 4, 4000, 1, 4000)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (52, 39, 3, 120, 2, 240)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (53, 40, 6, 3550, 2, 7100)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (54, 41, 9, 24750, 1, 24750)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (55, 42, 4, 4000, 2, 8000)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (56, 43, 6, 3550, 3, 10650)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (57, 44, 11, 14000, 1, 14000)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (58, 44, 12, 2500, 2, 5000)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (59, 44, 16, 1500, 1, 1500)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (60, 45, 11, 14000, 1, 14000)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (61, 46, 3, 120, 20, 2400)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (62, 47, 3, 120, 20, 2400)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (63, 48, 3, 120, 10, 1200)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (64, 49, 3, 120, 2, 240)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (65, 50, 3, 120, 20, 2400)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (66, 51, 3, 120, 8, 960)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (67, 52, 7, 35000, 1, 35000)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (68, 52, 4, 4000, 1, 4000)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (69, 53, 13, 120000, 1, 120000)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (70, 53, 9, 24750, 1, 24750)
INSERT [dbo].[DetalleOperaciones] ([idDetalle], [IdOperacion], [IdArticulo], [PrecioUnitario], [Cantidad], [Monto]) VALUES (71, 54, 12, 2500, 2, 5000)
SET IDENTITY_INSERT [dbo].[DetalleOperaciones] OFF
GO
SET IDENTITY_INSERT [dbo].[Operaciones] ON 

INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (36, 305, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (37, 308, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (38, 311, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (39, 311, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (40, 311, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (41, 314, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (42, 314, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (43, 314, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (44, 305, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (45, 305, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (46, 305, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (47, 305, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (48, 305, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (49, 305, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (50, 305, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (51, 305, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (52, 320, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (53, 320, CAST(N'2020-11-09' AS Date), 1)
INSERT [dbo].[Operaciones] ([IdOperacion], [IdPareja], [Fecha], [Cargado]) VALUES (54, 320, CAST(N'2020-11-09' AS Date), 1)
SET IDENTITY_INSERT [dbo].[Operaciones] OFF
GO
SET IDENTITY_INSERT [dbo].[Parejas] ON 

INSERT [dbo].[Parejas] ([IdPareja], [Monto], [Estado], [IdCuenta]) VALUES (305, 40, 1, 84)
INSERT [dbo].[Parejas] ([IdPareja], [Monto], [Estado], [IdCuenta]) VALUES (308, 50640, 1, 85)
INSERT [dbo].[Parejas] ([IdPareja], [Monto], [Estado], [IdCuenta]) VALUES (311, 1660, 1, 86)
INSERT [dbo].[Parejas] ([IdPareja], [Monto], [Estado], [IdCuenta]) VALUES (314, 10150, 1, 87)
INSERT [dbo].[Parejas] ([IdPareja], [Monto], [Estado], [IdCuenta]) VALUES (317, 195000, 1, 88)
INSERT [dbo].[Parejas] ([IdPareja], [Monto], [Estado], [IdCuenta]) VALUES (320, 1250, 1, 89)
SET IDENTITY_INSERT [dbo].[Parejas] OFF
GO
SET IDENTITY_INSERT [dbo].[TipoArticulos] ON 

INSERT [dbo].[TipoArticulos] ([IdTipoArticulo], [Tipo]) VALUES (1, N'Hogar')
INSERT [dbo].[TipoArticulos] ([IdTipoArticulo], [Tipo]) VALUES (2, N'Jardinería')
INSERT [dbo].[TipoArticulos] ([IdTipoArticulo], [Tipo]) VALUES (3, N'Tecnología')
INSERT [dbo].[TipoArticulos] ([IdTipoArticulo], [Tipo]) VALUES (4, N'Electrodoméstico')
INSERT [dbo].[TipoArticulos] ([IdTipoArticulo], [Tipo]) VALUES (5, N'Informatica')
INSERT [dbo].[TipoArticulos] ([IdTipoArticulo], [Tipo]) VALUES (6, N'Infantiles')
SET IDENTITY_INSERT [dbo].[TipoArticulos] OFF
GO
ALTER TABLE [dbo].[Articulos]  WITH CHECK ADD  CONSTRAINT [FK_Articulos_TipoArticulos] FOREIGN KEY([IdTipoArticulo])
REFERENCES [dbo].[TipoArticulos] ([IdTipoArticulo])
GO
ALTER TABLE [dbo].[Articulos] CHECK CONSTRAINT [FK_Articulos_TipoArticulos]
GO
ALTER TABLE [dbo].[Conyugues]  WITH CHECK ADD  CONSTRAINT [FK_Conyugues_Parejas] FOREIGN KEY([IdPareja])
REFERENCES [dbo].[Parejas] ([IdPareja])
GO
ALTER TABLE [dbo].[Conyugues] CHECK CONSTRAINT [FK_Conyugues_Parejas]
GO
ALTER TABLE [dbo].[Depositos]  WITH CHECK ADD  CONSTRAINT [FK_Depositos_Parejas] FOREIGN KEY([IdPareja])
REFERENCES [dbo].[Parejas] ([IdPareja])
GO
ALTER TABLE [dbo].[Depositos] CHECK CONSTRAINT [FK_Depositos_Parejas]
GO
ALTER TABLE [dbo].[DetalleOperaciones]  WITH CHECK ADD  CONSTRAINT [FK_DetalleOperaciones_Articulos] FOREIGN KEY([IdArticulo])
REFERENCES [dbo].[Articulos] ([IdArticulo])
GO
ALTER TABLE [dbo].[DetalleOperaciones] CHECK CONSTRAINT [FK_DetalleOperaciones_Articulos]
GO
ALTER TABLE [dbo].[DetalleOperaciones]  WITH CHECK ADD  CONSTRAINT [FK_DetalleOperaciones_Operaciones] FOREIGN KEY([IdOperacion])
REFERENCES [dbo].[Operaciones] ([IdOperacion])
GO
ALTER TABLE [dbo].[DetalleOperaciones] CHECK CONSTRAINT [FK_DetalleOperaciones_Operaciones]
GO
ALTER TABLE [dbo].[DetalleOperaciones]  WITH CHECK ADD  CONSTRAINT [FK_DetalleOperaciones_Operaciones1] FOREIGN KEY([IdOperacion])
REFERENCES [dbo].[Operaciones] ([IdOperacion])
GO
ALTER TABLE [dbo].[DetalleOperaciones] CHECK CONSTRAINT [FK_DetalleOperaciones_Operaciones1]
GO
ALTER TABLE [dbo].[Operaciones]  WITH CHECK ADD  CONSTRAINT [FK_Operaciones_Parejas] FOREIGN KEY([IdPareja])
REFERENCES [dbo].[Parejas] ([IdPareja])
GO
ALTER TABLE [dbo].[Operaciones] CHECK CONSTRAINT [FK_Operaciones_Parejas]
GO
ALTER TABLE [dbo].[Parejas]  WITH CHECK ADD  CONSTRAINT [FK_Parejas_Cuentas] FOREIGN KEY([IdCuenta])
REFERENCES [dbo].[Cuentas] ([IdCuenta])
GO
ALTER TABLE [dbo].[Parejas] CHECK CONSTRAINT [FK_Parejas_Cuentas]
GO
ALTER TABLE [dbo].[Peticiones]  WITH CHECK ADD  CONSTRAINT [FK_Peticiones_Conyugues] FOREIGN KEY([idConyugue])
REFERENCES [dbo].[Conyugues] ([Dni])
GO
ALTER TABLE [dbo].[Peticiones] CHECK CONSTRAINT [FK_Peticiones_Conyugues]
GO
/****** Object:  StoredProcedure [dbo].[sprDTOArticulos]    Script Date: 09/11/2020 12:48:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sprDTOArticulos]
AS
SELECT a.IdArticulo IdArticulo, a.Articulo as Articulo, ta.Tipo as Categoria, a.Precio as Precio, a.Cantidad as Cantidad,
a.Estado as Estado, a.LinkImagen as LinkImagen, a.Descripcion as Descripcion, a.Promocion as Promocion
FROM Articulos a
INNER JOIN TipoArticulos ta
ON a.IdTipoArticulo = ta.IdTipoArticulo
GO
/****** Object:  StoredProcedure [dbo].[unProcedure]    Script Date: 09/11/2020 12:48:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[unProcedure] as
	begin

	begin try
		begin transaction

		commit transaction
	end try
	begin catch
	end catch
end
GO
USE [master]
GO
ALTER DATABASE [MyGreatLove] SET  READ_WRITE 
GO
