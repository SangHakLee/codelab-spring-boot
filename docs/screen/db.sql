create database codelab_db default character set utf8;

grant all privileges on codelab_db.* to codelab@localhost identified by 'codelab';

flush privileges;