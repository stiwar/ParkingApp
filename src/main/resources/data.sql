insert into tipovehiculo(id,nombre) values (1,'Carro');
insert into tipovehiculo(id,nombre) values (2,'Moto');
insert into vehiculo(id,fecha_entrada,fecha_salida,placa,cilindraje,total_cobro,estado,tipovehiculo) values (1,NOW(),null,'HFG123',null,null,1,1);
insert into vehiculo(id,fecha_entrada,fecha_salida,placa,cilindraje,total_cobro,estado,tipovehiculo) values (2,NOW(),null,'LJL456',200,null,1,2);
insert into vehiculo(id,fecha_entrada,fecha_salida,placa,cilindraje,total_cobro,estado,tipovehiculo) values (3,{ts '2019-06-11 08:27:43.193'},null,'PQR150',null,null,1,1);