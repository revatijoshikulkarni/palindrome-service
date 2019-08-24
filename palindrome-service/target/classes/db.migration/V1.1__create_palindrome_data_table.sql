create database palindrome;

create table palindromedata
(
  id                serial  not null
    constraint palindromedata_pkey
    primary key,
  payload           varchar,
  created_timestamp varchar not null
);

create unique index palindromedata_id_uindex
  on palindromedata (id);

create unique index palindromedata_id_uindex
  on palindromedata (id);

