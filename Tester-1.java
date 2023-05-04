// Tester class, with commented out methods that return caught error messages as well as each method called at least twice

public class Tester
{
    public static void main(String[] args)
    {
        LinkedList<Integer> LL = new LinkedList<>();
        // below are potential errors that are caught
        /*LL.removeFirst();
        LL.removeLast();
        LL.removeIndex(2);
        LL.insertIndex(1, 10);
        LL.insertIndex(-2, -2);
        LL.reSort();
        LL.searchByValue(10);
        LL.searchByIndex(2);
        LL.update(2, 2);
        LL.updateAll(2, 3, 2);
        LL.updateAll(2, 3);
        LL.toString();*/

        LL.insertFirst(2);
        System.out.println(LL);
        LL.insertFirst(10);
        System.out.println(LL);
        LL.insertLast(23);
        System.out.println(LL);
        LL.insertLast(1);
        System.out.println(LL);
        LL.insertFirst(5);
        System.out.println(LL);
        LL.insertFirst(1);
        System.out.println(LL);
        LL.insertLast(63);
        System.out.println(LL);
        LL.insertLast(12);
        System.out.println(LL);
        LL.insertIndex(49,3);
        System.out.println(LL);
        LL.insertIndex(30, 7);
        System.out.println(LL);
        LL.insertSorted(42);
        System.out.println(LL);
        LL.insertSorted(-10);
        System.out.println(LL);
        LL.removeIndex(3);
        System.out.println(LL);
        LL.removeIndex(10);
        System.out.println(LL);
        LL.removeFirst();
        System.out.println(LL);
        LL.removeLast();
        System.out.println(LL);
        LL.removeFirst();
        System.out.println(LL);
        LL.removeLast();
        System.out.println(LL);
        LL.reSort();
        System.out.println(LL);
        LL.insertFirst(-10);
        System.out.println(LL);
        LL.insertLast(-10);
        System.out.println(LL);
        System.out.println(LL.updateAll(-10,1));
        System.out.println(LL);
        LL.updateAll(1,2);
        System.out.println(LL);
        LL.updateAll(2,1,2);
        System.out.println(LL);
        LL.update(5,10);
        System.out.println(LL);
        LL.update(1, 100);
        System.out.println(LL);
        System.out.println(LL.searchByIndex(7));
        System.out.println(LL.searchByValue(10));
        System.out.println(LL.searchByIndex(1));
        System.out.println(LL.searchByValue(2));
        System.out.println(LL);
        LL.reSort();
        System.out.println(LL);
    }
}
