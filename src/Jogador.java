
public class Jogador {
	
	private String nome = "anonimo";
	private int xp = 100;
	private int hp = 100;
	private boolean envenenado;
	
	public Jogador() {
		System.out.println("Criando jogador " + nome);
	}
	
	//sobrecarda de metodo
	public Jogador(String nome) { //parametro
		System.out.println("Criando jogador " + nome);
		this.nome = nome;
	}
	
	public void receberDano(int pontos) {
		hp -= pontos;
		if(foiDerrotado()) {
			System.out.println("Game Over " + nome);
		}
	}

	public void receberCura(int pontos) {
		hp += pontos;		
	}

	public String getNome() {
		return nome;
	}

	public int getXp() {
		return xp;
	}

	public int getHp() {
		return hp;
	}

	public boolean isEnvenenado() {
		return envenenado;
	}

	public void ganharExperiencia(int pontos) {
		xp += pontos;		
	}

	public void receberAntidoto() {
//		if(isEnvenenado()) { //code smell
//			envenenado = false;
//		}
//		
//		if(!isEnvenenado()) {
//			envenenado = true;
//		}
		
		envenenado = !envenenado;
		
	}

	public void atacar(Jogador jogador) {
		// this -> atacante
		// jogador -> atacado
		jogador.receberDano(this.getXp());
		if(jogador.foiDerrotado())
			ganharExperiencia(jogador.getXp());
		
	}

	private boolean foiDerrotado() {
		return hp <= 0;
	}

	

}
