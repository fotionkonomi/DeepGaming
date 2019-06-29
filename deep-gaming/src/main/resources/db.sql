CREATE TABLE company (
	id_company int not null auto_increment,
    company_name varchar(50) not null,
    company_description text not null,
    hyperlink varchar(255) not null,
    UNIQUE(company_name),
    PRIMARY KEY(id_company)
);

CREATE TABLE ram_memory_technology(
	id_ram_memory_technology int not null auto_increment,
    ram_memory_technology_name varchar(50) not null,
    ram_memory_technology_description text not null,
    UNIQUE(ram_memory_technology_name),
    PRIMARY KEY(id_ram_memory_technology)    
);

CREATE TABLE gpu_memory_technology(
	id_gpu_memory_technology int not null auto_increment,
    gpu_memory_technology_name varchar(50) not null,
    gpu_memory_technology_description text not null,
    UNIQUE(gpu_memory_technology_name),
    PRIMARY KEY(id_gpu_memory_technology)
);

CREATE TABLE direct_x(
	id_direct_x int not null auto_increment,
    direct_x_type varchar(50) not null,
    direct_x_description text not null,
    UNIQUE(direct_x_type),
    PRIMARY KEY(id_direct_x)
);

CREATE TABLE gpu_slot(
	id_gpu_slot int not null auto_increment,
    gpu_slot_name varchar(50) not null,
    gpu_slot_description text not null,
	laptop_desktop boolean not null,
    UNIQUE(gpu_slot_name),
    PRIMARY KEY(id_gpu_slot)
);

CREATE TABLE cpu_family (
	id_cpu_family int not null auto_increment,
	cpu_family_name varchar(50) not null,
    cpu_family_description text not null,
    id_company int not null,
    UNIQUE(cpu_family_name),
    PRIMARY KEY(id_cpu_family),
	FOREIGN KEY(id_company) REFERENCES company(id_company)
);

CREATE TABLE gpu_family (
	id_gpu_family int not null auto_increment,
	gpu_family_name varchar(50) not null,
    gpu_family_description text not null,
    id_company int not null,
    UNIQUE(gpu_family_name),
    PRIMARY KEY(id_gpu_family),
	FOREIGN KEY(id_company) REFERENCES company(id_company)
);

CREATE TABLE cpu_architecture (
	id_cpu_architecture int not null auto_increment,
	cpu_architecture_name varchar(50) not null,
    cpu_architecture_description text not null,
    cpu_process_nm tinyint not null,
    id_company int not null,
    UNIQUE(cpu_architecture_name),
    PRIMARY KEY(id_cpu_architecture),
    FOREIGN KEY(id_company) REFERENCES company(id_company)
);

CREATE TABLE gpu_architecture (
	id_gpu_architecture int not null auto_increment,
    gpu_architecture_name varchar(50) not null,
    gpu_architecture_description text not null,
    gpu_process_nm tinyint not null,
    id_company int not null,
    UNIQUE(gpu_architecture_name),
    PRIMARY KEY(id_gpu_architecture),
    FOREIGN KEY(id_company) REFERENCES company(id_company)
);

CREATE TABLE cpu_socket (
	id_cpu_socket int not null auto_increment,
    socket_name varchar(50) not null,
    socket_description text not null,
    id_company int not null,
    laptop_desktop boolean not null,
    UNIQUE(socket_name),
    PRIMARY KEY(id_cpu_socket),
    FOREIGN KEY(id_company) REFERENCES company(id_company)
);

CREATE TABLE chipset (
	id_chipset int not null auto_increment,
    chipset_name varchar(50) not null,
    chipset_description text not null,
    id_company int not null,
    UNIQUE(chipset_name),
    PRIMARY KEY(id_chipset),
    FOREIGN KEY(id_company) REFERENCES company(id_company)
);

CREATE TABLE user (
	id_user int not null auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(320) not null, #64 para @, 255 ne fushen e domainit = 320
    user_name varchar(50) not null,
    password varchar(255) not null,
    gender boolean, #mund te mos specifikohet
    age int not null,
    date_registered date not null,
    date_edited date not null,
    id_cpu int, #vendos cpu e kompjuterit te tij
    id_gpu int, #vendos gpu e kompjuterit te tij
    ram_size double(5,2), #vendos sasine e ram-it ne kompjuterin e tij
    UNIQUE(email),
    UNIQUE(user_name),
    PRIMARY KEY(id_user)
);

CREATE TABLE role (
	id_role int not null auto_increment,
    role_name varchar(50) not null,
    role_description text not null,
    UNIQUE(role_name),
    PRIMARY KEY(id_role)
);

