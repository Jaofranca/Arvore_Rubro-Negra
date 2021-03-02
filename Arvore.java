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
				raiz = new Node(false,valor,nil,nil,null);
				return ;
			}
			if(valor > noBase.getKey()) {
				if(noBase.getRight() == nil) {
					Node novoNo = new Node(true,valor,nil,nil,noBase);
					noBase.setRight(novoNo);
					re_estruturarArvore(noBase.getRight());
				}
				else {
					insereNo(valor,noBase.getRight());
				}
				
			}else if(valor < noBase.getKey()) {
					if(noBase.getLeft() == nil) {
						Node novoNo = new Node(true,valor,nil,nil,noBase);
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
		while(pai.getColor() == true ) {
		if(pai == pai.getPai().getLeft()) {
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
			y = pai.getPai().getLeft();
			if(y.getColor() == true) {
				pai.setColor(false);
				y.setColor(false);
				pai.getPai().setColor(true);
				x = pai.getPai();
			}
			else {
				if(x == pai.getLeft()) {
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
	/*
	 * Node rotateLeft(Node x) {
          Node y = x.right;
          x.right =y.left;
          y.left = x;
          y.color = x.color;
          x.color = RED;
          y.N = x.N;
          x.N = 1 + size(x.left) + size(x.right);
          return x;
       }
	 * 
	 */
	  
	
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
	public Node pesquisaNo(Integer valor, Node noBase) {
		if(noBase == null) {
			return null;
		}
		if(valor == noBase.getKey()) {
			return noBase;
		}
		if(valor< noBase.getKey()) {
			return pesquisaNo(valor,noBase.getLeft());
		}else {
			return pesquisaNo(valor,noBase.getRight());
		}
	}
	public void transplant (Node x, Node y) {
		if (x.getPai() == nil) {
			raiz = y;
		}
		else if (x == x.getPai().getLeft()) {
			x.setPai(y);
		}
		else {
			x.getPai().setRight(y);
			y.setPai(x.getPai());
		}
	}
	
	public Node remove(Integer x) {
		if(raiz == null) {
			return raiz;
		}
		Node NoRemovido = pesquisaNo(x,raiz);
		if(NoRemovido.getLeft() == nil && NoRemovido.getRight() == nil) {
			if(NoRemovido == NoRemovido.getPai().getLeft()) {
				NoRemovido.getPai().setLeft(nil);
				NoRemovido.setPai(null);
			}else {
				NoRemovido.getPai().setRight(nil);
				NoRemovido.setPai(null);
			}
		}
		else if(NoRemovido.getLeft() != nil && NoRemovido.getRight() == nil) {
			if(NoRemovido == NoRemovido.getPai().getLeft()) {
				NoRemovido.getPai().setLeft(NoRemovido.getLeft());
				NoRemovido.setPai(null);
			}else {
				NoRemovido.getPai().setRight(NoRemovido.getRight());
				NoRemovido.setPai(null);
			}
		}
		else if(NoRemovido.getLeft() != nil && NoRemovido.getRight() != nil) {
			
		}
		return NoRemovido;
	}
	public String PrintNodeColor(Node No) {
		if(No.getColor() == true) {
			return "vermelho";
		}else {
			return "preto";
		}
	}
	
	public void imprimePrefixado(Node noBase) {
		if(noBase != null) {
			if(noBase != nil) {
				System.out.print(noBase.getKey() + " cor: " + PrintNodeColor(noBase) + "\t");
			}
			imprimePrefixado(noBase.getLeft());
			imprimePrefixado(noBase.getRight());
		}
	}
	public void imprimeInterfixado(Node noBase) {
			if(noBase != null) {
				imprimeInterfixado(noBase.getLeft());
				if(noBase != nil) {
					System.out.print(noBase.getKey() + " cor: " + PrintNodeColor(noBase) + "\t");
				}
				imprimeInterfixado(noBase.getRight());
			}
	}
	public void imprimePosfixado(Node noBase) {
				if(noBase != null) {
					imprimePosfixado(noBase.getLeft());
					imprimePosfixado(noBase.getRight());
					if(noBase != nil) {
						System.out.print(noBase.getKey() + " cor: " + PrintNodeColor(noBase) + "\t");
					}
					
				}
		
	}
	
}

