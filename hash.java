public class Main {

    enum ItemType {
        BOOK(10),
        PEN(5);

        int value;

        ItemType(int val) {
            this.value = val;
        }
    }

    public static void main(String[] args) {
        for(ItemType item : ItemType.values()) {
            if(item.name().equals("PEN")) {
                System.out.println(item.value);  // вывод: 5
            }
        }
    }
}