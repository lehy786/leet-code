package bfsdfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luozhenzhao on 2022/3/2
 * description: 22. 括号生成
 */
public class GenerateParenthesis {
  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    dfsGen(list, n, n, "");
    return list;
  }

  private void dfsGen(List<String> list, int left, int right, String cur) {
    if (left == 0 && right == 0) {
      list.add(cur);
      return;
    }
    if (left > 0)
      dfsGen(list, left - 1, right, cur + "(");
    if (right > 0 && right > left)
      dfsGen(list, left, right - 1, cur + ")");
  }
}
