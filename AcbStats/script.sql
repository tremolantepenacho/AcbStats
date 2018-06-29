
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
        minutos int4,
        perdidas int4,
        puntos int4,
        rebotes int4,
        rebotesDefensivos int4,
        rebotesOfensivos int4,
        robos int4,
        segundos int4,
        taponesContra int4,
        taponesFavor int4,
        temporada int4,
        valoracion int4,
        jugador varchar(255),
        partido varchar(255),
        primary key (Id)
    );

    create table TemporadaJugador (
        Id  serial not null,
        asistencias int4,
        asistenciasPorPartido float4,
        canastasDos int4,
        canastasDosPorPartido float4,
        canastasTres int4,
        canastasTresPorPartido float4,
        canastasUno int4,
        canastasUnoPorPartido float4,
        faltasContra int4,
        faltasContraPorPartido float4,
        faltasFavor int4,
        faltasFavorPorPartido float4,
        idJugador varchar(255),
        intentosDos int4,
        intentosDosPorPartido float4,
        intentosTres int4,
        intentosTresPorPartido float4,
        intentosUno int4,
        intentosUnoPorPartido float4,
        minutos int4,
        minutosPorPartido float4,
        partidos int4,
        perdidas int4,
        perdidasPorPartido float4,
        puntos int4,
        puntosPorPartido float4,
        rebotes int4,
        rebotesDefensivos int4,
        rebotesDefensivosPorPartido float4,
        rebotesOfensivos int4,
        rebotesOfensivosPorPartido float4,
        rebotesPorPartido float4,
        robos int4,
        robosPorPartido float4,
        segundos int4,
        segundosPorPartido float4,
        taponesContra int4,
        taponesContraPorPartido float4,
        taponesFavor int4,
        taponesFavorPorPartido float4,
        valoracion int4,
        valoracionPorPartido float4,
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
