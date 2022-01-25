# UD9 Interfaces
## 1. Conceptos y definición de interfaces
Si queremos tener un método que todas las clases implementen, se podría hacer de dos formas:
* clase abstracta
    * no nos permitiría heredar de otra clase
    * no obliga a que la clase hija lo implemente
* interface
    * Podríamos heredar de una clase, e implementar varias
    * obliga a la clase que lo implementa a definir los métodos que están en el interface definidos.
    * algunos de los métodos del interface podrían estar ya definidos.

La definición de una implementación es 

```java
public interface Sonido {
    void voz();
}
```

a la hora de implementar una clase **Perro** que implemente este interface sería:

```java
public class Perro implements Sonido {

    @Override
    public void voz() {
        System.out.println("Guau!");
    }

}

```

## 2. Atributos de una interface
Podríamos definir atributos, que por defecto son **static** y **final**, es decir, Perro lo podría emplear, pero en ningún caso podría modificarlo
```java
public interface Sonido {
    int version = 1;
    
    void voz();

}
```

Se podría acceder a ellos o con el nombre de la interface o de la clase:
```java 
        System.out.println(Sonido.version);
        System.out.println(Perro.version);
```

## 3. Métodos de una interface
### Métodos abstractos
Los vistos en el ejemplo anterior, solo está definido y tienen que implementarlos las clases.
```java
public interface Sonido {
    void voz();
}
```
### Métodos por defecto (no admitido en JDK 8, configurar la 15)
Imaginando que por defecto durmiendo todos hacen el mismo sonido, podríamos implementando vozDurmiendo en el interface

```java
    default void vozDurmiendo() {
        System.out.println("Zzz");
    }
```

### Métodos estáticos (no admitido en JDK 8, configurar la 15)
Estos son métodos de la interfaz, no de las clases que lo implementan
```java
    static void bostezo() {
        System.out.println("¡AAAAAAAAAAAuuuuuuuuhhh!");
    }
```

Estos son métodos de la interfaz, no de las clases que lo implementan
```java
        Sonido.bostezo();
        // Perro.bostezo(); no se podría acceder a través de Perro
```

### Métodos privados
Sólo serán accesibles desde dentro de la interface

## 4. Herencia
Una interfaz puede heredar de otra interfaz, o incluso de varias (de las clases solo se podía heredar de una)

De esta manera, tendría los métodos **habla**(), **voz**(), y el atributo **version**.
```java
public interface SonidoPersona extends Sonido {
    void habla();
}
```

## 5. Variables de tipo interfaz

Podemos declarar variables de tipo interfaz.

```java
        Sonido son1;
```

siempre que referencien a un objeto que implemente dicha clase
```java
        Sonido son1 = new Gato();
```

Si ahora accediesemos al método voz, mostraría el de gato.

```java
        Sonido son1 = new Gato();
        son1.voz();         // Miau!
        Sonido son2 = new Perro();  
        son2.voz();         // Guau!
```

Ejemplos de selección dinámica de métodos:
* Los métodos a los que se puede acceder desde son1 son los definidos en Sonido y en Object (no podría acceder a métodos definidos en Gato)
* Si accede a un método definido en Sonido o Object, y éste, está sobreescrito en la clase Gato, ejecutará dicho código.

## Clases anónimas
Podríamos querer implementar una variable de tipo interface que no pertenezca a ninguna clase en concreto, por tanto no tendría un nombre asociado.
Al definir este tipo de variables, tendríamos que definir en la creación, los métodos de la interface.
```java
        Sonido son3 = new Sonido() {
            @Override
            public void voz() {
                System.out.println("sonido sin definir!!!");
            }
        };  
```

