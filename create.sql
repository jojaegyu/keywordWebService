
    create table user (
       id bigint generated by default as identity,
        age integer not null,
        email varchar(255),
        gender TINYINT,
        name varchar(11),
        password varchar(20),
        phone_number varchar(11),
        primary key (id)
    );

    alter table user 
       add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);