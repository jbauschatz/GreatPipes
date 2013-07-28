package pipes.view.tools;

public abstract class EditTool {
	public String getName() {
		return name;
	}
	
	public void mouseClicked(int x, int y) {
	}
	
	public void mouseDown(int x, int y) {
	}
	
	public void mouseUp(int x, int y) {
	}
	
	public void mouseDragged(int x, int y) {
	}
	
	public EditTool(String name) {
		this.name = name;
	}
	
	protected String name;
}
