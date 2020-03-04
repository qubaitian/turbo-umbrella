create table code
(
    id   bigint auto_increment,
    type varchar(255) null,
    dr   int          null,
    constraint code_pk
        primary key (id)
);