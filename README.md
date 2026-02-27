# Programación de Sistemas Adaptativos - Spring Boot + Thymeleaf

Aplicación web educativa para practicar y preparar respuestas de examen sobre:
- Unidad 1: Auto-ajuste y Algoritmos Genéticos (Cruza)
- Unidad 2: Sistemas complejos (Caos)
- Unidad 3: Sistemas inteligentes (BFS y Perceptrón)
- Unidad 4: Sistemas multiagente (estrategia dominante)

## Requisitos
- Java 17
- Maven 3.9+

## Ejecutar
```bash
mvn spring-boot:run
```
Abrir: `http://localhost:8080`

## Cómo usar para el examen
En cada sección de la web verás:
1. **¿Qué responde del examen?** (enunciado teórico que estás resolviendo).
2. **¿Para qué sirve?** (interpretación práctica).
3. **Formulario con ejemplo precargado** para ejecutar rápido.
4. **Resultado + interpretación** para convertirlo en respuesta escrita.

Estrategia recomendada de estudio:
- Ejecutar ejemplo base.
- Cambiar parámetros.
- Explicar en tus palabras: entrada, algoritmo/procedimiento, salida e interpretación.

## Módulos
### 1) Auto-ajuste
Simula un sistema de control proporcional iterativo con ruido opcional.
- Entradas: setpoint, valor inicial, ruido, iteraciones, ganancia inicial.
- Salida: tabla por iteración (medición, error, parámetro ajustado, salida).

### 2) GA Cruza
Implementa crossover de un punto para cromosomas binarios.
- Entradas: `p1`, `p2`, `pc`.
- Salidas: `h1`, `h2`, explicación y pseudocódigo.

### 3) Caos Quiz
Mini cuestionario interactivo con feedback inmediato:
- Fractal / Atractor / Auto-ajuste.
- Sensibilidad a condiciones iniciales.

### 4) BFS
Crea un grafo desde texto y ejecuta búsqueda en anchura.
- Entradas: nodos, aristas, origen.
- Salidas: orden de visita, niveles y pasos (cola/visitados).

### 5) Redes Neuronales
Perceptrón desde cero (sin librerías de ML externas).
- Dataset: AND/OR o manual.
- Salida: pesos iniciales/finales, error y evolución por épocas.

### 6) Multiagente
Analiza matriz 2x2 de pagos del agente `j`.
- Detecta dominancia estricta o débil.
- Explica comparación por filas/columnas.

## Estructura técnica
- `controller/`: controladores por módulo.
- `service/`: lógica principal por tema.
- `dto/`: entradas con Bean Validation.
- `templates/`: vistas Thymeleaf + fragmento navbar/footer.
- `static/css/`: estilos responsivos.

## Pruebas
```bash
mvn test
```
Incluye pruebas unitarias para cruza GA, BFS y estrategia dominante.
