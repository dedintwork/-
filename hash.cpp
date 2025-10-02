#include <iostream>
#include <string>

using namespace std;

int main() {
    // Два массива: для названий цветов и соответствующих чисел
    string colors[2] = {"red", "blue"};
    int numbers[2] = {10, 15};

    // Ищем нужный цвет и выводим его число
    for(int i = 0; i < 2; i++) {
        if(colors[i] == "blue") {
            cout << numbers[i] << endl;  // Выведет: 15
        }
    }

    return 0;
}