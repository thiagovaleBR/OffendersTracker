do $$begin
-- Criar tabela Lines com campos Id e Name
create table lines (
    id uuid not null,
    name varchar(30) not null,
    created_by varchar(30) not null,
    updated_by varchar(30) not null,
    created_at timestamp with time zone not null,
    updated_at timestamp with time zone not null,
    primary key (id)
);

-- Criar tabela para Areas
create table areas (
    id uuid not null,
    name varchar(30) not null,
    created_by varchar(30) not null,
    updated_by varchar(30) not null,
    created_at timestamp with time zone not null,
    updated_at timestamp with time zone not null,
    primary key (id)
);

-- Criar tabela de apontamentos

create table appointments (
    id uuid not null,
    date date not null,
    line_id uuid not null,
    offender_id uuid not null,
    start_time time not null,
    end_time time not null,
    description text not null,
    ticketId bigint,
    appointer varchar(30) not null,
    created_by varchar(30) not null,
    updated_by varchar(30) not null,
    created_at timestamp with time zone not null,
    updated_at timestamp with time zone not null,
    primary key (id),
    foreign key (line_id) references lines(id),
    foreign key (offender_id) references areas(id)
);
end$$;
