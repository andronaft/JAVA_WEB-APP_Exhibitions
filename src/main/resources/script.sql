create table EXHIBIT
(
    ID      INTEGER default NEXT VALUE FOR "DBEX"."SYSTEM_SEQUENCE_388F7863_A091_434B_8FEF_ABF99563DBA9" auto_increment,
    NAME    CLOB,
    AUTHOR  CLOB,
    HALL_ID INTEGER not null,
    constraint EXHIBIT_PK
        primary key (ID)
);

create table HALL
(
    ID      INTEGER default NEXT VALUE FOR "DBEX"."SYSTEM_SEQUENCE_825327A3_98F2_4200_80F4_E3779C8587EE" auto_increment,
    NAME    CLOB not null,
    ADDRESS CLOB not null,
    THEME   CLOB not null,
    constraint HALL_PK
        primary key (ID)
);

create table TRANSACTION
(
    ID      INTEGER default NEXT VALUE FOR "DBEX"."SYSTEM_SEQUENCE_2BE0256A_9539_4F9F_BF28_6953245DC1D8" auto_increment,
    USER_ID INTEGER  not null,
    HALL_ID INTEGER  not null,
    DATE    DATE(10) not null,
    COST    INTEGER  not null,
    constraint TRANSACTION_PK
        primary key (ID)
);

create table USER
(
    ID        INTEGER default NEXT VALUE FOR "DBEX"."SYSTEM_SEQUENCE_82E08260_F409_4851_99BE_6EA9E4FE85BB" auto_increment,
    FIRSTNAME CLOB     not null,
    LASTNAME  CLOB     not null,
    BIRTHDAY  DATE(10) not null,
    LOGIN     CLOB     not null,
    PASSWORD  CLOB     not null,
    ROLE      CLOB,
    constraint USER_PK
        primary key (ID)
);
