# Batallas Galácticas

## Índice
1. [Descripción](#descripción)  
2. [Tecnologías](#tecnologías)  
3. [Requisitos](#requisitos)  
4. [Ejecución](#ejecución)  
5. [Cómo jugar](#cómo-jugar)

---

## Descripción
Proyecto del ciclo de Desarrollo de Aplicaciones Multiplataforma (DAM). Juego de batallas galácticas por turnos en consola: diriges dos equipos (Alfa y Beta) sobre un tablero de 8×8 moviendo naves con patrones de ataque y alcance distintos para destruir la “Madre Comandante” rival. Con él consolidé mis conocimientos de POO en Java, herencia, polimorfismo y validación de entradas por teclado.

---

## Tecnologías
- Java

---

## Requisitos
- JDK 14 o superior 

---

## Ejecución
    git clone https://github.com/eaomarb/BatallasGalacticas.git
    cd BatallasGalacticas/src
    javac *.java
    java BatalletesGalactiques

---

## Cómo jugar
- Cada turno alterna entre Equipo Alfa y Equipo Beta.  
- Elige la nave y la casilla a la que quieres moverla; si está en rango de ataque, puedes eliminar una nave enemiga.  
- Naves disponibles:  
    - **Madre Comandante (M/m)**: mueve 1 casilla en cualquier dirección y ataca.  
    - **Fragata (F/f)**: recto hasta 2 casillas y ataca.  
    - **Cazabombardero (C/c)**: en “L” (como el caballo de ajedrez) y ataca.  
    - **Exploradora (E/e)**: diagonal libre (no ataca).  
    - **Dron (D/d)**: avanza recto o ataca en diagonal.  
- Gana el equipo que destruye la Madre Comandante enemiga.  
