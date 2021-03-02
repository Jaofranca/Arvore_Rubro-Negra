package ifce.estruturadados.Arvorerubronegra;

public class ArvoreTeste {

	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		arvore.insereNo(10, arvore.raiz);
		arvore.insereNo(12, arvore.raiz);
		arvore.insereNo(9, arvore.raiz);
		arvore.insereNo(8, arvore.raiz);
		arvore.insereNo(13, arvore.raiz);
		arvore.insereNo(11, arvore.raiz);
		arvore.insereNo(7, arvore.raiz);
		arvore.insereNo(15, arvore.raiz);
		arvore.insereNo(22, arvore.raiz);
		
		arvore.imprimeInterfixado(arvore.raiz);
		System.out.println();
		arvore.imprimePrefixado(arvore.raiz);
		System.out.println();
		arvore.imprimePosfixado(arvore.raiz);
	}

}