CREATE TABLE user_role(
	id_user int not null,
    id_role int not null,
    PRIMARY KEY(id_user, id_role),
    FOREIGN KEY(id_user) REFERENCES user(id_user),
    FOREIGN KEY(id_role) REFERENCES role(id_role)
);

CREATE TABLE product (
	id_product int not null auto_increment,
    product_name varchar(100), #disa produkte mund ta kene emrin nga familja ose nga arkitekturat e tyre
    product_description text not null,
    release_date date not null,
    price int, #nuk perdor not null pasi mund te jene produkte jo per shitje
    quantity int, #nuk perdor not null pasi mund te jene produkte jo per shitje
    upload_date date not null,
    edited_date date not null,
    suggested_by int not null,
    approved_by int not null,
    hyperlink varchar(255) not null,
    PRIMARY KEY(id_product),
    FOREIGN KEY(suggested_by) REFERENCES user(id_user),
    FOREIGN KEY(approved_by) REFERENCES user(id_user)
);

CREATE TABLE cpu_benchmark_type (
	id_cpu_benchmark_type int not null auto_increment,
    cpu_benchmark_type_name varchar(50) not null,
    cpu_benchmark_type_description text not null,
    UNIQUE(cpu_benchmark_type_name),
    PRIMARY KEY(id_cpu_benchmark_type)
);


CREATE TABLE gpu(
	id_gpu int not null,
    tmu int not null,
    texture_rate int not null,
    rop int not null,
    pixel_rate int not null,
    shader_processing_units int not null,
    ray_tracing_cores int,
    tensor_cores int,
    driver_support double(3,2) not null,
    memory_size int not null,
    memory_speed int not null,
    memory_bus int not null,
    memory_bandwidth int not null,
    cache int not null,
    core_speed int not null,
    boost_clock int not null,
    tdp int not null,
    shader double(4,2) not null,
    open_gl double(4,2) not null,
    dedicated_integrated boolean not null,
    id_gpu_family int not null,
    id_gpu_architecture int not null,
    id_gpu_memory_technology int not null,
    id_direct_x int not null,
    id_gpu_slot int not null,
    id_cpu_recommended int,
    PRIMARY KEY(id_gpu),
    FOREIGN KEY(id_gpu) REFERENCES product(id_product),
    FOREIGN KEY(id_gpu_family) REFERENCES gpu_family(id_gpu_family),
    FOREIGN KEY(id_gpu_architecture) REFERENCES gpu_architecture(id_gpu_architecture),
    FOREIGN KEY(id_gpu_memory_technology) REFERENCES gpu_memory_technology(id_gpu_memory_technology),
    FOREIGN KEY(id_direct_x) REFERENCES direct_x(id_direct_x),
    FOREIGN KEY(id_gpu_slot) REFERENCES gpu_slot(id_gpu_slot)
);

CREATE TABLE cpu(
	id_cpu int not null,
    cpu_speed double(4,2) not null,
    turbo_speed double(4,2) not null,
    physical_cores tinyint not null,
    threads tinyint not null,
    tdp int not null,
    bit_width int not null,
    l1_cache int not null,
    l2_cache int not null,
    l3_cache int not null,
	id_cpu_family int not null,
	id_cpu_socket int not null,
    id_cpu_architecture int not null,
    id_integrated_gpu int,
    PRIMARY KEY(id_cpu),
    FOREIGN KEY(id_cpu) REFERENCES product(id_product),
    FOREIGN KEY(id_cpu_family) REFERENCES cpu_family(id_cpu_family),
    FOREIGN KEY(id_cpu_architecture) REFERENCES cpu_architecture(id_cpu_architecture),
    FOREIGN KEY(id_cpu_socket) REFERENCES cpu_socket(id_cpu_socket),
    FOREIGN KEY(id_integrated_gpu) REFERENCES gpu(id_gpu)
);

CREATE TABLE cpu_chipset (
	id_cpu int not null,
    id_chipset int not null,
    PRIMARY KEY(id_cpu, id_chipset),
    FOREIGN KEY(id_cpu) REFERENCES cpu(id_cpu),
    FOREIGN KEY(id_chipset) REFERENCES chipset(id_chipset)
);

CREATE TABLE cpu_benchmark(
	id_cpu_benchmark int not null auto_increment,
    value int not null,
    id_cpu int not null,
    id_cpu_benchmark_type int not null,
    PRIMARY KEY(id_cpu_benchmark),
    FOREIGN KEY(id_cpu) REFERENCES cpu(id_cpu),
    FOREIGN KEY(id_cpu_benchmark_type) REFERENCES cpu_benchmark_type(id_cpu_benchmark_type)
    
);

CREATE TABLE gpu_benchmark_type (
	id_gpu_benchmark_type int not null auto_increment,
    gpu_benchmark_type_name varchar(50) not null,
    gpu_benchmark_type_description text not null,
    UNIQUE(gpu_benchmark_type_name),
    PRIMARY KEY(id_gpu_benchmark_type)
);

