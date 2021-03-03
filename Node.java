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
	
    public Node min() {
        if (this.left != Arvore.nil) {
        	return this.left.min();
        }
        else {
        	return this;
        }
    }

    public Node max() {
        if (this.right != Arvore.nil) {
        	return this.right.max();
        }
        else {
        	return this;
        }
    }

    public Node successor() {
        if (this.right != Arvore.nil) {
        	return this.right.min();
        }
        else {
        	return this;
        }
    }
    
    public int altura() {
        if (this.getLeft() != Arvore.nil && this.right != Arvore.nil) {
            return 1 + Math.max(this.getLeft().altura(), this.getRight().altura());
        }
        else if (this.getLeft() != Arvore.nil) {
            return 1 + this.getLeft().altura();
        }
        else if (this.getRight() != Arvore.nil) {
            return 1 + this.getRight().altura();
        }
        else return 0;
    }

}
