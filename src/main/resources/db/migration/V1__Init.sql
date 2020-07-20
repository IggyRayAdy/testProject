create table banner
(
    id          integer          not null auto_increment,
    content     varchar(255),
    deleted     bit              not null,
    name        varchar(255),
    price       double precision not null,
    category_id integer,
    primary key (id)
) engine = InnoDB;

create table category
(
    id         integer      not null auto_increment,
    is_deleted bit,
    name       varchar(255) not null,
    req_name   varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table request
(
    id         integer not null auto_increment,
    date       date,
    ip_address varchar(255),
    user_agetn varchar(255),
    banner_id  integer,
    primary key (id)
) engine = InnoDB;


alter table banner
    add constraint FK2evybotynuel3qb4r4tkqvjuh foreign key (category_id) references category (id);
alter table request
    add constraint FKrbdxvkl5bwuycjo82cq0nosl4 foreign key (banner_id) references banner (id);

