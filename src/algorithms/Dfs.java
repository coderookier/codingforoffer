package algorithms;

import java.util.ArrayList;

/**
 * @author gutongxue
 * @date 2020/2/11 16:06
 * 打印字符串的全排列，使用深度优先搜索与回溯实现
 **/
public class Dfs {

    private ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> permutation(String str) {
        if (str != null && str.length() > 0) {
            char[] arr = str.toCharArray();
            //字符是否已在当前排列中,true在false不在
            boolean[] visited = new boolean[arr.length];

            permutationCore(arr, visited, new StringBuilder());
        }

        return res;
    }

    private void permutationCore(char[] arr, boolean[] visited, StringBuilder sb) {
        //一次排列完成
        if (sb.length() == arr.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //此位置字符未访问
            if (visited[i] == false) {
                sb.append(arr[i]);
                visited[i] = true;
                permutationCore(arr, visited, sb);
                //回溯
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Dfs dfs = new Dfs();
        ArrayList<String> res = dfs.permutation("123");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
