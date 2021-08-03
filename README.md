# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---

**The rest of the documentation is left for the users of this template to complete**

Para modelar el problema se crean los distintos tipos de objetos de Scarbble como distintas clases, estas clases extienden
a una clase abstracta que a su vez implementa la interfaz SType.

en esta interfaz se definen los metodos de transformacion y operaciones que se piden, notando que hay solo un grupo
especifico donde los operadores logicos tienen efecto, se crea una nueva interfaz LogicType que son implementados por
el tipo SBoolean y SBinary, para ordenar el modelo.

en cada clase se especifica el funcionamiento de los metodos particulares de cada tipo y en la clase abstracta se define
el retorno por defecto de cada metodo nulo, para ordenar.

SBinary actualmente solo codifica un número entero positivo de largo arbitrario, si de una operación resulta un binario
con valor negativo retorna un binario con valor '0' instead.

------

Para realizar el árbol de sintaxis abstracta, se hacen a partir de cada operación una clase que implementa a NodoI,
que contiene el método solve(), que reduce cualquier AST (Nodo, expresión) a un tipo de scrabble, para esto tambien se hace que
STypeI extienda a NodoI, de forma que solve() vaya recursivamente bajando por los nodos del arbol hasta llegar a un
SType donde solve() retorna a si mismo y los Nodos que no son hojas hagan la operación apropiada entre los hijos.

Luego para hacer el ahorro de memoria, se crea una clase singleton TypeFactory, que contiene diccionarios(Hashmap) de
cada tipo de scrabble, de forma que cuando se use un método de creación de factory, se reutilice un valor que ya haya sido
creado, usando como llave el valor del SType. Para hacer uso de esto se tuvieron que cambiar todos los métodos en Stype
para que usen los métodos de factory en vez de crear nuevas instancias usando new.

De una forma similar se implementan las variables, se crea la clase variable que contiene un valor SType cualquiera y
se guardan en una clase singleton VarFactory, pero en este caso no existe un método que retorne las variables, solamente
se pueden definir, de forma que queden guardadas en el diccionario. y se pueden buscar, de forma que retornen el valor
Stype que contienen.

-------

Con una idea similar a los AST se realizó el control de flujo, donde cada paso de máquina, u operación que no retorna nada
implementa en este caso la interfaz FluxNode, que contiene el método act(). Usualmente los FluxNode contienen como parámetro
otro FluxNode, donde dada ciertas condiciones act() va a ejecutar secuencialmente cada FluxNode, con esto se crean las
operaciones If, While y Set, donde Set le coloca un valor a una variable.

Las operaciones de comparación se hace que SType implemente la interfaz Comparable y se define el método compareTo para
los tipos numéricos, como se pide en el enunciado. Dado que no se implementaron excepciones, cuando se intenta comparar
objetos no numéricos, dado que se definio el valor de compareTo por default a -2, el programa va a retornar un booleano
pero no tendria sentido.
Luego con la posibilidad de hacer comparaciones, se definen las operaciones mayor, menor, e igual como nodos que retornan
un valor SBool.

Para completar el control de flujo se crean nuevas operaciones en NodeI, que son Get, operaciones de comparación y las
operaciones toType o de transformación, también se establece el estándar que cualquier operación que retorne un SType 
debería tener su propio tipo NodeI para mantener consistencia y que cada árbol se resuelva solo cuando sea su turno.