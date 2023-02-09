/* B Closest Points to Origin
We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).

Problem Constraints
1 <= B <= length of the list A <= 10^5
-10^5 <= A[i][0] <= 10^5
-10^5 <= A[i][1] <= 10^5

TC=O(N)
SC=O(N)

Input Format
The argument given is list A and an integer B.

Output Format
Return the B closest points to the origin (0, 0) in any order.

 */


package Sorting;

public class EuclideanDistance {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {


        HashMap<Integer,Long> sqrtValueHashMap = new HashMap<>();

        for(int d=0;d<A.size();d++){
            ArrayList<Integer> tempList = A.get(d);
            long sqrtValue = tempList.get(0)*tempList.get(0) + tempList.get(1) * tempList.get(1);
            sqrtValueHashMap.put(d,sqrtValue);
        }

        List<Map.Entry<Integer,Long>> list = new ArrayList<>(sqrtValueHashMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer,Long>>(){
            public int compare(Map.Entry<Integer,Long> e1, Map.Entry<Integer,Long> e2){
                return (int)(e1.getValue()-e2.getValue());
            }
        });

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        Iterator<Map.Entry<Integer, Long>> entrySet = sqrtValueHashMap.entrySet().iterator();

        for(Map.Entry<Integer,Long> e: list){
            if(B>0){
                int key = e.getKey();
                resultList.add(A.get(key));
                B--;
            }else{
                break;
            }
        }
        return resultList;
    }
}
