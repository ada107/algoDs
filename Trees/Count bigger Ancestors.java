/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    static HashMap<TreeNode, Integer> start;
    static HashMap<TreeNode, Integer> end;
    
    static int s;
    static class pair{
        TreeNode t;
    }
    public void dfs(TreeNode A){
        if(A==null){
            return;
        }
        s++;
        start.put(A, s);
        dfs(A.left);
        dfs(A.right);
        end.put(A, s);
    }
    
    
    public int query(int bit[], int index){
        int ind = index;
        int ans = 0;
        for(;ind>0;ind -= (ind&-ind)){
            ans += bit[ind];
        }
        return ans;
    }
    
    public void update(int bit[], int index){
        int ind = index;
        for(;ind<bit.length;ind += (ind&-ind))
            bit[ind]++;
    }
    public int fill(TreeNode A, TreeNode p[], int ind){
        if(A==null)
            return 0;
        p[ind] = new TreeNode(0);
        p[ind] = A;
        int l = fill(A.left, p, ind+1);
        int r = fill(A.right, p, ind + 1 + l);
        return 1 + l + r;
    }
    public int solve(TreeNode A) {
        s = 0;
        start = new HashMap<>();
        end = new HashMap<>();
        dfs(A);
        TreeNode p[] = new TreeNode[s];
        fill(A, p, 0);
        Arrays.sort(p, new Comparator<TreeNode>(){
            public int compare(TreeNode p1, TreeNode p2){
                return p1.val - p2.val;
            }
        });
        int bit[] = new int[s+1];
        int ans = 0;
        for(int i=0;i<p.length;i++){
            System.out.print(p[i].val+" ");
            ans+= query(bit, start.get(p[i]));
            update(bit, start.get(p[i]));
            update(bit, end.get(p[i])+1);
        }
        return ans;
    }
}
