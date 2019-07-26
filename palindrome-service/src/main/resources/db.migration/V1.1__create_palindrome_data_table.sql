create database palindrome;

create table palindromedata
(
  id                integer                 not null
    constraint palindromedata_pkey
    primary key,
  payload           jsonb,
  created_timestamp varchar not null
);

create unique index palindromedata_id_uindex
  on palindromedata (id);

