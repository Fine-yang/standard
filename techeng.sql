create table technology.TechEng
(
    NO                  varchar(255) not null
        primary key,
    Country             varchar(255) null,
    Industry            varchar(255) null,
    CleanTechnology     varchar(255) null,
    ProductionStage     varchar(255) null,
    TechnologyOverview  text         null,
    Effect              text         null,
    Fields              varchar(255) null,
    Highlights          varchar(255) null,
    TypicalApplications text         null,
    Cost                text         null,
    Stability           text         null,
    Innovation          text         null,
    Source              text         null
)charset = utf8;


