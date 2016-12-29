# trip-sorter 
:round_pushpin: :arrow_right: :train: :arrow_right: :airplane: :arrow_right: :bus: :arrow_right: :round_pushpin:

API Java para solucionar el problema "trip sorter".

[Enunciado del problema trip sorter](Enunciado trip sorter.pdf)

El código fuente está dentro del directorio src organizado por paquetes Java.

El JavaDoc está contenido en la carpeta [doc](doc) a través del fichero index.html.

Se ha optado por organizar el código fuente en 4 paquetes:

1. **com.eduardo.transport**: contiene todas las clases relacionados con los medios de transporte añadidos a esta API: avión, autobús y tren; las compañías de transporte, y los fabricantes de vehículos. 

 Mencionar que la clase Transport es abstracta para que pueda ser extendida por otros medios de transporte nuevos a añadir, pero implementando todo el código cómun para todos los medios de transporte.
2. **com.eduardo.location**: contiene todas las clases que tengan que ver con localizaciones o lugares físicos. 

 Esta API sólo contiene la clase Place para representar los lugares que figuran en las boarding cards y conocer las diferentes paradas del viaje correspondiente a este conjunto de boarding cards.
3. **com.eduardo.boardingcards**:
  * Existe una clase abstracta llamada BoardingCard que representa a la clase común para cualquier tipo de boarding card. De esta manera     se pueden crear nuevos tipos concretos de boarding cards extendiendo esta clase. 
  
    Se ha añadido tres clases que heredan de ésta y que representan las tarjetas correspondiente a diferentes medios de transporte:         AerolineBoardingCard (viaje en avión), TrainBoardingCard (viaje en tren) y BusBoardingCard (viaje en autobús).
  * Cabe mencionar que este paquete contiene también la clase involucrada en el patrón Factory (clase ConcreteBoardingCardFactory) para crear en un mismo lugar los diferentes tipos de boarding card que existen o que puedan existir en un futuro.
  * Cabe mencionar también que este paquete contiene las clases involucradas en el patrón Strategy usado para poder aplicar, en tiempo de ejecución, diferentes algoritmos de ordenamiento del conjunto de boarding cards. 
  
    La interfaz llamada TripSorterStrategy es la que contiene la cabecera del método de ordenación. Para añadir un algoritmo de ordenación concreto sólo hay que crear una clase nueva implementado dicha interfaz para implementar dicho método de ordenación. En esta API sólo existe una clase llamada StrategyNoStartNoEnd que implementa esta interfaz y que implementa el método de ordenación para ordenar una serie de boarding cards en las que no se sabe su orden para realizar el viaje desde el origen al destino final. 
    
    El patrón Strategy lo completa la clase ContextTripSorter que es la que permite variar el algoritmo de ordenación en tiempo de ejecución.
4. **com.eduardo.mainapp**: contiene una clase llamada Main para simular el problema de ordenamiento de cuatro boarding cards, y poder ver el orden en el que debemos realizar nuestro viaje.
  

Se puede consultar el diagrama de clases reducido (sin atributos ni métodos) para ver las relaciones entre clases en el fichero
[Class diagram.png](Class diagram.png).
