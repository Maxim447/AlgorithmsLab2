# AlgorithmsLab2
# Cравнение алгоритмов по времени построения
<img width="613" alt="изображение" src="https://user-images.githubusercontent.com/114473716/234645028-149c1c2e-60e5-4595-886f-42f8766216bd.png">

<img width="610" alt="Снимок экрана 2023-04-26 в 18 29 02" src="https://user-images.githubusercontent.com/114473716/234626402-210daaa3-cf94-4fe8-9a84-cea2eca26b00.png">

Если посмотреть на график, то можно увидеть что алгоритм на карте строится всех дольше, потому что сложность построения данного алгоритма O(n^3). Из этого следует, что данный алгоритм на большом тестовом наборе данных будет затрачивать много времени. Построение алгоритма на дереве происходит значительно быстрее(сложность построения дерева O(nlogn)), чем алгоритма на карте. Алгоритм перебором не затрачивает времени на построение.

# Сравнение алгоритмов по скорости работы
<img width="674" alt="Снимок экрана 2023-04-26 в 19 06 13" src="https://user-images.githubusercontent.com/114473716/234635297-b67ff2c2-2e67-4ae4-9fdc-516311251e1e.png">
<img width="675" alt="Снимок экрана 2023-04-26 в 19 05 28" src="https://user-images.githubusercontent.com/114473716/234635394-aebf2fe9-1a10-48b7-97cd-679d8dcdfb09.png">
<img width="731" alt="Снимок экрана 2023-04-26 в 18 06 34" src="https://user-images.githubusercontent.com/114473716/234633988-9a5ebfd3-6797-4bf7-b07a-154bae83f346.png">

Из первого графика можно сделать вывод, что временная сложность BruteForce алгоритма O(n).
Алгоритм на карте и на дереве имеют одинаковую временную сложность logn, но на деле алгоритм на карте работает быстрее - это может быть связано с тем, что константа у алгоритма на дереве больше, чем у алгоритма на карте.
Посмотрев на третий график можно заметить, что где-то до отметки 250-300 прямоугольников и точек все три алгоритма работают одинаков.

# Выводы

- Можно сделать вывод, что для не большого количества входных данных нет разницы какой алгоритм использовать. Если на входе мало прямоугольников и точек нужно использовать алгоритм перебором. Если на входе мало прямоугольников, но много точек - лучше использовать алгоритм на карте. На мой взгляд, использовать алгоритм на дереве при небольшом количестве прямоугольников и точек не нужно.
- При большом количестве входных данных нужно знать что использовать. Например, если на входе много прямоугольников и небольшое количество точек то лучше использовать алгоритм перебора, так как он займет время на построение. Если на входе много прямоугольников и точек, то лучше использовать алгоритм на дереве, на таких данных он будет оптимальнее других.

# Логин в контесте: masalyaev@edu.hse.ru
<img width="988" alt="изображение" src="https://user-images.githubusercontent.com/114473716/234644404-db62d9cc-f8e1-4d5c-945c-0e365f4e9961.png">
