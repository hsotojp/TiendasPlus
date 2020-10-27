create table public.producto
(
    idproducto  serial not null
        constraint producto_pkey
            primary key,
    nombre      varchar(50),
    descripcion varchar(100),
    precio      numeric(10, 2)
);

alter table public.producto
    owner to postgres;

create table public.tienda
(
    idtienda  serial not null
        constraint tienda_pkey
            primary key,
    nombre    varchar(50),
    direccion varchar(50),
    telefono  varchar(10)
);

alter table public.tienda
    owner to postgres;

create table public.empleado
(
    idempleado  serial  not null
        constraint empleado_pkey
            primary key,
    nombre      varchar(50),
    apellido    varchar(50),
    idtienda    integer not null,
    usuario     varchar(15),
    contrasenia varchar(15)
);

alter table public.empleado
    owner to postgres;

create table public.ingreso
(
    idingreso  serial  not null
        constraint ingreso_pkey
            primary key,
    fecha      date,
    cantidad   integer,
    idproducto integer not null,
    idempleado integer not null
);

alter table public.ingreso
    owner to postgres;

create table public.inventario
(
    idregistro serial  not null
        constraint inventario_pkey
            primary key,
    cantidad   integer,
    idproducto integer not null,
    idtienda   integer not null
);

alter table public.inventario
    owner to postgres;

create table public.cliente
(
    idcliente serial not null
        constraint cliente_pkey
            primary key,
    nit       varchar(15),
    nombre    varchar(50)
);

alter table public.cliente
    owner to postgres;

create table public.receta
(
    idreceta    serial not null
        constraint receta_pkey
            primary key,
    nombre      varchar(15),
    descripcion varchar(50),
    precio      numeric(10, 2)
);

alter table public.receta
    owner to postgres;

create table public.detalle_receta
(
    idregistro serial not null
        constraint detalle_receta_pkey
            primary key,
    idreceta   integer,
    idproducto integer,
    cantidad   integer
);

alter table public.detalle_receta
    owner to postgres;

create table public.venta
(
    idventa   serial not null
        constraint venta_pkey
            primary key,
    fecha     date,
    total     numeric(10, 2),
    idcliente integer,
    idtienda  integer
);

alter table public.venta
    owner to postgres;

create table public.detalle_venta
(
    idregistro serial not null
        constraint detalle_venta_pkey
            primary key,
    idventa    integer,
    posicion   integer,
    cantidad   integer,
    idproducto integer,
    idreceta   integer,
    total      numeric(10, 2)
);

alter table public.detalle_venta
    owner to postgres;
