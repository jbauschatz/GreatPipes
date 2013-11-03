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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.author = type;
	}

	public EditTuneParameters(String name, String author, String type) {
		this.name = name;
		this.author = author;
		this.type = type;
	}

	private String name;
	private String author;
	private String type;
}
