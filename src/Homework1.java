import java.util.Scanner;
import java.util.Stack;

import javax.imageio.metadata.IIOMetadataNode;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class Homework1 {
	static public void Infix(Node a) {
		if(a!=null) {
			if(Operate(a.getNodeName().charAt(0))&&a!=root) {
				System.out.print("(");	
			}
				Infix(a.getChildNodes().item(1));
				System.out.print(a.getNodeName());
				Infix(a.getChildNodes().item(0));
			if(Operate(a.getNodeName().charAt(0))&&a!=root) {
					System.out.print(")");	
			}
		}
	}
	
	static public void Inorder(Node a) {
		if(!Operate(a.getNodeName().charAt(0))) {
			a.setNodeValue(a.getNodeName());
			return;
		}
		Node secound = new IIOMetadataNode(stack.pop().toString());
		Inorder(secound);
		Node frist = new IIOMetadataNode(stack.pop().toString());
		Inorder(frist);
		a.appendChild(secound);
		a.appendChild(frist);
		Calculator(a);
		
		
	}
	static public boolean Operate(char a) {
		if(a=='+'||a=='-'||a=='*'||a=='/') {
			return true;
		}else {
			return false;
		}
	}
	
	static public void Calculator(Node a) {
		int secound =Integer.parseInt(a.getChildNodes().item(0).getNodeValue());
		int frist =Integer.parseInt(a.getChildNodes().item(1).getNodeValue());
		int result = 0;
		switch(a.getNodeName()) {
			case "+":
				result = frist+secound;
				break;
			case "-":
				result = frist-secound;
				break;
			case "*":
				result = frist*secound;
				break;
			case "/":
				result = frist/secound;
				break;
		}
		a.setNodeValue(Integer.toString(result));
	}
	
	static Stack stack = new Stack();
	static Stack stacktree = new Stack();
	static Node root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dataS ="251-*32*+";
		if(args.length>0) {
			dataS=args[0];
		}

//		Scanner scanInput = new Scanner(System.in);
//		dataS= scanInput.nextLine();
//
//		scanInput.close();
			
		char[] dataC = dataS.toCharArray();	
		for(int i=0;i<dataC.length;i++) {
			stack.push((char)dataC[i]);
			stacktree.push((char)dataC[i]);
		}
		root = new IIOMetadataNode(stack.pop().toString());
		Inorder(root);
		Infix(root);
		System.out.println("="+root.getNodeValue());
		//TreeDemo tree = new TreeDemo();
		TreeDemo.main(stacktree);
	}
}