
/*
Inserta datos en la tabla estado
*/
INSERT INTO ESTADO(ESTADO_ID,ESTADO_NOMBRE)VALUES
(1, 'Registrado'),
(2, 'Retirado');


/*
Inserta datos en la tabla tiempo
*/
INSERT INTO TIEMPO(TIEMPO_ID,TIEMPO_NOMBRE)VALUES
(1, 'Dia'),
(2, 'Hora');


/*
Inserta datos en la tabla clase_automotor
*/
INSERT INTO CLASE_AUTOMOTOR(CLASE_ID,CLASE_NOMBRE)VALUES
(1, 'Carro'),
(2, 'Moto');


/*
Inserta datos en la tabla tarifa
*/
INSERT INTO TARIFA(TARIFA_ID,CLASE_ID,TIEMPO_ID,TARIFA_VALOR)VALUES
(1,1,1,8000),
(2,1,2,1000),
(3,2,1,4000),
(4,2,2,500);

