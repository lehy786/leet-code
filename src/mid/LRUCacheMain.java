package mid;


/**
 * Created by luozhenzhao on 2021/9/27
 * description:
 */
public class LRUCacheMain {
    public static void main(String[] args) {
        String input = "[\"LRUCache\",\"put\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"put\",\"get\",\"put\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"get\",\"get\",\"put\",\"put\",\"get\",\"get\",\"get\",\"put\",\"put\",\"get\",\"put\",\"get\",\"put\",\"get\",\"get\",\"get\",\"put\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"get\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"get\",\"put\",\"get\",\"get\",\"get\",\"put\",\"get\",\"get\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"put\",\"get\",\"get\",\"get\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"get\",\"get\",\"get\",\"put\",\"put\",\"put\",\"put\",\"get\",\"put\",\"put\",\"put\",\"put\",\"put\",\"put\",\"put\"]\n" +
                "[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]";
        int secondArrayStart = input.indexOf("]");
        String opts = input.substring(12, secondArrayStart);
        String elements = input.substring(secondArrayStart+3, input.length()-1);
        System.out.println("opts: " + opts + "\n\n");
        System.out.println("elements: " + elements);

        String[] opt = opts.replace("\"", "").split(",");
        String[] ele = elements.substring(1, elements.length()-1).split("],\\[");

        LRUCache lruCache = new LRUCache(Integer.parseInt(ele[0]));
        System.out.println("null");
        for (int i = 0; i < opt.length; i++) {
            switch (opt[i]) {
                case "put":
                    String [] kv = ele[i+1].split(",");
                    lruCache.put(Integer.parseInt(kv[0]), Integer.parseInt(kv[1]));
                    System.out.println("null");
                    break;
                case "get":
                    int key = Integer.parseInt(ele[i+1]);
                    System.out.println(lruCache.get(key));
                    break;
                default:
            }
        }

//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 0); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        System.out.println(lRUCache.get(1));    // 返回 0
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=0, 3=3}
//        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {3=3, 4=4}
//        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
//        System.out.println(lRUCache.get(3));    // 返回 3
//        System.out.println(lRUCache.get(4));    // 返回 4

    }

}
