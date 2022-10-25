package utility;

public class ListPrinter {
	public static <S, T extends Iterable<S>> void print(T list){
        for (Object element : list){
            System.out.println(element);
        }
    }

}
