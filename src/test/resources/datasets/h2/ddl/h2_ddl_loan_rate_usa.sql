create table loan_rate_usa
(
    UNIT_NAME  text     null,
    STAT_NAME  text     null,
    STAT_CODE  text     null,
    ITEM_CODE1 text     null,
    ITEM_CODE2 text     null,
    ITEM_CODE3 text     null,
    ITEM_NAME1 text     null,
    ITEM_NAME2 text     null,
    ITEM_NAME3 text     null,
    DATA_VALUE double   null,
    TIME       datetime not null
        primary key
);

create index loan_rate_usa_TIME_index
    on loan_rate_usa (TIME);

