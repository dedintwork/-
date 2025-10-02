# Два списка: для названий стран и численности населения (в млн)
countries = ["Russia", "Japan", "Canada"]
population = [144, 126, 38]

# Находим население нужной страны
for i in range(len(countries)):
    if countries[i] == "Japan":
        print(population[i])  # вывод: 126