CREATE TABLE gpu_benchmark (
	id_gpu_benchmark int not null auto_increment,
    value int not null,
    id_gpu int not null,
    id_gpu_benchmark_type int not null,
    PRIMARY KEY(id_gpu_benchmark),
    FOREIGN KEY(id_gpu) REFERENCES gpu(id_gpu),
    FOREIGN KEY(id_gpu_benchmark_type) REFERENCES gpu_benchmark_type(id_gpu_benchmark_type)
);	

CREATE TABLE motherboard_form_factor (
	id_motherboard_form_factor int not null auto_increment,
    motherboard_form_factor_name varchar(50) not null,
    motherboard_form_factor_description text not null,
    UNIQUE(motherboard_form_factor_name),
    PRIMARY KEY(id_motherboard_form_factor)
);

CREATE TABLE motherboard (
	id_motherboard int not null,
	maximum_ram_capacity double(5,2) not null,
    maximum_ram_speed int not null,
    id_company int not null,
    id_cpu_socket int not null,
	id_chipset int not null,
    id_ram_memory_technology int not null,
    id_motherboard_form_factor int not null,
    PRIMARY KEY(id_motherboard),
    FOREIGN KEY(id_company) REFERENCES company(id_company),
    FOREIGN KEY(id_cpu_socket) REFERENCES cpu_socket(id_cpu_socket),
    FOREIGN KEY(id_chipset) REFERENCES chipset(id_chipset),
    FOREIGN KEY(id_ram_memory_technology) REFERENCES ram_memory_technology(id_ram_memory_technology),
    FOREIGN KEY(id_motherboard_form_factor) REFERENCES motherboard_form_factor(id_motherboard_form_factor),
    FOREIGN KEY(id_motherboard) REFERENCES product(id_product)
);

CREATE TABLE motherboard_gpu_slot (
	id_motherboard int not null,
    id_gpu_slot int not null,
    number_of_slots int not null,
    PRIMARY KEY(id_motherboard, id_gpu_slot),
    FOREIGN KEY(id_motherboard) REFERENCES motherboard(id_motherboard),
    FOREIGN KEY(id_gpu_slot) REFERENCES gpu_slot(id_gpu_slot)
);

CREATE TABLE storage_port (
	id_storage_port int not null auto_increment,
    name varchar(100) not null,
    description text not null,
    UNIQUE(name),
    PRIMARY KEY(id_storage_port)
);

CREATE TABLE motherboard_storage(
	id_motherboard int not null,
    id_storage_port int not null,
    number_of_ports int not null,
    PRIMARY KEY(id_motherboard, id_storage_port),
    FOREIGN KEY(id_motherboard) REFERENCES motherboard(id_motherboard),
    FOREIGN KEY(id_storage_port) REFERENCES storage_port(id_storage_port)
    
);

CREATE TABLE storage_type (
	id_storage_type int not null auto_increment,
    storage_type_name varchar(50) not null,
    storage_type_description text not null,
    PRIMARY KEY(id_storage_type)
);

CREATE TABLE power_supply (
	id_power_supply int not null,
    power_capacity int not null,
    id_company int not null,
    PRIMARY KEY(id_power_supply),
    FOREIGN KEY(id_company) REFERENCES company(id_company),
    FOREIGN KEY(id_power_supply) REFERENCES product(id_product)
);

CREATE TABLE storage (
	id_storage int not null,
    write_speed double(7,2) not null,
    read_speed double(7,2) not null,
    id_company int not null,
    id_storage_type int not null,
    id_storage_port int not null,
    PRIMARY KEY(id_storage),
    FOREIGN KEY(id_storage) REFERENCES product(id_product),
    FOREIGN KEY(id_company) REFERENCES company(id_company),
    FOREIGN KEY(id_storage_type) REFERENCES storage_type(id_storage_type),
	FOREIGN KEY(id_storage_port) REFERENCES storage_port(id_storage_port)
);

CREATE TABLE ram (
	id_ram int not null,
    capacity double(5,2) not null,
    frequency int not null,
    id_company int not null,
    id_ram_memory_technology int not null,
    PRIMARY KEY(id_ram),
    FOREIGN KEY(id_company) REFERENCES company(id_company),
    FOREIGN KEY(id_ram) REFERENCES product(id_product),
    FOREIGN KEY(id_ram_memory_technology) REFERENCES ram_memory_technology(id_ram_memory_technology)
    
);

CREATE TABLE operating_system_type (
	id_operating_system_type int not null auto_increment,
    operating_system_type_name varchar(30) not null,
    operating_system_type_description text not null,
    id_company int not null,
    UNIQUE(operating_system_type_name),
    PRIMARY KEY(id_operating_system_type),
    FOREIGN KEY(id_company) REFERENCES company(id_company)
);

