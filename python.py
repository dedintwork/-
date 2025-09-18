# Массив:
import array

# Создаем массив целых чисел с новыми значениями
numbers_array = array.array('i', [5, 15, 25, 35, 45])
numbers_array.append(55)  # Добавляем элемент в конец
numbers_array.append(65)  # Добавляем ещё один элемент

# Список:
# Создаем список с разнородными данными
data_list = ["один", 2, 3.5, False, {"ключ": "значение"}]
data_list.append("добавленный элемент")  # Добавляем элемент в конец
data_list.insert(3, "новая вставка")     # Вставляем элемент на позицию 3
data_list.remove(False)                 # Удаляем элемент со значением False

# Стек:
# Создаем стек и добавляем элементы
stack_collection = []
stack_collection.append("начало")
stack_collection.append("середина")
stack_collection.append("конец")
