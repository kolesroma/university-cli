create table `degree` (
    `id` int primary key auto_increment,
    `name` varchar(20) not null
);

create table `lector` (
    `id` int primary key auto_increment,
    `name` varchar(32) not null,
    `surname` varchar(32) not null,
    `age` int,
    `degree_id` int references `degree` (`id`),
    `salary` int not null
);

create table `department` (
    `id` int primary key auto_increment,
    `name` varchar(32) not null,
    `head_id` int references `lector` (`id`)
);

create table `lector_department` (
    `id` int primary key auto_increment,
    `lector_id` int references `lector` (`id`),
    `department_id` int references `department` (`id`)
);