CREATE TABLE operating_system (
	id_operating_system int not null auto_increment,
    os_name varchar(50) not null,
    os_description text not null,
    id_operating_system_type int not null,
    UNIQUE(os_name),
    PRIMARY KEY(id_operating_system),
    FOREIGN KEY(id_operating_system_type) REFERENCES operating_system_type(id_operating_system_type)
    
);

CREATE TABLE computer (
	id_computer int not null,
    #nese eshte laptop apo desktop merret vesh nga motherboardi
    id_cpu int not null,
    id_gpu int not null,
    id_motherboard int not null,
    id_ram int not null,
    id_company int not null,
    id_operating_system int not null,
    id_power_supply int not null,
    PRIMARY KEY(id_computer),
    FOREIGN KEY(id_computer) REFERENCES product(id_product),
    FOREIGN KEY(id_cpu) REFERENCES cpu(id_cpu),
    FOREIGN KEY(id_gpu) REFERENCES gpu(id_gpu),
    FOREIGN KEY(id_motherboard) REFERENCES motherboard(id_motherboard),
    FOREIGN KEY(id_ram) REFERENCES ram(id_ram),
    FOREIGN KEY(id_company) REFERENCES company(id_company),
    FOREIGN KEY(id_operating_system) REFERENCES operating_system(id_operating_system),
    FOREIGN KEY(id_power_supply) REFERENCES power_supply(id_power_supply)
);

CREATE TABLE computer_storage (
	id_computer int not null,
    id_storage int not null,
    PRIMARY KEY(id_computer, id_storage),
    FOREIGN KEY(id_computer) REFERENCES computer(id_computer),
    FOREIGN KEY(id_storage) REFERENCES storage(id_storage)
);

CREATE TABLE category_of_game (
	id_category int not null auto_increment,
    category_name varchar(50) not null,
    category_description text not null,
    UNIQUE(category_name),
    PRIMARY KEY(id_category)
);

CREATE TABLE game_franchise ( 
	id_game_franchise int not null auto_increment,
    game_franchise_name varchar(100) not null,
    game_franchise_description text not null,
    id_company int not null,
    UNIQUE(game_franchise_name),
    PRIMARY KEY(id_game_franchise),
    FOREIGN KEY(id_company) REFERENCES company(id_company)
);

CREATE TABLE esrb_ratings (
	id_esrb_rating int not null auto_increment,
    esrb_rating_name varchar(10) not null,
    esrb_rating_description text not null,
    UNIQUE(esrb_rating_name),
    PRIMARY KEY(id_esrb_rating)
);

CREATE TABLE game (
	id_game int not null,
    ram_low double(4,2) not null,
    ram_medium double(4,2) not null,
    ram_high double(5,2) not null,
    id_game_franchise int not null,
    id_cpu_low int not null,
    id_cpu_medium int not null,
    id_cpu_high int not null,
    id_gpu_low int not null,
    id_gpu_medium int not null,
    id_gpu_high int not null,
    id_direct_x_low int not null,
    id_esrb_rating int not null,
    PRIMARY KEY(id_game),
    FOREIGN KEY(id_game_franchise) REFERENCES game_franchise(id_game_franchise),
    FOREIGN KEY(id_cpu_low) REFERENCES cpu(id_cpu),
    FOREIGN KEY(id_cpu_medium) REFERENCES cpu(id_cpu),
    FOREIGN KEY(id_cpu_high) REFERENCES cpu(id_cpu),
    FOREIGN KEY(id_gpu_low) REFERENCES gpu(id_gpu),
    FOREIGN KEY(id_gpu_medium) REFERENCES gpu(id_gpu),
    FOREIGN KEY(id_gpu_high) REFERENCES gpu(id_gpu),
	FOREIGN KEY(id_direct_x_low) REFERENCES direct_x(id_direct_x),
    FOREIGN KEY(id_esrb_rating) REFERENCES esrb_ratings(id_esrb_rating),
    FOREIGN KEY(id_game) REFERENCES product(id_product)
);

CREATE TABLE game_category (
	id_game int not null,
    id_category int not null,
    PRIMARY KEY(id_game, id_category),
    FOREIGN KEY(id_game) REFERENCES game(id_game),
    FOREIGN KEY(id_category) REFERENCES category_of_game(id_category)
);


ALTER TABLE user add FOREIGN KEY(id_gpu) REFERENCES gpu(id_gpu);

ALTER TABLE user add FOREIGN KEY(id_cpu) REFERENCES cpu(id_cpu);

ALTER TABLE gpu add FOREIGN KEY(id_cpu_recommended) REFERENCES cpu(id_cpu);











