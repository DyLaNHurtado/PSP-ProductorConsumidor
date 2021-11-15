# Programacion de Servicios y Procesos

## Productor - Consumidor
### Descripción 📝 :
Patron clasico del Productor-Consumidor con hilos y monitor Java 11<br />

#### Enunciado:<br />

El problema del productor-consumidor es un ejemplo clásico de <br />
problema de sincronización de multiprocesos. <br />
* El programa describe dos procesos, productor y consumidor, <br />
ambos comparten un buffer de tamaño finito. La tarea del <br />
productor es generar un producto, almacenarlo y comenzar <br />
nuevamente; mientras que el consumidor toma <br />
(simultáneamente) productos uno a uno. El problema consiste <br />
en que el productor no añada más productos que la <br />
capacidad del buffer y que el consumidor no intente tomar un <br />
producto si el buffer está vacío.<br /><br />
* La idea para la solución es la siguiente, ambos procesos <br />
(productor y consumidor) se ejecutan simultáneamente y se <br />
“despiertan” o “duermen” según el estado del buffer.<br /><br />
* Concretamente, el productor agrega productos mientras quede <br />
espacio y en el momento en que se llene el buffer se pone a <br />
“dormir”. Cuando el consumidor toma un producto notifica al <br />
productor que puede comenzar a trabajar nuevamente. En caso <br />
contrario, si el buffer se vacía, el consumidor se pone a dormir y <br />
en el momento en que el productor agrega un producto crea una <br />
señal para despertarlo<br />

## Autor ✍🏻 :

* Dylan Hurtado López hecho en IntelliJ IDE

