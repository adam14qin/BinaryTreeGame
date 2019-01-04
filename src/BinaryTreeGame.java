
public class BinaryTreeGame {
	static TreeNode root;
	public TreeNode makeSecondMove(TreeNode First){// this is the optimal method for the 2nd person, no guarantee of victory
		int max=Math.max(CountNonchildNodes(First),Math.max(CountNodes(First.left), CountNodes(First.left)));
		if (max==CountNonchildNodes(First)){
			return First.parent;
		} else if (max==CountNodes(First.left)){
			return First.left;
		} else return First.right;
		
	}
	
	public TreeNode makeFirstMove(){//assumption: there is a victory node for the first person
		TreeNode Curr=root;
		int parent= CountNonchildNodes(Curr);
		int left= CountNodes(Curr.left);
		int right=CountNodes(Curr.right);
		int max=Math.max(parent, Math.max(left, right));
		while (!isTriangle(parent,left,right)){//we already know that we are moving into either left or right, since we start from the root
			if (max==left){
				Curr=Curr.left;
			} else Curr=Curr.right;
			
			parent= CountNonchildNodes(Curr);
			left= CountNodes(Curr.left);
			right=CountNodes(Curr.right);
		}
		return Curr;
	}
	
	public boolean isTriangle(int a, int b, int c){
		return (a+b>=c)&&(a+c>=b)&&(b+c>=a);
	}
	
	public int CountNodes(TreeNode node){//including the node itself
		if (node==null) return 0;
		return (1+CountNodes(node.left)+CountNodes(node.right));
	}
	
	public int CountNonchildNodes(TreeNode node){
		
		return CountNodes(root)-CountNodes(node);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		root=new TreeNode(1);
		TreeNode A=new TreeNode(2);
		TreeNode B=new TreeNode(3);
		TreeNode C=new TreeNode(4);
		TreeNode D=new TreeNode(5);
		TreeNode E=new TreeNode(6);
		TreeNode F=new TreeNode(7);
		TreeNode G=new TreeNode(8);
		TreeNode H=new TreeNode(9);
		TreeNode I=new TreeNode(10);
		TreeNode J=new TreeNode(11);
		TreeNode K=new TreeNode(12);
		TreeNode L=new TreeNode(13);
		/*
		      1
		    /   \
		  2      3
		 /\      / \
	   4   5     6  7
	  /\  / \   
	 8 9 10 11 
	/  /       
   12 13
		 */
		root.left=A;
		root.right=B;
		A.parent=root;
		B.parent=root;
		A.left=C;
		A.right=D;
		C.parent=A;
		D.parent=A;
		B.left=E;
		B.right=F;
		E.parent=B;
		F.parent=B;
		C.left=G; G.parent=C;
		C.right=H; H.parent=C;
		D.left=I; I.parent=D;
		D.right=J; J.parent=D;
		G.left=K; K.parent=G;
		H.left=L; L.parent=H;
		BinaryTreeGame game=new BinaryTreeGame();
		TreeNode SecondMove=game.makeSecondMove(A);
		System.out.println(SecondMove.val);
		TreeNode FirstMove=game.makeFirstMove();
		System.out.println(FirstMove.val);
	}

}
