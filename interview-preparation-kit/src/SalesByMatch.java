import java.util.HashMap;
import java.util.Map;

class SalesByMatch {

  /**
   * There is a large pile of socks that must be paired by color.
   * Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
   *
   * @param n
   * @param ar
   * @return
   */
  static int sockMerchant(int n, int[] ar) {

    Map<Integer, Integer> pairsMap = new HashMap<>();

    for (int sock : ar) {
      if (!pairsMap.containsKey(sock)) {
        pairsMap.put(sock, 1);
      } else {
        pairsMap.put(sock, pairsMap.get(sock) + 1);
      }
    }

    int pairsOfSocks = 0;

    for (int kindOfSock : pairsMap.keySet()) {
      if (pairsMap.get(kindOfSock) % 2 == 0) {
        pairsOfSocks += (pairsMap.get(kindOfSock) / 2);

      } else {
        pairsOfSocks += (pairsMap.get(kindOfSock) - 1) / 2;
      }
    }

    return pairsOfSocks;
  }

  public static void main(String[] args) {

    System.out.println(SalesByMatch.sockMerchant(7, new int[]{1, 2, 1, 2, 1, 3, 2}));
  }

}