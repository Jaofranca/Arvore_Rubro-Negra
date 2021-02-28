package ifce.estruturadados.Arvorerubronegra;


public class Arvore {
	Node raiz;
	Node nil;
	
	Arvore(){
		this.nil = new Node(false,null,null,null,null);
		this.raiz = null;
	}
	
	
	public void insereNo(Integer valor,Node noBase) {
			if(raiz == null) {
				raiz = new Node(false,valor,null,null,null);
				
			}
			if(valor > noBase.getKey()) {
				if(noBase.getRight() == null) {
					Node novoNo = new Node(true,valor,null,null,noBase);
					noBase.setRight(novoNo);
					re_estruturarArvore(noBase.getRight());
				}
				else {
					insereNo(valor,noBase.getRight());
				}
				
			}else if(valor < noBase.getKey()) {
					if(noBase.getLeft() == null) {
						Node novoNo = new Node(true,valor,null,null,noBase);
						noBase.setLeft(novoNo);
						re_estruturarArvore(noBase.getLeft());
					}
					else {
						insereNo(valor,noBase.getLeft());
					}
				
				
			}else if(valor == noBase.getKey()) {
				System.out.println("Valor " + valor + "Ja foi inserido na arvore");
			}
		}
		
	 public void re_estruturarArvore(Node x) {
		Node pai = x.getPai();
		Node y;
		while(pai.getColor() == true) {
		if(pai == pai.getPai().getLeft()) {
			// caso 1 (tio é vermelho):
			// muda a cor do pai e do tio para preto e dos avós para vermelho.
		 // Então, sobe dois níveis na árvore.
			y = pai.getPai().getRight();
			if(y.getColor() == true) {
				pai.setColor(false);
				y.setColor(false);
				pai.getPai().setColor(true);
				x = pai.getPai();
			}
			else {
				if(x == pai.getRight()) {
					x = pai;
					RotacionarEsquerda(x);
				}
				pai.setColor(false);
				pai.getPai().setColor(true);
				RotacionarDireita(pai.getPai());
			}
		}else {
			y = pai.getPai().getRight();
			if(y.getColor() == true) {
				pai.setColor(false);
				y.setColor(false);
				pai.getPai().setColor(true);
				x = pai.getPai();
			}
			else {
				if(x == pai.getRight()) {
					x = pai;
					RotacionarDireita(x);
				}
				pai.setColor(false);
				pai.getPai().setColor(true);
				RotacionarEsquerda(pai.getPai());
		}
			}
		}
		raiz.setColor(false);
		
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

