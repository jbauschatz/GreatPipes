package pipes.model;

public class EditTuneParameters {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public EditTuneParameters(String name, String author) {
		this.name = name;
		this.author = author;
	}

	private String name;
	private String author;
}
