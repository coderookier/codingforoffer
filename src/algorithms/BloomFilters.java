package algorithms;

/**
 * @author gutongxue
 * @date 2019/10/10 21:28
 * 布隆过滤器主要用于在海量数据中判断一个元素是否存在
 **/
public class BloomFilters {

    private int arraySize;
    private int[] array;

    public BloomFilters(int arraySize) {
        this.arraySize = arraySize;
        array = new int[arraySize];
    }

    public void add(String key) {
        int first = hashcode_1(key);
        int second = hashcode_2(key);
        int third = hashcode_3(key);

        array[first % arraySize] = 1;
        array[second % arraySize] = 1;
        array[third % arraySize] = 1;
    }

    public boolean check(String key) {
        int first = hashcode_1(key);
        int second = hashcode_2(key);
        int third = hashcode_3(key);
        if (array[first % arraySize] == 0) {
            return false;
        }
        if (array[second % arraySize] == 0) {
            return false;
        }
        if (array[third % arraySize] == 0) {
            return false;
        }
        return true;
    }

    private int hashcode_1(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = 33 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }

    private int hashcode_2(String key) {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);
    }

    private int hashcode_3(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BloomFilters bloomFilters = new BloomFilters(10000000);
        for (int i = 0; i < 1000000; i++) {
            bloomFilters.add(i + "");
        }
        System.out.println(bloomFilters.check(99999 + ""));
        System.out.println(bloomFilters.check(1000001 + ""));
        long end = System.currentTimeMillis();
        System.out.println("执行时间: " + (end - start));
    }
}
