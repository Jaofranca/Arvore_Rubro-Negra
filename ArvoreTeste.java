package ifce.estruturadados.Arvorerubronegra;

public class ArvoreTeste {

	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		arvore.insereNo(10, arvore.raiz);
		arvore.insereNo(1, arvore.raiz);
		arvore.insereNo(5, arvore.raiz);
		arvore.insereNo(8, arvore.raiz);
		arvore.insereNo(15, arvore.raiz);
		arvore.insereNo(11, arvore.raiz);
		arvore.insereNo(3, arvore.raiz);
		arvore.insereNo(6, arvore.raiz);
		arvore.insereNo(20, arvore.raiz);
		arvore.insereNo(4, arvore.raiz);
		arvore.insereNo(7, arvore.raiz);
		arvore.insereNo(16, arvore.raiz);
		arvore.insereNo(18, arvore.raiz);
		arvore.insereNo(50, arvore.raiz);
		arvore.insereNo(30, arvore.raiz);
		arvore.imprimeInterfixado(arvore.raiz);
		Node x = arvore.pesquisaNo(10,arvore.raiz);
		System.out.println();
		arvore.remove(8);
		arvore.remove(4);
		arvore.remove(18);
		arvore.remove(50);
		arvore.remove(30);
		System.out.println();
		System.out.println("Após remoção");
		arvore.imprimeInterfixado(arvore.raiz);
		System.out.println();
		System.out.println("altura: " + x.altura());
		
		
		
		
	}

}


/*
 * 
 * Arvore arvore = new Arvore();
		arvore.insereNo(10, arvore.raiz);
		arvore.insereNo(12, arvore.raiz);
		arvore.insereNo(9, arvore.raiz);
		arvore.insereNo(8, arvore.raiz);
		arvore.insereNo(13, arvore.raiz);
		arvore.insereNo(16, arvore.raiz);
		arvore.insereNo(80, arvore.raiz);
		arvore.insereNo(75, arvore.raiz);
		arvore.insereNo(11, arvore.raiz);
		arvore.insereNo(7, arvore.raiz);
		**/
