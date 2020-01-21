create schema filme_ator;
use filme_ator;

create table tb_filme(id integer primary key auto_increment , title varchar(50));
create table tb_ator(id integer primary key auto_increment, nome varchar(50));
create table tb_filme_ator(id_filme integer, id_ator integer, CONSTRAINT fk_filme FOREIGN KEY (id_filme) REFERENCES tb_filme (id), CONSTRAINT fk_ator FOREIGN KEY (id_ator) REFERENCES tb_ator (id),
CONSTRAINT pk_filme_ator PRIMARY KEY (id_filme, id_ator));

insert into tb_filme (title) value("Matrix");
insert into tb_filme (title) value("John Wick");
insert into tb_filme (title) value("John Wick 2");
insert into tb_filme (title) value("Lord of the Rings");

insert into tb_ator (nome) value("Keanu Reeves");
insert into tb_ator (nome) value("Carrie-Anne Moss");
insert into tb_ator (nome) value("Laurence Fishburne");

insert into tb_ator (nome) value("Halle Berry");
insert into tb_ator (nome) value("Ian McShane");

insert into tb_ator (nome) value("Ruby Rose");
insert into tb_ator (nome) value("Claudia Gerini");

insert into tb_ator (nome) value("Elijah Wood");
insert into tb_ator (nome) value("Orlando Bloom");
insert into tb_ator (nome) value("Ian McKellen");

insert into tb_filme_ator (id_ator,id_filme) value(1,1);
insert into tb_filme_ator (id_ator,id_filme) value(2,1);
insert into tb_filme_ator (id_ator,id_filme) value(3,1);

insert into tb_filme_ator (id_ator,id_filme) value(1,2);
insert into tb_filme_ator (id_ator,id_filme) value(4,2);
insert into tb_filme_ator (id_ator,id_filme) value(5,2);

insert into tb_filme_ator (id_ator,id_filme) value(1,3);
insert into tb_filme_ator (id_ator,id_filme) value(6,3);
insert into tb_filme_ator (id_ator,id_filme) value(7,3);

insert into tb_filme_ator (id_ator,id_filme) value(8,4);
insert into tb_filme_ator (id_ator,id_filme) value(9,4);
insert into tb_filme_ator (id_ator,id_filme) value(10,4);


select title from tb_filme_ator join tb_ator on tb_ator.id = tb_filme_ator.id_ator join tb_filme on tb_filme.id = tb_filme_ator.id_filme where tb_ator.nome = "Keanu Reeves";
