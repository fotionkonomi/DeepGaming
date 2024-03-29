 create table cart (id_cart integer not null auto_increment, reserved integer not null, id_user integer not null, primary key (id_cart)) ;
 create table cart_item (id_cart_item integer not null auto_increment, quantity integer not null, id_cart integer not null, id_product integer not null, primary key (id_cart_item)) ;
 create table category_of_game (id_category integer not null auto_increment, category_description text not null, category_name varchar(50) not null, primary key (id_category)) ;
 create table company (id_company integer not null auto_increment, company_description text not null, company_name varchar(50) not null, hyperlink varchar(255) not null, primary key (id_company)); 
 create table cpu (bit_width integer not null, cpu_benchmark integer not null, cpu_speed double precision not null, l1_cache integer not null, l2_cache integer not null, l3_cache integer not null, physical_cores tinyint not null, tdp integer not null, threads tinyint not null, turbo_speed double precision not null, id_product integer not null, id_cpu_architecture integer not null, id_cpu_family integer not null, id_integrated_gpu integer, id_cpu_socket integer not null, primary key (id_product)) ;
 create table cpu_architecture (id_cpu_architecture integer not null auto_increment, cpu_architecture_description text not null, cpu_architecture_name varchar(50) not null, cpu_process_nm tinyint not null, id_company integer not null, primary key (id_cpu_architecture)) ;
 create table cpu_family (id_cpu_family integer not null auto_increment, cpu_family_description text not null, cpu_family_name varchar(50) not null, id_company integer not null, primary key (id_cpu_family)) ;
 create table cpu_socket (id_cpu_socket integer not null auto_increment, laptop_desktop bit not null, socket_description text not null, socket_name varchar(50) not null, id_company integer not null, primary key (id_cpu_socket)); 
 create table direct_x (id_direct_x integer not null auto_increment, direct_x_description text not null, direct_x_type varchar(50) not null, primary key (id_direct_x)) ;
 create table esrb_ratings (id_esrb_rating integer not null auto_increment, esrb_rating_description text not null, esrb_rating_name varchar(10) not null, primary key (id_esrb_rating)) ;
 create table game (ram_high double precision not null, ram_low double precision not null, ram_medium double precision not null, id_product integer not null, id_cpu_high integer not null, id_cpu_low integer not null, id_cpu_medium integer not null, id_direct_x_low integer not null, id_esrb_rating integer not null, id_gpu_high integer not null, id_gpu_low integer not null, id_gpu_medium integer not null, primary key (id_product)); 
 create table game_category (id_gane integer not null, id_category integer not null, primary key (id_gane, id_category)) ;
 create table gpu (boost_clock integer not null, cache integer not null, core_speed integer not null, driver_support double precision not null, gpu_benchmark integer not null, memory_bandwidth integer not null, memory_bus integer not null, memory_size integer not null, memory_speed integer not null, open_gl double precision not null, pixel_rate integer not null, ray_tracing_cores integer, rop integer not null, shader double precision not null, shader_processing_units integer not null, tdp integer not null, tensor_cores integer, texture_rate integer not null, tmu integer not null, id_product integer not null, id_gpu_architecture integer not null, id_cpu_recommended integer, id_gpu_family integer not null, id_gpu_slot integer not null, id_direct_x integer not null, id_gpu_memory_technology integer not null, primary key (id_product)) ;
 create table gpu_architecture (id_gpu_architecture integer not null auto_increment, gpu_architecture_description text not null, gpu_architecture_name varchar(50) not null, gpu_process_nm tinyint not null, id_company integer not null, primary key (id_gpu_architecture)) ;
 create table gpu_family (id_gpu_family integer not null auto_increment, gpu_family_description text not null, gpu_family_name varchar(50) not null, id_company integer not null, primary key (id_gpu_family)) ;
 create table gpu_memory_technology (id_gpu_memory_technology integer not null auto_increment, gpu_memory_technology_description text not null, gpu_memory_technology_name varchar(50) not null, primary key (id_gpu_memory_technology)) ;
 create table gpu_slot (id_gpu_slot integer not null auto_increment, gpu_slot_description text not null, gpu_slot_name varchar(50) not null, laptop_desktop bit not null, primary key (id_gpu_slot)) ;
 create table motherboard (maximum_ram_capacity double precision not null, maximum_ram_speed integer not null, id_product integer not null, id_company integer not null, id_cpu_socket integer not null, id_motherboard_form_factor integer not null, id_gpu_slot integer not null, primary key (id_product)) ;
 create table motherboard_form_factor (id_motherboard_form_factor integer not null auto_increment, motherboard_form_factor_description text not null, motherboard_form_factor_name varchar(50) not null, primary key (id_motherboard_form_factor)) ;
 create table product (id_product integer not null auto_increment, edited_date DATETIME not null, hyperlink varchar(255) not null, price integer, product_description text not null, product_name varchar(100) not null, quantity integer, release_date DATETIME not null, upload_date DATETIME not null, id_product_type integer not null, primary key (id_product)) ;
 create table product_type (id_product_type integer not null auto_increment, product_type varchar(30), primary key (id_product_type)) ;
 create table role (role_id integer not null auto_increment, role_description text not null, role_name varchar(50) not null, primary key (role_id)) ;
 create table user (id_user integer not null auto_increment, date_edited DATETIME not null, date_of_birth DATETIME not null, date_registered DATETIME not null, email varchar(320) not null, first_name varchar(50) not null, last_name varchar(50) not null, password varchar(255) not null, ram_size double precision, user_name varchar(50) not null, id_cpu integer, id_gpu integer, primary key (id_user)) ;
 create table user_role (id_user integer not null, id_role integer not null, primary key (id_user, id_role)) ;
 alter table category_of_game add constraint UK_1oj6ca8mrabbqaum5vmwqmllj  unique (category_name);
 alter table company add constraint UK_46jubpbtfae2gfb74a3x6qug7  unique (company_name);
 alter table cpu_architecture add constraint UK_1998vpvhi0f9hqt888ekr88yn  unique (cpu_architecture_name);
 alter table cpu_family add constraint UK_53asaiqtj76ytk7dg827ew0ir  unique (cpu_family_name);
 alter table cpu_socket add constraint UK_r13krv3f62x4qx9f17c7wy2nw  unique (socket_name);
 alter table direct_x add constraint UK_gpttmqwukrugmxvqyhopntp04  unique (direct_x_type);
 alter table esrb_ratings add constraint UK_53accc26aqrj19q2q9v343f3b  unique (esrb_rating_name);
 alter table gpu_architecture add constraint UK_eblvnnqkolkgu52qyy7bpwhuw  unique (gpu_architecture_name);
 alter table gpu_family add constraint UK_e0j76bi8vjlwyrqp3g6flfmtv  unique (gpu_family_name);
 alter table gpu_memory_technology add constraint UK_8mpcspexrkfqh2gwde4e1sw9h  unique (gpu_memory_technology_name);
 alter table gpu_slot add constraint UK_t3p3n1cs8i37mjh2wjiqns280  unique (gpu_slot_name);
 alter table motherboard_form_factor add constraint UK_e7rw2t5swphe1d7x29ujrghn4  unique (motherboard_form_factor_name);
 alter table role add constraint UK_iubw515ff0ugtm28p8g3myt0h  unique (role_name);
 alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe  unique (email);
 alter table user add constraint UK_lqjrcobrh9jc8wpcar64q1bfh  unique (user_name);
 alter table cart add constraint FK_fm4wld2k9rii4aa508ahl3652 foreign key (id_user) references user (id_user);
 alter table cart_item add constraint FK_m5426liqx5x97t8fugq1iu008 foreign key (id_cart) references cart (id_cart);
 alter table cart_item add constraint FK_qwol68q1ov8y88k7exsmrijgc foreign key (id_product) references product (id_product);
 alter table cpu add constraint FK_6wf7kpr6998l73hf176qpevou foreign key (id_cpu_architecture) references cpu_architecture (id_cpu_architecture);
 alter table cpu add constraint FK_o0fs9pn3x3dleuv610atb9j49 foreign key (id_cpu_family) references cpu_family (id_cpu_family);
 alter table cpu add constraint FK_c78ol9yki60mv0ool137f3hpl foreign key (id_integrated_gpu) references gpu (id_product);
 alter table cpu add constraint FK_dkro2dixl6j7i5fo3fke7oc64 foreign key (id_cpu_socket) references cpu_socket (id_cpu_socket);
 alter table cpu add constraint FK_p8jrh60mfprkvabx9srihk5lp foreign key (id_product) references product (id_product);
 alter table cpu_architecture add constraint FK_kqfv2hcp5dpthg8ntrlwh8ekm foreign key (id_company) references company (id_company);
 alter table cpu_family add constraint FK_1sqewupead6vrmijpsdc0kdli foreign key (id_company) references company (id_company);
 alter table cpu_socket add constraint FK_jndrtxowl5hvqh1e2i5txfbxn foreign key (id_company) references company (id_company);
 alter table game add constraint FK_8r1r7wk6pdp2rhhcgpom2tds0 foreign key (id_cpu_high) references cpu (id_product);
 alter table game add constraint FK_9h3e69row7ypv0e0u2llw3hyv foreign key (id_cpu_low) references cpu (id_product);
 alter table game add constraint FK_gdpw08mlv4x9ldj07jdp8s18y foreign key (id_cpu_medium) references cpu (id_product);
 alter table game add constraint FK_rk7x8v582cr39jdmsixmoo6dw foreign key (id_direct_x_low) references direct_x (id_direct_x);
 alter table game add constraint FK_3msq0a95e8rchwab2rddhr3px foreign key (id_esrb_rating) references esrb_ratings (id_esrb_rating);
 alter table game add constraint FK_50f2rld2d45tb8lyw50h6lwyx foreign key (id_gpu_high) references gpu (id_product);
 alter table game add constraint FK_4ft1vv75ygum59vnwayfkbsam foreign key (id_gpu_low) references gpu (id_product);
 alter table game add constraint FK_k2co2l0cgm3e445oqb66px7w1 foreign key (id_gpu_medium) references gpu (id_product);
 alter table game add constraint FK_jik2eofp6myse7r2b8h93itd3 foreign key (id_product) references product (id_product);
 alter table game_category add constraint FK_o1ehl9t1x134q007xrf5o1orq foreign key (id_category) references category_of_game (id_category);
 alter table game_category add constraint FK_jfl82u9qug2mb5ojwha0afemv foreign key (id_gane) references game (id_product);
 alter table gpu add constraint FK_ao2li7g8rtifrchwe0vbunmhl foreign key (id_gpu_architecture) references gpu_architecture (id_gpu_architecture);
 alter table gpu add constraint FK_swcdr2q8jvdwnjetfhuyuma1h foreign key (id_cpu_recommended) references cpu (id_product);
 alter table gpu add constraint FK_4b1ngk6r19grupf8uukui43sb foreign key (id_gpu_family) references gpu_family (id_gpu_family);
 alter table gpu add constraint FK_gndiwqmltr95qhxcjcrcpm7hs foreign key (id_gpu_slot) references gpu_slot (id_gpu_slot);
 alter table gpu add constraint FK_jejvm0aevqhdvd4qd7ubc17km foreign key (id_direct_x) references direct_x (id_direct_x);
 alter table gpu add constraint FK_rg8twecgr3hrbix4s4be8hptj foreign key (id_gpu_memory_technology) references gpu_memory_technology (id_gpu_memory_technology);
 alter table gpu add constraint FK_my4av20ctps9052c7ecrjf2i9 foreign key (id_product) references product (id_product);
 alter table gpu_architecture add constraint FK_971yotmgc9668m613xosi61l0 foreign key (id_company) references company (id_company);
 alter table gpu_family add constraint FK_mtg6fmkneu4gjep4r64sg0dqq foreign key (id_company) references company (id_company);
 alter table motherboard add constraint FK_q9262f636t9o8s1drqjjdv68j foreign key (id_company) references company (id_company);
 alter table motherboard add constraint FK_3hsfho163awyfy85mfjnuuu0r foreign key (id_cpu_socket) references cpu_socket (id_cpu_socket);
 alter table motherboard add constraint FK_9vodpf9dom2wsi9joio98bhky foreign key (id_motherboard_form_factor) references motherboard_form_factor (id_motherboard_form_factor);
 alter table motherboard add constraint FK_9aa4sqy7stmm1qgpn4tylma9y foreign key (id_gpu_slot) references gpu_slot (id_gpu_slot);
 alter table motherboard add constraint FK_g8abk7qybpmcwc7pxv5p17iwx foreign key (id_product) references product (id_product);
 alter table product add constraint FK_p76uw293y446w6uhoxqualkbj foreign key (id_product_type) references product_type (id_product_type);
 alter table user add constraint FK_ke4n344pkuarhfdts6319mhbw foreign key (id_cpu) references cpu (id_product);
 alter table user add constraint FK_6kmhx41ert4jumfvhefe7xglq foreign key (id_gpu) references gpu (id_product);
 alter table user_role add constraint FK_56olsq329osn3lxem8ftn9q9h foreign key (id_role) references role (role_id);
 alter table user_role add constraint FK_qibq3rh7mo4f8372yxkn549j7 foreign key (id_user) references user (id_user);