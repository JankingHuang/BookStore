create or replace table t_book
(
    book_id          bigint        not null
        primary key,
    book_name        varchar(50)   not null,
    book_name_pinyin varchar(50)   not null,
    book_category_id bigint        not null,
    book_author      varchar(256)  not null,
    book_price       float         not null,
    book_image       bigint        null,
    publishing       varchar(50)   not null,
    book_desc        varchar(1024) not null,
    book_state       int           not null,
    deploy_datetime  datetime      null,
    sales_volume     int           not null
);

create or replace table t_book_category
(
    book_category_id   bigint auto_increment
        primary key,
    book_category_name varchar(50) null
);

create or replace table t_doc
(
    id        bigint      not null
        primary key,
    file_name varchar(50) not null,
    mime      varchar(50) not null
);

create or replace table t_order
(
    order_id       bigint      not null
        primary key,
    user_id        bigint      not null,
    order_datetime datetime    not null,
    consignee      varchar(50) not null,
    phone          varchar(50) not null,
    postalcode     varchar(50) not null,
    address        varchar(50) not null,
    send_type      int         not null,
    send_datetime  datetime    null,
    order_price    decimal     not null,
    order_state    int         not null
);

create or replace table t_order_item
(
    order_item_id bigint not null
        primary key,
    order_id      bigint not null,
    book_id       int    not null,
    quantity      int    not null
);

create or replace table t_user
(
    user_id   bigint auto_increment
        primary key,
    user_name varchar(10)   not null,
    password  varchar(32)   not null,
    user_type int default 2 not null
)
    charset = utf8mb4;


