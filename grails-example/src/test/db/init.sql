CREATE USER IF NOT EXISTS 'test'@'localhost'
  IDENTIFIED BY 'test';

create database if not exists development;

create database if not exists test;

create database if not exists production;