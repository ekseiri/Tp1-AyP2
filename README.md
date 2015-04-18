# Tp1-AyP2

Trabajo Práctico Final Obligatorio –Primera Parte
Enunciado del problema:
¡Felicitaciones! Acabás de conseguir trabajo para una empresa consultora. Tu primera asignación consiste en atender a la compañía de lavado de autos “¡Autos Relucientes Ya!” (ARY) que quiere saber cómo mejorar sus costos, planificar nuevas inversiones y optimizar el tiempo de espera de los clientes.
ARY posee una máquina automática de lavado que presenta las siguientes estaciones (cada estación realiza un proceso en un tiempo fijo y tiene asociado un costo):
- P: Prelavado
- LyE: Lavado y enjuague
- LL: Lavado de llantas
- S: Secado automático
- B: Aplicación automática de brillo para llantas
Los servicios que brinda ARY son:
- Lavado Económico
- Lavado Completo
- Lavado Premium
- Encerado
A continuación se describen cada uno de los servicios:
Servicio de Lavado Económico (máquina automática):
Paso 1: Lavado y enjuague. 
Paso 2: Lavado de llantas
Paso 3: Secado 
Servicio de Lavado Completo (máquina automática):
Paso 1: Prelavado.
Paso 2: Lavado y enjuague.
Paso 3: Lavado de llantas.
Paso 4: Secado
Servicio de Lavado Premium (máquina automática):
Paso 1: Prelavado.
Paso 2: Lavado y enjuague.
Paso 3: Lavado de llantas
Paso 4: Secado.
Paso 5: Aplicación de brillo para llantas.
Servicio de Encerado (manual):
E: Aplicación de cera sólida sobre la carrocería.
ARY abre sus puertas de lunes a sábados desde las 8 hs. de la mañana hasta las 20 hs.. Cuando un auto llega a ARY informa en caja el servicio que requiere: lavado económico, lavado completo o lavado premium, y opcionalmente si requiere encerado. El cajero entrega un ticket con la hora de llegada y los servicios contratados. En todos los casos primero se tiene que hacer la cola de lavado y luego, sólo los autos que se enceran hacen la cola del encerado. 
La máquina automática solo puede tener un único vehículo en proceso (es decir no puede haber distintos vehículos en las distintas estaciones)
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
Aplicación de brillo para llantas
B1: 5'
B2: $5
Encerado
E1: 10'
E2: $15
Tabla 1: Tiempos y costos con la configuración actual
De las estadísticas del último año se sabe que un día cualquiera de trabajo, el 50% de los clientes requiere el lavado económico, el 30% el lavado completo y el 20% restante el lavado premium. También se sabe que el 50% de los clientes (independientemente del tipo de lavado contratado) solicita el servicio de encerado.
Así mismo se obtuvieron las siguientes cantidades promedio de clientes de acuerdo al día de la semana:
Día de la semana
Cantidad promedio de clientes
Lunes
120
Martes
100
Miércoles
100
Jueves
90
Viernes
120
Sábados
150
Tabla 2: Cantidad promedio de clientes por día de la semana
A fin de determinar una política de precios y promociones, de optimizar el tiempo de espera de los clientes y de determinar las próximas inversiones a realizar (cada estación de la máquina automática se puede reemplazar por otra más moderna, con menores tiempos y costos asociados) se requiere una simulación que incluya una semana de trabajo con la siguiente información, considerando que los arribos de los clientes responden a un proceso de Poisson:
Costos por servicio para cada día de la semana:
1- Costo por día y por servicio.
Tiempos promedio de espera para cada día de la semana:
2- Promedio general de espera
3- Promedio por cada tipo de servicio (lavado económico, completo, premium).
4- Promedio de espera para el servicio de encerado.
Longitud promedio de las colas para cada día de la semana:
5- Longitud promedio de la cola de lavado.
6- Longitud promedio de la cola de encerado.
Las tablas 1 y 2 vienen dadas como datos en un archivo de texto con el siguiente formato:
P: P1, P2
LyE: LyE1, LyE2
LL: LL1, LL2
S: S1, S2
B: B1, B2
E: E1, E2
<línea en blanco>
Lunes: C1
Martes: C2
Miércoles: C3
Jueves: C4
Viernes: C5
Sábados: C6
<EOF>
Se proveen las clases:
Cola: Cola genérica (FIFO). El primero que entra es el primero que sale
PoissonSimulator: Dada la cantidad de eventos que ocurren en una determinada cantidad de minutos simula al azar el arribo del próximo evento en un proceso de Poisson (ver http://es.wikipedia.org/wiki/Proceso_de_Poisson).
Forma de realización y Entrega
El trabajo deberá realizarse en grupos de hasta 4 (cuatro) alumnos.

Se deberá entregar en formato impreso y digital: 
Informe
Archivo comprimido con las clases de java (sólo los archivos .java).
El informe debe incluir:
Nombres de los integrantes del grupo.
Diagrama de clases.
Decisiones de diseño tomadas.
Lista de archivos .java comprendidos en solución del problema.

La entrega en formato digital se deberá realizar vía mail a Rosita Wachenchauzer rositaw@gmail.com, Martín Albarracín Franzone mfranzo@gmail.com,  y Margarita Buriano<mburiano@gmail.com> 

Fecha de entrega y aprobación
1er entrega: 30/4/2015.
Luego de la primera entrega sólo se podrá llevar a cabo una nueva entrega adicional en caso de que el trabajo no haya sido aprobado, habiéndose entregado la primera vez en tiempo y forma. Fecha de entrega adicional: 19/5/2015.
Para la aprobación del trabajo práctico obligatorio se deberá tener aprobada tanto la entrega del TP como la defensa del mismo. 
