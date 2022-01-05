

class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

public class Codec {
    StringBuilder str;
    final String SPLIT = ",";
    final String NULL = "null";
    int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        str = new StringBuilder();
        dfsS(root);
        str.deleteCharAt(str.lastIndexOf(SPLIT));
        return str.toString();
    }

    private void dfsS(TreeNode root){
        if (root == null){
            str.append(NULL).append(SPLIT);
            return;
        }
        str.append(root.val).append(SPLIT);
        dfsS(root.left);
        dfsS(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()){
            return null;
        }
        String[] vals = data.split(SPLIT);
        TreeNode head ;
        TreeNode pre = null;
        index = 0;
        head = dfsD(pre,vals);
        return head;
    }

    private TreeNode dfsD(TreeNode pre, String[] data){
        if (data[index].equals(NULL)){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index++]));
        pre = root;
        root.left = dfsD(pre,data);
        root.right = dfsD(pre,data);
        return root;
    }
}

