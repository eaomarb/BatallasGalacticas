# 🚀 Batallas Galácticas

Proyecto del ciclo de Desarrollo de Aplicaciones Multiplataforma (DAM). Se trata de un juego por turnos en consola donde dos equipos (Alfa y Beta) mueven diferentes tipos de naves en un tablero 8x8, con el objetivo de destruir la nave "Madre Comandante" del rival.

## 🎮 Cómo funciona

- Juego en consola por turnos.
- Tablero validado y simétrico.
- Cada nave tiene un comportamiento único (movimiento y si puede atacar o no).
- Gana quien elimina la nave "Madre Comandante" del otro equipo.

## ✨ Naves disponibles

| Nave              | Símbolo | Ataca | Movimiento                          |
|-------------------|---------|-------|-------------------------------------|
| Madre Comandante  | M / m   | Sí    | 1 casilla en cualquier dirección    |
| Fragata           | F / f   | Sí    | Recto, hasta 2 casillas             |
| Cazabombardero    | C / c   | Sí    | En L (tipo caballo en ajedrez)      |
| Exploradora       | E / e   | No    | Diagonal libre sin obstáculos       |
| Dron de combate   | D / d   | Sí    | Avanza recto o ataca en diagonal    |

## ℹ️ Sobre el proyecto

Proyecto 100% en Java, usando POO y validación de entradas. Me sirvió para practicar diseño de clases, herencia y lógica de juego por turnos. Pensado como reto personal para aplicar lo aprendido en DAM.

## ▶️ Cómo ejecutar

```bash
git clone https://github.com/eaomarb/BatallasGalacticas.git
cd BatallasGalacticas
javac *.java
java BatalletesGalactiques.java´´´´´
