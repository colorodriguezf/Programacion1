Se tiene una matriz MAT de caracteres de tamaño MAXFIL X MAXCOL, que esta precargada. Se pide realizar un programa que agregue en un arreglo de enteros de tamaño MAXCOL ordenado de forma descendente e inicializado con 0, la cantidad de caracteres vocales de las columnas. El arreglo debe estar ordenado en todo momento.
Observaciones generales:
•	Suponer que MAT esta precargada
•	No se pueden utilizar estructuras auxiliares
•	Realizar un programa completo bien modularizado
-------------------------------------------------------------------------------------------------------------------------
Se tiene dos arreglos de secuencias de caracteres letra. Se pide realizar un programa (sin metodo de carga del arreglo) que intercambie la secuencia de mayor tamaño de A por la secuencia de mayor tamaño de B.
Observaciones generales:
•	Todos los arreglos de secuencias empiezan y terminan con espacios
•	Las secuencias estan separadas por uno o mas espacios
•	Todos los arreglos mencionados tienen tamaño MAX
•	No utilizar estructuras auxiliares
-------------------------------------------------------------------------------------------------------------------------
Se tiene una matriz precargada con secuencias de enteros distintos de cero en sus filas. Ademas se tiene precargado un arreglo con algunos numeros de filas. Los numeros de filas no se repiten y estan ubicados de forma consecutiva desde el principio del arreglo, luego se completa con -1. De dichas filas se pide eliminar la ultima secuencia que cumpla con la condicion de tener solo valores pares.
Observaciones generales:
•	El tamaño arreglo es igual a la cantidad de filas de la matriz
•	Las secuencias estan separadas por uno o mas ceros, empiezan y terminan con uno o mas ceros
•	Realizar el programa completo sin metodos de carga e impresion de arreglo y matriz, ni utilizar estructuras auxiliares
-------------------------------------------------------------------------------------------------------------------------
Tema 1: Se tiene una matriz precargada con secuencias de enteros distintos de cero en sus filas. Se pide guardar en un arreglo los números de filas de las primeras 4 filas que cumplen con la condición de tener a lo sumo 5 secuencias sin orden ascendente.
Observaciones: 
•	El tamaño arreglo es igual a la cantidad de filas de la matriz, y está inicializado con -1
•	Las secuencias están separadas por uno o más ceros, empiezan y terminan con uno o más ceros
•	Realizar el programa completo sin realizar métodos de carga e impresión de matriz, ni utilizar estructuras auxiliares.
-------------------------------------------------------------------------------------------------------------------------
Tema 2: Se tiene una matriz precargada con secuencias de enteros distintos de cero en sus filas. Además se tiene precargado un arreglo con algunos números de filas. Los números de filas no se repiten y están ubicados de forma consecutiva desde el principio del arreglo, luego se completa con -1. De dichas filas se pide eliminar la penúltima y la antepenúltima secuencia que tengan al menos 3 números impares.
Observaciones: 
•	El tamaño arreglo es igual a la cantidad de filas de la matriz,
•	Las secuencias están separadas por uno o más ceros, empiezan y terminan con uno o más ceros,
•	Realizar el programa completo sin realizar métodos de carga e impresión de arreglo y matriz, ni utilizar estructuras auxiliares
-------------------------------------------------------------------------------------------------------------------------
Tema 1: Se tiene una matriz de caracteres letra minúscula. a) Para las primeras 3 filas que tienen una cantidad impar de vocales, se pide obtener el número de la fila que tiene la menor cantidad de consonantes. b) Agregar en un arreglo de caracteres letra minúscula ordenado ascendente (manteniendo su orden en todo momento), las consonantes mayores al caracter letra ‘f’ de la fila correspondiente al número de fila obtenido en a).
Observaciones: 
•	El tamaño del arreglo es igual a la cantidad de filas de la matriz 
•	La matriz y el arreglo están precargados
•	Realizar el programa completo bien modularizado sin métodos de carga e impresión de matriz, ni utilizar estructuras auxiliares
-------------------------------------------------------------------------------------------------------------------------
Tema 2: Se tiene una matriz que contiene caracteres dígito y caracteres letra minúscula. a) Considerando solo las columnas que tienen caracteres letra minúscula, se pide obtener el número de la columna que tiene la menor cantidad de consonantes menores al caracter ‘m’. b) Determinar si en un arreglo dado de caracteres letra minúscula ordenado ascendente, están todas las consonantes incluídas en la columna correspondiente al número de columna obtenido en a).
Observaciones: 
•	El tamaño del arreglo es igual a la cantidad de columnas de la matriz
•	La matriz y el arreglo están precargados 
•	Realizar el programa completo bien modularizado sin métodos de carga e impresión de matriz, ni utilizar estructuras auxiliares.
-------------------------------------------------------------------------------------------------------------------------
19/4/18
Escribir un programa que mientras el usuario ingrese un numero distinto de 0, pida ingresar un caracter e imprima:
•	"digito" ('0', '1', ..., '9') si el caracter ingresado es digito, en cuyo caso ademas debera imprimir si el numero ingresado previamente es o no multiplo de 3 y 5
•	o "vocal minuscula" si el caracter ingresado es vocal
•	u "otro" para los restantes caracteres ingresados
-------------------------------------------------------------------------------------------------------------------------
Escribir un programa completo que mientras el usuario ingrese un numero entero, pida ingresar dos caracteres vocales minuscula, e imprima el numero entero ingresado cada vez que el primer caracter vocal sea menor en el orden alfabetico respecto delo segundo caracter vocal.
-------------------------------------------------------------------------------------------------------------------------
Se tiene una matriz MAT de enteros de tamaño NFIL x NCOL, donde en cada fila se tiene secuencias de numeros distintos de cero separadas por uno o mas ceros. Realizar un programa que ordene de forma ascendente las ultimas CANT de secuencias.
Observaciones: Cada fila empieza y termina con uno o mas ceros. Suponer que MAT esta cargada, y que CANT tiene valor y es pasados por parametro. Recuerde definir constantes y modularizar la solucion con procedimientos y funciones. No realizar recorridos innecesarios.
-------------------------------------------------------------------------------------------------------------------------
Se tiene una matriz MAT de enteros de tamaño 5 x 20, donde en cada fila se tiene secuencias de numeros distintos de cero separadas por uno o mas ceros.  Realizar un programa que para todas las filas invierta el contenido de las secuencias que tienen tamaño N, y comienzan y terminan con al menos un 1, siendo N un valor entero cargado desde teclado entre 0 y la cantidad de columnas.
Observaciones: Cada fila empieza y termina con uno o mas ceros. Recuendo definir constantes y modularizar la solucion con procedimientos y funciones.
-------------------------------------------------------------------------------------------------------------------------
Dada un matriz de caracteres de M x N compuesta de secuencias de caracteres separadas por espacion, hacer un programa completo para borrar la secuencia central de cada fila (secuencia correspondiente a la mitad de la cantidad de secuencias que tiene la fila, sin importar si la cantidad es par o impar). Para borrar realizar los desplazamientos necesarios y no utilziar estructuras auxiliares	. Suponer que la matriz se encuentra cargada y que cada fila comienza y termina con caracteres espacio.
-------------------------------------------------------------------------------------------------------------------------
Escribir un programa que mienteras el usuario ingrese un numero NUM que sea multiplo de 7 y de 11, pida ingresar NUM caracteres, y por cada caracter ingresado imprima:
•	"letra minuscula" si el caracter es una letra del abecedario en minuscula
•	"letra mayuscula" si el caracter es una letra del abecedario en mayuscula
•	"digito" si el caracter correspode a un caracter numero
•	"otro" para los restantes casos de caracteres
-------------------------------------------------------------------------------------------------------------------------

