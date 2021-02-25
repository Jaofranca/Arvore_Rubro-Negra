package ifce.estruturadados.Arvorerubronegra;

public class Node {
	private Boolean color;
	private Integer key;
	private Node left,right;
	private Node pai;
	
	Node(Boolean color,Integer key,Node left,Node right,Node pai ){
		this.color = color;
		this.key = key;
		this.left = left;
		this.right = right;
		this.pai = pai;
	}
	public Boolean getColor() {
		return color;
	}
	public void setColor(Boolean color) {
		this.color = color;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getPai() {
		return pai;
	}
	public void setPai(Node pai) {
		this.pai = pai;
	}
	
	

}
