package ifce.estruturadados.Arvorerubronegra;

public class Arvore {
	Node raiz;
	
	
	public void inserirNo(Integer key) {
		if(raiz == null) {
			raiz = new Node(false,key,null,null,null);
			return;
		}
	}
}
