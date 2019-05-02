CREATE TABLE funcionario(
nome varchar(40),
login varchar(20) unique,
senha varchar(20) unique,
nivel_acesso int,
cargo varchar(20),
id int auto_increment,
primary key(id)
);

create table cliente(
nome varchar(40),
telefone varchar(20),
cpf varchar(20) unique,
endereco varchar(30),
id int auto_increment,
primary key(id));

create table pizza(
nome varchar(30),
tamanho varchar(20),
valor decimal(10,2),
fatia decimal(10,2),
quant_fatias int,
id int auto_increment,
primary key(id));

create table tbl_sabores(
id_pi int not null,
sabor varchar(15),
foreign key(id_pi) references pizza(id) on delete cascade);

create table pedido(
id_cli int not null,
id_pi int not null,
status varchar(20),
id int auto_increment,
foreign key(id_cli) references cliente(id),
foreign key(id_pi) references pizza(id), 
primary key(id));