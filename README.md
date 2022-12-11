# Interprete Rust - Mateo Capón Blanquer -104258

Materia: Lenguajes Formales

## Ejecución del interprete

```shell
lein run
```

Ejecutar los ejemplos en el interprete con:
```shell
inter rust-ejemplos/main*.rs
```

## Ejecución de los tests

```shell
lein test
```

Agregar a todas los que tienen redondito como palabras reservadas. 


## Notas

Manejamos la complejidad a traves de la descomposicion

Compilador interpretativo - traducimos a lenguaje intermedio y luego se ejecuta
Interprete - va ejecutando a medida
Compilador - De alta calidad, muy complejo


En este se hace rust a bytecode y directamente se interpreta eso


Proceso -> 
1. Scaner en Escanear arch: trata con el archivo -> retorna la lista con tokens
2. Parser 
3. Ejecutar -> en compilador genera codigo fuente, sino funcion interpretar

La nuestra esta basada en pilas, otra forma es con arbol de sintaxis

Es un interprete iterativo -> esta implementado mediante recursividad, pero hace una instruccion a la vez.

Apto para interpretar cod de maquina (o representacion intermedia)


Interprete LISP -> totalmente recursivo. Es para lenguajes especificos de dominio. 


```shell
lein repl
```
A partir de ahi puedo correr los ejemplos que hice


# Errores mios

* En los test de println tendria que haber usado el `with-out-str`
* En el u32 de compatibles no deberia preguntar por pos? de positivo, sino por mayor o igual a cero. 
* Ver el tema de sqrt con 80. Para convertir formato impresion clj rust. 


Depurar:

Invocar (pst), print stack, imprime el stack del error

(spy "El estado al entrar en ... es" lo-que-ya-habia)


# FINAL

diegocorsi.com.ar/rust


el agregar-pto-coma es como un preprocesador.

Agregar i32 -> Tendria que agregar los tipos de dato en palabra reservada. 
Ponerlo en procesar tipo variable



Falta agregar en parametros y retorno de las funciones

Que se puedan pasar parametros, o retornar algo de tal dato.


El as se usa en el casteo de pasar a float o pasar a int.

procesar-tipo-as -> hay que hacer un escanear y pasar a int o float ahi.


Agregar el ++-> primero hay que agregar el ++ en la expresion regular escanear-arch. Hay que ponerlo antes del + solo. 

Buscamos un identificador que actua como expresion
	