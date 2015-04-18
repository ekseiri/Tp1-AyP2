# Tp1-AyP2

Trabajo Pr�ctico Final Obligatorio �Primera Parte
Enunciado del problema:
�Felicitaciones! Acab�s de conseguir trabajo para una empresa consultora. Tu primera asignaci�n consiste en atender a la compa��a de lavado de autos ��Autos Relucientes Ya!� (ARY) que quiere saber c�mo mejorar sus costos, planificar nuevas inversiones y optimizar el tiempo de espera de los clientes.
ARY posee una m�quina autom�tica de lavado que presenta las siguientes estaciones (cada estaci�n realiza un proceso en un tiempo fijo y tiene asociado un costo):
- P: Prelavado
- LyE: Lavado y enjuague
- LL: Lavado de llantas
- S: Secado autom�tico
- B: Aplicaci�n autom�tica de brillo para llantas
Los servicios que brinda ARY son:
- Lavado Econ�mico
- Lavado Completo
- Lavado Premium
- Encerado
A continuaci�n se describen cada uno de los servicios:
Servicio de Lavado Econ�mico (m�quina autom�tica):
Paso 1: Lavado y enjuague. 
Paso 2: Lavado de llantas
Paso 3: Secado 
Servicio de Lavado Completo (m�quina autom�tica):
Paso 1: Prelavado.
Paso 2: Lavado y enjuague.
Paso 3: Lavado de llantas.
Paso 4: Secado
Servicio de Lavado Premium (m�quina autom�tica):
Paso 1: Prelavado.
Paso 2: Lavado y enjuague.
Paso 3: Lavado de llantas
Paso 4: Secado.
Paso 5: Aplicaci�n de brillo para llantas.
Servicio de Encerado (manual):
E: Aplicaci�n de cera s�lida sobre la carrocer�a.
ARY abre sus puertas de lunes a s�bados desde las 8 hs. de la ma�ana hasta las 20 hs.. Cuando un auto llega a ARY informa en caja el servicio que requiere: lavado econ�mico, lavado completo o lavado premium, y opcionalmente si requiere encerado. El cajero entrega un ticket con la hora de llegada y los servicios contratados. En todos los casos primero se tiene que hacer la cola de lavado y luego, s�lo los autos que se enceran hacen la cola del encerado. 
La m�quina autom�tica solo puede tener un �nico veh�culo en proceso (es decir no puede haber distintos veh�culos en las distintas estaciones)
Los tiempos y costos asociados a cada proceso vienen dados en una tabla:
Proceso
Tiempo [minutos]
Costo asociado [$]
Prelavado
P1: 2'
P2: $10
Lavado y enjuague
LyE1: 2'
LyE2: $12
Lavado de llantas
LL1: 1'
LyE3: $5
Secado
S1: 3'
S2: $5
Aplicaci�n de brillo para llantas
B1: 5'
B2: $5
Encerado
E1: 10'
E2: $15
Tabla 1: Tiempos y costos con la configuraci�n actual
De las estad�sticas del �ltimo a�o se sabe que un d�a cualquiera de trabajo, el 50% de los clientes requiere el lavado econ�mico, el 30% el lavado completo y el 20% restante el lavado premium. Tambi�n se sabe que el 50% de los clientes (independientemente del tipo de lavado contratado) solicita el servicio de encerado.
As� mismo se obtuvieron las siguientes cantidades promedio de clientes de acuerdo al d�a de la semana:
D�a de la semana
Cantidad promedio de clientes
Lunes
120
Martes
100
Mi�rcoles
100
Jueves
90
Viernes
120
S�bados
150
Tabla 2: Cantidad promedio de clientes por d�a de la semana
A fin de determinar una pol�tica de precios y promociones, de optimizar el tiempo de espera de los clientes y de determinar las pr�ximas inversiones a realizar (cada estaci�n de la m�quina autom�tica se puede reemplazar por otra m�s moderna, con menores tiempos y costos asociados) se requiere una simulaci�n que incluya una semana de trabajo con la siguiente informaci�n, considerando que los arribos de los clientes responden a un proceso de Poisson:
Costos por servicio para cada d�a de la semana:
1- Costo por d�a y por servicio.
Tiempos promedio de espera para cada d�a de la semana:
2- Promedio general de espera
3- Promedio por cada tipo de servicio (lavado econ�mico, completo, premium).
4- Promedio de espera para el servicio de encerado.
Longitud promedio de las colas para cada d�a de la semana:
5- Longitud promedio de la cola de lavado.
6- Longitud promedio de la cola de encerado.
Las tablas 1 y 2 vienen dadas como datos en un archivo de texto con el siguiente formato:
P: P1, P2
LyE: LyE1, LyE2
LL: LL1, LL2
S: S1, S2
B: B1, B2
E: E1, E2
<l�nea en blanco>
Lunes: C1
Martes: C2
Mi�rcoles: C3
Jueves: C4
Viernes: C5
S�bados: C6
<EOF>
Se proveen las clases:
Cola: Cola gen�rica (FIFO). El primero que entra es el primero que sale
PoissonSimulator: Dada la cantidad de eventos que ocurren en una determinada cantidad de minutos simula al azar el arribo del pr�ximo evento en un proceso de Poisson (ver http://es.wikipedia.org/wiki/Proceso_de_Poisson).
Forma de realizaci�n y Entrega
El trabajo deber� realizarse en grupos de hasta 4 (cuatro) alumnos.

Se deber� entregar en formato impreso y digital: 
Informe
Archivo comprimido con las clases de java (s�lo los archivos .java).
El informe debe incluir:
Nombres de los integrantes del grupo.
Diagrama de clases.
Decisiones de dise�o tomadas.
Lista de archivos .java comprendidos en soluci�n del problema.

La entrega en formato digital se deber� realizar v�a mail a Rosita Wachenchauzer rositaw@gmail.com, Mart�n Albarrac�n Franzone mfranzo@gmail.com,  y Margarita Buriano<mburiano@gmail.com> 

Fecha de entrega y aprobaci�n
1er entrega: 30/4/2015.
Luego de la primera entrega s�lo se podr� llevar a cabo una nueva entrega adicional en caso de que el trabajo no haya sido aprobado, habi�ndose entregado la primera vez en tiempo y forma. Fecha de entrega adicional: 19/5/2015.
Para la aprobaci�n del trabajo pr�ctico obligatorio se deber� tener aprobada tanto la entrega del TP como la defensa del mismo. 
