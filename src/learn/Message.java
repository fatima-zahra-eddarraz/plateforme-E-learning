package learn;

public class Message {
	private String content;
	private String expediteur;
	private String destinataire;
	public Message(String contenu, String expediteur, String destinataire) {
		super();
		this.content = contenu;
		this.expediteur = expediteur;
		this.destinataire = destinataire;
	}
	public Message(String contenu, String destinataire) {
		super();
		this.content = contenu;
		this.destinataire = destinataire;
	}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
	
	public String getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	
	
}
