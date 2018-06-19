
    alter table PartidoJugador 
        drop constraint FK193B86C1194680B9;

    alter table PartidoJugador 
        drop constraint FK193B86C15116DCF7;

    alter table TemporadaJugador 
        drop constraint FK8EFC255B194680B9;

    drop table if exists Jugador cascade;

    drop table if exists Partido cascade;

    drop table if exists PartidoJugador cascade;

    drop table if exists TemporadaJugador cascade;

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
        Id varchar(255) not null,
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
        canastasDos int4,
        canastasTres int4,
        canastasUno int4,
        faltasContra int4,
        faltasFavor int4,
        idJugador varchar(255),
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
        partido varchar(255),
        primary key (Id)
    );

    create table TemporadaJugador (
        Id  serial not null,
        asistencias int4,
        asistenciasPorPartido float8,
        canastasDos int4,
        canastasDosPorPartido float8,
        canastasTres int4,
        canastasTresPorPartido float8,
        canastasUno int4,
        canastasUnoPorPartido float8,
        faltasContra int4,
        faltasContraPorPartido float8,
        faltasFavor int4,
        faltasFavorPorPartido float8,
        idJugador varchar(255),
        intentosDos int4,
        intentosDosPorPartido float8,
        intentosTres int4,
        intentosTresPorPartido float8,
        intentosUno int4,
        intentosUnoPorPartido float8,
        minutos timestamp,
        minutosPorPartido float8,
        partidos int4,
        perdidas int4,
        perdidasPorPartido float8,
        puntos int4,
        puntosPorPartido float8,
        rebotes int4,
        rebotesDefensivos int4,
        rebotesDefensivosPorPartido float8,
        rebotesOfensivos int4,
        rebotesOfensivosPorPartido float8,
        rebotesPorPartido float8,
        robos int4,
        robosPorPartido float8,
        taponesContra int4,
        taponesContraPorPartido float8,
        taponesFavor int4,
        taponesFavorPorPartido float8,
        valoracion int4,
        valoracionPorPartido float8,
        jugador varchar(255),
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

    alter table TemporadaJugador 
        add constraint FK8EFC255B194680B9 
        foreign key (jugador) 
        references Jugador;
