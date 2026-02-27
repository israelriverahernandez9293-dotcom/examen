# Programación de Sistemas Adaptativos - Spring Boot + Thymeleaf

Proyecto Maven con Java 17 que contiene simulaciones/prácticas por unidad temática.

## Requisitos
- Java 17
- Maven 3.9+

## Ejecución
```bash
mvn spring-boot:run
```
Luego abrir: `http://localhost:8080`

## Módulos
- **Inicio**: resumen general.
- **Auto-ajuste**: simulación de control proporcional con ruido, setpoint, parámetro ajustable e iteraciones.
- **GA Cruza**: cruza de un punto para cromosomas binarios (`p1`, `p2`, `pc`) con pseudocódigo y ejecución.
- **Caos Quiz**: mini cuestionario interactivo sobre fractales y sensibilidad a condiciones iniciales.
- **BFS**: creación de grafo desde texto (nodos/aristas), ejecución BFS con orden, niveles y pasos (cola/visitados).
- **Redes neuronales**: perceptrón simple (AND/OR o dataset manual) mostrando pesos por época y error.
- **Multiagente**: análisis de matriz 2x2 de pagos de `j` para detectar estrategia dominante estricta o débil.

## Estructura
- `controller/`: `AutoTuneController`, `GeneticController`, `ChaosController`, `GraphController`, `NeuralController`, `MultiAgentController`.
- `service/`: `AutoTuneService`, `GeneticService`, `BFSService`, `NeuralService`, `GameTheoryService`.
- `dto/`: objetos de entrada validados con Bean Validation.
- `templates/`: vistas Thymeleaf por módulo y fragmento compartido de layout/navbar.

## Pruebas
```bash
mvn test
```
Incluye pruebas unitarias para cruza GA, BFS y estrategia dominante.
