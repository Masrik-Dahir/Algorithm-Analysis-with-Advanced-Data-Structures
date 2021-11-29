import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class generate {


    public static int[] random(int max){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int min = 10;
        int size = (int)Math.floor(Math.random()*(max-min+1)+min);
        int cuts = (int)Math.floor(Math.random()*( size/2-min/2+1)+min/2)+1;

        for (int i=1; i<size; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        List<Integer> pre = list.subList(0,cuts);
        Collections.sort(pre);
        list2.add(size);
        list2.add(cuts);
        list2.addAll(pre);
        return toArray(list2);

    }

    public static int[] toArray(List<Integer> a){
        int[] result = new int[a.size()];
        for (int i=0; i<a.size(); i++){
            result[i] = a.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] first = random(100);
        for (int i: first){
            System.out.println(i);
        }
    }
}
