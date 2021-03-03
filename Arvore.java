package ifce.estruturadados.Arvorerubronegra;


public class Arvore {
	Node raiz;
	static Node nil;
	
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
	/**
	 * 
	 * public void re_estruturarArvore(Node x) {
		
		Node y;
		while(x.getPai().getColor() == true ) {
		if(x.getPai() == x.getPai().getPai().getLeft()) {
			y = x.getPai().getPai().getRight();
			if(y.getColor() == true) {
				x.getPai().setColor(false);
				y.setColor(false);
				x.getPai().getPai().setColor(true);
				x = x.getPai().getPai();
			}
			else {
				if(x == x.getPai().getRight()) {
					x = x.getPai();
					RotacionarEsquerda(x);
				}
				x.getPai().setColor(false);
				x.getPai().getPai().setColor(true);
				RotacionarDireita(x.getPai().getPai());
			}
		}else {
			y = x.getPai().getPai().getLeft();
			if(y.getColor() == true) {
				x.getPai().setColor(false);
				y.setColor(false);
				x.getPai().getPai().setColor(true);
				x = x.getPai().getPai();
			}
			else {
				if(x == x.getPai().getLeft()) {
					x = x.getPai();
					RotacionarDireita(x);
				}
				x.getPai().setColor(false);
				x.getPai().getPai().setColor(true);
				RotacionarEsquerda(x.getPai().getPai());
		}
			}
		}
		raiz.setColor(false);
	 }
	 */
	
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
			x.getPai().setLeft(y);
		}
		else {
			x.getPai().setRight(y);
			y.setPai(x.getPai());
		}
	}
	
	public void remove(Integer n) {
		
		if(raiz == null) {
			System.out.print("Raiz nula, não há elementos para remover");
		}
		Node z = pesquisaNo(n,raiz);
		if(z.getKey() == n) {
			Node x = z;
			Node y = z;
		
		
		Boolean CorY = z.getColor();
		if(z.getLeft() == Arvore.nil) {
			x = z.getRight();
            this.transplant(z, z.getRight());
		}else if(z.getRight() == nil) {
			x = z.getLeft();
			transplant(z,z.getLeft());
		}
		
		else {
			y = z.successor();
			CorY = y.getColor();
			x = y.getRight();
			if(y.getPai() == z) {
				x.setPai(y);
			}else {
				transplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setPai(y);
			}
			transplant(z,y);
			y.setLeft(z.getLeft());
			y.getLeft().setPai(y);
			y.setColor(z.getColor());
			
		}
		if(CorY == false) {
			fixaremocao(x);
			
		}
		
	}
		}
	private void fixaremocao(Node n) {
		Node x;

		while (n != raiz && n.getColor() == false) {
				
				if (n.getPai()!= null && n == n.getPai().getLeft()) {
						x = n.getPai().getRight();

						if (x.getColor() == true) { // caso 1
								x.setColor(false);
								n.getPai().setColor(true);	
								RotacionarEsquerda(n.getPai());
								x = n.getPai().getRight();
						}
						if (x.getLeft().getColor() == false && x.getRight().getColor() == false) { // caso 2
								x.setColor(true);
								n = n.getPai();
						} else {
								if (x.getRight().getColor() == false) { // caso 3
										x.getLeft().setColor(false);
										x.setColor(true);
										RotacionarDireita(x);
										x = n.getPai().getRight();
								}
								// caso 4
								x.setColor(n.getPai().getColor());
								n.getPai().setColor(false);
								x.getRight().setColor(false);
								RotacionarEsquerda(n.getPai());
								n = raiz;
						}
				}	else {
					x = n.getPai().getLeft();

					if (x.getColor() == true) { // caso 1
						x.setColor(false);
						n.getPai().setColor(true);	
						RotacionarDireita(n.getPai());
						x = n.getPai().getLeft();
					}
					if (x.getLeft().getColor() == false && x.getRight().getColor() == false) { // caso 2
							x.setColor(true);
							n = n.getPai();
					} else {
							if (x.getRight().getColor() == false) { // caso 3
									x.getRight().setColor(false);
									x.setColor(true);
									RotacionarEsquerda(x);
									x = n.getPai().getLeft();
							}
							// caso 4
							x.setColor(n.getPai().getColor());
							n.getPai().setColor(false);
							x.getLeft().setColor(false);
							RotacionarDireita(n.getPai());
							n = raiz;
						}
				}
		}
		n.setColor(false);
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
				System.out.println(noBase.getKey() + " cor: " + PrintNodeColor(noBase) + "\t");
			}
			imprimePrefixado(noBase.getLeft());
			imprimePrefixado(noBase.getRight());
		}
	}
	public void imprimeInterfixado(Node noBase) {
			if(noBase != null) {
				imprimeInterfixado(noBase.getLeft());
				if(noBase != nil) {
					System.out.println("Nó :" + noBase.getKey() + " cor: " + PrintNodeColor(noBase) + "\t");
				}
				imprimeInterfixado(noBase.getRight());
			}
	}
	public void imprimePosfixado(Node noBase) {
				if(noBase != null) {
					imprimePosfixado(noBase.getLeft());
					imprimePosfixado(noBase.getRight());
					if(noBase != nil) {
						System.out.println(noBase.getKey() + " cor: " + PrintNodeColor(noBase) + "\t");
					}
					
				}
		
	}
	
}


