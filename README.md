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

para realizar el arbol de sintáxis abstracta, se hacen a partir de cada operación una clase que implementa a NodoI,
que contiene el método solve(), que reduce cualquier AST (Nodo, expresión) a un tipo de scrabble, para esto tambien se hace que
STypeI extienda a NodoI, de forma que solve() vaya recursivamente bajando por los nodos del arbol hasta llegar a un
SType donde solve() retorna a si mismo y los Nodos que no son hojas hagan la operación apropiada entre los hijos.

Luego para hacer el ahorro de memoria, se crea una clase singleton TypeFactory, que contiene diccionarios(Hashmap) de
cada tipo de scrabble, de forma que cuando se use un metodo de creación de factory, se reutilize un valor que ya haya sido
creado, usando como llave el valor del SType. Para hacer uso de esto se tuvieron que cambiar todos los metodos en Stype
para que usen los metodos de factory en vez de crear nuevas instancias usando new.

De una forma similar se implementan las variables, se crea la clase variable que contiene un valor SType cualquiera y
se guardan en una clase singleton VarFactory, pero en este caso no existe un método que retorne las variables, solamente
se pueden definir, de forma que queden guardadas en el diccionario. y se pueden buscar, de forma que retornen el valor
Stype que contienen.