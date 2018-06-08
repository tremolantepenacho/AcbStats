
    alter table PartidoJugador 
        drop constraint FK193B86C1194680B9;

    alter table PartidoJugador 
        drop constraint FK193B86C15116DCF7;

    drop table if exists Jugador cascade;

    drop table if exists Partido cascade;

    drop table if exists PartidoJugador cascade;

    create table Jugador (
        Id varchar(255) not null unique,
        altura float8,
        fechaNacimiento timestamp,
        lugarNacimiento varchar(255),
        nacionalidad varchar(255),
        nombre varchar(255),
        pasaporte int4,
        posicion int4,
        primary key (Id)
    );

    create table Partido (
        Id  serial not null,
        fecha timestamp,
        hora time,
        jornada int4,
        local varchar(255),
        pabellon varchar(255),
        publico int4,
        puntosLocal int4,
        puntosVisitante int4,
        temporada int4,
        visitante varchar(255),
        primary key (Id)
    );

    create table PartidoJugador (
        Id  serial not null,
        asistencias int4,
        canastasDps int4,
        canastasTres int4,
        canastasUno int4,
        faltasContra int4,
        faltasFavor int4,
        idJugador varchar(255) unique,
        intentosDos int4,
        intentosTres int4,
        intentosUno int4,
        minutos timestamp,
        perdidas int4,
        puntos int4,
        rebotes int4,
        rebotesDefensivos int4,
        rebotesOfensivos int4,
        robos int4,
        taponesContra int4,
        taponesFavor int4,
        valoracion int4,
        jugador varchar(255),
        partido int4,
        primary key (Id)
    );

    alter table PartidoJugador 
        add constraint FK193B86C1194680B9 
        foreign key (jugador) 
        references Jugador;

    alter table PartidoJugador 
        add constraint FK193B86C15116DCF7 
        foreign key (partido) 
        references Partido;
