package ifce.estruturadados.Arvorerubronegra;

public class Arvore {
	Node raiz;
	Node nil;
	
	Arvore(){
		this.nil = new Node(false,null,null,null,null);
		this.raiz = null;
	}
	
	public void inserirNo(Integer key) {
		if(raiz == null) {
			raiz = new Node(false,key,null,null,null);
			return;
		}
		
	}
	public void RotacionarEsquerda(Node x) {
		Node y = x.getRight();
		Node pai = x.getPai();
		x.setRight(y.getLeft());
		if(y.getLeft() != nil) {
			y.getLeft().setPai(x);	
		}
		y.setPai(pai);
		if(pai == nil) {
			this.raiz = y;
		}
		if(x == pai.getLeft()) {
			pai.setLeft(y);
		}else {
			pai.setRight(y);
		}
		y.setLeft(x);
		x.setPai(y);
		
	}
	
	public void RotacionarDireita(Node x) {
		Node y = x.getLeft();
		Node pai = x.getPai();
		x.setLeft(y.getRight());
		if(y.getRight() != nil) {
			y.getRight().setPai(x);	
		}
		y.setPai(pai);
		if(pai == nil) {
			this.raiz = y;
		}
		if(x == pai.getLeft()) {
			pai.setLeft(y);
		}else {
			pai.setRight(y);
		}
		y.setRight(x);
		x.setPai(y);
		
	}
	public void pesquisaNo() {
		
	};
}

