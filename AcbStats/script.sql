
    drop table if exists Jugador cascade;

    create table Jugador (
        Id varchar(255) not null,
        altura float8,
        fechaNacimiento timestamp,
        lugarNacimiento varchar(255),
        nacionalidad varchar(255),
        nombre varchar(255),
        pasaporte int4,
        posicion int4,
        primary key (Id)
    );
